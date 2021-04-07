package com.sample.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mTextView;
    Button mButton; //commit message : added button
    LocationManager locMgr;
    List<String> locProviders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        locMgr = (LocationManager) getSystemService(LOCATION_SERVICE);
        locProviders = locMgr.getAllProviders();

        String s = "";

        int [] array = new int [locProviders.size()];
            for(int result : array) {
                s += "Loc.Provider: " + locProviders.get(result) + "\n"
                        + "Status: " + locMgr.isProviderEnabled(locProviders.get(result)) + "\n\n";
            }

        mTextView.setText(s);

    }
}