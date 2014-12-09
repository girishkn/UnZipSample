package com.gkn.unzip;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.gkn.zip4j.ExtractZipFile;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;


public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String zipFileName = "1415644062";

        String zipFilePath = "/sdcard/" + zipFileName + ".zip";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String unZipPath = getExternalFilesDir(null).getPath();

            boolean result = ExtractZipFile.extractZipFile(zipFilePath, unZipPath);
            if (result) {
                Log.d(TAG, "Zip file " + zipFilePath + "extracted to " + unZipPath);
            } else {
                Log.d(TAG, "Unzip Zip file " + zipFilePath + "Failed!");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
