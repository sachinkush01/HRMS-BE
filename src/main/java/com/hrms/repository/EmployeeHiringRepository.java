package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.EmployeeHiringDetail;
@Repository
 public interface EmployeeHiringRepository extends JpaRepository<EmployeeHiringDetail, Integer>{

}
