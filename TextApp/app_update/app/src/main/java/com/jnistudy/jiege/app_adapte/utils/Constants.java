package com.jnistudy.jiege.app_adapte.utils;

import java.io.File;

import android.os.Environment;

public class Constants {

	public static final String PATCH_FILE = "apk.patch";

	public static final String URL_PATCH_DOWNLOAD = "http://192.168.1.103:8080/"+PATCH_FILE;
	
	public static final String PACKAGE_NAME = "com.jnistudy.jiege.app_adapte";
	
	public static final String SD_CARD = Environment.getExternalStorageDirectory() + File.separator;
	
	//新版本apk的目录
	public static final String NEW_APK_PATH = SD_CARD+"dn_apk_new.apk";
	
	public static final String PATCH_FILE_PATH = SD_CARD+PATCH_FILE;
	
}
