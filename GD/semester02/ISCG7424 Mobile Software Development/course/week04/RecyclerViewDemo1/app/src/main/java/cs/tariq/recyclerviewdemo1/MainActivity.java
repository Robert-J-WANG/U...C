package cs.tariq.recyclerviewdemo1;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.r_view);
        String []data = {"New Zealand","Australia","USA","China","India","Pakistan","UAE","UK","Canada","South Africa", "Japan","Fiji"};
        RVAdapter adapter = new RVAdapter(data);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}