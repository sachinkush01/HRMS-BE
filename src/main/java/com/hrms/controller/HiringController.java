package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.EmployeeHiringDetail;
import com.hrms.service.EmployeeHiringSevice;

import java.util.List;
@RestController
public class HiringController  {
	@Autowired
   EmployeeHiringSevice employeeHiringSevice;
	
	@GetMapping("/gethiring") 	
	public List<EmployeeHiringDetail> gethiHiringDetails() {
		return this.employeeHiringSevice.getALLEmployeeHiringDetails();


}
	@GetMapping("/gethiring/{Id}")
	   public EmployeeHiringDetail getBook(@PathVariable String Id) {
		   
		   return this.employeeHiringSevice.getHiringDetails(Integer.parseInt(Id));
}
}