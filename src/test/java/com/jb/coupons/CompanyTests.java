package com.jb.coupons;

import com.jb.coupons.dao.CompanyDAO;
import com.jb.coupons.entities.Company;
import com.jb.coupons.exeptions.NotExistException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompanyTests {

    @Autowired
    private CompanyDAO companyDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void save(){
        try {
            companyDAO.addCompany(new Company("test2@test", "password", "TestCompany2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void delete(){
        try {
            companyDAO.deleteCompany(1L);
        } catch (NotExistException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAllCompanies(){
        System.out.println(companyDAO.getAllCompanies());
    }




}
