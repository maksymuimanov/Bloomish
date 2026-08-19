package io.bloomish.api.json;

import com.google.gson.JsonElement;

import java.io.Serializable;

public interface JsonSerializable extends Serializable {
    JsonElement toJson();
}
