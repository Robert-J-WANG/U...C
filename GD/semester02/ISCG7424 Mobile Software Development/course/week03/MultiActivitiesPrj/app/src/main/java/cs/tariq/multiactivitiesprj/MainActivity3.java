package cs.tariq.multiactivitiesprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // get data
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int level = intent.getIntExtra("level",0);
        double val = intent.getDoubleExtra("Dbl_val",0);
        Toast.makeText(this,name+"\n"+level+"\n"+val, Toast.LENGTH_LONG).show();
    }
}