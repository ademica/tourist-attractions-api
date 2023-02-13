package com.adema.touristapi.repo;

import com.adema.touristapi.enumeration.Significance;
import com.adema.touristapi.model.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    Optional<Attraction> findAttractionByName(String name);
    List<Attraction> findAttractionsBySignificance(Significance significance);
    Attraction findAttractionById(Long id);
}
