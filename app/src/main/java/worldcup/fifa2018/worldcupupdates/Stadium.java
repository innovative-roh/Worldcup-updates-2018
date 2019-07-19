package worldcup.fifa2018.worldcupupdates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import worldcup.fifa2018.worldcupupdates.Adapter.StadiumAdapter;
import worldcup.fifa2018.worldcupupdates.Model.SadiumModel;
import worldcup.fifa2018.worldcupupdates.Model.SquadModel;

public class Stadium extends AppCompatActivity {

    List<SadiumModel> squadModelList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);
        squadModelList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_stadium);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        StadiumAdapter adapter = new StadiumAdapter(this, squadModelList);
        recyclerView.setAdapter(adapter);

        squadModelList.add(new SadiumModel("Luzhniki Stadium | Capacity: 80,000 seats | Opening: 1956", "http://studoob.in/WC/stadium/luzhniki_moscow.jpg"));
        squadModelList.add(new SadiumModel("Saint Petersburg Stadium | Capacity: 67,000 seats | Opening: 2017", "http://studoob.in/WC/stadium/stpetersburg.jpg"));
        squadModelList.add(new SadiumModel("Fisht Stadium | Capacity: 48,000 seats | Opening: 2013", "http://studoob.in/WC/stadium/fisht_sochi.jpg"));
        squadModelList.add(new SadiumModel("Ekaterinburg Arena | Capacity: 45,000 seats | Opening: 1957", "http://studoob.in/WC/stadium/ekaterinburgarena.jpg"));
        squadModelList.add(new SadiumModel("Kazan Arena | Capacity: 45,000 seats | Opening: 2013", "http://studoob.in/WC/stadium/kazan.jpg"));
        squadModelList.add(new SadiumModel("Nizhny Novgorod Stadium | Capacity: 45,000 seats | Opening: 2018", "http://studoob.in/WC/stadium/nizhny.jpg"));
        squadModelList.add(new SadiumModel("Samara Arena | Capacity: 45,000 seats | Opening: 2018", "http://studoob.in/WC/stadium/samara.jpg"));
        squadModelList.add(new SadiumModel("Rostov Arena | Capacity: 45,000 seats | Opening: 2018", "http://studoob.in/WC/stadium/rostov.jpg"));
        squadModelList.add(new SadiumModel("Mordovia Arena | Capacity: 45,000 seats | Opening: 2018", "http://studoob.in/WC/stadium/saransk.jpg"));
        squadModelList.add(new SadiumModel("Volgograd Stadium | Capacity: 45,000 seats | Opening: 2018", "http://studoob.in/WC/stadium/volgogradstadium.jpg"));
        squadModelList.add(new SadiumModel("Spartak Stadium | Capacity: 42,000 seats | Opening: 2014", "http://studoob.in/WC/stadium/spartakmoscow.jpg"));
        squadModelList.add(new SadiumModel("Kaliningrad Stadium | Capacity: 35,212 seats | Opening: 2018", "http://studoob.in/WC/stadium/kaliningrad.jpg"));
        adapter.notifyDataSetChanged();
    }
}
