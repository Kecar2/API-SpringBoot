CREATE table foods
(
  id   INT,
  name VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE table animalFamily
(
    id INT,
    name VARCHAR(50),
     PRIMARY KEY (id)
);

CREATE table animals
(
  id   INT,
  name VARCHAR(50),
  legs INT,
  idFood INT,
  idFamily INT,
  FOREIGN KEY (idFamily) REFERENCES animalFamily(id),
  FOREIGN KEY (idFood) REFERENCES foods(id),
  PRIMARY KEY (id)
);

CREATE table studyExcluded
(
  idAnimalExcluded   INT,
  PRIMARY KEY (idAnimalExcluded)
);

INSERT INTO animalFamily VALUES(0,'mammal');
INSERT INTO animalFamily VALUES(1,'reptile');
INSERT INTO animalFamily VALUES(2,'birds');
INSERT INTO animalFamily VALUES(3,'arthropod');

INSERT INTO foods VALUES (0, 'carrot');
INSERT INTO foods VALUES (1, 'leafs');
INSERT INTO foods VALUES (2, 'insects');
INSERT INTO foods VALUES (3, 'vermin');
INSERT INTO foods VALUES (4, 'birdseed');

INSERT INTO animals VALUES (0, 'Rabbit', 4,0,0);
INSERT INTO animals VALUES (1, 'Ape', 2,1,0);
INSERT INTO animals VALUES (2, 'Deer', 4,1,0);
INSERT INTO animals VALUES (3, 'Snake', 0,2,1);
INSERT INTO animals VALUES (4, 'Coocodrile',4,3,1);
INSERT INTO animals VALUES (5, 'Chicken', 2,4,2);
INSERT INTO animals VALUES (6, 'Spider', 8,2,3);




INSERT INTO studyExcluded VALUES (3);



