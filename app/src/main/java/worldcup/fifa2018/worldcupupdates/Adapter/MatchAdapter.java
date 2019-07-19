package worldcup.fifa2018.worldcupupdates.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import worldcup.fifa2018.worldcupupdates.Model.MatchModel;
import worldcup.fifa2018.worldcupupdates.R;

public class MatchAdapter  extends RecyclerView.Adapter<MatchAdapter.ViewHolder>{

    private Context context;
    private List<MatchModel> matchModelListItems;

    public MatchAdapter(Context context, List<MatchModel> pointTableModelsItems) {
        this.context = context;
        this.matchModelListItems = pointTableModelsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.match_list_items,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        MatchModel matchModel= matchModelListItems.get(position);

        Glide.with(context).load(matchModel.getImg1()).into(holder.img1);
        Glide.with(context).load(matchModel.getImg2()).into(holder.img2);
        holder.team1.setText(matchModel.getTeam1());
        holder.team2.setText(matchModel.getTeam2());
        holder.time.setText(matchModel.getTime());
        holder.stadium.setText(matchModel.getStadium());
        holder.date.setText(matchModel.getDate());



    }

    @Override
    public int getItemCount() {

            return matchModelListItems.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img1,img2;
        TextView team1,team2,time,date,stadium;



        public ViewHolder(View itemView) {
            super(itemView);

            img1=(ImageView)itemView.findViewById(R.id.MATCH_imag1);
            img2=(ImageView)itemView.findViewById(R.id.MATCH_img2);

            team1=(TextView) itemView.findViewById(R.id.MATCH_team1);
            team2=(TextView) itemView.findViewById(R.id.MATCH_team2);
            time=(TextView) itemView.findViewById(R.id.MATCH_time);
            date=(TextView)itemView.findViewById(R.id.MATCH_date);
            stadium=(TextView)itemView.findViewById(R.id.MATCH_stadium);



        }
    }
}
