package fr.epsi.tp3_data.repository;

public interface PersonRepositoryCustom {

    void deletePersonWithoutAnimals();

    void generateRandomPersons(Integer count);
}
