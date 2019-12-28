package com.example.android.webview;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity_ex6 extends AppCompatActivity {
    WebView my_web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        my_web_view = new WebView(this);
        setContentView(my_web_view);

        Toast.makeText(this, "JavaScript: Enabled\nAll links handled by WebView.\nTry navigating and clicking the back btn", Toast.LENGTH_LONG).show();
        my_web_view.getSettings().setJavaScriptEnabled(true);
        my_web_view.setWebViewClient(new WebViewClient());
        my_web_view.loadUrl("https://www.andreicozma.com");
    }

    @Override
    public void onBackPressed() {
        if (my_web_view != null && my_web_view.canGoBack()){
            my_web_view.goBack(); // if there is previous page go back to it
        } else{
            super.onBackPressed(); //if there is no previous page, close app
        }
    }
}
