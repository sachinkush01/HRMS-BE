package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.MyInfoDetail;
@Repository
public interface MyInfoRepository  extends JpaRepository<MyInfoDetail,Integer> {

}
