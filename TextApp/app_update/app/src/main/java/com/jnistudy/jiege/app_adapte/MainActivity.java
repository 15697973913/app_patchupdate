package com.jnistudy.jiege.app_adapte;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jnistudy.jiege.app_adapte.utils.ApkUtils;
import com.jnistudy.jiege.app_adapte.utils.BsPatch;
import com.jnistudy.jiege.app_adapte.utils.Constants;
import com.jnistudy.jiege.app_adapte.utils.DownloadUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ApkUpdateTask().execute();
    }


    @SuppressLint("StaticFieldLeak")
    class ApkUpdateTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                //下载差分包
                File patchFile = DownloadUtils.download(Constants.URL_PATCH_DOWNLOAD);
                //获取应用的apk文件
                String oldfile = ApkUtils.getSourceApkPath(MainActivity.this, Constants.PACKAGE_NAME);
                //合并得到最新版本APK
                String newfile = Constants.NEW_APK_PATH;
                String patchfile = Constants.PATCH_FILE_PATH;
                Log.v(TAG,oldfile);
                Log.v(TAG,newfile);
                Log.v(TAG,patchfile);
                BsPatch.patch(oldfile, newfile, patchfile);
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            //安装
            if (result) {
                Toast.makeText(MainActivity.this, "你正在进行无流量更新", Toast.LENGTH_SHORT).show();
                ApkUtils.installApk(MainActivity.this,Constants.NEW_APK_PATH);
            }

        }
    }


}
