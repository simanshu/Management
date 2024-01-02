package com.Management.Management.controller;

import com.Management.Management.model.boss;
import com.Management.Management.model.employee;
import com.Management.Management.repository.bossrepository;
import com.Management.Management.repository.employeerepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class managementcontroller {
    @Autowired
    bossrepository bossrepo;
    @Autowired
    employeerepository emprepo;

    private final List<employee> employees;
    private final List<boss> bosses;


    @RequestMapping("/addboss")
    public String addboss(@RequestBody boss bossadd){
        bosses.add(bossadd);
        return "Boss Add Successfull";
    }
    @RequestMapping("/addemp")
    public String addemp(@RequestBody employee emp){
        employees.add(emp);
        return "Employee Add Successfull";

    }

    @GetMapping("/getemp")
    public List<employee> getEmployees(@RequestParam int ageLimit, @RequestParam int ratingLimit) {
        List<employee> filteredEmployees = new ArrayList<>();

        for (employee employee : employees) {
            if (employee.getAge() < ageLimit && employee.getRating() > ratingLimit) {
                filteredEmployees.add(employee);
            }
        }

        return filteredEmployees;
    }
    @PutMapping("/updateboos")
    public String updatesalary(@RequestParam int x,@RequestParam int y){
        bosses.forEach(boss -> {
            if(boss.getRating()>y)
                boss.setSalary(boss.getSalary()+x);
        });
        return "update successfull";
    }
    @GetMapping("/allemp")
    public long allemp(@RequestParam int x){
        return employees.stream()
                .filter(employee -> employee.getRating()>x)
                .count();
    }



}
