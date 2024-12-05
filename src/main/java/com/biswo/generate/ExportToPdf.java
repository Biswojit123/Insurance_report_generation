package com.biswo.generate;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.biswo.entity.CityzenPlanInfo;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExportToPdf {

	public void generatePdf(HttpServletResponse response, List<CityzenPlanInfo> plans,File file)throws Exception {
		// Create a Document
		Document document = new Document(PageSize.A4);
		// Create the PdfWriter
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		// Open the Document
		document.open();
		// Create the Paragraph
		Paragraph p = new Paragraph("List of users insurance report");
		// paragraph alignment
		p.setAlignment(Paragraph.ALIGN_CENTER);
		// add that paragraph to the document
		document.add(p);
		// Create a Table
		PdfPTable table = new PdfPTable(11);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 2.2f, 3.0f, 3.5f, 4.5f, 4.5f, 4.5f, 4.5f, 4.5f, 4.5f, 4.5f });
		table.setSpacingBefore(10);
		// Create Cell and set Color and padding
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLACK);
		cell.setPadding(5);
		// Create the font for cell
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		// Set the Phrase for cell
		cell.setPhrase(new Phrase("Id", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Status", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan Start date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Plan End date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Benefit Amount", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Denailed Reason", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Terminated Date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Terminated Reason", font));
		table.addCell(cell);
		// Set the all Data
		for (CityzenPlanInfo record : plans) {
			table.addCell(record.getCityzenId() + "");
			table.addCell(record.getCityzenName());
			table.addCell(record.getGender());
			table.addCell(record.getPlanName());
			table.addCell(record.getPlanStatus());
			if (null != record.getPlanStartDate()) {
				table.addCell(record.getPlanStartDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (null != record.getPlanEndDate()) {
				table.addCell(record.getPlanEndDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (null != record.getBenfitAmount()) {
				table.addCell(record.getBenfitAmount() + "");
			} else {
				table.addCell("N/A");
			}
			table.addCell(record.getDenailResion());
			if (null != record.getTerminateDate()) {
				table.addCell(record.getTerminateDate() + "");
			} else {
				table.addCell("N/A");
			}
			table.addCell(record.getTerminationResion());
		}

		document.add(table);
		// close the document
		document.close();
	}
}
