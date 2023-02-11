package com.adema.touristapi.attraction;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "attractions")
@SQLDelete(sql="UPDATE attractions SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
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
    private boolean deleted = Boolean.FALSE;

    //treba dodati atribut prosjecna ocjena koji ce se izracunavati na osnovu podataka u bp
    //treba dodati i atribut aktivno/neaktivno DODANO

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Significance getSignificance() {
        return significance;
    }

    public void setSignificance(Significance significance) {
        this.significance = significance;
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
