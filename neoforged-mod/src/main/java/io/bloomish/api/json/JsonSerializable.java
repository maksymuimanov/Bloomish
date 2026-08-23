package io.bloomish.api.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.bloomish.api.engine.context.ModContext;

import java.io.Serializable;

//TODO: needs to be reworked to because the dto shouldn't be aware how it is serialized :D
public interface JsonSerializable extends Serializable {
    default JsonElement toJson() {
        return ModContext.getObject(Gson.class)
                .toJsonTree(this);
    }
}
