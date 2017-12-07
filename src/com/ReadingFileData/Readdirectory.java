package com.ReadingFileData;

import java.io.File;
import java.util.ArrayList;

public class Readdirectory {
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
		    
			for (File file : ar) {
				if(file.isFile()) 
				{
					System.out.println(file.getName());
				}
				
				
			}
			displayfiletype(ar);
		}
	}

	private static void displayfiletype(File[] ar) {
		
		// TODO Auto-generated method stub
		int pdf=0;
		int txt=0;
		ArrayList<String> array1= new ArrayList<String>();
		ArrayList<String> array2= new ArrayList<String>();
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
		
		System.out.println("No of Pdf file are \t"+pdf);
		System.out.println("No of txt file are \t"+txt);
		
	
		
	}

}
