package org.mitpu.referral.core.controllers;

import org.mitpu.referral.core.controllers.dto.CompanyDto;
import org.mitpu.referral.core.controllers.dto.validation.Validation;
import org.mitpu.referral.core.controllers.dto.validation.ValidationFactory;
import org.mitpu.referral.core.controllers.mapper.CompanyMapper;
import org.mitpu.referral.core.repositories.models.Company;
import org.mitpu.referral.core.services.main.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {

    private CompanyMapper companyMapper;

    private CompanyService companyService;

    private static final String SUCCESS_RESPONSE_MESSAGE = "Request is successfully executed.";

    @Autowired
    public CompanyController(CompanyMapper companyMapper, CompanyService companyService) {
        this.companyMapper = companyMapper;
        this.companyService = companyService;
    }

    @RequestMapping(path = "/company/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCompany(@PathVariable(name = "id") Integer id) {
        CompanyDto companyDto = new CompanyDto();

        // validating request
        companyDto.setId(id);
        Validation validation = ValidationFactory.getValidation(companyDto);
        validation.validateRequest(companyDto, RequestMethod.GET);

        Company company = companyService.getCompany(id);

        // mapping
        companyDto = companyMapper.getCompanyDtoFrom(company);
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }

    @RequestMapping(path = "/companies", method = RequestMethod.GET)
    public ResponseEntity<?> getCompanies() {
        List<CompanyDto> companyDtoList = new ArrayList<>();

        List<Company> companyList = companyService.getCompanies();

        // mapping
        for (Company company : companyList) {
            companyDtoList.add(companyMapper.getCompanyDtoFrom(company));
        }
        return new ResponseEntity<>(companyDtoList, HttpStatus.OK);
    }

    @RequestMapping(path = "/company/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCompany(@PathVariable(name = "id") Integer id) {
        CompanyDto companyDto = new CompanyDto();

        // validating request
        companyDto.setId(id);
        Validation validation = ValidationFactory.getValidation(companyDto);
        validation.validateRequest(companyDto, RequestMethod.DELETE);

        companyService.deleteCompany(id);

        return new ResponseEntity<>(SUCCESS_RESPONSE_MESSAGE, HttpStatus.OK);
    }

    @RequestMapping(path = "/company", method = RequestMethod.POST)
    public ResponseEntity<?> createCompany(@RequestBody CompanyDto companyDto) {

        // validating request
        Validation validation = ValidationFactory.getValidation(companyDto);
        validation.validateRequest(companyDto, RequestMethod.POST);

        Integer newKey = companyService.createCompany(companyMapper.getCompanyFrom(companyDto));
        companyDto.setId(newKey);
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }

}
