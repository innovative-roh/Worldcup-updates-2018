package worldcup.fifa2018.worldcupupdates.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import worldcup.fifa2018.worldcupupdates.Model.SadiumModel;
import worldcup.fifa2018.worldcupupdates.R;

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.ViewHolder>{

    private Context context;
    private List<SadiumModel> sadiumModelList;

    public StadiumAdapter(Context context, List<SadiumModel> sadiumModelList) {
        this.context = context;
        this.sadiumModelList = sadiumModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_stadium, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SadiumModel model= sadiumModelList.get(position);
        holder.stadium.setText(model.getDescription());
        Glide.with(context).load(model.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return sadiumModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView place, stadium, heading, description;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            stadium = itemView.findViewById(R.id.stadiumname);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
