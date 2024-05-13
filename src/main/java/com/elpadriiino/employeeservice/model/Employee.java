package com.elpadriiino.employeeservice.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Data
@Entity
@Table(name="employee")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name="email",nullable = false)
    private String email;

    @Column(name = "age", nullable = false)
    private String age;


}
