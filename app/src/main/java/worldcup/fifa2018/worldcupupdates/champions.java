package worldcup.fifa2018.worldcupupdates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class champions extends AppCompatActivity {

    private CardView worldchampions, goldenboot;
    private TextView champ, boo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions);
        worldchampions = (CardView) findViewById(R.id.worldchampion);
        goldenboot = (CardView) findViewById(R.id.goldenboot);
        champ = (TextView) findViewById(R.id.champion);
        boo = (TextView) findViewById(R.id.boot);
    }

    public void world(View v) {
        worldchampions.setVisibility(View.VISIBLE);
        goldenboot.setVisibility(View.GONE);
        boo.setBackgroundColor(getResources().getColor(R.color.light));
        champ.setBackgroundColor(getResources().getColor(R.color.dark));
    }

    public void golden(View v) {
        worldchampions.setVisibility(View.GONE);
        goldenboot.setVisibility(View.VISIBLE);
        champ.setBackgroundColor(getResources().getColor(R.color.light));
        boo.setBackgroundColor(getResources().getColor(R.color.dark));
    }
}