package com.pablo.back.controllers;

import com.pablo.back.model.Worker;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import java.util.ArrayList;

public class MasterController {


    @CrossOrigin()
    @RestController
    @RequestMapping({"/employees"})
    public class TestController {

        private List<Worker> employees = new ArrayList<>();

        @GetMapping(produces = "application/json")
        public List<Worker> firstPage() {
            return employees;
        }




        @DeleteMapping(path = {"/{id}"})
        public Worker delete(@PathVariable("id") int id) {
            Worker deletedEmp = null;
            for (Worker emp : employees) {
                if (emp.getWorkerID() == id) {
                    employees.remove(emp);
                    deletedEmp = emp;
                    break;
                }
            }
            return deletedEmp;
        }

        @PostMapping
        public Worker create(@RequestBody Worker user) {
            employees.add(user);
            return user;
        }

//        private static List<Worker> createList() {
//            List<Employee> tempEmployees = new ArrayList<>();
//            Employee emp1 = new Employee();
//            emp1.setName("emp1");
//            emp1.setDesignation("manager");
//            emp1.setEmpId("1");
//            emp1.setSalary(3000);
//
//            Employee emp2 = new Employee();
//            emp2.setName("emp2");
//            emp2.setDesignation("developer");
//            emp2.setEmpId("2");
//            emp2.setSalary(3000);
//            tempEmployees.add(emp1);
//            tempEmployees.add(emp2);
//            return tempEmployees;
//        }

    }
}
