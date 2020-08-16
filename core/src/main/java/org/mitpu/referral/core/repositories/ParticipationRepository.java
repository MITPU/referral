package org.mitpu.referral.core.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitpu.referral.core.repositories.database.DBUtils;
import org.mitpu.referral.core.repositories.models.Participation;
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
public class ParticipationRepository {

    private static final Logger LOGGER = LogManager.getLogger(ParticipationRepository.class);

    private RowMapper<Participation> mapper = (rs, rowNum) -> {
        Participation participation = new Participation();
        participation.setId(rs.getInt("id"));
        participation.setName(rs.getString("name"));
        return participation;
    };

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ParticipationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Participation findById(Integer id) {
        Participation participation = null;
        try {
            Object[] parameters = new Object[]{id};
            String query = "SELECT * FROM participation WHERE id = ?";
            participation = jdbcTemplate.queryForObject(query, parameters, mapper);
        } catch (EmptyResultDataAccessException er) {
            LOGGER.debug("Query returned empty result set.");
        }
        return participation;
    }

    public List<Participation> findAll() {
        List<Participation> participationList = null;
        Object[] parameters = null;
        String query = "SELECT * FROM participation";
        participationList = jdbcTemplate.query(query, parameters, mapper);
        if (participationList != null && participationList.isEmpty()) {
            participationList = null;
        }
        return participationList;
    }

    public Integer save(Participation participation) {
        Integer participationId = null;
        try {
            KeyHolder personPrimaryKey = new GeneratedKeyHolder();

            Object[] parameters = new Object[]{participation.getName()};
            String query = "INSERT INTO participation (NAME) VALUES (?)";

            if (jdbcTemplate.update(conn -> DBUtils.createPsWithKey(conn, query, parameters), personPrimaryKey) > 0) {
                participationId = personPrimaryKey.getKey().intValue();
            }
        } catch (DataAccessException dae) {
            DBUtils.catchException(dae);
        }
        return participationId;
    }

    public Boolean delete(Integer id) {
        Boolean isDeleted = false;
        Object[] parameters = new Object[]{id};
        String query = "DELETE FROM participation WHERE id = ?";
        if (jdbcTemplate.update(query, parameters) > 0) {
            isDeleted = true;
        }
        return isDeleted;
    }

}
