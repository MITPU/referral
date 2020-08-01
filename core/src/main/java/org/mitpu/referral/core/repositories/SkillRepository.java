package org.mitpu.referral.core.repositories;

import org.mitpu.referral.core.repositories.database.DBUtils;
import org.mitpu.referral.core.repositories.models.Skill;
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
public class SkillRepository {

    private RowMapper<Skill> mapper = (rs, rowNum) -> {
        Skill skill = new Skill();
        skill.setId(rs.getInt("id"));
        skill.setName(rs.getString("name"));
        return skill;
    };

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SkillRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Skill findById(Integer id) {
        Skill skill = null;
        try {
            Object[] parameters = new Object[] {id};
            String query = "SELECT * FROM skill WHERE id = ?";
            skill = jdbcTemplate.queryForObject(query, parameters, mapper);
        } catch (EmptyResultDataAccessException er) {
        }
        return skill;
    }

    public List<Skill> findAll() {
        List<Skill> skillList = null;
        Object[] parameters = null;
        String query = "SELECT * FROM skill";
        skillList = jdbcTemplate.query(query, parameters, mapper);
        if (skillList != null && skillList.isEmpty()) {
            skillList = null;
        }
        return skillList;
    }

    public Integer save(Skill skill) {
        Integer skillId = null;
        try {
            KeyHolder personPrimaryKey = new GeneratedKeyHolder();

            Object[] parameters = new Object[] {skill.getName()};
            String query = "INSERT INTO skill (NAME) VALUES (?)";

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
        String query = "DELETE FROM skill WHERE id = ?";
        if (jdbcTemplate.update(query, parameters) > 0) {
            isDeleted = true;
        }
        return isDeleted;
    }

}
