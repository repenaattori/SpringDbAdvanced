package com.db.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.example.data.EmployeeInfoDto;
import com.db.example.repo.CompanyRepository;
import com.db.example.repo.EmployeeRepository;

@Service
public class CompanyService {
    
    CompanyRepository compRepo;
    EmployeeRepository empRepo;

    public CompanyService(CompanyRepository compRepo, EmployeeRepository empRepo){
        this.compRepo = compRepo;
        this.empRepo = empRepo;
    }

    /**
     * Etsii hakusanalla työntekijöiden nimiä
     */
    public List<String> searchNamesByKeyword(String keyword){
        return empRepo.getEmployeeNamesByKeyword(keyword);
    }

    /**
     * Hakee työntekijöiden nimen ja työpaikan nimen olioina.
     */
    public List<EmployeeInfoDto> getEmployeeInfos(){
        return empRepo.getEmpoyeeInfos();
    }

    public  List<Map<String, Object>> getCustom(){
        return  empRepo.getCustomEmployeeInfo();
    }
}
