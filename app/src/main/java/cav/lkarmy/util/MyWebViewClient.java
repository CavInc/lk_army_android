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
        Log.i("PAGEFINISHED", "YES FINISHED");

        String JS="function X18(userName,loginPass,serialNum,SNILS,tbxBirthday){\n" +
                " if ($(\"#ctl00_MainContent_Login1_UserName\").val()!=undefined) {\n" +
                "    $(\"#ctl00_MainContent_Login1_UserName\").val(userName);\n" +
                " };\n" +
                " if ($(\"#ctl00_MainContent_Login1_Password\").val()!=undefined) {\n" +
                "    $(\"#ctl00_MainContent_Login1_Password\").val(loginPass);\n" +
                " };\n" +
                " if ($(\"#ctl00_MainContent_Login1_SerialNumber\").val()!=undefined) {\n" +
                "    $(\"#ctl00_MainContent_Login1_SerialNumber\").val(serialNum);\n" +
                " };\n" +
                " if ($(\"#ctl00_MainContent_Login1_SNILS\").val()!=undefined) {\n" +
                "    $(\"#ctl00_MainContent_Login1_SNILS\").val(SNILS);\n" +
                " };\n" +
                " if ($(\"#ctl00_MainContent_Login1_tbxBirthday\").val()!=undefined) {\n" +
                "    $(\"#ctl00_MainContent_Login1_tbxBirthday\").val(tbxBirthday);\n" +
                " };\n" +
                " setTimeout(function(){X18(userName,loginPass,serialNum,SNILS,tbxBirthday)},8000);\n" +
                "}";


        if ((Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT)) {
            view.loadUrl("javascript: {"+JS+
                        "X18('"+Glu.userData.get("ctl00_MainContent_Login1_UserName")+"','"+Glu.userData.get("ctl00_MainContent_Login1_Password")+
                    "','"+Glu.userData.get("ctl00_MainContent_Login1_SerialNumber")+
                    "','"+Glu.userData.get("ctl00_MainContent_Login1_SNILS")+"','"+Glu.userData.get("ctl00_MainContent_Login1_tbxBirthday")+"'); };");
            //view.loadUrl("javascript: {" +
            //        "document.getElementById('ctl00_MainContent_Login1_UserName').value = '" + Glu.userData.get("ctl00_MainContent_Login1_UserName") + "';" +
           //         "document.getElementById('ctl00_MainContent_Login1_Password').value = '" + Glu.userData.get("ctl00_MainContent_Login1_Password") + "';};");

        } else {
            view.evaluateJavascript("javascript: {"+JS+
                    "X18('"+Glu.userData.get("ctl00_MainContent_Login1_UserName")+"','"+Glu.userData.get("ctl00_MainContent_Login1_Password")+
                    "','"+Glu.userData.get("ctl00_MainContent_Login1_SerialNumber")+
                    "','"+Glu.userData.get("ctl00_MainContent_Login1_SNILS")+"','"+Glu.userData.get("ctl00_MainContent_Login1_tbxBirthday")+"'); };",null);

            //view.evaluateJavascript("javascript: {" +
            //        "document.getElementById('ctl00_MainContent_Login1_UserName').value = '" + Glu.userData.get("ctl00_MainContent_Login1_UserName") + "';" +
            //        "document.getElementById('ctl00_MainContent_Login1_Password').value = '" + Glu.userData.get("ctl00_MainContent_Login1_Password") + "';" +
            //        "document.getElementById('ctl00_MainContent_Login1_SerialNumber').value=" + Glu.userData.get("ctl00_MainContent_Login1_SerialNumber") + ";};", null);

        }
    }

}
