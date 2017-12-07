package com.ReadingFileData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AListString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String []> list=new ArrayList<String []>();
		String [] ar= new String[3];
		Scanner sc=new Scanner(System.in);
		 for(int i =0 ; i<3;i++) 
		 {
			 ar[i]=sc.nextLine();
		 }
		list.add(ar);
		for(String str[] : list)
			System.out.println(Arrays.toString(str));
			
	
	
	
	}

}
