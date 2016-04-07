package com.example.donottouch6.myapplication2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class P004MapsPolylineOptions  extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p004mapspolylineoptions);

        SupportMapFragment supportMapFragmentP004=(SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.supportMapFragmentP004);

        supportMapFragmentP004.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng latLngCornerOfA=new LatLng(52.395715,4.888916);
        MarkerOptions markerOptionsOfA=new MarkerOptions();
        markerOptionsOfA.title("Corner Of A");
        markerOptionsOfA.position(latLngCornerOfA);

        LatLng latLngCornerOfB=new LatLng(58.983991,5.734863);
        MarkerOptions markerOptionsOfB=new MarkerOptions();
        markerOptionsOfB.title("Corner Of B");
        markerOptionsOfB.position(latLngCornerOfB);

        LatLng latLngCornerOfC=new LatLng(51.508742,-0.120850);
        MarkerOptions markerOptionsOfC=new MarkerOptions();
        markerOptionsOfC.title("Corner Of C");
        markerOptionsOfC.position(latLngCornerOfC);

        PolylineOptions polylineOptions=new PolylineOptions();
        polylineOptions.add(latLngCornerOfA);
        polylineOptions.add(latLngCornerOfB);
        polylineOptions.add(latLngCornerOfC);
        polylineOptions.color(Color.parseColor("#FFBB00"));

        googleMap.addPolyline(polylineOptions);
    }
}
