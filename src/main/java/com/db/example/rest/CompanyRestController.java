package com.db.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.db.example.data.Company;
import com.db.example.data.Employee;
import com.db.example.data.EmployeeInfoDto;
import com.db.example.service.CompanyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CompanyRestController {

    @Autowired
    CompanyService compService;

    @PostMapping("addcompany")
    public String addCompany(@RequestBody Company company) {
        return "Ok";
    }

    @PostMapping("addemployee")
    public String addEmployee(@RequestBody Employee employee) {
        return "Ok";
    }

    @GetMapping("getbytext")
    public List<Employee> getEmpoyeesByText(@RequestParam String text){
        return compService.searchEmployees(text);
    }
  
    @GetMapping("getinfo")
    public List<EmployeeInfoDto> getInfo(){
        return compService.getEmployeeInfos();
    }
    
}
