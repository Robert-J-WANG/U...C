package cs.tariq.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String SHARED_PREF = "PrefDemo";
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void writePref(View view) {
        editor.putString("hello","Welcome to shared Preferences");
        editor.putInt("int_val",2001);
        editor.putBoolean("bool_val", false);
        editor.apply();

    }

    public void readPref(View view) {
        int intVal = sharedPref.getInt("int_val",0);
        boolean boolVal = sharedPref.getBoolean("bool_val", true);
        String str = sharedPref.getString("hello","Default value");

        Toast.makeText(getApplicationContext(),
                str+"\n"+boolVal+"\n"+intVal,
                Toast.LENGTH_LONG).show();
    }

    public void clearPref(View view) {
        editor.clear();
        editor.apply();
        Toast.makeText(getApplicationContext(),
                "All Preferences Cleared",
                Toast.LENGTH_LONG).show();
    }
}