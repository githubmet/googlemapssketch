package com.example.donottouch6.myapplication2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class P010MapsUiSettings extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p010mapsuisettings);

        SupportMapFragment supportMapFragment=new SupportMapFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayoutP010,supportMapFragment)
                .commit();
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng latLng=new LatLng(36.884331964690375,30.705478191375732);
        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.title("Hello World");
        markerOptions.snippet("I can not sleeep anymore");
        markerOptions.position(latLng);

        googleMap.addMarker(markerOptions);

        UiSettings uiSettings=googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setMapToolbarEnabled(false);

    }
}
