package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
