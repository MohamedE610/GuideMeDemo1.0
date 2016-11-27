package com.example.e610.guideme.Models;

import com.google.api.client.util.Key;

import java.io.Serializable;

/**
 * Created by E610 on 25/11/2016.
 */
public class PlaceDetails implements Serializable {

    @Key
    public String status;

    @Key
    public Place result;

    @Override
    public String toString() {
        if (result != null) {
            return result.toString();
        }
        return super.toString();
    }
}