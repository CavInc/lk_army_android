package cav.lkarmy;

import cav.lkarmy.util.MyWebChromeClient;
import cav.lkarmy.util.MyWebViewClient;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import java.util.HashMap;


public class FullscreenActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_fullscreen);


        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(true);    // включение зума
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            webView.getSettings().setDisplayZoomControls(false);
        }


        webView.getSettings().setBuiltInZoomControls(true);


        webView.getSettings().setLoadWithOverviewMode(true); // ? маштабирует сайт по размеру экрана
        webView.getSettings().setUseWideViewPort(true);  // ?  маштабирует сайт по размеру экрана

        //  webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        //   webView.setScrollbarFadingEnabled(false);

        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);

        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());

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
            // Intent settingsActivity = new Intent(getBaseContext(),SettingsActivity.class);
            Intent settingsActivity = new Intent(getBaseContext(),Preferences.class);
            startActivity(settingsActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart(){
        super.onStart();
        getPrefs();
        webView.loadUrl("http://kempir.com:8000/");
    }

    HashMap<String,String> mapPref;

    private void getPrefs(){
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());
        mapPref = new HashMap<String,String>();
        mapPref.put("ctl00_MainContent_Login1_UserName",prefs.getString("loginReg","Nothing"));
        mapPref.put("ctl00_MainContent_Login1_Password",prefs.getString("loginPass","Nothing"));
        mapPref.put("ctl00_MainContent_Login1_SerialNumber",prefs.getString("imSign",""));
        mapPref.put("ctl00_MainContent_Login1_tbxBirthday",prefs.getString("dayBirth","Nothing"));
        mapPref.put("ctl00_MainContent_Login1_SNILS",prefs.getString("snils",""));
        mapPref.put("ctl00_MainContent_Login1_tbxBirthday",prefs.getString("dayBirthGS","Nothing"));

        Log.i("MAIN LOG",mapPref.get("ctl00_MainContent_Login1_UserName"));


    }

}
