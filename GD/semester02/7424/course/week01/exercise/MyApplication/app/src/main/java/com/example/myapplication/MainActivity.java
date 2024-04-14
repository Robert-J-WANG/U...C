package cs.tariq.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edSrc, edDst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edSrc = findViewById(R.id.ed_src);
        edDst = findViewById(R.id.ed_dst);
    }

    public void tranaferText(View view) {
        edDst.setText(edSrc.getText());
        edSrc.setText("");
    }
}