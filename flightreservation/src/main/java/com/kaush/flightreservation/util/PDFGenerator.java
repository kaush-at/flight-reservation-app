package com.kaush.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.kaush.flightreservation.entities.Reservation;

@Component
public class PDFGenerator {

	public void generateItinerary(Reservation reservation, String filePath) {
		
		// 1 st step to generate PDF using itext dependency is to create a document(creating I text document)
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			
			// open the pdf file
			document.open();
			
			// write on pdf
			document.add(generateTable(reservation));
			
			document.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		// add flight details
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Operating Airline");
		table.addCell(reservation.getFlight().getOperatingAirline());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Date of departure");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		
		table.addCell("Departure Time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		// passenger details
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());
		
		return table;
	}
	
}
