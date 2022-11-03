package com.db.example.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.example.data.Company;
import com.db.example.data.Employee;
import com.db.example.data.EmployeeInfoDto;
import com.db.example.repo.CompanyRepository;
import com.db.example.repo.EmployeeRepository;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository compRepo;

    @Autowired
    EmployeeRepository empRepo;

    @PostConstruct
    void init(){
        List<Long> ids = empRepo.getCompanyIds();

        for (Long e : ids) {
            System.out.println("***"+e);
        }
    }

    public void saveCompany(Company employee){
        compRepo.save(employee);
    }
    
    public void saveEmployee(Employee employee){
        empRepo.save(employee);
    }

    public List<Employee> getEmpoyees(){
        return empRepo.findAll();
    }

    public List<String> getCompanyNames(){
        return null;
    }

    public List<Employee> searchEmployees(String text){
        return empRepo.findByNameContains(text);
    }

    public List<EmployeeInfoDto> getEmployeeInfos(){
        return empRepo.getEmpoyeeInfos();
    }
}
