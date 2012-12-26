package com.hjgauss.hjwebtools;

public class HjWebTools {
	final static String VERSION = "0.1.0";

	
	public static void main(String[] args) {
		String command = "";
		if(args.length>0)
			command = args[0];
		
		switch (command) {
		case "-v":
			System.out.println("HJWebTools v"+VERSION);
			break;
		case "-build":
			WebBuild webbuild = new WebBuild();
			webbuild.build();
		default:
			System.out.println(
				"HJ Web Tools v" + VERSION +
				"Options available:\n" +
				"-v     : show version\n" +
				"-build : export build"
			);
		}

	}
	
}
