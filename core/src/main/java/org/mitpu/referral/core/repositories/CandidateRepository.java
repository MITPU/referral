package org.mitpu.referral.core.repositories;

import org.mitpu.referral.core.repositories.database.DBUtils;
import org.mitpu.referral.core.repositories.models.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CandidateRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<Candidate> mapper = (rs, rowNum) -> {
        Candidate.CandidateBuilder candidateBuilder = new Candidate.CandidateBuilder();
        candidateBuilder.setWorkAuthorization(
                Candidate.WorkAuthorization.getWorkAuthorization(rs.getByte("workauthorization")));
        candidateBuilder.setLinkedin(rs.getString("linkedin"));
        candidateBuilder.setStage(Candidate.Stage.getStage(rs.getByte("stage")));
        candidateBuilder.setStatus(Candidate.Status.getStatus(rs.getByte("status")));
        candidateBuilder.setCoordinatorId(rs.getInt("coordinator_id"));
        candidateBuilder.setId(rs.getInt("id"));
        candidateBuilder.setFirstname(rs.getString("firstname"));
        candidateBuilder.setMiddlename(rs.getString("middlename"));
        candidateBuilder.setLastname(rs.getString("lastname"));
        candidateBuilder.setEmail(rs.getString("email"));
        candidateBuilder.setPhone(rs.getString("phone"));
        candidateBuilder.setCity(rs.getString("city"));
        candidateBuilder.setState(rs.getString("state"));
        candidateBuilder.setZip(rs.getString("zip"));
        candidateBuilder.setCountry(rs.getString("country"));
        return candidateBuilder.build();
    };

    @Autowired
    public CandidateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Candidate findById(Integer id) {
        Candidate candidate = null;
        try {
            Object[] parameters = new Object[] {id};
            String query = "SELECT * FROM candidate WHERE id = ?";
            candidate = jdbcTemplate.queryForObject(query, parameters, mapper);
        } catch (EmptyResultDataAccessException er) {
        }
        return candidate;
    }

    public List<Candidate> findAll() {
        List<Candidate> candidateList = null;
        Object[] parameters = null;
        String query = "SELECT * FROM candidate";
        candidateList = jdbcTemplate.query(query, parameters, mapper);
        if (candidateList != null && candidateList.isEmpty()) {
            candidateList = null;
        }
        return candidateList;
    }

    public Integer save(Candidate candidate) {
        Integer candidateId = null;
        try {
            KeyHolder personPrimaryKey = new GeneratedKeyHolder();

            Object[] parameters = new Object[] {candidate.getFirstname(),
                                                candidate.getMiddlename(),
                                                candidate.getLastname(),
                                                candidate.getEmail(),
                                                candidate.getPhone(),
                                                candidate.getCity(),
                                                candidate.getState(),
                                                candidate.getZip(),
                                                candidate.getCountry(),
                                                candidate.getWorkAuthorization().code,
                                                candidate.getLinkedin(),
                                                candidate.getStage().code,
                                                candidate.getStatus().code,
                                                candidate.getCoordinatorId()};
            String query = "INSERT INTO candidate ("
                    + "firstname, "
                    + "middlename, "
                    + "lastname, "
                    + "email, "
                    + "phone, "
                    + "city, "
                    + "state, "
                    + "zip, "
                    + "country, "
                    + "workauthorization, "
                    + "linkedin, "
                    + "stage, "
                    + "status, "
                    + "coordinator_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            if (jdbcTemplate.update(conn -> DBUtils.createPsWithKey(conn, query, parameters), personPrimaryKey) > 0) {
                candidateId = personPrimaryKey.getKey().intValue();
            }
        } catch (DataAccessException dae) {
            DBUtils.throwConflictException(dae);
        }
        return candidateId;
    }

    public Boolean delete(Integer id) {
        Boolean isDeleted = false;
        Object[] parameters = new Object[] {id};
        String query = "DELETE FROM candidate WHERE id = ?";
        if (jdbcTemplate.update(query, parameters) > 0) {
            isDeleted = true;
        }
        return isDeleted;
    }
}
