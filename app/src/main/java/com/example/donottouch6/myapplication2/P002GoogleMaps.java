package com.example.donottouch6.myapplication2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class P002GoogleMaps extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p002googlemaps);

        SupportMapFragment supportMapFragment=(SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.supportMapFragmentP002);
        supportMapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLngOfSydney = new LatLng(-34, 151);  //lattitude=enlem; longitude=boylam
        googleMap.addMarker(new MarkerOptions().title("Sydney City")
                .snippet("Sydney is a beatiful city").position(latLngOfSydney));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLngOfSydney));

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); //.MAP_TYPE_HYBRID; .MAP_TYPE_SATELLITE
    }
}
