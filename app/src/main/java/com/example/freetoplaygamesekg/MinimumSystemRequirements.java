package com.example.freetoplaygamesekg;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinimumSystemRequirements {
    @SerializedName("os")
    private String os;
    @SerializedName("processor")
    private String processor;
    @SerializedName("memory")
    private String memory;
    @SerializedName("graphics")
    private String graphics;
    @SerializedName("storage")
    private String storage;
}
