package cav.lkarmy.util;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by cav on 24.05.16.
 */
public class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        view.loadUrl(url);
        return true;
    }

    public void onPageFinished (WebView view, String url) {
        String uname="odminko";
        String password="1245";
/*
        view.loadUrl("javascript: {" +
                "document.getElementsByName('user')[0].value = '" + uname + "';" +
                "document.getElementsByName('pass')[0].value = '" + password + "';};");
*/
        view.loadUrl("javascript: {" +
                "document.getElementById('ctl00_MainContent_Login1_UserName').value = '" + uname + "';" +
                "document.getElementsByName('pass')[0].value = '" + password + "';};");
    }

}
