package com.hrms.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrms.entity.EmployeeAttendance;
import com.hrms.repository.EmployeeAttendanceRepository;
import com.hrms.service.EmployeeAttendanceService;

@Service
@Transactional
public class EmployeeAttendanceImpl implements EmployeeAttendanceService {
	
	@Autowired
	EmployeeAttendanceRepository eAttendanceRepo;

	@Override
	public EmployeeAttendance getEmployeeAttendance(int id) {
		Optional<EmployeeAttendance> AttendanceList = this.eAttendanceRepo.findById(id);
		return ! AttendanceList.isPresent() ? null : AttendanceList.get();
	}
	
	@Override
	public List<EmployeeAttendance> getEmployeeAttendanceByList(String idListSepByComma) {
		List<Integer> listInt = Arrays.asList(idListSepByComma.split(",")).stream().map(e -> Integer.parseInt(e))
				.collect(Collectors.toList());
		return eAttendanceRepo.findAllById(listInt);
	}

	@Override
	public EmployeeAttendance saveEmployeeAttendance(EmployeeAttendance employeeAttendance) {
		return this.eAttendanceRepo.save(employeeAttendance);
	}

	@Override
	public EmployeeAttendance updateEmployeeAttendance(EmployeeAttendance employeeAttendance) {
		return this.eAttendanceRepo.save(employeeAttendance);
	}

	@Override
	public List<EmployeeAttendance> getEmAttendanceBetweenDate(Date startDate, Date endDate, int empId) {
		return this.eAttendanceRepo.findAllWithEmpId(startDate, endDate, empId);
	}

	@Override
	public EmployeeAttendance findTodayAttendenceByEmpId(Integer empId) {
		return this.eAttendanceRepo.findTodayAttendenceByEmpId(empId);
	}

	@Override
	public List<EmployeeAttendance> getEmAttendanceBetweenDateAndTime(String startDate, String endDate, Integer empId) {
		if(null != empId) {
			return this.eAttendanceRepo.findAllWithEmpIdBetweenStartDateAndEndDate(startDate, endDate, empId);
		}
		return this.eAttendanceRepo.findAllWithCreationDateBetweenCustom(startDate, endDate);
	}
	
}
