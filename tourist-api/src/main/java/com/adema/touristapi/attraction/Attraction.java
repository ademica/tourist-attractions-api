package com.adema.touristapi.attraction;

import com.adema.touristapi.city.City;
import com.adema.touristapi.country.Country;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "attractions")
public class Attraction implements Serializable {
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
    private String description;
    private String lat;
    private String lon;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public Attraction(Long id, String name, String description, String lat, String lon) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
    }

    public Attraction() {
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
