package com.elpadriiino.employeeservice.service;

import com.elpadriiino.employeeservice.dto.FullEmployeeResponse;
import com.elpadriiino.employeeservice.feignclient.AddressClient;
import com.elpadriiino.employeeservice.model.Address;
import com.elpadriiino.employeeservice.model.Employee;
import com.elpadriiino.employeeservice.repository.EmployeeRepository;
import com.elpadriiino.employeeservice.response.EmployeeResponse;
import feign.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressClient addressClient;

    @Autowired
    private ModelMapper modelMapper;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }
    public FullEmployeeResponse findEmployeeAddress(Integer employeeId){
        var employee = employeeRepository.findById(employeeId)
        .orElse(
                Employee.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .age("NOT_FOUND")
                        .build()
        );
        var address = addressClient.getAddressByEmpId(employeeId);
        return FullEmployeeResponse.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .age(employee.getAge())
                .address(address)
                .build();
    }
    public Employee updateEmployee(Employee employeeToUpdate,Integer id){

          Optional <Employee> employeeFound = employeeRepository.findById(id);

          Employee employeeFoundAndGot = employeeFound.get();

          employeeFoundAndGot.setName(employeeToUpdate.getName());
          employeeFoundAndGot.setEmail(employeeToUpdate.getEmail());
          employeeFoundAndGot.setAge(employeeToUpdate.getAge());

          return employeeRepository.save(employeeFoundAndGot);
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }


}
