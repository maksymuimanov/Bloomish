package io.bloomish.api.json;

import com.google.gson.JsonElement;

import java.io.Serializable;

public interface JsonModel extends Serializable {
    JsonElement toJson();
}
