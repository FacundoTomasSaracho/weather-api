package com.facundosaracho.weatherapi.business.model.client.weatherpapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherApiResponse {

    @JsonProperty("location")
    private Location location;

    @JsonProperty("current")
    private Current current;

    @Getter
    @Setter
    public static class Location {

        @JsonProperty("name")
        private String name;

        @JsonProperty("region")
        private String region;

        @JsonProperty("country")
        private String country;

        @JsonProperty("lat")
        private double lat;

        @JsonProperty("lon")
        private double lon;

        @JsonProperty("tz_id")
        private String tzId;

        @JsonProperty("localtime_epoch")
        private long localtimeEpoch;

        @JsonProperty("localtime")
        private String localtime;
    }


    @Getter
    @Setter
    public static class Current {

        @JsonProperty("last_updated_epoch")
        private long lastUpdatedEpoch;

        @JsonProperty("last_updated")
        private String lastUpdated;

        @JsonProperty("temp_c")
        private double tempC;

        @JsonProperty("temp_f")
        private double tempF;

        @JsonProperty("is_day")
        private int isDay;

        @JsonProperty("condition")
        private Condition condition;

        @JsonProperty("wind_mph")
        private double windMph;

        @JsonProperty("wind_kph")
        private double windKph;

        @JsonProperty("wind_degree")
        private int windDegree;

        @JsonProperty("wind_dir")
        private String windDir;

        @JsonProperty("pressure_mb")
        private double pressureMb;

        @JsonProperty("pressure_in")
        private double pressureIn;

        @JsonProperty("precip_mm")
        private double precipMm;

        @JsonProperty("precip_in")
        private double precipIn;

        @JsonProperty("humidity")
        private int humidity;

        @JsonProperty("cloud")
        private int cloud;

        @JsonProperty("feelslike_c")
        private double feelslikeC;

        @JsonProperty("feelslike_f")
        private double feelslikeF;

        @JsonProperty("windchill_c")
        private double windchillC;

        @JsonProperty("windchill_f")
        private double windchillF;

        @JsonProperty("heatindex_c")
        private double heatindexC;

        @JsonProperty("heatindex_f")
        private double heatindexF;

        @JsonProperty("dewpoint_c")
        private double dewpointC;

        @JsonProperty("dewpoint_f")
        private double dewpointF;

        @JsonProperty("vis_km")
        private double visKm;

        @JsonProperty("vis_miles")
        private double visMiles;

        @JsonProperty("uv")
        private double uv;

        @JsonProperty("gust_mph")
        private double gustMph;

        @JsonProperty("gust_kph")
        private double gustKph;

    }

    @Getter
    @Setter
    public static class Condition {

        @JsonProperty("text")
        private String text;

        @JsonProperty("icon")
        private String icon;

        @JsonProperty("code")
        private int code;

    }
}
