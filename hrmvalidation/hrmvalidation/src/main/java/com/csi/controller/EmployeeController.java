package com.csi.controller;


import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")
        public ResponseEntity<Employee>signUp(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServiceImpl.signUp(employee), HttpStatus.CREATED);
    }
    @GetMapping("signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean>signIn(@PathVariable String empEmailId,@PathVariable String empPassword) {
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId, empPassword));
    }
    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>>getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }
    @GetMapping("/getalldata")
    public  ResponseEntity<List<Employee>>getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }
    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee>updateData(@PathVariable int empId,@Valid @RequestBody Employee employee){
      Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RecordNotFoundException("Employee Id Does Not Exist"));
      employee1.setEmpFirstName(employee.getEmpFirstName());
      employee1.setEmpLastName(employee.getEmpLastName());
      employee1.setEmpAddress(employee.getEmpAddress());
      employee1.setEmpSalary(employee.getEmpSalary());
      employee1.setEmpDOB(employee.getEmpDOB());
      employee1.setEmpEmailId(employee.getEmpEmailId());
      employee1.setEmpPassword(employee.getEmpPassword());

      return new ResponseEntity<>(employeeServiceImpl.updateData(employee1),HttpStatus.CREATED);
    }
    @DeleteMapping("/deletedatabyid/{empId}")
    public  ResponseEntity<String>deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
