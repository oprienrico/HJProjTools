package com.hjgauss.hjwebtools;

import java.io.File;

public class Rules {
	public static Boolean isExcluded(File file, String rule){
		if(rule.startsWith("!"))
			if (file.getPath().equals(rule.substring(1)))
				return true;
			else
				return false;	
		else
			return false;
		
	}
		
	public static Boolean isContained(File file, String rule){
		if(rule.startsWith("/"))
			if(FileTree.pathUnixStyle(file.getPath()).indexOf(rule.substring(1)) == 0)
				return true;
		else
			if(FileTree.pathUnixStyle(file.getPath()).indexOf(rule) > 0)
				return true;
		
		return false;
	}
}
	

