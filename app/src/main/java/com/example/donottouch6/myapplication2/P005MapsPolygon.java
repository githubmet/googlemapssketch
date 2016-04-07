package com.example.donottouch6.myapplication2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class P005MapsPolygon extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p005mapspolygon);

        SupportMapFragment supportMapFragment= (SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.supportMapFragmentP005);

        //Set a callback object which will be triggered when the GoogleMap instance is ready to be used
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng latLngOfA=new LatLng(52.395715,4.888916);
        LatLng latLngOfB=new LatLng(58.983991,5.734863);
        LatLng latLngOfC=new LatLng(51.508742,-0.120850);


        PolygonOptions polygonOptions=new PolygonOptions();
        polygonOptions.add(latLngOfA); //istersen buraya new anahtar kelimesi ilede tasiyabilirsin
        polygonOptions.add(latLngOfB);
        polygonOptions.add(latLngOfC);
        polygonOptions.strokeColor(Color.CYAN);
        polygonOptions.strokeWidth(2);
        polygonOptions.fillColor(Color.parseColor("#0000FF"));

        googleMap.addPolygon(polygonOptions);
    }
}
