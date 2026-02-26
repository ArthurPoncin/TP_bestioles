-- Nettoyage des tables si elles existent (ordre respectant les clés étrangères)
DROP TABLE IF EXISTS person_role;
DROP TABLE IF EXISTS person_animals;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS animal;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS species;

-- Structure de la table species
CREATE TABLE species (
  id BIGSERIAL PRIMARY KEY,
  common_name VARCHAR(50) NOT NULL,
  latin_name VARCHAR(200) NOT NULL
);

-- Données pour species
INSERT INTO species (id, common_name, latin_name) VALUES
  (1, 'Chat', 'Felis silvestris catus'),
  (2, 'Chien', 'Canis lupus familiaris'),
  (3, 'Lapin', 'Oryctolagus cuniculus');

-- Structure de la table animal
CREATE TABLE animal (
  id BIGSERIAL PRIMARY KEY,
  color VARCHAR(50) DEFAULT NULL,
  name VARCHAR(50) NOT NULL,
  sex VARCHAR(255) NOT NULL,
  species_id BIGINT NOT NULL, -- Changé en BIGINT pour correspondre à species(id)
  CONSTRAINT FK_animal_species FOREIGN KEY (species_id) REFERENCES species (id)
);

-- Données pour animal
INSERT INTO animal (id, color, name, sex, species_id) VALUES
  (1, 'Gris tacheté', 'Max', 'M', 1),
  (2, 'Blanc', 'Médor', 'M', 2),
  (3, 'Noir', 'Loulou', 'F', 1),
  (4, 'Brun', 'Zia', 'F', 2),
  (5, 'Blanc', 'Lou', 'F', 3),
  (6, 'Roux', 'Minouchette', 'M', 1);

-- Structure de la table person
CREATE TABLE person (
  id BIGSERIAL PRIMARY KEY,
  age INT DEFAULT NULL,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  login VARCHAR(50) NOT NULL UNIQUE,
  mdp VARCHAR(100) NOT NULL,
  active INTEGER NOT NULL DEFAULT 1 -- Changé en INTEGER pour correspondre au "int" Java
);

-- Données pour person
INSERT INTO person (id, age, firstname, lastname, login, mdp, active) VALUES
  (1, 22, 'Henri', 'Lamarque', 'hla', '*****', 1),
  (2, 24, 'Sylvie', 'Lamarque', 'sla', '*****', 1),
  (3, 55, 'Jean', 'Vintroi', 'jvi', '*****', 1),
  (4, 80, 'Paul', 'Demaine', 'pde', '*****', 1),
  (5, 45, 'Sophie', 'Nero', 'sne', '*****', 1),
  (6, 17, 'Pierre', 'Sansane', 'sva', '*****', 1),
  (7, 33, 'John', 'Mangolo', 'jma', '*****', 1),
  (8, 26, 'Bill', 'Wagner', 'bwa', '*****', 1);

-- Structure de la table person_animals
CREATE TABLE person_animals (
  person_id BIGINT NOT NULL,  -- Changé en BIGINT
  animals_id BIGINT NOT NULL, -- Changé en BIGINT
  PRIMARY KEY (person_id, animals_id),
  CONSTRAINT FK_person_animals_animal FOREIGN KEY (animals_id) REFERENCES animal (id),
  CONSTRAINT FK_person_animals_person FOREIGN KEY (person_id) REFERENCES person (id)
);

-- Données pour person_animals
INSERT INTO person_animals (person_id, animals_id) VALUES
  (2, 1),
  (7, 1),
  (4, 2),
  (3, 3),
  (5, 4),
  (2, 5),
  (8, 6);

-- Structure de la table role
CREATE TABLE role (
  id BIGSERIAL PRIMARY KEY,
  label VARCHAR(50) NOT NULL
);

-- Données pour role
INSERT INTO role (id, label) VALUES
  (1, 'ROLE_EMPLOYE'),
  (2, 'ROLE_USER'),
  (3, 'ROLE_ADMIN');

-- Structure de la table person_role
CREATE TABLE person_role (
  person_id BIGINT NOT NULL, -- Changé en BIGINT
  role_id BIGINT NOT NULL,   -- Changé en BIGINT
  PRIMARY KEY (person_id, role_id),
  CONSTRAINT FK_person_role_person FOREIGN KEY (person_id) REFERENCES person (id),
  CONSTRAINT FK_person_role_role FOREIGN KEY (role_id) REFERENCES role (id)
);

-- Synchronisation des séquences
SELECT setval('species_id_seq', (SELECT MAX(id) FROM species));
SELECT setval('animal_id_seq', (SELECT MAX(id) FROM animal));
SELECT setval('person_id_seq', (SELECT MAX(id) FROM person));
SELECT setval('role_id_seq', (SELECT MAX(id) FROM role));