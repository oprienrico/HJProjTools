package com.hjgauss.hjprojtools.exceptions;

public class IgnoreListNotLoaded extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IgnoreListNotLoaded(){
		super("\nIgnoreList not loaded, need to execute <loadIgnoreList> before this");
	}
}
