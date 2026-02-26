package fr.epsi.tp3_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epsi.tp3_data.model.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

}
