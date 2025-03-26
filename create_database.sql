
DROP SCHEMA IF EXISTS oblig3 CASCADE;

CREATE SCHEMA oblig3 ;
SET search_path TO oblig3 ;

CREATE TABLE Avdeling (
	avdelingId SERIAL PRIMARY KEY,
	navn VARCHAR(50),
	sjefId INT
);

CREATE TABLE Ansatt (
    ansattId SERIAL PRIMARY KEY,
    brukernavn VARCHAR(4) UNIQUE,
    fornavn VARCHAR(50),
    etternavn VARCHAR(50),
    ansettelseDato DATE,
    stilling VARCHAR(50),
    manedslonn DECIMAL,
    avdelingId INT
);

ALTER TABLE Ansatt
ADD CONSTRAINT fk_avdeling FOREIGN KEY (avdelingId) REFERENCES Avdeling(avdelingId) ON DELETE SET NULL;

ALTER TABLE Avdeling
ADD CONSTRAINT fk_sjef FOREIGN KEY (sjefId) REFERENCES Ansatt(ansattId) ON DELETE SET NULL;

CREATE TABLE Prosjekt (
	prosjektId SERIAL PRIMARY KEY,
	navn VARCHAR(50),
	beskrivelse TEXT
);

CREATE TABLE Prosjektdeltagelse (
	ansattId INT,
	prosjektId INT,
	rolle VARCHAR(50),
	timer DECIMAL DEFAULT 0,
	PRIMARY KEY (ansattId, prosjektId),
	FOREIGN KEY (ansattId) references Ansatt(ansattId) ON DELETE CASCADE,
	FOREIGN KEY (prosjektId) references Prosjekt(prosjektId) ON DELETE CASCADE
);

INSERT INTO
	Avdeling (navn, sjefId)
VALUES
    ('Snacks', NULL),
    ('Stemning', NULL),
    ('Loking', NULL);

INSERT INTO
  Ansatt(ansattId, brukernavn, fornavn, etternavn, ansettelseDato, stilling, manedslonn, avdelingId)
VALUES
    (1001, 'Mart','Marte', 'Saevig', '2025-03-19', 'Snacks-sjef', 50000.01, 1),
    (1002, 'Nads','Nadia', 'Lambrecht', '2025-03-19', 'Stemning-sjef', 45000.23, 2),
    (1003, 'J9','Jenny', 'Hopland', '2025-03-19', 'Loking-sjef',40000.99, 3),
    (1004, 'Alx','Alexander', 'Jakobsen', '2025-03-20', 'Steming', 50.2, 2),
    (1005, 'Bsh','Bashar', 'Mohamad', '2025-03-20', 'Steming', 40.1, 1),
    (1006, 'Andy','Andreas', 'Odegard', '2025-03-20', 'Loking', 30.3, 2),
    (1007, 'THo','Teodor', 'Orjansen', '2025-03-20', 'Loking', 20.2, 3),
    (1008, 'Maty','Mats', 'Rui', '2025-03-20', 'Loking', 50.2, 3),
    (1009, 'Ask','Andreas', 'Kaartinen', '2025-03-21', 'Loking', 10.2, 1),
    (1010, 'Kap','Kasper', 'Austbo', '2025-03-21', 'Steming', 10.9, 1);
    
UPDATE Avdeling SET sjefId = 1001 WHERE navn = 'Snacks';   
UPDATE Avdeling SET sjefId = 1002 WHERE navn = 'Stemning';  
UPDATE Avdeling SET sjefId = 1003 WHERE navn = 'Loking';  

INSERT INTO Prosjekt (navn, beskrivelse)
VALUES
	('Prosjekt A', 'Dette er et prosjekt for noe bra'),
	('Prosjekt B', 'Prosjekt for å holde stemningen på topp');
	
INSERT INTO Prosjektdeltagelse (ansattId, prosjektId, rolle, timer)
VALUES
	(1001, 1, 'yapping', 120),
	(1002, 1, 'lytting', 100),
	(1003, 2, 'soving', 150);

select * from Ansatt;

select * from Avdeling;

select * from Prosjekt;

select * from Prosjektdeltagelse;

--printer bare ut siste tabellen...--



