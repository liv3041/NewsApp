package com.example.newz;

import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

public class Source {
/*    @SerializableName() -
    it is used to help in serialization/deserialization of JSON data
     into java objects

      We are not setting the setter methods in our response in
      Transfer Objects. Since we are not going to use this value**/
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
