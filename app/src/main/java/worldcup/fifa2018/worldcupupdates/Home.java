package worldcup.fifa2018.worldcupupdates;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import worldcup.fifa2018.worldcupupdates.Adapter.SquadAdapter;
import worldcup.fifa2018.worldcupupdates.Model.SquadModel;

public class Home  extends Fragment {


    TextView match, goal, yello, red, yellored, audi;
    private AdView mAdView;
    private String Video = "kFMZUxX6K6o";
    private String name=null;
    ImageView yt;
    TextView videoname;
    public static final String LOGIN_URL = "http://www.studoob.in/WC/";

    public Home() {
        // Required empty public constructor
    }

    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home, container, false);

        MobileAds.initialize(getContext(), getString(R.string.admob_app_id));
        mAdView = v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView rank = (TextView) v.findViewById(R.id.worldRanking);
        rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WorldRanking.class));
            }
        });
      //  videoname=(TextView)v.findViewById(R.id.livetv);

        TextView stadium = (TextView) v.findViewById(R.id.stadium);
        stadium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Stadium.class));
            }
        });

        TextView facts = (TextView) v.findViewById(R.id.worldcupfacts);
        facts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WorldCupFacts.class));
            }
        });

        TextView champ = (TextView) v.findViewById(R.id.champion);
        champ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), champions.class));
            }
        });


        TextView scorer = (TextView) v.findViewById(R.id.seemore);
        scorer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TopScore.class));
            }
        });

        Button share = (Button) v.findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "Here is an interesting app for all football lovers out there. The FIFA WORLD CUP 2018 updates are now at your fingertips. Check out this new app and you would love it!!! \n https://play.google.com/store/apps/details?id=worldcup.fifa2018.worldcupupdates");
                startActivity(sharingIntent);
            }
        });

        Button rate = (Button) v.findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rateus = new Intent(Intent.ACTION_VIEW);
                rateus.setData(Uri.parse("https://play.google.com/store/apps/details?id=worldcup.fifa2018.worldcupupdates"));
                startActivity(rateus);
            }
        });

       /* yt = (ImageView) v.findViewById(R.id.youtubevideo);
        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getActivity(), Video.class);
                i.putExtra("VID",Video);
                startActivity(i);
            }
        });
        Action("video.php");*/
        return v;
    }



    private void Action(String url) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL + url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            response = "{hero:" + response + "}";
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("hero");
                            JSONObject o = array.getJSONObject(0);
                            Video = o.getString("url");
                            name=o.getString("name");
                            videoname.setText(name);
                            try {
                               // Glide.with(getActivity()).load("https://img.youtube.com/vi/"+Video+"/default.jpg").into(yt);
                                Glide.with(getActivity()).load("https://img.youtube.com/vi/"+Video+"/sddefault.jpg").into(yt);
                            }
                           catch (Exception e ){
                             e.printStackTrace();
                           }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String message = null;
                        if (error instanceof NetworkError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                        } else if (error instanceof ServerError) {
                            message = "The server could not be found. Please try again after some time!!";
                            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                        } else if (error instanceof AuthFailureError) {
                            message = "Authentication Error!!";
                            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                        } else if (error instanceof ParseError) {
                            message = "Parsing error! Please try again after some time!!";
                            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                        } else if (error instanceof TimeoutError) {
                            message = "Connection TimeOut! Please check your internet connection.";
                            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                        }
                    }

                }) {
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}


