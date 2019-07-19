package worldcup.fifa2018.worldcupupdates;


import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import worldcup.fifa2018.worldcupupdates.Adapter.PTSAdapter;
import worldcup.fifa2018.worldcupupdates.Model.pointTableModel;

public class ScoreBoard extends Fragment {

    private List<pointTableModel> modelListItems;
    Boolean network =false;
    public ScoreBoard() {
        // Required empty public constructor
    }

    public static ScoreBoard newInstance(String param1, String param2) {
        ScoreBoard fragment = new ScoreBoard();
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


        final View view = inflater.inflate(R.layout.scoreboard, container, false);



        final RecyclerView recyclerView_PTS = (RecyclerView) view.findViewById(R.id.recycler_PTS1);
        recyclerView_PTS.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager_PTS = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView_PTS.setLayoutManager(layoutManager_PTS);

        modelListItems = new ArrayList<>();
        final ProgressBar loading = (ProgressBar)view.findViewById(R.id.progressBar2);
        loading.setVisibility(View.VISIBLE);
        loading.setIndeterminate(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();
                Document doc;
                try {

                    doc = Jsoup.connect("http://studoob.in/WC/score.html").timeout(10000).get();
                    for (Element table : doc.select("table[class=fi-table fi-standings]")) {

                        Elements group = table.select("p[class=fi-table__caption__title]");
                        String groupname = group.text();
                        // Log.d("GP", groupName);

                        for (int i = 0; i < 5; i++) {
                            Element row = table.select("tr").get(i);
                            Elements tds = row.select("td[class=fi-table__teamname teamname-nolink]");
                            Elements img_div = tds.select("div[class=fi-t__i ");
                            Elements image = img_div.select("img[src]");
                            String image_URL = image.attr("src");
                            //Log.d("TD", imgSrcStr);

                            Elements Sda = tds.select("div[class=fi-t__n]");
                            Elements team = Sda.select("span[class=fi-t__nText]");
                            String teamName = team.text();
                            // Log.d("TD", team.text());

                            Elements td_mp = row.select("td[class=fi-table__matchplayed]");
                            Elements sp_mp = td_mp.select("span[class=text]");
                            String MP = sp_mp.text();
                            //  Log.d("GP", MP);

                            Elements td_w = row.select("td[class=fi-table__win]");
                            Elements sp_w = td_w.select("span[class=text]");
                            String W = sp_w.text();
                            //  Log.d("W", W);

                            Elements td_d = row.select("td[class=fi-table__draw]");
                            Elements sp_d = td_d.select("span[class=text]");
                            String D = sp_d.text();
                            //  Log.d("D", D);


                            Elements td_l = row.select("td[class=fi-table__lost]");
                            Elements sp_l = td_l.select("span[class=text]");
                            String L = sp_l.text();
                            //  Log.d("L", L);

                            Elements td_gf = row.select("td[class=fi-table__goalfor]");
                            Elements sp_gf = td_gf.select("span[class=text]");
                            String GF = sp_gf.text();
                            //  Log.d("GF", GF);

                            Elements td_ga = row.select("td[class=fi-table__goalagainst]");
                            Elements sp_ga = td_ga.select("span[class=text]");
                            String GA = sp_ga.text();
                            //  Log.d("GA", GA);

                            Elements td_gd = row.select("td[class=fi-table__diffgoal]");
                            Elements sp_gd = td_gd.select("span[class=text]");
                            String GD = sp_gd.text();
                            // Log.d("GD", GD);

                            Elements td_pts = row.select("td[class=fi-table__pts]");
                            Elements sp_pts = td_pts.select("span[class=text]");
                            String PTS = sp_pts.text();
                            //  Log.d("PTS", PTS);

                            modelListItems.add(new pointTableModel(groupname, teamName, image_URL, MP, W, D, L, GF, GA, GD, PTS));
                            Log.d("COUNT", modelListItems.size() + "");
                        }

                    }

                } catch (IOException e) {
                    builder.append("Error : ").append(e.getMessage()).append("\n");
                }

                try {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            final PTSAdapter Agp1 = new PTSAdapter(getContext(), modelListItems);
                            recyclerView_PTS.setAdapter(Agp1);
                            loading.setIndeterminate(false);
                            loading.setVisibility(View.INVISIBLE);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
        getContext().registerReceiver(
                mConnReceiver,
                new IntentFilter(
                        ConnectivityManager.CONNECTIVITY_ACTION));
        return view;
    }


    public BroadcastReceiver mConnReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            String reason = intent.getStringExtra(ConnectivityManager.EXTRA_REASON);
            boolean isFailover = intent.getBooleanExtra(ConnectivityManager.EXTRA_IS_FAILOVER, false);

            NetworkInfo currentNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
            NetworkInfo otherNetworkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_OTHER_NETWORK_INFO);

            if (currentNetworkInfo.isConnected()) {
                network = true;
            } else {
                 Toast.makeText(getContext(), "No internet", Toast.LENGTH_LONG).show();
                network = false;
            }
        }
    };

    @Override
    public void onStop() {
        try {
            getContext().unregisterReceiver(mConnReceiver);
            super.onStop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onResume() {
        try {
            getContext().registerReceiver(
                    mConnReceiver,
                    new IntentFilter(
                            ConnectivityManager.CONNECTIVITY_ACTION));
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}