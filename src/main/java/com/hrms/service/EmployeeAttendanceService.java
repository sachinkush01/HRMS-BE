package com.hrms.service;

import java.util.Date;
import java.util.List;

import com.hrms.entity.EmployeeAttendance;

public interface EmployeeAttendanceService {

	EmployeeAttendance getEmployeeAttendance(int id);

	List<EmployeeAttendance> getEmployeeAttendanceByList(String idListSepByComma);

	EmployeeAttendance saveEmployeeAttendance(EmployeeAttendance employeeAttendance);

	EmployeeAttendance updateEmployeeAttendance(EmployeeAttendance employeeAttendance);

	List<EmployeeAttendance> getEmAttendanceBetweenDate(Date startDate, Date endDate, int empId);

	List<EmployeeAttendance> getEmAttendanceBetweenDateAndTime(String startDate, String endDate, Integer empId);

	EmployeeAttendance findTodayAttendenceByEmpId(Integer empId);
}
