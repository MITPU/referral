package org.mitpu.referral.core.repositories;

import org.mitpu.referral.core.repositories.models.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CandidateRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Candidate findById(int id) {
        Candidate candidate = null;
        try {
            Candidate.CandidateBuilder candidateBuilder = new Candidate.CandidateBuilder();

            Object[] argForPerson = new Object[] {id};
            String queryForPerson = "SELECT * FROM person WHERE id = ?";
            jdbcTemplate.queryForObject(queryForPerson, argForPerson, (rs, rowNum) -> {
                candidateBuilder.setId(rs.getInt("id"));
                candidateBuilder.setFirstname(rs.getString("firstname"));
                candidateBuilder.setMiddlename(rs.getString("middlename"));
                candidateBuilder.setLastname(rs.getString("lastname"));
                candidateBuilder.setEmail(rs.getString("email"));
                candidateBuilder.setPhone(rs.getString("phone"));
                candidateBuilder.setStreet1(rs.getString("street1"));
                candidateBuilder.setStreet2(rs.getString("street2"));
                candidateBuilder.setCity(rs.getString("city"));
                candidateBuilder.setState(rs.getString("state"));
                candidateBuilder.setZip(rs.getString("zip"));
                candidateBuilder.setCountry(rs.getString("country"));
                return null;
            });

            Object[] argForCandidate = new Object[] {id};
            String queryForCandidate = "SELECT * FROM candidate WHERE id = ?";
            jdbcTemplate.queryForObject(queryForCandidate, argForCandidate, (rs, rowNum) -> {
                candidateBuilder.setWorkAuthorization(
                        Candidate.WorkAuthorization.getWorkAuthorization(rs.getByte("workauthorization")));
                candidateBuilder.setLinkedin(rs.getString("linkedin"));
                candidateBuilder.setStage(Candidate.Stage.getStage(rs.getByte("stage")));
                candidateBuilder.setStatus(Candidate.Status.getStatus(rs.getByte("status")));
                candidateBuilder.setCoordinatorId(rs.getInt("coordinator_id"));
                return null;
            });

            candidate = candidateBuilder.build();
        } catch (Exception e) {
            candidate = null;
        }
        return candidate;
    }
}
