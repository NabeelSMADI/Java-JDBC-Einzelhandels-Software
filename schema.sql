CREATE TABLE IF NOT EXISTS Lager
       (LagerID        INTEGER PRIMARY KEY,
        name           VARCHAR(30) NOT NULL,
        adresse        VARCHAR(256) );

 
CREATE TABLE IF NOT EXISTS Kunden
       (KundenID       INTEGER PRIMARY KEY,
        name           VARCHAR(30) NOT NULL,
        Telefon        INTEGER,
        EMail          VARCHAR(30),
        adresse        VARCHAR(256));

CREATE TABLE IF NOT EXISTS Versorger
       (VersorgerID    INTEGER PRIMARY KEY,
        name           VARCHAR(30) NOT NULL,
        Telefon        INTEGER,
        EMail          VARCHAR(30),
        adresse        VARCHAR(256));

CREATE TABLE IF NOT EXISTS Produkt
       (ProduktID      INTEGER PRIMARY KEY,
        name           VARCHAR(30) NOT NULL,
        Preis          INTEGER,
        beschreibung   VARCHAR(256));

CREATE TABLE IF NOT EXISTS HVerkauf
       (HVerkaufID     INTEGER PRIMARY KEY,
        Datum          date NOT NULL,
        KundenID       INTEGER,
        FOREIGN KEY    (KundenID) REFERENCES Kunden);

CREATE TABLE IF NOT EXISTS DVerkauf
       (DVerkaufID     INTEGER PRIMARY KEY,
        ProduktID      INTEGER NOT NULL REFERENCES Produkt,
        Anzahl         INTEGER NOT NULL,
        Preis          INTEGER NOT NULL,
        HVerkaufID     INTEGER NOT NULL REFERENCES HVerkauf ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS HKauf
       (HKaufID        INTEGER PRIMARY KEY,
        Datum          date NOT NULL,
        VersorgerID    INTEGER,
        FOREIGN KEY    (VersorgerID) REFERENCES Versorger);

CREATE TABLE IF NOT EXISTS DKauf
       (DKaufID        INTEGER PRIMARY KEY,
        ProduktID      INTEGER NOT NULL REFERENCES Produkt,
        Anzahl         INTEGER NOT NULL,
        Preis          INTEGER NOT NULL,
        HKaufID        INTEGER NOT NULL REFERENCES HKauf ON DELETE CASCADE);





