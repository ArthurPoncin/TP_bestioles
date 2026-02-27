package fr.epsi.tp3_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epsi.tp3_data.model.Animal;
import fr.epsi.tp3_data.model.Species;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findBySpecies(Species species);

    List<Animal> findByColorIn(List<String> colors);
}
