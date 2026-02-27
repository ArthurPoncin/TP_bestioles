package fr.epsi.tp3_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epsi.tp3_data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByLastNameOrFirstName(String lastName, String firstName);

    List<Person> findByAgeGreaterThanEqual(Integer age);
}
