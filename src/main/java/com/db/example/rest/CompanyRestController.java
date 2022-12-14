package com.db.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.db.example.data.EmployeeInfoDto;
import com.db.example.service.CompanyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CompanyRestController {

    @Autowired
    CompanyService compService;

    @GetMapping("search")
    public List<String> getNamesByText(@RequestParam String keyword){
        return compService.searchNamesByKeyword(keyword);
    }

    @GetMapping("employeeinfos")
    public List<EmployeeInfoDto> getEmployeeInfos(){
        return compService.getEmployeeInfos();
    }
}
