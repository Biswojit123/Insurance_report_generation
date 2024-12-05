package com.biswo.generate;

import java.io.File;
import java.io.FileOutputStream;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.biswo.entity.CityzenPlanInfo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExportToExcel {
	public void generateExcel(HttpServletResponse response, List<CityzenPlanInfo> plans,File file) throws Exception {
		// Create the the WorkBook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create the Sheet in the work book
		Sheet sheet = workbook.createSheet();
		// Create the Row in the sheet
		Row headerRow = sheet.createRow(0);

		// Create the cell style
		CellStyle style = workbook.createCellStyle();
		CreationHelper helper = workbook.getCreationHelper();
//				XSSFFont font = workbook.createFont();
//				font.setBold(true);
//				font.setFontHeight(16);
//				style.setFont(font);
		// create the Date format style
		style.setDataFormat(helper.createDataFormat().getFormat("dd-MM-yyyy"));

		// Create the cell
		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		headerRow.createCell(7).setCellValue("Benefit Amount");
		headerRow.createCell(8).setCellValue("Denailed Reason");
		headerRow.createCell(9).setCellValue("Terminated Date");
		headerRow.createCell(10).setCellValue("Terminate Reason");
		// Create a Variable
		int noOfRows = 1;
		// Travel the all record and add that data to the rows
		for (CityzenPlanInfo record : plans) {
			// create the dataRow
			Row dataRow = sheet.createRow(noOfRows);

			// set the all data of first record into the DataRow
			dataRow.createCell(0).setCellValue(record.getCityzenId());
			dataRow.createCell(1).setCellValue(record.getCityzenName());
			dataRow.createCell(2).setCellValue(record.getGender());
			dataRow.createCell(3).setCellValue(record.getPlanName());
			dataRow.createCell(4).setCellValue(record.getPlanStatus());
			if (null != record.getPlanStartDate()) {
				Cell dateCell = dataRow.createCell(5);
				dateCell.setCellValue(
						Date.from(record.getPlanStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
				dateCell.setCellStyle(style);
			} else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			if (null != record.getPlanEndDate()) {
				Cell dateCell = dataRow.createCell(6);
				dateCell.setCellValue(
						Date.from(record.getPlanEndDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
				dateCell.setCellStyle(style);
			} else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			if (null != record.getBenfitAmount()) {
				dataRow.createCell(7).setCellValue(record.getBenfitAmount());
			} else {
				dataRow.createCell(7).setCellValue("N/A");
			}
			dataRow.createCell(8).setCellValue(record.getDenailResion());
			if (null != record.getTerminateDate()) {
				Cell dateCell = dataRow.createCell(9);
				dateCell.setCellValue(
						Date.from(record.getTerminateDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
				dateCell.setCellStyle(style);
			} else {
				dataRow.createCell(9).setCellValue("N/A");
			}
			dataRow.createCell(10).setCellValue(record.getTerminationResion());
			// increment
			noOfRows++;
		}
		//This is for send file to the our folder
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		//this is for send the file to the Browser
		ServletOutputStream outputStreame = response.getOutputStream();
		workbook.write(outputStreame);
		workbook.close();
	}
}
