package com.hjgauss.hjwebtools;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import org.nbgit.util.exclude.FnMatch;


public class HjWebTools {
	

	
	public static void main(String[] args) {
		File filePath = null;
		try {
			filePath = new File("test2/.hjrules");
			
			ArrayList<File> fileList = null;
			String pattern = "/test*";
			String path = FileTree.pathUnixStyleFakeAbsolute(filePath.getPath());
			//System.out.print("\n" + loadRulesList("test")+"\n");
			//System.out.println("test : "+(new String("w/test/string").indexOf("/test/")));FileTree.pathUnixStyle(filePath.getPath())
			
			System.out.println("test2 : "+FnMatch.fnmatch(pattern, path));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void log(Object aMsg){
		System.out.println(String.valueOf(aMsg));
	}

}
