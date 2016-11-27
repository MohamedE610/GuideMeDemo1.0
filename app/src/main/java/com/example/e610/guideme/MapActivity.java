package com.example.e610.guideme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.e610.guideme.Models.Place;
import com.example.e610.guideme.Models.PlacesList;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by E610 on 26/11/2016.
 */
public class MapActivity extends Activity implements OnMapReadyCallback {

    private Intent intent;
    private PlacesList nearestPlaces;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        nearestPlaces=new PlacesList();
        intent=getIntent();

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {

            //LatLng sydney = new LatLng(-33.867, 151.206);
            LatLng myLocation = new LatLng(Double.valueOf(intent.getStringExtra("user_latitude")) ,Double.valueOf(intent.getStringExtra("user_longitude")) );

          //  map.setMyLocationEnabled(true);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 13));

            map.addMarker(new MarkerOptions()
                    .title("^_^")
                    .snippet("your location")
                    .position(myLocation)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));


       // map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        nearestPlaces =(PlacesList) intent.getSerializableExtra("near_places");
        for(Place place : nearestPlaces.results){

            LatLng newLocation = new LatLng(place.geometry.location.lat , place.geometry.location.lng );

//            map.moveCamera(CameraUpdateFactory.newLatLngZoom(newLocation, 13));

            map.addMarker(new MarkerOptions()
                    .title(place.name)
                    .snippet(place.formatted_phone_number)
                    .position(newLocation))
                    .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        }

    }

}


