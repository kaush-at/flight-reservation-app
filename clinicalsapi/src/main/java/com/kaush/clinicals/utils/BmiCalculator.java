package com.kaush.clinicals.utils;

import java.util.List;

import com.kaush.clinicals.entities.ClinicalData;

public class BmiCalculator {

	public static void calculateBMI(List<ClinicalData> clinicalData, ClinicalData eachEntry) {
		if (eachEntry.getComponentName().equals("hw")) {
			String[] hieghtAndWeight = eachEntry.getComponentValue().split("/");

			if (hieghtAndWeight != null && hieghtAndWeight.length > 1) {
				float heightInMeters = Float.parseFloat(hieghtAndWeight[0]) * 0.4536F;
				float bmi = Float.parseFloat(hieghtAndWeight[1]) / (heightInMeters * heightInMeters);

				ClinicalData bmiData = new ClinicalData();
				bmiData.setComponentName("bmi");
				bmiData.setComponentValue(Float.toString(bmi));

				clinicalData.add(bmiData); 
			}

		}
	}
}
