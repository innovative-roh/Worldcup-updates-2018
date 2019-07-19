package worldcup.fifa2018.worldcupupdates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TeamDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String team= i.getStringExtra("TEAM");

        switch (team){
            case "GER":
                setContentView(R.layout.activity_germany1);
                break;
            case "BRA":
                setContentView(R.layout.activity_brazil);
                break;
            case "BEL":
                setContentView(R.layout.activity_belgium1);
                break;
            case "POR":
                setContentView(R.layout.activity_portugal);
                break;
            case "ARG":
                setContentView(R.layout.activity_argentina);
                break;
            case "SUI":
                setContentView(R.layout.activity_switzerland);
                break;
            case "FRA":
                setContentView(R.layout.activity_france);
                break;
            case "ESP":
                setContentView(R.layout.activity_spain);
                break;
            case "POL":
                setContentView(R.layout.activity_poland);
                break;
            case "PER":
                setContentView(R.layout.activity_peru);
                break;
            case "DEN":
                setContentView(R.layout.activity_denmark);
                break;
            case "ENG":
                setContentView(R.layout.activity_england);
                break;
            case "TUN":
                setContentView(R.layout.activity_tunisia);
                break;
            case "MEX":
                setContentView(R.layout.activity_mexico);
                break;
            case "COL":
                setContentView(R.layout.activity_colombia);
                break;
            case "URU":
                setContentView(R.layout.activity_uruguay);
                break;
            case "CRO":
                setContentView(R.layout.activity_croatia);
                break;
            case "ISL":
                setContentView(R.layout.activity_iceland);
                break;
            case "SWE":
                setContentView(R.layout.activity_sweden);
                break;
            case "CRC":
                setContentView(R.layout.activity_costarica);
                break;
            case "SEN":
                setContentView(R.layout.activity_senegal);
                break;
            case "SER":
                setContentView(R.layout.activity_serbia);
                break;
            case "IRN":
                setContentView(R.layout.activity_iran);
                break;
            case "AUS":
                setContentView(R.layout.activity_australia);
                break;
            case "MAR":
                setContentView(R.layout.activity_morocco);
                break;
            case "EGY":
                setContentView(R.layout.activity_egypt);
                break;
            case "NGA":
                setContentView(R.layout.activity_nigeria);
                break;
            case "JPN":
                setContentView(R.layout.activity_japan);
                break;
            case "KOR":
                setContentView(R.layout.activity_southkorea);
                break;
            case "RUS":
                setContentView(R.layout.activity_russia);
                break;
            case "KSA":
                setContentView(R.layout.activity_saudiarabia);
                break;

            case "PAN":
                setContentView(R.layout.activity_panama);
                break;
            default:
                setContentView(R.layout.activity_brazil);
                break;

        }
    }
}
