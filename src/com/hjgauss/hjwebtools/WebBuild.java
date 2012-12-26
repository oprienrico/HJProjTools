package com.hjgauss.hjwebtools;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.hjgauss.hjwebtools.exceptions.IgnoreListNotLoaded;

public class WebBuild {
	final String BUILD_PATH = "../build";
	
	public void cleanBuild(){
		try {
			FileUtils.cleanDirectory(new File(BUILD_PATH));
			System.out.println("cleaned build");
		} catch (IOException e) {
			System.out.println("cannot clean build");
		}
	}
	
	public void build(){
		Filter filter = new Filter();
		filter.loadRules();
		buildWithParams(filter);
	}
	public void buildWithParams(Filter filter){
		if(!(new File(BUILD_PATH)).exists())
			(new File(BUILD_PATH)).mkdir();
		cleanBuild();
		
		try {
			File dest = null;
			for (File source : filter.getFileList()){
				dest = new File(BUILD_PATH+FileTree.pathUnixStyleFakeAbsolute(source));
				System.out.println("exported to: "+dest);
				FileUtils.copyFile(source, dest);
			}
			System.out.println("build exported correctly");
		} catch (IgnoreListNotLoaded e) {
			System.out.println("IgnoreList not initialized correctly");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
