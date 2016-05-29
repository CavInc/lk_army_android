package cav.lkarmy.util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

/**
 * Created by cav on 29.05.16.
 */
public class SavePref {
    private  SharedPreferences sPref;


    public  void loadPref(String key){

/*
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(key, "");

        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
*/
    }
    public void savePref(String key,String val){
/*
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(key,val);
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
 */
    }

}
