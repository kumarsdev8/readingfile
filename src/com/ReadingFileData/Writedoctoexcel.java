package com.ReadingFileData;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writedoctoexcel {
	public static void main(String args[]) 
	{
		 XSSFWorkbook workbook= new XSSFWorkbook();
		 
		 XSSFSheet sheet= workbook.createSheet("FileDetails");
		 
		 Map<String, Object[]> data= new TreeMap<String,Object[]>();
		 data.put("1", new Object[] {"ID","NAME","LASTNAME"});
		 Set<String> keyset =data.keySet();
		int rownum=0;
	     for (String key : keyset) {
	            // this creates a new row in the sheet
	            Row row = sheet.createRow(rownum++);
	            Object[] objArr = data.get(key);
	            int cellnum = 0;
	            for (Object obj : objArr) {
	                // this line creates a cell in the next column of that row
	                Cell cell = row.createCell(cellnum++);
	                if (obj instanceof String)
	                    cell.setCellValue("sachin");
	                else if (obj instanceof Integer)
	                    cell.setCellValue("kumR");
	            }
	        }
	     try {
	            // this Writes the workbook gfgcontribute
	            FileOutputStream out = new FileOutputStream(new File("gfgcontribute.xlsx"));
	            workbook.write(out);
	            out.close();
	            System.out.println("gfgcontribute.xlsx written successfully on disk.");
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
	}

 
}