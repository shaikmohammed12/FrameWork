package com.Tests;



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;




public  class Solution {
	

    public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		 * BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		 */
        String skills = "pcmbzpcmbz";
        
        char sort[] = skills.toCharArray();
        Arrays.sort(sort);
        System.out.println(sort);
        String temp = "";
        for (int i = 0; i < skills.length(); i++){
            if (temp.indexOf(skills.charAt(i)) == - 1)
               temp = temp + skills.charAt(i);
         }
            System.out.println(temp);
          int count;
          int count1[] = null;
          try {
         for(int i=0;i<temp.length();i++)
         {
        	 count = 0;
        	 for(int j=0;j<skills.length();j++)
        	 {
        		 if(temp.charAt(i)==sort[j])
        			 count++;
        	 }
        	 System.out.println(temp.charAt(i)+":"+count);
        	 count1[i]=count;
         }
         int small = count1[0];
         
         for(int i = 0 ; i < temp.length() ; i++)
         {
             if ( count1[i] < small )
                 small = count1[i];
         }
          
          
         
        System.out.println(small);
          }
          catch(Exception e)
          {
        	  
          }
    }
}
        
