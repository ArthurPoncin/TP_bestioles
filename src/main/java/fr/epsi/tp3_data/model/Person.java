package fr.epsi.tp3_data.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    @Column(name = "age")
    private Integer age;

    @Column(name = "active", nullable = false)
    private int active;

    @ManyToMany
    @JoinTable(name = "person_animals", joinColumns = @jakarta.persistence.JoinColumn(name = "person_id"), inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "animals_id"))
    private List<Animal> animals;

    @ManyToMany
    @JoinTable(name = "person_role", joinColumns = @jakarta.persistence.JoinColumn(name = "person_id"), inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "role_id"))
    private List<Role> roles;

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, String login, String mdp, Integer age, int active,
            List<Animal> animals, List<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.mdp = mdp;
        this.age = age;
        this.active = active;
        this.animals = animals;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
