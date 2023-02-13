package com.adema.touristapi.model;

import com.adema.touristapi.model.Attraction;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @SequenceGenerator(
            name = "rate_sequence",
            sequenceName = "rate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rate_sequence"
    )
    private Long id;
    @Min(value=1)
    @Max(value=5)
    private Integer rate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="attraction_id", nullable = false)
    private Attraction attraction;

    public Rate(Long id, Integer rate, Attraction attraction) {
        this.id = id;
        this.rate = rate;
        this.attraction = attraction;
    }

    public Rate(Integer rate, Attraction attraction) {
        this.rate = rate;
        this.attraction = attraction;
    }

    public Rate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", rate=" + rate +
                ", attraction=" + attraction +
                '}';
    }
}
