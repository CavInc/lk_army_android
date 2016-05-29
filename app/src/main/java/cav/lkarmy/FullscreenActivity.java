package cav.lkarmy;

import cav.lkarmy.util.MyWebChromeClient;
import cav.lkarmy.util.MyWebViewClient;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.webkit.WebView;


public class FullscreenActivity extends Activity {

    private WebView webView;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            webView.getSettings().setDisplayZoomControls(false);
        }
        webView.getSettings().setBuiltInZoomControls(true);

        webView.getSettings().setLoadWithOverviewMode(true); // ? маштабирует сайт по размеру экрана
        webView.getSettings().setUseWideViewPort(true);  // ?  маштабирует сайт по размеру экрана

        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);

        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());
       // webView.loadUrl("http://developer.alexanderklimov.ru/android");
       // webView.loadUrl("http://kempir.com:8000");
        webView.loadUrl("https://cabinet.mil.ru/login.aspx");
        String uname="odminko";
        String password="1245";
        // https://developer.android.com/reference/android/webkit/WebView.html#evaluateJavascript%28java.lang.String,%20android.webkit.ValueCallback%3Cjava.lang.String%3E%29
/*
        webView.loadUrl("javascript: {" +
                "document.getElementsById('ctl00_MainContent_Login1_UserName').value = '" + uname + "';" +
                "document.getElementsByName('pass')[0].value = '" + password + "';};");
*/


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // обработчик меню
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.about) {
            return true;
        }
        if (id==R.id.setting) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
