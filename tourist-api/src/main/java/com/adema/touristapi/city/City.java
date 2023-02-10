package com.adema.touristapi.city;

import com.adema.touristapi.attraction.Attraction;
import com.adema.touristapi.country.Country;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City implements Serializable {
    @Id
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )
    private Long id;
    private String name;
    @Column(unique = true)
    private String postcode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attraction> attractions;

    public City(Long id, String name, String postcode) {
        this.id = id;
        this.name = name;
        this.postcode = postcode;
    }

    public City(String name, String postcode) {
        this.name = name;
        this.postcode = postcode;
    }

    public City() {
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
