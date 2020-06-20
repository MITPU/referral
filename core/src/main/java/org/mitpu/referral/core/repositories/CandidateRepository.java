package org.mitpu.referral.core.repositories;

import org.mitpu.referral.core.repositories.models.Candidate;
import org.mitpu.referral.core.repositories.models.Person;
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
        System.out.println("AAA=" + id);
        Object[] argForPerson = new Object[] {id};
        String queryForPerson = "SELECT * FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(queryForPerson, argForPerson,
                                                    (rs, rowNum) -> new Person(rs.getInt("id"),
                                                                               rs.getString("firstname"),
                                                                               rs.getString("middlename"),
                                                                               rs.getString("lastname"),
                                                                               rs.getString("email"),
                                                                               rs.getString("phone"),
                                                                               rs.getString("street1"),
                                                                               rs.getString("street2"),
                                                                               rs.getString("city"),
                                                                               rs.getString("state"),
                                                                               rs.getString("zip"),
                                                                               rs.getString("country")));
        Object[] argForCandidate = new Object[] {id};
        String queryForCandidate = "SELECT * FROM candidate WHERE id = ?";
        Candidate candidate = jdbcTemplate.queryForObject(queryForCandidate, argForCandidate,
                                                          (rs, rowNum) -> new Candidate(rs.getByte("workauthorization"),
                                                                                        rs.getString("linkedin"),
                                                                                        rs.getByte("stage"),
                                                                                        rs.getByte("status"),
                                                                                        rs.getInt("coordinator_id")));

        candidate.setFirstname(person.getFirstname());
        candidate.setMiddlename(person.getMiddlename());
        candidate.setLastname(person.getLastname());
        candidate.setEmail(person.getEmail());
        candidate.setPhone(person.getPhone());
        candidate.setStreet1(person.getStreet1());
        candidate.setStreet2(person.getStreet2());
        candidate.setCity(person.getCity());
        candidate.setState(person.getState());
        candidate.setZip(person.getZip());
        candidate.setCountry(person.getCountry());
        return candidate;
    }
}
