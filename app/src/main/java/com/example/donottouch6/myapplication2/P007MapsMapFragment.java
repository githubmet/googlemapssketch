package com.example.donottouch6.myapplication2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class P007MapsMapFragment extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p007mapsmapfragment);

/*        MapFragment mapFragment=new MapFragment();  //but SupportMapFragment is the best
        getFragmentManager().beginTransaction()       //U MapFragment do not work earlier than api level 12
                .add(R.id.frameLayoutP007,mapFragment)
                .commit();
        mapFragment.getMapAsync(this);*/

        SupportMapFragment supportMapFragment=new SupportMapFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayoutP007,supportMapFragment)
                .commit();
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng=new LatLng(52.395715,4.888916);
        googleMap.addMarker(new MarkerOptions().title("Hello world").position(latLng));
        googleMap.setPadding(200,200,200,200);  //ekran degil google logoso ice dogru yaklasir
    }
}
