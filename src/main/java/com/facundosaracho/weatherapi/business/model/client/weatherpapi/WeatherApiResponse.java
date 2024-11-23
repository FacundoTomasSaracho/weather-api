package com.facundosaracho.weatherapi.business.model.client.weatherpapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class WeatherApiResponse {

    @JsonProperty("location")
    private Location location;

    @JsonProperty("current")
    private Current current;

    // Getters and Setters
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    @Getter
    public static class Location {

        // Getters and Setters
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

        public void setName(String name) {
            this.name = name;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public void setTzId(String tzId) {
            this.tzId = tzId;
        }

        public void setLocaltimeEpoch(long localtimeEpoch) {
            this.localtimeEpoch = localtimeEpoch;
        }

        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }
    }

    @Getter
    public static class Current {

        // Getters and Setters
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

        public void setLastUpdatedEpoch(long lastUpdatedEpoch) {
            this.lastUpdatedEpoch = lastUpdatedEpoch;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public void setTempC(double tempC) {
            this.tempC = tempC;
        }

        public void setTempF(double tempF) {
            this.tempF = tempF;
        }

        public void setIsDay(int isDay) {
            this.isDay = isDay;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public void setWindMph(double windMph) {
            this.windMph = windMph;
        }

        public void setWindKph(double windKph) {
            this.windKph = windKph;
        }

        public void setWindDegree(int windDegree) {
            this.windDegree = windDegree;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public void setPressureMb(double pressureMb) {
            this.pressureMb = pressureMb;
        }

        public void setPressureIn(double pressureIn) {
            this.pressureIn = pressureIn;
        }

        public void setPrecipMm(double precipMm) {
            this.precipMm = precipMm;
        }

        public void setPrecipIn(double precipIn) {
            this.precipIn = precipIn;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public void setCloud(int cloud) {
            this.cloud = cloud;
        }

        public void setFeelslikeC(double feelslikeC) {
            this.feelslikeC = feelslikeC;
        }

        public void setFeelslikeF(double feelslikeF) {
            this.feelslikeF = feelslikeF;
        }

        public void setWindchillC(double windchillC) {
            this.windchillC = windchillC;
        }

        public void setWindchillF(double windchillF) {
            this.windchillF = windchillF;
        }

        public void setHeatindexC(double heatindexC) {
            this.heatindexC = heatindexC;
        }

        public void setHeatindexF(double heatindexF) {
            this.heatindexF = heatindexF;
        }

        public void setDewpointC(double dewpointC) {
            this.dewpointC = dewpointC;
        }

        public void setDewpointF(double dewpointF) {
            this.dewpointF = dewpointF;
        }

        public void setVisKm(double visKm) {
            this.visKm = visKm;
        }

        public void setVisMiles(double visMiles) {
            this.visMiles = visMiles;
        }

        public void setUv(double uv) {
            this.uv = uv;
        }

        public void setGustMph(double gustMph) {
            this.gustMph = gustMph;
        }

        public void setGustKph(double gustKph) {
            this.gustKph = gustKph;
        }
    }

    @Getter
    public static class Condition {

        // Getters and Setters
        @JsonProperty("text")
        private String text;

        @JsonProperty("icon")
        private String icon;

        @JsonProperty("code")
        private int code;

        public void setText(String text) {
            this.text = text;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
