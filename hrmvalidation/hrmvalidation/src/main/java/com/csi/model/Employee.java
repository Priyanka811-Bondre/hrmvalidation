package com.csi.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

   @Id
   @GeneratedValue

   private int empId;

    @Pattern(regexp="[A-Za-z]*", message="First name should not contain space and special characters")
   private String empFirstName;

   @Size(min = 2,message = "Employee last name should be atleast 2 character")
   private String empLastName;

   @NotNull
   private String empAddress;

   @NotNull
   private double empSalary;

   @JsonFormat (pattern = "dd-MM-yyyy")
   @NotNull
   private Date empDOB;


  @Email(message = "Email should be valid")
   private String empEmailId;


   @Size(min=4,message = "Password at least 4 character")
   private String empPassword;
}
