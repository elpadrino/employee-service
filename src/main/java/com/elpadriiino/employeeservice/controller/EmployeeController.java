package com.elpadriiino.employeeservice.controller;

import com.elpadriiino.employeeservice.dto.FullEmployeeResponse;
import com.elpadriiino.employeeservice.model.Employee;
import com.elpadriiino.employeeservice.repository.EmployeeRepository;
import com.elpadriiino.employeeservice.response.EmployeeResponse;
import com.elpadriiino.employeeservice.service.EmployeeService;
import jakarta.persistence.Access;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees/")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(name = "id")Integer id){

        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee-ad/{employeeId}")
    public ResponseEntity<FullEmployeeResponse> getEmployeeDetails(@PathVariable(name="employeeId") Integer employeeId){
        return ResponseEntity.ok(employeeService.findEmployeeAddress(employeeId));
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employeeToSave){
        return employeeService.saveEmployee(employeeToSave);
    }

    @PutMapping("{id}")
    public Employee updateEmployee(@RequestBody Employee employeeToUpdate,@PathVariable(name="id")Integer id){
        return employeeService.updateEmployee(employeeToUpdate,id);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable(name = "id")Integer id){
        employeeService.deleteEmployee(id);

    }

    /*@GetMapping("{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable(name="id")int id){
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }*/
}
