package com.jiege.bsdiff;


public class BsDiffText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String oldfile = "F:/chaifenText/app_update_old.apk";
		String newfile = "F:/chaifenText/app_update_new.apk";
		String patchfile = "F:/chaifenText/apk.patch";
		BsDiff.diff(oldfile, newfile, patchfile);
	}

}
