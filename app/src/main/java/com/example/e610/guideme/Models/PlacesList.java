package com.example.e610.guideme.Models;

import com.google.api.client.util.Key;

import java.io.Serializable;
import java.util.List;

/**
 * Created by E610 on 25/11/2016.
 */
public class PlacesList implements Serializable {

    @Key
    public String status="";

    @Key
    public List<Place> results;

}
