package com.example.freetoplaygamesekg;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Screenshot {
    @SerializedName("id")
    private int id;
    @SerializedName("image")
    private String image;
}
