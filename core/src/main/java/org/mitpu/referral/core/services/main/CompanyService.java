package org.mitpu.referral.core.services.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mitpu.referral.core.repositories.CompanyRepository;
import org.mitpu.referral.core.repositories.models.Company;
import org.mitpu.referral.core.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private static final Logger LOGGER = LogManager.getLogger(SkillService.class);

    private final static String OBJECT_NAME = "company";

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getCompany(Integer id) {
        Company company = companyRepository.findById(id);
        if (company == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return company;
    }

    public List<Company> getCompanies() {
        List<Company> companyList = companyRepository.findAll();
        if (companyList == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        return companyList;
    }

    public void deleteCompany(Integer id) {
        Company company = companyRepository.findById(id);
        if (company == null) {
            throw new NotFoundException(OBJECT_NAME);
        }
        if (companyRepository.delete(id)) {
            LOGGER.debug("{} is deleted successfully.", OBJECT_NAME);
        }
    }

    public Integer createCompany(Company company) {
        Integer newKey = companyRepository.save(company);

        return newKey;
    }
}
