package com.elpadriiino.employeeservice.dto;

import com.elpadriiino.employeeservice.model.Address;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullEmployeeResponse {
       private String name;
       private String email;
       private String age;
       Address address;
}
