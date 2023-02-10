package com.adema.touristapi.attraction;

import jakarta.persistence.*;

@Entity
@Table(name = "attractions")
public class Attraction {
    @Id
    @SequenceGenerator(
            name = "attraction_sequence",
            sequenceName = "attraction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "attraction_sequence"
    )
    private Long id;
    private String name;
    private String country;
    private String city;
    private String description;
    private String lat;
    private String lon;
    @Enumerated(EnumType.STRING)
    private Significance significance;

    public enum Significance {
        SIGNIFICANT, VERY_SIGNIFICANT, INEVITABLE
    }

    public Attraction(Long id, String name, String country, String city, String description, String lat, String lon, Significance significance) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
        this.significance = significance;
    }

    public Attraction(String name, String country, String city, String description, String lat, String lon, Significance significance) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
        this.significance = significance;
    }

    public Attraction() {
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", significance=" + significance +
                '}';
    }
}
