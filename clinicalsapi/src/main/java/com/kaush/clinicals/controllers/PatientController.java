package com.kaush.clinicals.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaush.clinicals.entities.ClinicalData;
import com.kaush.clinicals.entities.Patient;
import com.kaush.clinicals.repos.PatientRepository;
import com.kaush.clinicals.utils.BmiCalculator;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

	private PatientRepository patientRepo;

	@Autowired
	PatientController(PatientRepository patientRepo) {
		this.patientRepo = patientRepo;
	}

	Map<String, String> filters = new HashMap<>();
	
	@RequestMapping("/patients")
	public List<Patient> getAllPatients() {
		List<Patient> patientList = patientRepo.findAll();
		return patientList;
	}

	// @RequestMapping(value="/patients/{id}", method=RequestMethod.GET)
	@GetMapping("/patientDetails/{id}")
	public Patient getPatientDetails(@PathVariable("id") int id) {
		return patientRepo.findById(id).get();
	}

	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public Patient savePatient(@RequestBody Patient patient) { // request eka ena json eka deserialize karala map
																// karannawa patient object ekata
		return patientRepo.save(patient);

	}

	@RequestMapping(value = "/patients/analyze/{id}", method = RequestMethod.GET)
	public Patient analyze(@PathVariable("id") int id) {
		Patient patient = patientRepo.findById(id).get();
		List<ClinicalData> clinicalData = patient.getClinicalData();

		// creating a duplicate of a clinicalData
		ArrayList<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);

		for (ClinicalData eachEntry : duplicateClinicalData) {
			
			if(filters.containsKey(eachEntry.getComponentName())) {
				clinicalData.remove(eachEntry);
				continue;
			}else {
				filters.put(eachEntry.getComponentName(), null);
			}
			
			BmiCalculator.calculateBMI(clinicalData, eachEntry);  // right click -> refactor  -> extract method 
		}
		filters.clear();
		return patient;

	}



}
