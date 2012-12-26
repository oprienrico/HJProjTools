package com.hjgauss.hjwebtools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileTree {
	
	public static File getBaseDir(){
		return new File(".");
	}
	
	public static String getBaseDirAbsolutePath() throws IOException{
		return getBaseDir().getCanonicalPath();
	}
	
	public static ArrayList<File> listFilesFromFolder(final File folder) {
		ArrayList<File> fileList = new ArrayList<File>();
		
	    for (final File fileEntry : folder.listFiles())
	    	if(!fileEntry.getPath().contains(".hjrules"))//exclude .hjrule files
		        if (fileEntry.isDirectory())
		        	fileList.addAll(listFilesFromFolder(fileEntry));
		        else
		            fileList.add(fileEntry);
	    
		return fileList;
	}
	
	public static ArrayList<File> listFilesFromFolderPath(final String folderPath) {
		return listFilesFromFolder(new File(folderPath));
	}
	
	public static ArrayList<File> listFilesFromBaseDir(){
		return listFilesFromFolder(getBaseDir());
	}
	
	public static String getFileExtension(final File file){

		int i = file.getName().lastIndexOf('.');
		int p = Math.max(file.getName().lastIndexOf('/'), file.getName().lastIndexOf('\\'));

		if (i > p) {
		    return file.getName().substring(i+1);
		}
		return "";
	}
	
	public static String pathUnixStyle(String path){
		return path.replace('\\', '/');//(92, 47);
	}
	public static String pathUnixStyleFakeAbsolute(String path){
		path = path.replace('\\', '/');//tranform win separator to unix like
		path = path.replace("./", "");//remove base path ./
		if(path.startsWith("/"))
			return path;
		else
			return "/"+path;
	}
	public static String pathUnixStyleFakeAbsolute(File file){
		return pathUnixStyleFakeAbsolute(file.getPath());
	}

}
