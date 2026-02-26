package fr.epsi.tp3_data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epsi.tp3_data.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
