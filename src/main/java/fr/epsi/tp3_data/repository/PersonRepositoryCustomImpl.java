package fr.epsi.tp3_data.repository;

import fr.epsi.tp3_data.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void deletePersonWithoutAnimals() {
        String query = "DELETE FROM Person p WHERE p.animals IS EMPTY";
        em.createQuery(query)
                .executeUpdate();
    }

    @Transactional
    public void generateRandomPersons(Integer count) {
        for (int i = 0; i < count; i++) {
            Person person = new Person();
            person.setFirstName("FirstName" + i);
            person.setLastName("LastName" + i);
            person.setLogin("user" + i + "_" + System.currentTimeMillis());
            person.setMdp("password" + i);
            person.setAge(20 + i);
            person.setActive(1);
            em.persist(person);
        }
    }

}
