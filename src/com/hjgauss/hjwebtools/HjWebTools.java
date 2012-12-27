package com.hjgauss.hjwebtools;

public class HjWebTools {
	final static String VERSION = "0.1.0";

	public static void main(String[] args) {
		String command = "-init";
		if(args.length>0)
			command = args[0];
		
		switch (command) {
		case "-v":
			System.out.println("HJWebTools v"+VERSION);
			break;
		case "-init":
			Filter.createExampleRuleFolder();
			break;
		case "-finit":
			Filter.createExampleRuleFolder(true);
			break;
		case "-build":
			WebBuild webbuild = new WebBuild();
			webbuild.build();
			break;
		case "-cleanbuild":
			WebBuild webbuild2 = new WebBuild();
			webbuild2.cleanBuild();
			break;
		default:
			System.out.println(
				"HJ Web Tools v" + VERSION + "\n" +
				"Options available:\n" +
				"-v          : show version\n" +
				"-init       : init .hjrule\n" +
				"-finit      : force init .hjrule\n" +
				"-build      : export build\n" + 
				"-cleanbuild : clean build"
			);
		}
	}
	
}
