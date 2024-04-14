package cs.tariq.multiactivitiesprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    TextView tv_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // get data
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int level = intent.getIntExtra("level",0);
        double val = intent.getDoubleExtra("Dbl_val",0);
        Toast.makeText(this,name+"\n"+level+"\n"+val, Toast.LENGTH_LONG).show();

        tv_name=findViewById(R.id.name);
        tv_name.setText(name);

    }


}