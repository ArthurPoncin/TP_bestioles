package fr.epsi.tp3_data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epsi.tp3_data.model.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
    public Optional<Species> findFirstByCommonName(String commonName);

    public List<Species> findByLatinName(String latinName);

}
