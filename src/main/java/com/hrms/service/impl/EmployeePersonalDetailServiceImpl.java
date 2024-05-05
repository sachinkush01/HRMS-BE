package com.hrms.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.dto.EmployeePersonalDetailsDto;
import com.hrms.entity.EmployeeMaster;
import com.hrms.entity.EmployeePersonalDetail;
import com.hrms.repository.EmployeePersonalDetailsRepository;
import com.hrms.service.EmployeePersonalDetailService;

@Service
public class EmployeePersonalDetailServiceImpl implements EmployeePersonalDetailService {

	@Autowired
	private EmployeePersonalDetailsRepository repo;

	@Override
	public EmployeePersonalDetail getEmpPersonalDetailsById(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EmployeePersonalDetail saveEmployeePersonalDetails(Date currentDate,
			EmployeePersonalDetailsDto personalDto) {
		EmployeePersonalDetail e3 = new EmployeePersonalDetail();
		e3.setName(personalDto.getName());
		e3.setEmp_id(personalDto.getEmp_id());
		e3.setCreated_on(currentDate);
		e3.setUdated_on(currentDate);
		e3.setGender(personalDto.getGender());
		e3.setAge(personalDto.getAge());
		e3.setAddress(personalDto.getAddress());
		e3.setOther_field_1(personalDto.getOther_field_1());
		e3.setOther_field_2(personalDto.getOther_field_2());
		return this.saveEmployeePersonalDetails(e3);
	}

	@Transactional
	protected EmployeePersonalDetail saveEmployeePersonalDetails(EmployeePersonalDetail empDetails) {
		return repo.save(empDetails);
	}

	@Override
	public EmployeePersonalDetail getEmployeePersonalDetailsByEmployeeId(Integer emp_id) {
		return repo.findByEmp_Id(emp_id);
	}

	@Override
	public Map<Integer, String> getAllEmployeeNamesByIds(List<Integer> empIds) {
		List<EmployeePersonalDetail> list = repo.findAllByEmpIdIn(empIds);
		Map<Integer, String> nameMap = list.stream()
				.collect(Collectors.toMap(EmployeePersonalDetail::getEmp_id, EmployeePersonalDetail::getName));
		return nameMap;
	}

	@Override
	public EmployeePersonalDetail updateEmpPersonalDetails(Date currentDate, Integer emp_id, EmployeePersonalDetailsDto employeePersonalDetail) {
		//Integer	empID=employeePersonalDetail.getEmp_id();
		EmployeePersonalDetail emp2=repo.findByEmp_Id(emp_id);
		emp2.setName(employeePersonalDetail.getName());
		emp2.setAddress(employeePersonalDetail.getAddress());
		return repo.save(emp2);
	}

}
