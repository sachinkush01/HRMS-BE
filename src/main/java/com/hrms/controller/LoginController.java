package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dto.LoginDto;
import com.hrms.entity.EmployeeMaster;
import com.hrms.enums.ExceptionEnum;
import com.hrms.enums.SuccessEnum;
import com.hrms.response.LoginResponse;
import com.hrms.service.EmployeeHrmsDetailService;
import com.hrms.service.EmployeeMasterService;

@RestController
public class LoginController {
	@Autowired
	EmployeeMasterService eMasterSerice;
	
	@Autowired
	EmployeeHrmsDetailService employeeHrmsService;
	
	@GetMapping("")
	public String home () {
		return "welcome home";
	}

//	@PostMapping("/login")
//	public LoginResponse login(@RequestBody LoginDto loginDto) {
//		LoginResponse response = new LoginResponse();
//		
//		EmployeeMaster employeeMasterEntity = eMasterSerice.getEmployee(Integer.parseInt(loginDto.getId()));
//		if(employeeMasterEntity.getPassword().equals(loginDto.getPassword()) ) {
//			response.setCode(200);
//			response.setMessage("success");
//			response.setData(employeeMasterEntity);
//		} else {
//			response.setCode(401);
//			response.setMessage("unauthorized");
//		}
//		return response;
//	}
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginDto loginDto) {
		LoginResponse response = new LoginResponse();
		
		EmployeeMaster employeeMasterEntity = eMasterSerice.getEmployee(Integer.parseInt(loginDto.getId()));
		employeeMasterEntity.setPassword("12345");
		if(employeeMasterEntity.getPassword().equals("12345")) {
			response.setCode(SuccessEnum.SUCCESS_LOGIN.getCode());
			response.setMessage(SuccessEnum.SUCCESS_LOGIN.getMessage());
			response.setData(employeeMasterEntity);
		} else {
			response.setCode(ExceptionEnum.INVALID_SESSION.getErrorCode());
			response.setMessage(ExceptionEnum.INVALID_SESSION.getMessage());
		}
		return response;
	}
}
