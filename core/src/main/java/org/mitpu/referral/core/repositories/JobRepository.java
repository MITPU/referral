package org.mitpu.referral.core.repositories;

import org.mitpu.referral.core.repositories.database.DBUtils;
import org.mitpu.referral.core.repositories.models.Job;
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
public class JobRepository {

    private RowMapper<Job> mapper = (rs, rowNum) -> {
        Job job = new Job();
        job.setId(rs.getInt("id"));
        job.setCandidateId(rs.getInt("candidate_id"));
        job.setCompanyId(rs.getInt("company_id"));
        job.setType(Job.Type.getType(rs.getByte("type")));
        job.setState(rs.getString("state"));
        job.setStack(Job.Stack.getStack(rs.getByte("stack")));
        job.setReferrerId(rs.getInt("referrer_id"));
        job.setPositionLink(rs.getString("positionlink"));
        job.setDate(DateTimeUtils.stringToDateTime(rs.getString("date")));
        job.setCountry(rs.getString("country"));
        job.setCity(rs.getString("city"));
        job.setPosition(rs.getString("position"));
        return job;
    };

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Job findById(Integer id) {
        Job job = null;
        try {
            Object[] parameters = new Object[] {id};
            String query = "SELECT * FROM job WHERE id = ?";
            job = jdbcTemplate.queryForObject(query, parameters, mapper);
        } catch (EmptyResultDataAccessException er) {
        }
        return job;
    }

    public List<Job> findAll() {
        List<Job> JobList = null;
        Object[] parameters = null;
        String query = "SELECT * FROM job";
        JobList = jdbcTemplate.query(query, parameters, mapper);
        if (JobList != null && JobList.isEmpty()) {
            JobList = null;
        }
        return JobList;
    }

    public Integer save(Job job) {
        Integer JobId = null;
        try {
            KeyHolder personPrimaryKey = new GeneratedKeyHolder();

            Object[] parameters = new Object[] {
                    job.getCompanyId(),
                    job.getCandidateId(),
                    job.getPosition(),
                    job.getType().value,
                    job.getStack().value,
                    job.getPositionLink(),
                    job.getState(),
                    job.getCity(),
                    job.getCountry(),
                    job.getReferrerId()
            };
            String query =
                    "INSERT INTO job (COMPANY_ID, CANDIDATE_ID, POSITION, TYPE, DATE, STACK, POSITIONLINK, STATE, CITY, COUNTRY, REFERRER_ID) "
                            + "VALUES (?, ?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?)";

            if (jdbcTemplate.update(conn -> DBUtils.createPsWithKey(conn, query, parameters), personPrimaryKey) > 0) {
                JobId = personPrimaryKey.getKey().intValue();
            }
        } catch (DataAccessException dae) {
            dae.printStackTrace();
            DBUtils.throwConflictException(dae);
        }
        return JobId;
    }

    public Boolean delete(Integer id) {
        Boolean isDeleted = false;
        Object[] parameters = new Object[] {id};
        String query = "DELETE FROM job WHERE id = ?";
        if (jdbcTemplate.update(query, parameters) > 0) {
            isDeleted = true;
        }
        return isDeleted;
    }
}
