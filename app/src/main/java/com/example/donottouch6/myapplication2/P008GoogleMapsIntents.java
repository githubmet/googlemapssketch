package com.example.donottouch6.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class P008GoogleMapsIntents extends AppCompatActivity implements View.OnClickListener {
    EditText editTextSearchP008;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p008googlemapsintents);

        findViewById(R.id.buttonP008).setOnClickListener(this);
        findViewById(R.id.button2P008).setOnClickListener(this);
        findViewById(R.id.button3P008).setOnClickListener(this);
        findViewById(R.id.button4P008).setOnClickListener(this);
        findViewById(R.id.button5P008).setOnClickListener(this);
        findViewById(R.id.button6P008).setOnClickListener(this);
        findViewById(R.id.button7P008).setOnClickListener(this);
        findViewById(R.id.button8P008).setOnClickListener(this);
        editTextSearchP008=(EditText)findViewById(R.id.editTextSearchP008);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonP008:
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");
                // Attempt to start an activity that can handle the Intent

                if (mapIntent.resolveActivity(getPackageManager()) != null) { //yani bu intent i karsilayacak birisi var ise iceri gir
                    startActivity(mapIntent);
                }
                break;
            case R.id.button2P008:
                Uri uri = Uri.parse("geo:37.7749,-122.4194");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");

                //why resolveActivity BeU every Activity had checked before launched
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                break;
            case R.id.button3P008:
                Uri uriEncode= Uri.parse("geo:37.7749,-122.4192?q=" +
                        Uri.encode("1st & Pike, Seattle"));
                //"geo:37.7749,-122.4192?q=1st%20&%20Pike,%20Seattle"
                //"geo:37.7749,-122.4192?q=1st+&+Pike,+Seattle" //so must be encode
                Intent intentEncode=new Intent(Intent.ACTION_VIEW,uriEncode);
                intentEncode.setPackage("com.google.android.apps.maps");

                if(intentEncode.resolveActivity(getPackageManager())!=null){
                    startActivity(intentEncode);
                }
                break;

            case R.id.button4P008:
                Uri uriZoom= Uri.parse("geo:37.7749,-122.4194?z=21");  //?z=zoom level.
                Intent intentOfZoom=new Intent(Intent.ACTION_VIEW,uriZoom);
                intentOfZoom.setPackage("com.google.android.apps.maps");

                if(intentOfZoom.resolveActivity(getPackageManager())!=null) {
                    startActivity(intentOfZoom);
                }

                break;
            case R.id.button5P008:

                //Uri uriOfSearch= Uri.parse("geo:0,0?q=City+Hall,New+York,NY");
                String encode= Uri.encode(editTextSearchP008.getText().toString());

                Uri uriOfSearch= Uri.parse("geo:0,0?q=" + encode);
                Intent intentOfSearch= new Intent(Intent.ACTION_VIEW,uriOfSearch);
                intentOfSearch.setPackage("com.google.android.apps.maps");

                if(intentOfSearch.resolveActivity(getPackageManager())!=null){
                    startActivity(intentOfSearch);
                }
                break;
            case R.id.button6P008:
                Uri uriOfNearby= Uri.parse("geo:0,0?z=10&q=restaurants");
                Intent intentOfNearby=new Intent(Intent.ACTION_VIEW,uriOfNearby);
                intentOfNearby.setPackage("com.google.android.apps.maps");

                if(intentOfNearby.resolveActivity(getPackageManager())!=null){
                    startActivity(intentOfNearby);
                }
                break;
            case R.id.button7P008:
                Uri uriOfNavigation= Uri.parse("google.navigation:q=Taronga+Zoo,+Sydney+Australia");
                Intent intentOfNavigation=new Intent(Intent.ACTION_VIEW,uriOfNavigation);
                intentOfNavigation.setPackage("com.google.android.apps.maps");

                if(intentOfNavigation.resolveActivity(getPackageManager())!=null){
                    startActivity(intentOfNavigation);
                }
                break;
            case R.id.button8P008:
                Uri uriOfStreetView = Uri.parse("google.streetview:panoid=Iaa2JyfIggYAAAQfCZU9KQ");
                Intent intentOfStreetView= new Intent(Intent.ACTION_VIEW, uriOfStreetView);
                intentOfStreetView.setPackage("com.google.android.apps.maps");

                if(intentOfStreetView.resolveActivity(getPackageManager())!=null) {
                    startActivity(intentOfStreetView);
                }
        }
    }
}
