package org.mitpu.referral.core.controllers.mapper;

import org.mitpu.referral.core.controllers.dto.CompanyDto;
import org.mitpu.referral.core.repositories.models.Company;
import org.mitpu.referral.core.repositories.models.WorkAuthorization;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company getCompanyFrom(CompanyDto companyDto) {
        if (companyDto == null) {
            return null;
        }
        Company company = new Company();
        company.setCareerLink(companyDto.getCareerLink());
        company.setCity(companyDto.getCity());
        company.setCountry(companyDto.getCountry());
        company.setId(companyDto.getId());
        company.setIndustry(companyDto.getIndustry());
        company.setName(companyDto.getName());
        company.setState(companyDto.getState());
        company.setWorkAuthorization(WorkAuthorization.getWorkAuthorization(companyDto.getWorkAuthorization()));
        return company;
    }

    public CompanyDto getCompanyDto(Company company) {
        if (company == null) {
            return null;
        }
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCareerLink(company.getCareerLink());
        companyDto.setCity(company.getCity());
        companyDto.setCountry(company.getCountry());
        companyDto.setId(company.getId());
        companyDto.setIndustry(company.getIndustry());
        companyDto.setName(company.getName());
        companyDto.setState(company.getState());
        companyDto.setWorkAuthorization(company.getWorkAuthorization().value);
        return companyDto;
    }
}
