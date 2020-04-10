package com.jb.coupons.dao;

import com.jb.coupons.entities.Company;
import com.jb.coupons.exeptions.NotExistException;
import com.jb.coupons.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class CompanyDAO {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyDAO(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> getCompanyById(Long companyId) {
        return companyRepository.findById(companyId);
    }

    public Company addCompany(Company company) throws Exception {
        try {
            return  companyRepository.save(company);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Company updateCompany(Company company) throws Exception {
        return addCompany(company);
    }

    public Company deleteCompany(Long companyId) throws NotExistException {
        return getCompanyById(companyId).map( company -> {
            companyRepository.delete(company);
            return company;
        }).orElseThrow(() -> new NotExistException("Company with id:" + companyId + " not exists"));
    }

    public ArrayList<Company> getAllCompanies(){
       return (ArrayList<Company>) companyRepository.findAll();
    }






}
