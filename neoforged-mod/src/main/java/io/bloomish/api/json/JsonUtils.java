package io.bloomish.api.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public final class JsonUtils {
    private JsonUtils() {
    }

    public static void addPropertyIfNotNull(JsonObject jsonObject, String key, Character value) {
        if (value != null) jsonObject.addProperty(key, value);
    }

    public static void addPropertyIfNotNull(JsonObject jsonObject, String key, String value) {
        if (value != null) jsonObject.addProperty(key, value);
    }

    public static void addPropertyIfNotNull(JsonObject jsonObject, String key, Number value) {
        if (value != null) jsonObject.addProperty(key, value);
    }

    public static void addPropertyIfNotNull(JsonObject jsonObject, String key, Boolean value) {
        if (value != null) jsonObject.addProperty(key, value);
    }

    public static JsonElement convertResourceLocationList(List<ResourceLocation> resourceLocations) {
        return buildJsonArray(
                jsonArray -> resourceLocations.forEach(
                        resourceLocation -> jsonArray.add(resourceLocation.toString())
                )
        );
    }

    public static JsonElement convertStringList(List<String> strings) {
        return buildJsonArray(
                jsonArray -> strings.forEach(jsonArray::add)
        );
    }

    public static JsonElement convertJsonSerializableList(List<? extends JsonSerializable> jsonSerializables) {
        return buildJsonArray(
                jsonArray -> jsonSerializables.forEach(
                        jsonSerializable -> jsonArray.add(jsonSerializable.toJson())
                )
        );
    }

    public static JsonElement convertMap(Map<String, String> data) {
        return buildJson(
                jsonObject -> data.forEach(jsonObject::addProperty)
        );
    }

    public static JsonElement buildJson(Consumer<JsonObject> jsonConsumer) {
        JsonObject jsonObject = new JsonObject();
        jsonConsumer.accept(jsonObject);
        return jsonObject;
    }


    public static JsonElement buildJsonArray(Consumer<JsonArray> jsonArrayConsumer) {
        JsonArray jsonArray = new JsonArray();
        jsonArrayConsumer.accept(jsonArray);
        return jsonArray;
    }
}