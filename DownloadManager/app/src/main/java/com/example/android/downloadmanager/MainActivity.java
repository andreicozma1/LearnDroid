package com.example.android.downloadmanager;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileNotFoundException;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {

    EditText et_url;
    EditText et_download_name;
    Button btn_download;

    String permissionsToRequest[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    final int MY_REQUEST_PERMISSIONS_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_url = findViewById(R.id.et_url_id);
        et_download_name = findViewById(R.id.et_download_name_id);
        btn_download = findViewById(R.id.btn_download_id);

        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(MainActivity.this, permissionsToRequest[0]) == PackageManager.PERMISSION_DENIED) {
                    // Permission DENIED! Request it and wait for callback.
                    Log.v("ANDREI_PERMISSION", "Denied. Asking");
                    ActivityCompat.requestPermissions(MainActivity.this, permissionsToRequest, MY_REQUEST_PERMISSIONS_ID);
                } else {
                    // Permission GRANTED! Download.
                    Log.v("ANDREI_PERMISSION", "Granded. Downloading");
                    performDownload(et_url.getText().toString(), et_download_name.getText().toString());
                }


            }
        });
    }

    // Override this method to check the result of the permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_REQUEST_PERMISSIONS_ID:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // PERMISSION GRANTED! Download file
                    performDownload(et_url.getText().toString(), et_download_name.getText().toString());
                } else {
                    // PERMISSION DENIED! Don't do anything
                    String snack_text = "You must enable Write to Storage permission before being able to download";
                    View.OnClickListener listener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri settings_uri = Uri.parse("package:" + getPackageName());
                            Intent gotoSettingsIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, settings_uri);
                            startActivity(gotoSettingsIntent);
                            Toast.makeText(MainActivity.this, "Please proceed to the Permissions page and enable the required permissions", Toast.LENGTH_SHORT).show();
                        }
                    };

                    Snackbar.make(findViewById(R.id.my_layout_id), snack_text, Snackbar.LENGTH_LONG).setAction("Go to Settings", listener).show();
                }
                break;
            default:
                Log.v("PERMISSION_CHECK", "ID: " + requestCode);
                Log.v("PERMISSION_CHECK", grantResults.toString());
                break;
        }
    }


    void performDownload(String url, String name) {
        Log.v("ANDREI_DOWNLOAD", url);
        Log.v("ANDREI_DOWNLOAD", name);
        if(url.length() == 0){
            Toast.makeText(this, "URL box can't be empty.", Toast.LENGTH_SHORT).show();
        } else if (!URLUtil.isValidUrl(url)) {
            Toast.makeText(this, "URL is not valid", Toast.LENGTH_SHORT).show();
        } else {
            if (name.length() == 0) {
                name = String.valueOf(System.currentTimeMillis());
            } else {
                File my_file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() + "/" + name);
                if (my_file.exists()) {
                    Toast.makeText(this, "Error: File name already exists", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            Toast.makeText(this, getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + name, Toast.LENGTH_LONG).show();

            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
            request.setTitle("Downloading '" + name + "'!");
            request.setDescription("From " + url);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setRequiresCharging(false); // Needs API 24. False by default
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name); // My App Download is the title of the file we download

            // Don't forget to add permission to AndroidManifest
            DownloadManager manager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
            manager.enqueue(request);

        }

    }
}
