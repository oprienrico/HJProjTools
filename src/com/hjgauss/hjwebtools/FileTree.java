package com.hjgauss.hjwebtools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileTree {
	
	public static File getBaseDir(){
		return new File(".");
	}
	
	public static String getBaseDirAbsolutePath() throws IOException{
		return (new File(".")).getCanonicalPath();
	}
	
	public static ArrayList<File> listFilesForFolder(final File folder) {
		ArrayList<File> fileList = new ArrayList<File>();
		
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	fileList.addAll(listFilesForFolder(fileEntry));
	        } else {
	            fileList.add(fileEntry);
	        }
	    }
		return fileList;
	}
	
	public static ArrayList<File> listFilesForFolderPath(final String folderPath) {
		return listFilesForFolder(new File(folderPath));
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
	

}
