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

import org.nbgit.util.exclude.FnMatch;

import com.hjgauss.hjwebtools.exceptions.IgnoreListNotLoaded;

public class Filter {
	final static private Charset ENCODING = StandardCharsets.UTF_8;
	final static String RULES_FOLDER = ".hjrules";
	final static String RULES_FILE_IGNORE = ".hjignore";
	
	ArrayList<String> ignore_list;
	/**
	 * @param args
	 */
	public Filter(){

	}
	
	public void loadIgnoreList(){
		loadIgnoreList("");
	}
	
	public void loadIgnoreList(String rulePath){
		if(rulePath == null)
			rulePath = "";
		ignore_list = getRulesList(rulePath + RULES_FOLDER + "/" + RULES_FILE_IGNORE);
	}
	
	public void loadRules(){
		loadRules("");
	}
	
	public void loadRules(String rulePath){
		loadIgnoreList(rulePath);
		System.out.println("log list:"+ignore_list);
	}

	public static ArrayList<String> getRulesList(String rulePath){
		if(rulePath == null || rulePath.isEmpty())
			return null;
		
		ArrayList<String> rules = null;
		Path path = Paths.get(rulePath);
		
		try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
	    	rules = new ArrayList<String>();
	    	String line = null;
	    	while ((line = reader.readLine()) != null) {
	    		if(line.indexOf('#')>-1)
	    			line = line.substring(0,line.indexOf('#'));//manage comments
	    		line = line.replace(" ", "");//delete spaces
	    		if(!line.isEmpty())
	    			rules.add(line);
	    			System.out.print(line);
	    	}      
	    } catch (IOException e) {
			e.printStackTrace();
		}

		return rules;
	}
	
	public ArrayList<File> getFileList() throws IgnoreListNotLoaded{
		if(ignore_list == null)
			throw new IgnoreListNotLoaded();
		
		ArrayList<File> tempList = FileTree.listFilesFromBaseDir();
		for (int i = 0; i < tempList.size(); i++){
			if(isIgnored(tempList.get(i))){
				tempList.remove(i);
				i--;//compensate the removal
			}
		}
		return tempList;
	}
	
	public Boolean isIgnored(File file){
		String path = FileTree.pathUnixStyleFakeAbsolute(file.getPath());
		
		for (String pattern : ignore_list){
			//System.out.println("pattern :"+pattern+" path:"+path);
			if(FnMatch.fnmatch(pattern, path))
				return true;
		}
		return false;
	}
	
	
	
}
