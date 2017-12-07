package com.ReadingFileData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadTextAsString
{
public static void main(String[] args)throws Exception
  { 
	List<String[]> list=new ArrayList<String[]>();
  File file = new File("C:\\Users\\Sachin.Kusnoore\\Desktop\\index.txt");
 
  BufferedReader br = new BufferedReader(new FileReader(file));
 
  String st=br.readLine();
  while ((st = br.readLine()) != null)
   dislplayData(st,list);
  
  for(String [] str : list)
  System.out.println(Arrays.toString(str));
  br.close();
  }

private static void dislplayData(String st,List<String[]> list) {
	list.add(st.split("\\|", 21));	
}
		    	
		    
		      
		  }




