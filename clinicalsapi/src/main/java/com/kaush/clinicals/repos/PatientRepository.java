package com.kaush.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.clinicals.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
