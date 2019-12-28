package com.example.android.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class WebViewActivity_ex2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView my_web_view = new WebView(this);
        setContentView(my_web_view);

        Toast.makeText(this, "WebView defined and loaded as object without a layout XML.\n Loading HTTPS with ClearText OFF", Toast.LENGTH_LONG).show();
        my_web_view.loadUrl("https://www.andreicozma.com");

    }
}
