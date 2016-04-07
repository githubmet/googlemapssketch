package com.example.donottouch6.myapplication2;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class P006MapsCircle extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p006mapscircle);

        SupportMapFragment supportMapFragment= (SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.supportMapFragmentP006);

        supportMapFragment.getMapAsync(this); //gelsin bakalim
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng latLngOfCenter=new LatLng(52.395715,4.888916);

        CircleOptions circleOptions=new CircleOptions();
        circleOptions.center(latLngOfCenter);
        circleOptions.radius(30000);
        circleOptions.strokeColor(Color.CYAN);
        circleOptions.strokeWidth(5);
        circleOptions.fillColor(Color.parseColor("#0000FF"));

        googleMap.addCircle(circleOptions);
    }
}
