package com.hjgauss.hjprojtools;

public class HjProjTools {
	final static String VERSION = "0.1.2";

	public static void main(String[] args) {
		String command = "-build";
		if(args.length>0)
			command = args[0];
		
		switch (command) {
		case "-v":
			System.out.println("HJ Project Tools v"+VERSION);
			break;
		case "-init":
			Filter.createExampleRuleFolder();
			break;
		case "-finit":
			Filter.createExampleRuleFolder(true);
			break;
		case "-build":
			ProjBuild webbuild = new ProjBuild();
			webbuild.build();
			break;
		case "-cleanbuild":
			ProjBuild webbuild2 = new ProjBuild();
			webbuild2.cleanBuild();
			break;
		default:
			System.out.println(
				"HJ Project Tools v" + VERSION + "\n" +
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
