package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savaedata")
    public ResponseEntity <Employee>saveData(@RequestBody Employee employee){
    log.info("Trying to save data");
       return  ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getalldata")
    public  ResponseEntity <List<Employee>>getAllData(){
        return  ResponseEntity.ok(employeeServiceImpl.getAllData());
    }
    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee>updataData(@PathVariable int empId,@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.updateData(employee));
    }

    @DeleteMapping("/deletedata/{empId}")
    public ResponseEntity<String>deleteData(@PathVariable int empId){
        employeeServiceImpl.deleteData(empId);
        return ResponseEntity.ok("Data deleted successfully");
    }

    @GetMapping("/getdatabyname/{empFirstName}")
    public ResponseEntity<List<Employee>>getDataByName(@PathVariable String empFirstName){
        return  ResponseEntity.ok(employeeServiceImpl.getDataByName(empFirstName));
    }
}
