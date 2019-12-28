package com.example.android.webview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity_ex7 extends AppCompatActivity {
    WebView my_web_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        my_web_view = new WebView(this);
        setContentView(my_web_view);

        Toast.makeText(this, "JavaScript: Enabled\nAll links handled by WebView.\nBack btn handling\nOptions Menu", Toast.LENGTH_LONG).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"Back");
        menu.add(0,1,0,"Forward");
        menu.add(0,2,0,"Refresh");
        menu.add(0,3,0,"Stop Loading");
        menu.add(0,4,0,"Toggle JS");
        menu.add(0,5,0,"Go Home");
        menu.add(0,6,0,"Google.com");
        menu.add(0,7,0,"Get URL");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 0:
                if(my_web_view.canGoBack()){
                    my_web_view.goBack();
                }else{
                    Toast.makeText(this, "Can't go back", Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                if(my_web_view.canGoForward()){
                    my_web_view.goForward();
                }else{
                    Toast.makeText(this, "Can't go forward", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                my_web_view.reload();
                break;
            case 3:
                my_web_view.stopLoading();
                break;
            case 4:
                WebSettings my_settings = my_web_view.getSettings();
                if(my_settings.getJavaScriptEnabled()){
                    my_settings.setJavaScriptEnabled(false);
                    Toast.makeText(this, "JavaScript Disabled", Toast.LENGTH_SHORT).show();
                } else{
                    my_settings.setJavaScriptEnabled(true);
                    Toast.makeText(this, "JavaScript Enabled", Toast.LENGTH_SHORT).show();
                }
                break;
            case 5:
                my_web_view.loadUrl(my_web_view.getOriginalUrl());
                break;
            case 6:
                my_web_view.loadUrl("https://www.google.com/");
                break;
            case 7:
                Toast.makeText(this, my_web_view.getUrl(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
