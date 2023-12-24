package cs.tariq.multiactivitiesprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivity2(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }

    public void openActivity3(View view) {
        Intent intent = new Intent(this, MainActivity3.class);

        // transfer data
        intent.putExtra("name","Tariq");
        intent.putExtra("level",90000);
        intent.putExtra("Dbl_val",2.5);

        startActivity(intent);
    }
    public void openActivity4(View view) {
        Intent intent = new Intent(this, MainActivity3.class);

        // transfer data
        intent.putExtra("name","Tariq");
        intent.putExtra("level",90000);
        intent.putExtra("Dbl_val",2.5);

        startActivity(intent);

    }
}