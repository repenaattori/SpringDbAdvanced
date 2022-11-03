package com.db.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.example.data.EmployeeInfoDto;
import com.db.example.repo.CompanyRepository;
import com.db.example.repo.EmployeeRepository;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository compRepo;

    @Autowired
    EmployeeRepository empRepo;

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
}
