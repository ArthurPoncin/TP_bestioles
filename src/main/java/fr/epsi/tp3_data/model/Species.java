package fr.epsi.tp3_data.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "common_name", nullable = false)
    private String commonName;

    @Column(name = "latin_name", nullable = false)
    private String latinName;

    @OneToMany(mappedBy = "species")
    private List<Animal> animals;

    public Species() {
    }

    public Species(Long id, String commonName, String latinName, List<Animal> animals) {
        this.id = id;
        this.commonName = commonName;
        this.latinName = latinName;
        this.animals = animals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Species [id=" + id + ", commonName=" + commonName + ", latinName=" + latinName + "]";
    }
}
