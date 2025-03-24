-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = forelesning1
        -- Tabell(er) = person 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS oblig3 CASCADE;

CREATE SCHEMA oblig3 ;
SET search_path TO oblig3 ;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE person;

CREATE TABLE Ansatt
(
    ansattId SERIAL PRIMARY KEY,
    brukernavn VARCHAR(4) UNIQUE,
    fornavn VARCHAR(50),
    etternavn VARCHAR(50),
    ansettelseDato DATE,
    stilling VARCHAR(50),
    manedslonn DECIMAL,
    avdelingId INT
);

INSERT INTO
  Ansatt(ansattId, brukernavn, fornavn)
VALUES
    (1001, 'Mart','Marte Saevig'),
    (1002, 'Nads','Nadia Lambrecht'),
    (1003, 'J9','Jenny Hopland');

select * from Ansatt;

--IKKE FASIT, et eksempel fra forelsening


