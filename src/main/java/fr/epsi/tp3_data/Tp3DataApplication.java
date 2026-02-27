package fr.epsi.tp3_data;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.epsi.tp3_data.model.Animal;
import fr.epsi.tp3_data.model.Person;
import fr.epsi.tp3_data.model.Role;
import fr.epsi.tp3_data.model.Species;
import fr.epsi.tp3_data.repository.AnimalRepository;
import fr.epsi.tp3_data.repository.PersonRepository;
import fr.epsi.tp3_data.repository.RoleRepository;
import fr.epsi.tp3_data.repository.SpeciesRepository;

@SpringBootApplication
public class Tp3DataApplication implements CommandLineRunner {

	private final AnimalRepository animalRepository;
	private final SpeciesRepository speciesRepository;
	private final PersonRepository personRepository;
	private final RoleRepository roleRepository;

	public Tp3DataApplication(AnimalRepository animalRepository, SpeciesRepository speciesRepository,
			PersonRepository personRepository, RoleRepository roleRepository) {
		this.animalRepository = animalRepository;
		this.speciesRepository = speciesRepository;
		this.personRepository = personRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==== Début des tests ====");

		List<Animal> animals = animalRepository.findAll();
		List<Person> persons = personRepository.findAll();
		List<Role> roles = roleRepository.findAll();
		List<Species> species = speciesRepository.findAll();
		System.out.println("[findAll] Animaux trouvés : " + animals.size());
		System.out.println("[findAll] Personnes trouvées : " + persons.size());
		System.out.println("[findAll] Rôles trouvés : " + roles.size());
		System.out.println("[findAll] Espèces trouvées : " + species.size());

		Animal firstAnimal = animalRepository.findById(1L).orElse(null);
		System.out.println("[findById] nom: " + firstAnimal.getName() + " couleur: " + firstAnimal.getColor()
				+ " sexe: " + firstAnimal.getSex() + " appartient à l'espèce "
				+ firstAnimal.getSpecies().getCommonName());

		Person firstPerson = personRepository.findById(1L).orElse(null);
		Animal newAnimal = new Animal(null, "Rex", "Marron", "Mâle", List.of(firstPerson), species.get(0));
		animalRepository.save(newAnimal);
		System.out.println("[save] Nouvel animal enregistré : " + newAnimal);
		animalRepository.deleteById(newAnimal.getId());
		System.out.println("[delete] Animal supprimé ID: " + newAnimal.getId());
		System.out.println("[findAll] Animaux trouvés : " + animalRepository.count());

		List<Animal> animalsBySpecies = animalRepository.findBySpecies(species.get(0));
		System.out.println("[findBySpecies] Animaux de l'espèce " + species.get(0).getCommonName() + " : "
				+ animalsBySpecies.size());
	}

	public static void main(String[] args) {
		SpringApplication.run(Tp3DataApplication.class, args);
	}

}
