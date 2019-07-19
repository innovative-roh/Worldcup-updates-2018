package worldcup.fifa2018.worldcupupdates;

        import android.content.Context;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.RelativeLayout;

        import com.google.android.gms.ads.AdRequest;
        import com.google.android.gms.ads.AdView;
        import com.google.android.gms.ads.MobileAds;

        import java.util.ArrayList;
        import java.util.List;

        import worldcup.fifa2018.worldcupupdates.Adapter.SquadAdapter;
        import worldcup.fifa2018.worldcupupdates.Model.SquadModel;


public class Squad extends Fragment {

    List<SquadModel> squadModelListItems;
    RecyclerView recyclerView;
    private AdView mAdView;
    public Squad() {
        // Required empty public constructor
    }

    public static Squad newInstance(String param1, String param2) {
        Squad fragment = new Squad();
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
        View v = inflater.inflate(R.layout.fragment_squad, container, false);

        squadModelListItems = new ArrayList<>();

        MobileAds.initialize(getContext(), getString(R.string.admob_app_id));
        mAdView = v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_SQUAD);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        squadModelListItems.add(new SquadModel("Germany", R.drawable.germany,"GER"));
        squadModelListItems.add(new SquadModel("Brazil", R.drawable.brazil,"BRA"));
        squadModelListItems.add(new SquadModel("Belgium", R.drawable.belgium,"BEL"));
        squadModelListItems.add(new SquadModel("Portugal", R.drawable.portugal,"POR"));
        squadModelListItems.add(new SquadModel("Argentina", R.drawable.argentina,"ARG"));
        squadModelListItems.add(new SquadModel("Switzerland", R.drawable.switzerland,"SUI"));
        squadModelListItems.add(new SquadModel("France", R.drawable.france,"FRA"));
        squadModelListItems.add(new SquadModel("Spain", R.drawable.spain,"ESP"));
        squadModelListItems.add(new SquadModel("Poland", R.drawable.poland,"POL"));
        squadModelListItems.add(new SquadModel("Peru", R.drawable.peru,"PER"));
        squadModelListItems.add(new SquadModel("Denmark", R.drawable.denmark,"DEN"));
        squadModelListItems.add(new SquadModel("England", R.drawable.england,"ENG"));
        squadModelListItems.add(new SquadModel("Tunisia", R.drawable.tunisia,"TUN"));
        squadModelListItems.add(new SquadModel("Mexico", R.drawable.mexico,"MEX"));
        squadModelListItems.add(new SquadModel("Colombia", R.drawable.columbia,"COL"));
        squadModelListItems.add(new SquadModel("Uruguay", R.drawable.uruguay,"URU"));
        squadModelListItems.add(new SquadModel("Croatia", R.drawable.craotia,"CRO"));
        squadModelListItems.add(new SquadModel("Iceland", R.drawable.iceland,"ISL"));
        squadModelListItems.add(new SquadModel("Sweden", R.drawable.sweden,"SWE"));
        squadModelListItems.add(new SquadModel("Costa Rica", R.drawable.costarica,"CRC"));
        squadModelListItems.add(new SquadModel("Senegal", R.drawable.senagal,"SEN"));
        squadModelListItems.add(new SquadModel("Serbia", R.drawable.serbia,"SER"));
        squadModelListItems.add(new SquadModel("Iran", R.drawable.iran,"IRN"));
        squadModelListItems.add(new SquadModel("Australia", R.drawable.australia,"AUS"));
        squadModelListItems.add(new SquadModel("Morocco", R.drawable.morocco,"MAR"));
        squadModelListItems.add(new SquadModel("Egypt", R.drawable.egypt,"EGY"));
        squadModelListItems.add(new SquadModel("Nigeria", R.drawable.nigeria,"NGA"));
        squadModelListItems.add(new SquadModel("Panama", R.drawable.panama,"PAN"));
        squadModelListItems.add(new SquadModel("Japan", R.drawable.japan,"JPN"));
        squadModelListItems.add(new SquadModel("Korea Republic", R.drawable.korea,"KOR"));
        squadModelListItems.add(new SquadModel("Russia", R.drawable.russia,"RUS"));
        squadModelListItems.add(new SquadModel("Saudi Arabia", R.drawable.saudi,"KSA"));


        //creating recyclerview adapter
        SquadAdapter adapter = new SquadAdapter(getActivity(), squadModelListItems);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return v;
    }
}


