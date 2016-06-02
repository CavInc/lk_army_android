package cav.lkarmy.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
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

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void onPageFinished (WebView view, String url) {
        Log.i("PAGEFINISHED","YES FINISHED");
        String uname="odminko";
        String password="1245";
        /*

        view.loadUrl("javascript: {" +
                "document.getElementsByName('user')[0].value = '" + uname + "';" +
                "document.getElementsByName('pass')[0].value = '" + password + "';};");
        */
/*
        view.loadUrl("javascript: {" +
                "document.getElementById('ctl00_MainContent_Login1_UserName').value = '" + uname + "';" +
                "document.getElementsByName('pass')[0].value = '" + password + "';};");
*/

        if ((Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT)) {
            view.loadUrl("javascript: {" +
                    "document.getElementById('ctl00_MainContent_Login1_UserName').value = '" + Glu.userData.get("ctl00_MainContent_Login1_UserName") + "';" +
                    "document.getElementById('ctl00_MainContent_Login1_Password').value = '" + Glu.userData.get("ctl00_MainContent_Login1_Password") + "';};");
        } else {
            view.evaluateJavascript("javascript: {" +
                    "document.getElementById('ctl00_MainContent_Login1_UserName').value = '" + Glu.userData.get("ctl00_MainContent_Login1_UserName") + "';" +
                    "document.getElementById('ctl00_MainContent_Login1_Password').value = '" + Glu.userData.get("ctl00_MainContent_Login1_Password") + "';"+
                    "document.getElementById('ctl00_MainContent_Login1_SerialNumber').value="+Glu.userData.get("ctl00_MainContent_Login1_SerialNumber")+";};", null);

        }
    }

}
