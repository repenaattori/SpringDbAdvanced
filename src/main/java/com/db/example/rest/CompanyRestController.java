package com.db.example.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.db.example.data.Company;
import com.db.example.data.EmployeeInfoDto;
import com.db.example.service.CompanyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CompanyRestController {

    CompanyService compService;

    public CompanyRestController(CompanyService compService){
        this.compService = compService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<String>> getNamesByText(@RequestParam String keyword){
        return new ResponseEntity<>(compService.searchNamesByKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("/employeeinfos")
    public ResponseEntity<List<EmployeeInfoDto>> getEmployeeInfos(){
        return new ResponseEntity<>(compService.getEmployeeInfos(), HttpStatus.OK);
    }

    @GetMapping("/customemployees")
    public ResponseEntity<List<Map<String, Object>>> getCustoEmployeeInfo(){
        return new ResponseEntity<>(compService.getCustom(), HttpStatus.OK);
    }

    @PostMapping("/addcompany")
    public ResponseEntity<String> addCompany(Company company){
        compService.addCompany(company);
        HttpStatus status = company == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
        return new ResponseEntity<String>(status);
    }
}
