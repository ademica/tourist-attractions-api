package com.adema.touristapi.model;

import com.adema.touristapi.enumeration.Significance;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Name can not be empty")
    private String name;
    @NotEmpty(message = "Country can not be empty")
    private String country;
    @NotEmpty(message = "City can not be empty")
    private String city;
    private String description;
    @NotEmpty(message = "Latitude can not be empty")
    private String lat;
    @NotEmpty(message = "Longitude can not be empty")
    private String lon;
    private Significance significance;
    private boolean deleted = Boolean.FALSE;

    //treba dodati atribut prosjecna ocjena koji ce se izracunavati na osnovu podataka u bp
    //treba dodati i atribut aktivno/neaktivno DODANO
    //update konstruktor za significance

    public Attraction() {
    }

    public Attraction(String name, String country, String city, String description, String lat, String lon) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
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
