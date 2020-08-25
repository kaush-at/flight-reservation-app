package com.kaush.clinicals.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kaush.clinicals.dtos.ClinicalDataRequest;
import com.kaush.clinicals.entities.ClinicalData;
import com.kaush.clinicals.entities.Patient;
import com.kaush.clinicals.repos.ClinicalDataRepository;
import com.kaush.clinicals.repos.PatientRepository;
import com.kaush.clinicals.utils.BmiCalculator;

@RestController
@RequestMapping("/api")
@CrossOrigin  
public class ClinicalDataController {

	private ClinicalDataRepository clinicalDataRepository;

	private PatientRepository patientRepository;

	public ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository) {
		this.clinicalDataRepository = clinicalDataRepository;
		this.patientRepository = patientRepository;
	}

	@RequestMapping(value = "/saveClinicalData", method = RequestMethod.POST)
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		Patient patient = patientRepository.findById(request.getPatientId()).get();

		ClinicalData clinicalData = new ClinicalData();

		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);
		return clinicalDataRepository.save(clinicalData);

	}

	@RequestMapping(value = "/getSpecificClinicalData/{id}/{ComponentName}", method = RequestMethod.GET)
	public List<ClinicalData> getSpecificClinicalData(@PathVariable("ComponentName") String componentName,
			@PathVariable("id") int patientId) {

		if (componentName.equals("bmi")) {
			componentName="hw";
		}
		List<ClinicalData> specifiedClinicalData = clinicalDataRepository
				.findByPatientIdAndComponentNameOrderByMeasuredDateTime(patientId, componentName); 
													
		ArrayList<ClinicalData> duplicateClinicalData = new ArrayList<>(specifiedClinicalData);
		for (ClinicalData eachEntry : duplicateClinicalData) {
			BmiCalculator.calculateBMI(specifiedClinicalData, eachEntry);
		}

		return specifiedClinicalData;
	}
}
