package org.mitpu.referral.core.repositories;

import org.mitpu.referral.core.repositories.database.DBUtils;
import org.mitpu.referral.core.repositories.models.CandidateParticipation;
import org.mitpu.referral.core.services.DateTimeUtils;
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
public class CandidateParticipationRepository {

    private RowMapper<CandidateParticipation> mapper = (rs, rowNum) -> {
        CandidateParticipation candidateParticipation = new CandidateParticipation();
        candidateParticipation.setId(rs.getInt("id"));
        candidateParticipation.setCandidateId(rs.getInt("candidate_id"));
        candidateParticipation.setParticipationId(rs.getInt("participation_id"));
        candidateParticipation.setStatus(CandidateParticipation.Status.getStatus(rs.getByte("status")));
        candidateParticipation.setDate(DateTimeUtils.stringToDateTime(rs.getString("date")));
        candidateParticipation.setReferrerId(rs.getInt("referrer_id"));
        return candidateParticipation;
    };

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidateParticipationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CandidateParticipation findById(Integer id) {
        CandidateParticipation candidateParticipation = null;
        try {
            Object[] parameters = new Object[] {id};
            String query = "SELECT * FROM candidate_participation WHERE id = ?";
            candidateParticipation = jdbcTemplate.queryForObject(query, parameters, mapper);
        } catch (EmptyResultDataAccessException er) {
        }
        return candidateParticipation;
    }

    public List<CandidateParticipation> findAll() {
        List<CandidateParticipation> candidateParticipationList = null;
        Object[] parameters = null;
        String query = "SELECT * FROM candidate_participation";
        candidateParticipationList = jdbcTemplate.query(query, parameters, mapper);
        if (candidateParticipationList != null && candidateParticipationList.isEmpty()) {
            candidateParticipationList = null;
        }
        return candidateParticipationList;
    }

    public List<CandidateParticipation> findAllByCandidateId(Integer candidateId) {
        List<CandidateParticipation> candidateParticipationList = null;
        Object[] parameters = new Object[] {candidateId};
        String query = "SELECT * FROM candidate_participation WHERE candidate_id = ?";
        candidateParticipationList = jdbcTemplate.query(query, parameters, mapper);
        if (candidateParticipationList != null && candidateParticipationList.isEmpty()) {
            candidateParticipationList = null;
        }
        return candidateParticipationList;
    }

    public Integer save(CandidateParticipation candidateParticipation) {
        Integer skillId = null;
        try {
            KeyHolder personPrimaryKey = new GeneratedKeyHolder();

            Object[] parameters = new Object[] {candidateParticipation.getParticipationId(),
                                                candidateParticipation.getCandidateId(),
                                                candidateParticipation.getStatus().value,
                                                candidateParticipation.getReferrerId()};
            String query = "INSERT INTO candidate_participation (PARTICIPATION_ID, CANDIDATE_ID, STATUS, DATE, REFERRER_ID) "
                    + "VALUES (?, ?, ?, NOW(), ?)";

            if (jdbcTemplate.update(conn -> DBUtils.createPsWithKey(conn, query, parameters), personPrimaryKey) > 0) {
                skillId = personPrimaryKey.getKey().intValue();
            }
        } catch (DataAccessException dae) {
            dae.printStackTrace();
            DBUtils.throwConflictException(dae);
        }
        return skillId;
    }

    public Boolean delete(Integer id) {
        Boolean isDeleted = false;
        Object[] parameters = new Object[] {id};
        String query = "DELETE FROM candidate_participation WHERE id = ?";
        if (jdbcTemplate.update(query, parameters) > 0) {
            isDeleted = true;
        }
        return isDeleted;
    }

}
