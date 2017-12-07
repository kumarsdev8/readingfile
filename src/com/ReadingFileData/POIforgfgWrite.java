package com.ReadingFileData;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIforgfgWrite {

public static void main(String args[])
{
	String mirdir="C:\\Users\\Sachin.Kusnoore\\Documents\\PID 1270 Indecomm\\20171116";
	File readdir= new File(mirdir);
	if(readdir.isDirectory() && readdir.exists())
	{
		
		File ar[]=readdir.listFiles();
		System.out.println("******************************************");
		System.out.println("FILe in a  directory are");
		System.out.println("******************************************");
	    
	displayfiletype(ar);
	}
}

private static void displayfiletype(File[] ar) {
	
	// TODO Auto-generated method stub
	int pdf=0;
	int txt=0;
	ArrayList<String> array1= new ArrayList<String>();
	ArrayList<String> array2= new ArrayList<String>();
	  Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
	  XSSFWorkbook workbook = new XSSFWorkbook();
	  
      // Create a blank sheet
      XSSFSheet sheet = workbook.createSheet("student Details");
      data.put(0, new Object[]{  " PDF", " TXT" });
      
	for(File file: ar) 
	{
		if(file.getName().lastIndexOf(".pdf") != -1)
		{
			pdf++;
			array1.add(file.getName());
		}	else if(file.getName().lastIndexOf(".txt") != -1) 
		{
			array2.add(file.getName());
			txt++;
		}
			
		
	}
	
	

	
	if(array2.size() < array1.size() )
	{
		for(int i=1 ; i<=array2.size();i++) 
		{
			data.put(i, new Object[]{ array1.get(i-1) , array2.get(i-1) });
		}
		for(int i=array2.size()+1 ; i <= ar.length-array2.size();i++) 
		{
			data.put(i, new Object[]{ array1.get(i-1) , " " });
		}
		
		
	}
	
	
	
	
	
	
	System.out.println("No of Pdf file are \t"+pdf);
	System.out.println("No of txt file are \t"+txt);
	
	Set<Integer> keyset = data.keySet();
    int rownum = 0;
    for (Integer key : keyset) {
        // this creates a new row in the sheet
        Row row = sheet.createRow(rownum++);
        Object[] objArr = data.get(key);
        int cellnum = 0;
        for (Object obj : objArr) {
            // this line creates a cell in the next column of that row
            Cell cell = row.createCell(cellnum++);
            if (obj instanceof String)
                cell.setCellValue((String)obj);
            else if (obj instanceof Integer)
                cell.setCellValue((Integer)obj);
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