package com.hjgauss.hjwebtools;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;

import com.hjgauss.hjwebtools.exceptions.IgnoreListNotLoaded;

public class WebBuild {
	final String BUILD_PATH = "../build";
	
	public void clearBuild(){
		FileTree.deleteDirContent(new File(BUILD_PATH));
	}
	
	public void build(){
		Filter filter = new Filter();
		filter.loadRules();
		buildWithParams(filter);
	}
	public void buildWithParams(Filter filter){
		if(!(new File(BUILD_PATH)).exists())
			(new File(BUILD_PATH)).mkdir();
		clearBuild();
		
		try {
			for (File source : filter.getFileList()){
				File dest = new File(BUILD_PATH+FileTree.pathUnixStyleFakeAbsolute(source));
				System.out.println("destination: "+dest);
				FileUtils.copy(source, dest, );
			}
		} catch (IgnoreListNotLoaded e) {
			e.printStackTrace();
		}
	}
}
