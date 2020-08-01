package org.mitpu.referral.core.repositories;

import org.mitpu.referral.core.repositories.database.DBUtils;
import org.mitpu.referral.core.repositories.models.CandidateSkill;
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
public class CandidateSkillRepository {

    private RowMapper<CandidateSkill> mapper = (rs, rowNum) -> {
        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setId(rs.getInt("id"));
        candidateSkill.setCandidateId(rs.getInt("candidate_id"));
        candidateSkill.setSkillId(rs.getInt(rs.getInt("skill_id")));
        candidateSkill.setYear(rs.getByte("year"));
        return candidateSkill;
    };

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidateSkillRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CandidateSkill findById(Integer id) {
        CandidateSkill candidateSkill = null;
        try {
            Object[] parameters = new Object[] {id};
            String query = "SELECT * FROM candidate_skill WHERE id = ?";
            candidateSkill = jdbcTemplate.queryForObject(query, parameters, mapper);
        } catch (EmptyResultDataAccessException er) {
        }
        return candidateSkill;
    }

    public List<CandidateSkill> findAll() {
        List<CandidateSkill> candidateSkillList = null;
        Object[] parameters = null;
        String query = "SELECT * FROM candidate_skill";
        candidateSkillList = jdbcTemplate.query(query, parameters, mapper);
        if (candidateSkillList != null && candidateSkillList.isEmpty()) {
            candidateSkillList = null;
        }
        return candidateSkillList;
    }

    public Integer save(CandidateSkill candidateSkill) {
        Integer skillId = null;
        try {
            KeyHolder personPrimaryKey = new GeneratedKeyHolder();

            Object[] parameters = new Object[] {candidateSkill.getSkillId(), candidateSkill.getCandidateId(),
                                                candidateSkill.getYear()};
            String query = "INSERT INTO candidate_skill (SKILL_ID, CANDIDATE_ID, YEAR) VALUES (?, ?, ?)";

            if (jdbcTemplate.update(conn -> DBUtils.createPsWithKey(conn, query, parameters), personPrimaryKey) > 0) {
                skillId = personPrimaryKey.getKey().intValue();
            }
        } catch (DataAccessException dae) {
            DBUtils.throwConflictException(dae);
        }
        return skillId;
    }

    public Boolean delete(Integer id) {
        Boolean isDeleted = false;
        Object[] parameters = new Object[] {id};
        String query = "DELETE FROM candidate_skill WHERE id = ?";
        if (jdbcTemplate.update(query, parameters) > 0) {
            isDeleted = true;
        }
        return isDeleted;
    }

}
