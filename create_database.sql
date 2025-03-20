-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = oving:jpa
        -- Tabell(er) = ansatt 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS oving_jpa CASCADE;
CREATE SCHEMA oving_jpa;
SET search_path TO oving_jpa;


CREATE TABLE ansatt
(
    brukernavn CHAR(4) PRIMARY KEY,
    fornavn VARCHAR(30),
    etternavn VARCHAR(30),
    ansettelsedato DATE,
    stilling VARCHAR(100),
    maanedslonn DECIMAL(10, 2),
    CONSTRAINT ck_maanedslonn CHECK (maanedslonn >= 0)
);

INSERT INTO
  ansatt(brukernavn, fornavn)
VALUES
    (1001, 'Per Viskeler'),
    (1002, 'Atle Patle'),
    (1003, 'Donald Duck');
    
 select * from ansatt;   

