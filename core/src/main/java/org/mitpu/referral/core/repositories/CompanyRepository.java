package org.mitpu.referral.core.repositories;

import org.mitpu.referral.core.repositories.database.DBUtils;
import org.mitpu.referral.core.repositories.models.Company;
import org.mitpu.referral.core.repositories.models.WorkAuthorization;
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
public class CompanyRepository {

    private RowMapper<Company> mapper = (rs, rowNum) -> {
        Company company = new Company();
        company.setId(rs.getInt("id"));
        company.setName(rs.getString("name"));
        company.setState(rs.getString("state"));
        company.setCountry(rs.getString("country"));
        company.setIndustry(rs.getString("industry"));
        company.setCity(rs.getString("city"));
        company.setCareerLink(rs.getString("careerlink"));
        company.setWorkAuthorization(WorkAuthorization.getWorkAuthorization(rs.getByte("workauthorization")));
        return company;
    };

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Company findById(Integer id) {
        Company company = null;
        try {
            Object[] parameters = new Object[] {id};
            String query = "SELECT * FROM company WHERE id = ?";
            company = jdbcTemplate.queryForObject(query, parameters, mapper);
        } catch (EmptyResultDataAccessException er) {
        }
        return company;
    }

    public List<Company> findAll() {
        List<Company> companyList = null;
        Object[] parameters = null;
        String query = "SELECT * FROM company";
        companyList = jdbcTemplate.query(query, parameters, mapper);
        if (companyList != null && companyList.isEmpty()) {
            companyList = null;
        }
        return companyList;
    }

    public Integer save(Company company) {
        Integer companyId = null;
        try {
            KeyHolder personPrimaryKey = new GeneratedKeyHolder();

            Object[] parameters = new Object[] {company.getName(), company.getCareerLink(), company.getIndustry(),
                                                company.getWorkAuthorization().value, company.getCity(), company.getState(),
                                                company.getCountry()};
            String query = "INSERT INTO company (NAME, CAREERLINK, INDUSTRY, WORKAUTHORIZATION, CITY, STATE, COUNTRY) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            if (jdbcTemplate.update(conn -> DBUtils.createPsWithKey(conn, query, parameters), personPrimaryKey) > 0) {
                companyId = personPrimaryKey.getKey().intValue();
            }
        } catch (DataAccessException dae) {
            DBUtils.throwConflictException(dae);
        }
        return companyId;
    }

    public Boolean delete(Integer id) {
        Boolean isDeleted = false;
        Object[] parameters = new Object[] {id};
        String query = "DELETE FROM company WHERE id = ?";
        if (jdbcTemplate.update(query, parameters) > 0) {
            isDeleted = true;
        }
        return isDeleted;
    }
}
