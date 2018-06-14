package com.jiege.bsdiff;

public class BsDiff {
/**
 * 
 * @param oldfile jiubanben
 * @param newfile xinbanben
 * @param patchfile  chafenbaowenjian
 */
	public native static void diff(String oldfile,String newfile,String patchfile);

	static{
		System.loadLibrary("bsdiff");
	}
	
}

