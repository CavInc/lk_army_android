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
                " if ($(\"#clock_number\").val()!=undefined) {\n" +
                "  var cn=$(\"#clock_number\"); cn.focus(); cn.val(userName);\n" +
                " };\n" +
                " if ($(\"#password\").val()!=undefined) {\n" +
                "  var ps=$(\"#password\"); ps.focus(); ps.val(loginPass);\n" +
                " };\n" +
                " if ($(\"#personal_number\").val()!=undefined) {\n" +
                "  var ts=$(\"div.select-input\").text(); \n"+
                "  if (ts==\"Гражданский служащий\") { \n"+
                "    var pns=$(\"#personal_number\"); pns.focus(); pns.val(SNILS); }\n" +
                "    else { var pn=$(\"#personal_number\"); pn.focus(); pn.val(serialNum); }\n" +
                " };\n" +
                " if ($(\"#birthday\").val()!=undefined) {\n" +
                "    var br=$(\"#birthday\"); br.focus(); br.val(tbxBirthday);\n" +
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
