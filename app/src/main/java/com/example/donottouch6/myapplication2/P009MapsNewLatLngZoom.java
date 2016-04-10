package com.example.donottouch6.myapplication2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class P009MapsNewLatLngZoom extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p009mapsnewlatlngzoom);

        SupportMapFragment supportMapFragment=new SupportMapFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayoutP009, supportMapFragment)
                .commit();

        supportMapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng=new LatLng(36.884331964690375,30.705478191375732);
        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.title("hello world");
        markerOptions.snippet("You never walk alone");
        markerOptions.position(latLng);

        googleMap.addMarker(markerOptions);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,18.0f));
        //(0,22) araliginda zoom degerleri verilebilir!
    }
}
