package com.jnistudy.jiege.app_adapte.utils;

public class BsPatch {
    static {
        System.loadLibrary("apk_patch");
    }

    /**
     * 合并文件
     * @param oldfile 当前应用的apk文件
     * @param newfile 新的apk
     * @param patchfile 差分包
     */
    public native static void patch(String oldfile,String newfile,String patchfile);

}
