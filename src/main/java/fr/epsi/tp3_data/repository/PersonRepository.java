package fr.epsi.tp3_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.epsi.tp3_data.model.Animal;
import fr.epsi.tp3_data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {
    List<Person> findByLastNameOrFirstName(String lastName, String firstName);

    List<Person> findByAgeGreaterThanEqual(Integer age);

    @Query("Select p FROM Person p WHERE p.age BETWEEN :minAge AND :maxAge")
    List<Person> findByAgeBetween(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

    @Query("Select p FROM Person p WHERE :animal MEMBER OF p.animals")
    List<Person> findByAnimal(@Param("animal") Animal animal);
}
