package com.hjgauss.hjwebtools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Filter {
	final static Charset ENCODING = StandardCharsets.UTF_8;
	final static String RULES_FOLDER = ".hjrules";
	final static String RULES_FILE_IGNORE = ".hjignore";
	
	/**
	 * @param args
	 */
	
	public static ArrayList<String> loadIgnoreList(){
		return loadIgnoreList("");
	}
	
	public static ArrayList<String> loadIgnoreList(String rulePath){
		if(rulePath.isEmpty())
			rulePath = "";
		
		ArrayList<String> rules = null;
		rules = loadRulesList(rulePath + "/" + RULES_FOLDER + "/" + RULES_FILE_IGNORE);
		
		return rules;
	}
	
	public static ArrayList<String> loadRulesList(String rulePath){
		if(rulePath.isEmpty())
			return null;
		
		ArrayList<String> rules = null;
		Path path = Paths.get(rulePath);
		
		try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
	    	rules = new ArrayList<String>();
	    	String line = null;
	    	while ((line = reader.readLine()) != null) {
    			rules.add(line);
	    	}      
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rules;
	}
	

	public static ArrayList<File> filter(){
		ArrayList<File> tempList = null;
		
		return tempList;
	}
	
	public static Boolean isIgnored(File file){
		ArrayList<String> ignoredList = loadIgnoreList();
		for (String rule : ignoredList){
			
				
			
		}
		return false;
	}
	
	
}
