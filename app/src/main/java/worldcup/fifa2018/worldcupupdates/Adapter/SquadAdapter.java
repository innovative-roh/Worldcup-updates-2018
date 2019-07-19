package worldcup.fifa2018.worldcupupdates.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import worldcup.fifa2018.worldcupupdates.Model.SquadModel;
import worldcup.fifa2018.worldcupupdates.R;
import worldcup.fifa2018.worldcupupdates.TeamDetails;

/**
 * Created by Belal on 10/18/2017.
 */


public class SquadAdapter extends RecyclerView.Adapter<SquadAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context context;

    //we are storing all the products in a list
    private List<SquadModel> productList;

    //getting the context and product list with constructor
    public SquadAdapter(Context mCtx, List<SquadModel> productList) {
        this.context = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.squad_item_layout, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {
        //getting the product of the specified position
        final SquadModel product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTeam());

        Glide.with(context).load(product.getIMG()).into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TeamDetails(product.getSHORT());
            }
        });

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageView;
        LinearLayout linearLayout;

        public ProductViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageView);
            linearLayout = itemView.findViewById(R.id.squad_linear);
        }
    }


    public void TeamDetails(String SHORT) {
        Intent i = new Intent(context, TeamDetails.class);
        i.putExtra("TEAM", SHORT);
        context.startActivity(i);
    }
}