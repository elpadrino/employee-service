package com.elpadriiino.employeeservice.feignclient;

import com.elpadriiino.employeeservice.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service", url = "http://localhost:8081", path = "/address-service")
public interface AddressClient {
    @GetMapping("/api/v1/address/{employeeId}")
    public Address getAddressByEmpId(@PathVariable(name="employeeId")Integer employeeId);
}
