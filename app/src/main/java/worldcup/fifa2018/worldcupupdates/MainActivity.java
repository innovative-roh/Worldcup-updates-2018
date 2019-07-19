package worldcup.fifa2018.worldcupupdates;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;
    Fragment fragment;
    private InterstitialAd mInterstitialAd;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        toolbar = getSupportActionBar();


      //  MobileAds.initialize(this, "ca-app-pub-3502645265336252~3169215369");

        //MobileAds.initialize(this, getString(R.string.admob_app_id));

       // mInterstitialAd = new InterstitialAd(this);
       // mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        AdRequest adRequest = new AdRequest.Builder().build();
       // mInterstitialAd.loadAd(adRequest);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());
        toolbar.setTitle("World Cup Updates");
        fragment=new Home();
        loadFragment(fragment);

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_calendar:
              //   mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    toolbar.setTitle("Calendar");
                    fragment=new Calendar();
                    loadFragment(fragment);
                 /*   if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        count=0;
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }*/
                    return true;

                case R.id.navigation_score:
                 //   mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    toolbar.setTitle("Score");
                    fragment=new ScoreBoard();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_squad:
                   // mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    toolbar.setTitle("Squad");
                    fragment=new Squad();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_home:
                   // mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    toolbar.setTitle("World Cup Updates");
                    fragment=new Home();
                    loadFragment(fragment);

                    return true;


            }
            return false;
        }
    };


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit?")
                .setMessage(R.string.rating)
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                })
                .setPositiveButton("Sure",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface arg0, int arg1) {

                                Intent rateus = new Intent(Intent.ACTION_VIEW);
                                rateus.setData(Uri.parse("https://play.google.com/store/apps/details?id=worldcup.fifa2018.worldcupupdates"));
                                startActivity(rateus);
                            }
                        })
                .setNeutralButton("Cancel",null).create().show();
    }

}