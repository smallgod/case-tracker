package com.ura.casemgt.infrastructure.interfaces.web.json.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

public class JsonConverter {

    /**
     * Convert object to JSON
     *
     * @param objectToConvert
     * @param objectType
     * @param <T>
     * @return json string representation
     */
    public static <T> String convertToJson(T objectToConvert,
                                           Class<T> objectType) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new JodaGsonLocalDateConverter());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new JodaGsonLocalDateTimeConverter());
        gsonBuilder.registerTypeAdapter(LocalTime.class, new JodaGsonLocalTimeConverter());
        gsonBuilder.setPrettyPrinting();

        GraphAdapterBuilder graphAdapterBuilder = new GraphAdapterBuilder();
        graphAdapterBuilder.registerOn(gsonBuilder);

        Gson gson = gsonBuilder.create();
        return gson.toJson(objectToConvert, objectType);
    }

    /**
     * Convert json string representation to a json object
     *
     * @param stringToConvert
     * @param objectType
     * @param <T>
     * @return
     */
    public static <T> T convertFromJson(String stringToConvert,
                                        Class<T> objectType) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new JodaGsonLocalDateConverter());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new JodaGsonLocalDateTimeConverter());
        gsonBuilder.registerTypeAdapter(LocalTime.class, new JodaGsonLocalTimeConverter());
        gsonBuilder.setPrettyPrinting();

        GraphAdapterBuilder graphAdapterBuilder = new GraphAdapterBuilder();
        graphAdapterBuilder.registerOn(gsonBuilder);

        Gson gson = gsonBuilder.create();
        return gson.fromJson(stringToConvert.trim(), objectType);
    }
}