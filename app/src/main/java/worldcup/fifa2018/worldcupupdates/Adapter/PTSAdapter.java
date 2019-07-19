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

import worldcup.fifa2018.worldcupupdates.Model.pointTableModel;
import worldcup.fifa2018.worldcupupdates.R;

public class PTSAdapter extends RecyclerView.Adapter<PTSAdapter.ViewHolder> {

    private Context context;
    private List<pointTableModel> pointTableModelsItems;

    public PTSAdapter(Context context, List<pointTableModel> pointTableModelsItems) {
        this.context = context;
        this.pointTableModelsItems = pointTableModelsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pts_list_items_group, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int i = 1;
        if (position == 0) {
            i = 1;
        } else if (position == 1) {
            i = 6;
        } else if (position == 2) {
            i = 11;
        } else if (position == 3) {
            i = 16;
        } else if (position == 4) {
            i = 21;
        } else if (position == 5) {
            i = 26;
        } else if (position == 6) {
            i = 31;
        } else if (position == 7) {
            i = 36;
        }

        pointTableModel pointTableModel = pointTableModelsItems.get(i + 0);
        Glide.with(context).load(pointTableModel.getImg_url()).into(holder.image1);
        holder.group.setText(pointTableModel.getGroup());
        holder.team1.setText(pointTableModel.getTeam_name());
        holder.mp1.setText(pointTableModel.getMP());
        holder.w1.setText(pointTableModel.getW());
        holder.d1.setText(pointTableModel.getD());
        holder.l1.setText(pointTableModel.getL());
        holder.gf1.setText(pointTableModel.getGF());
        holder.ga1.setText(pointTableModel.getGA());
        holder.gd1.setText(pointTableModel.getGD());
        holder.pts1.setText(pointTableModel.getPTS());

        pointTableModel = pointTableModelsItems.get(i + 1);
        Glide.with(context).load(pointTableModel.getImg_url()).into(holder.image2);
        holder.team2.setText(pointTableModel.getTeam_name());
        holder.mp2.setText(pointTableModel.getMP());
        holder.w2.setText(pointTableModel.getW());
        holder.d2.setText(pointTableModel.getD());
        holder.l2.setText(pointTableModel.getL());
        holder.gf2.setText(pointTableModel.getGF());
        holder.ga2.setText(pointTableModel.getGA());
        holder.gd2.setText(pointTableModel.getGD());
        holder.pts2.setText(pointTableModel.getPTS());

        pointTableModel = pointTableModelsItems.get(i + 2);
        Glide.with(context).load(pointTableModel.getImg_url()).into(holder.image3);
        holder.team3.setText(pointTableModel.getTeam_name());
        holder.mp3.setText(pointTableModel.getMP());
        holder.w3.setText(pointTableModel.getW());
        holder.d3.setText(pointTableModel.getD());
        holder.l3.setText(pointTableModel.getL());
        holder.gf3.setText(pointTableModel.getGF());
        holder.ga3.setText(pointTableModel.getGA());
        holder.gd3.setText(pointTableModel.getGD());
        holder.pts3.setText(pointTableModel.getPTS());

        pointTableModel = pointTableModelsItems.get(i + 3);
        Glide.with(context).load(pointTableModel.getImg_url()).into(holder.image4);
        holder.team4.setText(pointTableModel.getTeam_name());
        holder.mp4.setText(pointTableModel.getMP());
        holder.w4.setText(pointTableModel.getW());
        holder.d4.setText(pointTableModel.getD());
        holder.l4.setText(pointTableModel.getL());
        holder.gf4.setText(pointTableModel.getGF());
        holder.ga4.setText(pointTableModel.getGA());
        holder.gd4.setText(pointTableModel.getGD());
        holder.pts4.setText(pointTableModel.getPTS());


    }

    @Override
    public int getItemCount() {
        if (pointTableModelsItems.size() <= 0) {
            return pointTableModelsItems.size();
        } else {
            return 8;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2, image3, image4;
        TextView team1, mp1, w1, d1, l1, gf1, ga1, gd1, pts1, group;
        TextView team2, mp2, w2, d2, l2, gf2, ga2, gd2, pts2;
        TextView team3, mp3, w3, d3, l3, gf3, ga3, gd3, pts3;
        TextView team4, mp4, w4, d4, l4, gf4, ga4, gd4, pts4;


        public ViewHolder(View itemView) {
            super(itemView);
            group = (TextView) itemView.findViewById(R.id.group);

            image1 = (ImageView) itemView.findViewById(R.id.PTS_image1);
            team1 = (TextView) itemView.findViewById(R.id.PTS_teamName1);
            mp1 = (TextView) itemView.findViewById(R.id.PTS_mp1);
            w1 = (TextView) itemView.findViewById(R.id.PTS_w1);
            d1 = (TextView) itemView.findViewById(R.id.PTS_d1);
            l1 = (TextView) itemView.findViewById(R.id.PTS_l1);
            gf1 = (TextView) itemView.findViewById(R.id.PTS_gf1);
            ga1 = (TextView) itemView.findViewById(R.id.PTS_ga1);
            gd1 = (TextView) itemView.findViewById(R.id.PTS_gd1);
            pts1 = (TextView) itemView.findViewById(R.id.PTS_pts1);

            image2 = (ImageView) itemView.findViewById(R.id.PTS_image2);
            team2 = (TextView) itemView.findViewById(R.id.PTS_teamName2);
            mp2 = (TextView) itemView.findViewById(R.id.PTS_mp2);
            w2 = (TextView) itemView.findViewById(R.id.PTS_w2);
            d2 = (TextView) itemView.findViewById(R.id.PTS_d2);
            l2 = (TextView) itemView.findViewById(R.id.PTS_l2);
            gf2 = (TextView) itemView.findViewById(R.id.PTS_gf2);
            ga2 = (TextView) itemView.findViewById(R.id.PTS_ga2);
            gd2 = (TextView) itemView.findViewById(R.id.PTS_gd2);
            pts2 = (TextView) itemView.findViewById(R.id.PTS_pts2);

            image3 = (ImageView) itemView.findViewById(R.id.PTS_image3);
            team3 = (TextView) itemView.findViewById(R.id.PTS_teamName3);
            mp3 = (TextView) itemView.findViewById(R.id.PTS_mp3);
            w3 = (TextView) itemView.findViewById(R.id.PTS_w3);
            d3 = (TextView) itemView.findViewById(R.id.PTS_d3);
            l3 = (TextView) itemView.findViewById(R.id.PTS_l3);
            gf3 = (TextView) itemView.findViewById(R.id.PTS_gf3);
            ga3 = (TextView) itemView.findViewById(R.id.PTS_ga3);
            gd3 = (TextView) itemView.findViewById(R.id.PTS_gd3);
            pts3 = (TextView) itemView.findViewById(R.id.PTS_pts3);

            image4 = (ImageView) itemView.findViewById(R.id.PTS_image4);
            team4 = (TextView) itemView.findViewById(R.id.PTS_teamName4);
            mp4 = (TextView) itemView.findViewById(R.id.PTS_mp4);
            w4 = (TextView) itemView.findViewById(R.id.PTS_w4);
            d4 = (TextView) itemView.findViewById(R.id.PTS_d4);
            l4 = (TextView) itemView.findViewById(R.id.PTS_l4);
            gf4 = (TextView) itemView.findViewById(R.id.PTS_gf4);
            ga4 = (TextView) itemView.findViewById(R.id.PTS_ga4);
            gd4 = (TextView) itemView.findViewById(R.id.PTS_gd4);
            pts4 = (TextView) itemView.findViewById(R.id.PTS_pts4);


        }
    }
}
