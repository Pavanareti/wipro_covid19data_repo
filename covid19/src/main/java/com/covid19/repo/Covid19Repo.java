package com.covid19.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid19.dto.Status;
import com.covid19.entity.Covid19DataEntity;

public interface Covid19Repo extends JpaRepository<Covid19DataEntity,Integer>{

	void save(Status entity);

}
