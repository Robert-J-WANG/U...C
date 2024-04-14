package cs.tariq.recyclerviewdemo1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVHolder extends RecyclerView.ViewHolder {
    TextView tv;

    public RVHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.c_name);
        tv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(),
                        tv.getText()+" Clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}
