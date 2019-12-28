package com.example.android.webview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity_ex3 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView my_web_view = new WebView(this);
        setContentView(my_web_view);

        Toast.makeText(this, "Loading HTTP with ClearText OFF -> ERROR.\nTo fix, use https or add the following in AndroidManifest.xml:\nandroid:usesCleartextTraffic=\"true\"", Toast.LENGTH_LONG).show();
        my_web_view.loadUrl("http://www.andreicozma.com");
    }
}
