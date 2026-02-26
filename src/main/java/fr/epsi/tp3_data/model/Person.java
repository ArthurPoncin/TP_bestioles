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
}
