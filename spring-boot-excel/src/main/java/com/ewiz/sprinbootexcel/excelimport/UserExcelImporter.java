package com.ewiz.sprinbootexcel.excelimport;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Id;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Scheduled;

import com.ewiz.sprinbootexcel.model.Customer;


public class UserExcelImporter {

	@Scheduled(cron= "0 0 11 * * *")
	public List<Customer> excelImport(){
		List<Customer> listCustomer=new ArrayList<>();
		
		String first_name="";
		
		String last_name="";
		
		String pannumber="";
		
		long aadharnumber=0;
		
		long uannumber=0;
		
		String email="";
		
		long mobile=0;
		
		String address="";
		
		boolean status=false;
		
		String excelFilePath="E:\\Excel\\input.xlsx";
		
		long start = System.currentTimeMillis();
		
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(excelFilePath);
			Workbook workbook=new XSSFWorkbook(inputStream);
			Sheet firstSheet=workbook.getSheetAt(0);
			Iterator<Row> rowIterator=firstSheet.iterator();
			rowIterator.next();
			
			while(rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator=nextRow.cellIterator();
				while(cellIterator.hasNext()) {
					Cell nextCell=cellIterator.next();
					int columnIndex=nextCell.getColumnIndex();
					switch (columnIndex) {
					case 0:
						first_name=nextCell.getStringCellValue();
						System.out.println(first_name);
						break;
					case 1:
						last_name=nextCell.getStringCellValue();
						System.out.println(last_name);
						break;
					case 2:
						pannumber=nextCell.getStringCellValue();
						System.out.println(pannumber);
						break;
					case 3:
						aadharnumber=(long)nextCell.getNumericCellValue();
						System.out.println(aadharnumber);
						break;
					case 4:
						uannumber=(long)nextCell.getNumericCellValue();
						System.out.println(uannumber);
						break;
					case 5:
						email=nextCell.getStringCellValue();
						System.out.println(email);
						break;
					case 6:
						mobile=(long)nextCell.getNumericCellValue();
						System.out.println(mobile);
						break;	
					case 7:
						address=nextCell.getStringCellValue();
						System.out.println(address);
						break;
					case 8:
						status=nextCell.getBooleanCellValue();
						System.out.println(status);
						break;	
					}
					listCustomer.add(new Customer(first_name, last_name, pannumber, aadharnumber,
							uannumber, email, mobile, address, status));
				}
			}
			
			workbook.close();
			long end = System.currentTimeMillis();
			System.out.printf("Import done in %d ms\n", (end - start));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return listCustomer;
	}
}
