package com.adema.touristapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @SequenceGenerator(
            name = "image_sequence",
            sequenceName = "image_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "image_sequence"
    )
    public Long id;
    public String name;
    public String path;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="attraction_id", nullable = false)
    private Attraction attraction;
}
