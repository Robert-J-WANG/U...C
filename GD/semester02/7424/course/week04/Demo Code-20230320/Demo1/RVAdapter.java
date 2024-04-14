package cs.tariq.recyclerviewdemo1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVAdapter extends RecyclerView.Adapter<RVHolder> {
    String data[];
    public RVAdapter(String [] data){
        this.data = data;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View view = inflater.inflate(R.layout.rv_item,
                parent,false);
        return new RVHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        holder.tv.setText(data[position]);
    }
    @Override
    public int getItemCount() {  return data.length;
    }
}
