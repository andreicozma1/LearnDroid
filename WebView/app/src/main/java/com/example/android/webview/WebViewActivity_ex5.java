package com.example.android.webview;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity_ex5 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView my_web_view = new WebView(this);
        setContentView(my_web_view);

        Toast.makeText(this, "JavaScript: Enabled\nAll links handled by WebView.\nTry clicking a link.", Toast.LENGTH_LONG).show();
        my_web_view.getSettings().setJavaScriptEnabled(true);
        my_web_view.setWebViewClient(new WebViewClient());
        my_web_view.loadUrl("https://www.andreicozma.com");
    }
}
