package com.example.androidwebapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressbar;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview=findViewById(R.id.webview);
        progressbar=findViewById(R.id.progressbar);
        webview.getSettings().setJavaScriptEnabled(true);
        //its launching in browser let's fixed it
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressbar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressbar.setVisibility(View.GONE);
            }
        });

        //its fixed let's add progressbar
        webview.loadUrl("https://amazon.in/");


        //now on back press it exist instead of back page let's fixed it
    }


    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
          webview.goBack();
        }
        else {
            super.onBackPressed();
        }

    }
}
