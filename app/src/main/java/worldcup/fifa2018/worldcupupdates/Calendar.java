package worldcup.fifa2018.worldcupupdates;

import android.Manifest;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import worldcup.fifa2018.worldcupupdates.Adapter.MatchAdapter;
import worldcup.fifa2018.worldcupupdates.Adapter.PTSAdapter;
import worldcup.fifa2018.worldcupupdates.Model.MatchModel;
import worldcup.fifa2018.worldcupupdates.Model.pointTableModel;

public class Calendar extends android.support.v4.app.Fragment {

    List<MatchModel> modelListItems;


    public Calendar() {
        // Required empty public constructor
    }

    public static Calendar newInstance(String param1, String param2) {
        Calendar fragment = new Calendar();
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
        final View view = inflater.inflate(R.layout.group, container, false);

        modelListItems = new ArrayList<>();

        final RecyclerView recyclerView_PTS = (RecyclerView) view.findViewById(R.id.recycler_MATCH);
        recyclerView_PTS.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager_PTS = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView_PTS.setLayoutManager(layoutManager_PTS);
        final MatchAdapter adapter = new MatchAdapter(getActivity(), modelListItems);
        recyclerView_PTS.setAdapter(adapter);
        final ProgressBar loading = (ProgressBar)view.findViewById(R.id.progressBar2);
        loading.setVisibility(View.VISIBLE);
        loading.setIndeterminate(true);






        modelListItems.add(new MatchModel("30 june 2018","19.30"," ", " ", " ", "Argentina",R.drawable.argentina,"France",R.drawable.france));
        modelListItems.add(new MatchModel("30 june 2018","23.30", " ", " ", " ", "Portugal",R.drawable.portugal,"Uruguay",R.drawable.uruguay));
        modelListItems.add(new MatchModel("1 july 2018","19.30", " ", " ", " ", "Spain",R.drawable.spain,"Russia",R.drawable.russia));
        modelListItems.add(new MatchModel("1 july 2018","23.30", " ", " ", " ", "Croatia",R.drawable.craotia,"Denmark",R.drawable.denmark));
        modelListItems.add(new MatchModel("2 july 2018","19.30", " ", " ", " ", "Brazil",R.drawable.brazil,"Mexico",R.drawable.mexico));
        modelListItems.add(new MatchModel("2 july 2018","23.30", " ", " ", " ", "Belgium",R.drawable.belgium,"Japan",R.drawable.japan));
        modelListItems.add(new MatchModel("3 july 2018","19.30", " ", " ", " ", "Sweden",R.drawable.sweden,"Switzerland",R.drawable.switzerland));
        modelListItems.add(new MatchModel("3 july 2018","23.30", " ", " ", " ", "England",R.drawable.england,"Colombia",R.drawable.columbia));


        modelListItems.add(new MatchModel("14 june 2018","20.30","Group A","Luzhniki Stadium","Moscow","Russia",R.drawable.russia,"Saudi Arabia",R.drawable.saudi));
        modelListItems.add(new MatchModel("15 june 2018","17.30","Group A","Ekaterinburg Arena","Ekaterinburg","Egypt",R.drawable.egypt,"Uruguay",R.drawable.uruguay));
        modelListItems.add(new MatchModel("15 june 2018","20.30","Group B","Saint Petersburg stadium","Saint Petersburg","Morocco",R.drawable.morocco,"Iran",R.drawable.iran));
        modelListItems.add(new MatchModel("15 june 2018","23.30","Group B","Fisht stadium","Sochi","Portugal",R.drawable.portugal,"Spain",R.drawable.spain));
        modelListItems.add(new MatchModel("16 june 2018","15.30","Group C","Kazan Arena","Kazan","France",R.drawable.france,"Australia",R.drawable.australia));
        modelListItems.add(new MatchModel("16 june 2018","18.30","Group D","Spartak stadium","Moscow","Argentina",R.drawable.argentina,"Iceland",R.drawable.iceland));
        modelListItems.add(new MatchModel("16 june 2018","21.30","Group C","Mordovia Arena","Saransk","Peru",R.drawable.peru,"Denmark",R.drawable.denmark));
        modelListItems.add(new MatchModel("16 june 2018","00.30","Group D","Kaliningrad stadium","Kaliningrad","Croatia",R.drawable.craotia,"Nigeria",R.drawable.nigeria));
        modelListItems.add(new MatchModel("17 june 2018","17.30","Group E","Samara Arena","Samara","Costa Rica",R.drawable.costarica,"Serbia",R.drawable.serbia));
        modelListItems.add(new MatchModel("17 june 2018","20.30","Group F","Luzhniki stadium","Moscow","Germany",R.drawable.germany,"Mexico",R.drawable.mexico));
        modelListItems.add(new MatchModel("17 june 2018","23.30","Group E","Rostov Arena","Rostov-On-Don","Brazil",R.drawable.brazil,"Switzerland",R.drawable.switzerland));
        modelListItems.add(new MatchModel("18 june 2018","17.30","Group F","Nizhny Novgorod stadium","Nizhny Novgorod","Sweden",R.drawable.sweden,"Korea Republic",R.drawable.korea));
        modelListItems.add(new MatchModel("18 june 2018","20.30","Group G","Fisht stadium","Sochi","Belgium",R.drawable.belgium,"Panama",R.drawable.panama));
        modelListItems.add(new MatchModel("18 june 2018","23.30","Group G","Volgograd Arena","Volgograd","Tunisia",R.drawable.tunisia,"England",R.drawable.england));
        modelListItems.add(new MatchModel("19 june 2018","17.30","Group H","Mordovia Arena","Saransk","Colombia",R.drawable.columbia,"Japan",R.drawable.japan));
        modelListItems.add(new MatchModel("19 june 2018","20.30","Group H","Spartak stadium","Moscow","Poland",R.drawable.poland,"Senegal",R.drawable.senagal));
        modelListItems.add(new MatchModel("19 june 2018","23.30","Group A","Saint Petersburg stadium","Saint Petersburg","Russia",R.drawable.russia,"Egypt",R.drawable.egypt));
        modelListItems.add(new MatchModel("20 june 2018","17.30","Group B","Luzhniki stadium","Moscow","Portugal",R.drawable.portugal,"Morocco",R.drawable.morocco));
        modelListItems.add(new MatchModel("20 june 2018","20.30","Group A","Rostov Arena","Rostov-On-Don","Uruguay",R.drawable.uruguay,"Saudi Arabia",R.drawable.saudi));
        modelListItems.add(new MatchModel("20 june 2018","23.30","Group B","Kazan Arena","Kazan","Iran",R.drawable.iran,"Spain",R.drawable.spain));
        modelListItems.add(new MatchModel("21 june 2018","17.30","Group C","Samara Arena","Samara","Denmark",R.drawable.denmark,"Australia",R.drawable.australia));
        modelListItems.add(new MatchModel("21 june 2018","20.30","Group C","Ekaterinburg Arena","Ekaterinburg","France",R.drawable.france,"Peru",R.drawable.peru));
        modelListItems.add(new MatchModel("21 june 2018","23.30","Group D","Nizhny Novgorod stadium","Nizhny Novgorod","Argentina",R.drawable.argentina,"Croatia",R.drawable.craotia));
        modelListItems.add(new MatchModel("22 june 2018","17.30","Group E","Saint Petersburg stadium","Saint Petersburg","Brazil",R.drawable.brazil,"Costa Rica",R.drawable.costarica));
        modelListItems.add(new MatchModel("22 june 2018","20.30","Group D","Volgograd Arena","Volgograd","Nigeria",R.drawable.nigeria,"Iceland",R.drawable.iceland));
        modelListItems.add(new MatchModel("22 june 2018","23.30","Group E","Kaliningrad stadium","Kaliningrad","Serbia",R.drawable.serbia,"Switzerland",R.drawable.switzerland));
        modelListItems.add(new MatchModel("23 june 2018","17.30","Group G","Spartak stadium","Moscow","Belgium",R.drawable.belgium,"Tunisia",R.drawable.tunisia));
        modelListItems.add(new MatchModel("23 june 2018","20.30","Group F","Rostov Arena","Rostov-On-Don","Korea Republic",R.drawable.korea,"Mexico",R.drawable.mexico));
        modelListItems.add(new MatchModel("23 june 2018","23.30","Group F","Fisht stadium","Sochi","Germany",R.drawable.germany,"Sweden",R.drawable.sweden));
        modelListItems.add(new MatchModel("24 june 2018","17.30","Group G","Nizhny Novgorod stadium","Nizhny Novgorod","England",R.drawable.england,"Panama",R.drawable.panama));
        modelListItems.add(new MatchModel("24 june 2018","20.30","Group H","Ekaterinburg Arena","Ekaterinburg","Japan",R.drawable.japan,"Senegal",R.drawable.senagal));
        modelListItems.add(new MatchModel("24 june 2018","23.30","Group H","Kazan Arena","Kazan","Poland",R.drawable.poland,"Colombia",R.drawable.craotia));
        modelListItems.add(new MatchModel("25 june 2018","19.30","Group A","Samara Arena","Samara","Uruguay",R.drawable.uruguay,"Russia",R.drawable.russia));
        modelListItems.add(new MatchModel("25 june 2018","19.30","Group A","Volgograd Arena","Volgograd","Saudi Arabia",R.drawable.saudi,"Egypt",R.drawable.egypt));
        modelListItems.add(new MatchModel("25 june 2018","23.30","Group B","Kaliningrad stadium","Kaliningrad","Spain",R.drawable.spain,"Morocco",R.drawable.morocco));
        modelListItems.add(new MatchModel("25 june 2018","23.30","Group B","Mordovia Arena","Saransk","Iran",R.drawable.iran,"Portugal",R.drawable.portugal));
        modelListItems.add(new MatchModel("26 june 2018","19.30","Group C","Fisht stadium","Sochi","Australia",R.drawable.australia,"Peru",R.drawable.peru));
        modelListItems.add(new MatchModel("26 june 2018","19.30","Group C","Luzhniki Stadium","Moscow","Denmark",R.drawable.denmark,"France",R.drawable.france));
        modelListItems.add(new MatchModel("26 june 2018","23.30","Group D","Saint Petersburg stadium","Saint Petersburg","Nigeria",R.drawable.nigeria,"Argentina",R.drawable.argentina));
        modelListItems.add(new MatchModel("26 june 2018","23.30","Group D","Rostov Arena","Rostov-On-Don","Iceland",R.drawable.iceland,"Croatia",R.drawable.craotia));
        modelListItems.add(new MatchModel("27 june 2018","19.30","Group F","Kazan Arena","Kazan","Korea Republic",R.drawable.korea,"Germany",R.drawable.germany));
        modelListItems.add(new MatchModel("27 june 2018","19.30","Group F","Ekaterinburg Arena","Ekaterinburg","Mexico",R.drawable.mexico,"Sweden",R.drawable.sweden));
        modelListItems.add(new MatchModel("27 june 2018","23.30","Group E","Spartak stadium","Moscow","Serbia",R.drawable.serbia,"Brazil",R.drawable.brazil));
        modelListItems.add(new MatchModel("27 june 2018","23.30","Group E","Nizhny Novgorod Stadium","Nizhny Novgorod","Switzerland",R.drawable.switzerland,"Costa Rica",R.drawable.costarica));
        modelListItems.add(new MatchModel("28 june 2018","19.30","Group H","Volgograd Arena","Volgograd","Japan",R.drawable.japan,"Poland",R.drawable.poland));
        modelListItems.add(new MatchModel("28 june 2018","19.30","Group H","Samara Arena","Samara","Senegal",R.drawable.senagal,"Colombia",R.drawable.columbia));
        modelListItems.add(new MatchModel("28 june 2018","23.30","Group G","Mordovia Arena","Saransk","Panama",R.drawable.panama,"Tunisia",R.drawable.tunisia));
        modelListItems.add(new MatchModel("28 june 2018","23.30","Group G","Kaliningrad Stadium","Kaliningrad","England",R.drawable.england,"Belgium",R.drawable.belgium));
        modelListItems.add(new MatchModel("14 june 2018","20.30","Group A","Luzhniki Stadium","Moscow","Russia",R.drawable.russia,"Saudi Arabia",R.drawable.saudi));
        modelListItems.add(new MatchModel("15 june 2018","17.30","Group A","Ekaterinburg Arena","Ekaterinburg","Egypt",R.drawable.egypt,"Uruguay",R.drawable.uruguay));
        modelListItems.add(new MatchModel("15 june 2018","20.30","Group B","Saint Petersburg stadium","Saint Petersburg","Morocco",R.drawable.morocco,"Iran",R.drawable.iran));
        modelListItems.add(new MatchModel("15 june 2018","23.30","Group B","Fisht stadium","Sochi","Portugal",R.drawable.portugal,"Spain",R.drawable.spain));
        modelListItems.add(new MatchModel("16 june 2018","15.30","Group C","Kazan Arena","Kazan","France",R.drawable.france,"Australia",R.drawable.australia));
        modelListItems.add(new MatchModel("16 june 2018","18.30","Group D","Spartak stadium","Moscow","Argentina",R.drawable.argentina,"Iceland",R.drawable.iceland));
        modelListItems.add(new MatchModel("16 june 2018","21.30","Group C","Mordovia Arena","Saransk","Peru",R.drawable.peru,"Denmark",R.drawable.denmark));
        modelListItems.add(new MatchModel("16 june 2018","00.30","Group D","Kaliningrad stadium","Kaliningrad","Croatia",R.drawable.craotia,"Nigeria",R.drawable.nigeria));
        modelListItems.add(new MatchModel("17 june 2018","17.30","Group E","Samara Arena","Samara","Costa Rica",R.drawable.costarica,"Serbia",R.drawable.serbia));
        modelListItems.add(new MatchModel("17 june 2018","20.30","Group F","Luzhniki stadium","Moscow","Germany",R.drawable.germany,"Mexico",R.drawable.mexico));
        modelListItems.add(new MatchModel("17 june 2018","23.30","Group E","Rostov Arena","Rostov-On-Don","Brazil",R.drawable.brazil,"Switzerland",R.drawable.switzerland));
        modelListItems.add(new MatchModel("18 june 2018","17.30","Group F","Nizhny Novgorod stadium","Nizhny Novgorod","Sweden",R.drawable.sweden,"Korea Republic",R.drawable.korea));
        modelListItems.add(new MatchModel("18 june 2018","20.30","Group G","Fisht stadium","Sochi","Belgium",R.drawable.belgium,"Panama",R.drawable.panama));
        modelListItems.add(new MatchModel("18 june 2018","23.30","Group G","Volgograd Arena","Volgograd","Tunisia",R.drawable.tunisia,"England",R.drawable.england));
        modelListItems.add(new MatchModel("19 june 2018","17.30","Group H","Mordovia Arena","Saransk","Colombia",R.drawable.columbia,"Japan",R.drawable.japan));
        modelListItems.add(new MatchModel("19 june 2018","20.30","Group H","Spartak stadium","Moscow","Poland",R.drawable.poland,"Senegal",R.drawable.senagal));
        modelListItems.add(new MatchModel("19 june 2018","23.30","Group A","Saint Petersburg stadium","Saint Petersburg","Russia",R.drawable.russia,"Egypt",R.drawable.egypt));
        modelListItems.add(new MatchModel("20 june 2018","17.30","Group B","Luzhniki stadium","Moscow","Portugal",R.drawable.portugal,"Morocco",R.drawable.morocco));
        modelListItems.add(new MatchModel("20 june 2018","20.30","Group A","Rostov Arena","Rostov-On-Don","Uruguay",R.drawable.uruguay,"Saudi Arabia",R.drawable.saudi));
        modelListItems.add(new MatchModel("20 june 2018","23.30","Group B","Kazan Arena","Kazan","Iran",R.drawable.iran,"Spain",R.drawable.spain));
        modelListItems.add(new MatchModel("21 june 2018","17.30","Group C","Samara Arena","Samara","Denmark",R.drawable.denmark,"Australia",R.drawable.australia));
        modelListItems.add(new MatchModel("21 june 2018","20.30","Group C","Ekaterinburg Arena","Ekaterinburg","France",R.drawable.france,"Peru",R.drawable.peru));
        modelListItems.add(new MatchModel("21 june 2018","23.30","Group D","Nizhny Novgorod stadium","Nizhny Novgorod","Argentina",R.drawable.argentina,"Croatia",R.drawable.craotia));
        modelListItems.add(new MatchModel("22 june 2018","17.30","Group E","Saint Petersburg stadium","Saint Petersburg","Brazil",R.drawable.brazil,"Costa Rica",R.drawable.costarica));
        modelListItems.add(new MatchModel("22 june 2018","20.30","Group D","Volgograd Arena","Volgograd","Nigeria",R.drawable.nigeria,"Iceland",R.drawable.iceland));
        modelListItems.add(new MatchModel("22 june 2018","23.30","Group E","Kaliningrad stadium","Kaliningrad","Serbia",R.drawable.serbia,"Switzerland",R.drawable.switzerland));
        modelListItems.add(new MatchModel("23 june 2018","17.30","Group G","Spartak stadium","Moscow","Belgium",R.drawable.belgium,"Tunisia",R.drawable.tunisia));
        modelListItems.add(new MatchModel("23 june 2018","20.30","Group F","Rostov Arena","Rostov-On-Don","Korea Republic",R.drawable.korea,"Mexico",R.drawable.mexico));
        modelListItems.add(new MatchModel("23 june 2018","23.30","Group F","Fisht stadium","Sochi","Germany",R.drawable.germany,"Sweden",R.drawable.sweden));
        modelListItems.add(new MatchModel("24 june 2018","17.30","Group G","Nizhny Novgorod stadium","Nizhny Novgorod","England",R.drawable.england,"Panama",R.drawable.panama));
        modelListItems.add(new MatchModel("24 june 2018","20.30","Group H","Ekaterinburg Arena","Ekaterinburg","Japan",R.drawable.japan,"Senegal",R.drawable.senagal));
        modelListItems.add(new MatchModel("24 june 2018","23.30","Group H","Kazan Arena","Kazan","Poland",R.drawable.poland,"Colombia",R.drawable.columbia));
        modelListItems.add(new MatchModel("25 june 2018","19.30","Group A","Samara Arena","Samara","Uruguay",R.drawable.uruguay,"Russia",R.drawable.russia));
        modelListItems.add(new MatchModel("25 june 2018","19.30","Group A","Volgograd Arena","Volgograd","Saudi Arabia",R.drawable.saudi,"Egypt",R.drawable.egypt));
        modelListItems.add(new MatchModel("25 june 2018","23.30","Group B","Kaliningrad stadium","Kaliningrad","Spain",R.drawable.spain,"Morocco",R.drawable.morocco));
        modelListItems.add(new MatchModel("25 june 2018","23.30","Group B","Mordovia Arena","Saransk","Iran",R.drawable.iran,"Portugal",R.drawable.portugal));
        modelListItems.add(new MatchModel("26 june 2018","19.30","Group C","Fisht stadium","Sochi","Australia",R.drawable.australia,"Peru",R.drawable.peru));
        modelListItems.add(new MatchModel("26 june 2018","19.30","Group C","Luzhniki Stadium","Moscow","Denmark",R.drawable.denmark,"France",R.drawable.france));
        modelListItems.add(new MatchModel("26 june 2018","23.30","Group D","Saint Petersburg stadium","Saint Petersburg","Nigeria",R.drawable.nigeria,"Argentina",R.drawable.argentina));
        modelListItems.add(new MatchModel("26 june 2018","23.30","Group D","Rostov Arena","Rostov-On-Don","Iceland",R.drawable.iceland,"Croatia",R.drawable.craotia));
        modelListItems.add(new MatchModel("27 june 2018","19.30","Group F","Kazan Arena","Kazan","Korea Republic",R.drawable.korea,"Germany",R.drawable.germany));
        modelListItems.add(new MatchModel("27 june 2018","19.30","Group F","Ekaterinburg Arena","Ekaterinburg","Mexico",R.drawable.mexico,"Sweden",R.drawable.sweden));
        modelListItems.add(new MatchModel("27 june 2018","23.30","Group E","Spartak stadium","Moscow","Serbia",R.drawable.serbia,"Brazil",R.drawable.brazil));
        modelListItems.add(new MatchModel("27 june 2018","23.30","Group E","Nizhny Novgorod Stadium","Nizhny Novgorod","Switzerland",R.drawable.switzerland,"Costa Rica",R.drawable.costarica));
        modelListItems.add(new MatchModel("28 june 2018","19.30","Group H","Volgograd Arena","Volgograd","Japan",R.drawable.japan,"Poland",R.drawable.poland));
        modelListItems.add(new MatchModel("28 june 2018","19.30","Group H","Samara Arena","Samara","Senegal",R.drawable.senagal,"Colombia",R.drawable.columbia));
        modelListItems.add(new MatchModel("28 june 2018","23.30","Group G","Mordovia Arena","Saransk","Panama",R.drawable.panama,"Tunisia",R.drawable.tunisia));
        modelListItems.add(new MatchModel("28 june 2018","23.30","Group G","Kaliningrad Stadium","Kaliningrad","England",R.drawable.england,"Belgium",R.drawable.belgium));


        adapter.notifyDataSetChanged();
        return view;
    }




    @Override
    public void onStop() {


        super.onStop();
    }

    @Override
    public void onResume() {


        super.onResume();
    }
}


