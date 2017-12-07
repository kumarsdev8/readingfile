package com.ReadingFileData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingIndexFileToExcel {

	public static void main(String[] args)throws Exception
	  { 
		List<String[]> list=new ArrayList<String[]>();
	  File file = new File("C:\\Users\\Sachin.Kusnoore\\Desktop\\index.txt");
	  Map<Integer, String[]> data = new TreeMap<Integer, String[]>();
	  XSSFWorkbook workbook = new XSSFWorkbook();
	  int i=1;
      // Create a blank sheet
      XSSFSheet sheet = workbook.createSheet("LOANDETAILS");
      data.put(0, new String[]{ " File Name " ,"Page Count","Loan Number", "Loan Amount","Client Reference","Mortgagor","Document Number","Document Type","Date Recorded","Recorded Book","Recorded Page","County","State","USR Invoice","USR Client","USR Originator","USR Bill To","USR A","USR B","USR C","USR D "});
	 
	  BufferedReader br = new BufferedReader(new FileReader(file));
	
	  String st=br.readLine();
	  while ((st = br.readLine()) != null)
	   dislplayData(st,list);
	  
	  for(String [] str : list) {
	 // System.out.println(Arrays.toString(str));
	 // String Str1[]=(String) Arrays.toString(str);
		
	   data.put(i, str);
	   i++;
	   //System.out.println(str);
	  }br.close();
	  
		Set<Integer> keyset = data.keySet();
	    int rownum = 0;
	    for (Integer key : keyset) {
	        // this creates a new row in the sheet
	        Row row = sheet.createRow(rownum++);
	        String[] objArr = data.get(key);
	        int cellnum = 0;
	        for (Object obj : objArr) {
	            // this line creates a cell in the next column of that row
	        	System.out.println("Line"+cellnum);
	            Cell cell = row.createCell(cellnum++);
	     
	                cell.setCellValue((String)obj);
	            
	        }
	    }
	    try {
	        // this Writes the workbook gfgcontribute
	        FileOutputStream out = new FileOutputStream(new File("INDECOMMDATA.xlsx"));
	        workbook.write(out);
	        out.close();
	       // System.out.println("gfgcontribute.xlsx written successfully on disk.");
	    }
	    catch (Exception e) {
	    	System.out.println("Exception");
	        e.printStackTrace();
	    }
		
	  }

	private static void dislplayData(String st,List<String[]> list) {
		String[]  array=st.split("\\|", 21);
		String[] arrays2= new String[21]; int i=0;
	    for (String element : array) {
	    	if(i == 21)
	    		i=0;
	    	arrays2[i]=element;
	    	i++;
	           System.out.println(element);
	       }
		list.add(arrays2);	
	}
			    	
		
}
