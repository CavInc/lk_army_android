package cav.lkarmy;

import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

//https://habrahabr.ru/company/tinkoff/blog/312968/
//http://www.vr-online.ru/content/pishem-igru-dlja-android-chast-5-khranenie-nastroek-3974
public class Preferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        EditTextPreference snils = (EditTextPreference) findPreference("snils");

        Slot[] slots = new UnderscoreDigitSlotsParser().parseSlots("___-___-___ __");
        FormatWatcher formatWatcher = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slots)
        );
        formatWatcher.installOn(snils.getEditText()); // устанавливаем форматтер на любой TextView
/*
        EditTextPreference user_num = (EditTextPreference) findPreference("imSign");
        EditText imSign = user_num.getEditText();
        Slot[] slots2 = new UnderscoreDigitSlotsParser().parseSlots("__-______");
        FormatWatcher formatWatcher2 = new MaskFormatWatcher(MaskImpl.createNonTerminated(slots2));
        formatWatcher2.installOn(imSign);
        */
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        LinearLayout root = (LinearLayout)findViewById(android.R.id.list).getParent().getParent().getParent();
        Toolbar bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.settings_toolbar, root, false);
        root.addView(bar, 0); // insert at top
    }


}
