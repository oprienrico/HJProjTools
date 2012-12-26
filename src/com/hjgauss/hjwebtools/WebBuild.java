package com.hjgauss.hjwebtools;

import java.io.File;

public class WebBuild {
	final String BUILD_PATH = "build/";
	
	public void clearBuild(){
		FileTree.deleteDirContent(new File(BUILD_PATH));
	}
	
	public void build(){
		(new File(BUILD_PATH)).mkdir();
	}
}
