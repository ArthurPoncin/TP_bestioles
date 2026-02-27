package fr.epsi.tp3_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.epsi.tp3_data.model.Animal;
import fr.epsi.tp3_data.model.Species;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findBySpecies(Species species);

    List<Animal> findByColorIn(List<String> colors);

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
    long countBySex(@Param("sex") String sex);

    @Query("SELECT (COUNT(a.owners) > 0) FROM Animal a WHERE a = :animal")
    boolean isAnimalOwned(@Param("animal") Animal animal);
}
