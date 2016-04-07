package com.example.donottouch6.myapplication2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class P003MapsMarkerOptions extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p003mapsmarkeroptions);

        SupportMapFragment supportMapFragment= (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.supportMapFragmentP003);
        supportMapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.title("Tittle AAA");
        markerOptions.snippet("This is first corner of Triangle");

        LatLng latLngPosition=new LatLng(52.395715,4.888916);
        markerOptions.position(latLngPosition);

        googleMap.addMarker(markerOptions);  //very easy add marker :)

    }
}
