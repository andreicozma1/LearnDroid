package com.example.android.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class WebViewActivity_ex1 extends AppCompatActivity {

    WebView my_web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_ex1);

        my_web_view = findViewById(R.id.my_webview_id);

        Toast.makeText(this, "WebView defined in layout XML.\n Loading HTTPS with ClearText OFF", Toast.LENGTH_LONG).show();
        my_web_view.loadUrl("https://www.andreicozma.com");
    }
}
