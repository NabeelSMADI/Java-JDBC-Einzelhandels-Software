
INSERT INTO Lager(LagerID, name, adresse) 
VALUES (01, 'Lager1', 'Berlin'); 

INSERT INTO Lager(LagerID, name, adresse) 
VALUES (02, 'Lager2', 'Berlin'); 

INSERT INTO Lager(LagerID, name, adresse) 
VALUES (03, 'Lager3', 'Berlin'); 

INSERT INTO Lager(LagerID, name, adresse) 
VALUES (04, 'Lager4', 'Berlin'); 


INSERT INTO Kunden(KundenID, name, Telefon, EMail, adresse) 
VALUES (5001, 'Nabeel', 01510000, 'Nabeel@DB.com', 'Berlin'); 

INSERT INTO Kunden(KundenID, name, Telefon, EMail, adresse) 
VALUES (5002, 'Khaled', 01510000, 'Khaled@DB.com', 'Berlin'); 

INSERT INTO Kunden(KundenID, name, Telefon, EMail, adresse) 
VALUES (5003, 'Marven', 01510000, 'Marven@DB.com', 'Berlin'); 

INSERT INTO Kunden(KundenID, name, Telefon, EMail, adresse) 
VALUES (5004, 'Andreas', 01510000, 'Andreas@DB.com', 'Berlin'); 


INSERT INTO Versorger(VersorgerID, name, Telefon, EMail, adresse) 
VALUES (6001, 'Arnold', 01510000, 'Arnold@DB.com', 'Berlin'); 

INSERT INTO Versorger(VersorgerID, name, Telefon, EMail, adresse) 
VALUES (6002, 'Carl', 01510000, 'Carl@DB.com', 'Berlin'); 

INSERT INTO Versorger(VersorgerID, name, Telefon, EMail, adresse) 
VALUES (6003, 'David', 01510000, 'David@DB.com', 'Berlin'); 

INSERT INTO Versorger(VersorgerID, name, Telefon, EMail, adresse) 
VALUES (6004, 'Dennis', 01510000, 'Dennis@DB.com', 'Berlin'); 


INSERT INTO Produkt(ProduktID, name, Preis, beschreibung) 
VALUES (2001, 'Kindle', 100, 'Paperwhite eReader'); 

INSERT INTO Produkt(ProduktID, name, Preis, beschreibung) 
VALUES (2002, 'In-Ear-Kopfhorer', 25, 'Sony MDR-EX450H geschlossene In-Ear-Kopfhorer'); 

INSERT INTO Produkt(ProduktID, name, Preis, beschreibung) 
VALUES (2003, 'Kamera', 100, 'Nikon Coolpix A10 Kamera Kit schwarz'); 

INSERT INTO Produkt(ProduktID, name, Preis, beschreibung) 
VALUES (2004, 'Samsung Smartphone A3', 100, 'Samsung Galaxy A3 Smartphone'); 


INSERT INTO HVerkauf(HVerkaufID, Datum, KundenID) 
VALUES (3001, '2017-01-25', 5001); 

INSERT INTO HVerkauf(HVerkaufID, Datum, KundenID) 
VALUES (3002, '2017-02-20', 5002); 

INSERT INTO HVerkauf(HVerkaufID, Datum, KundenID) 
VALUES (3003, '2017-03-15', 5001); 

INSERT INTO HVerkauf(HVerkaufID, Datum, KundenID) 
VALUES (3004, '2017-04-01', 5004); 



INSERT INTO DVerkauf(DVerkaufID, ProduktID, Anzahl ,Preis ,HVerkaufID) 
VALUES (70001, 2001, 5, 100, 3001); 

INSERT INTO DVerkauf(DVerkaufID, ProduktID, Anzahl ,Preis ,HVerkaufID) 
VALUES (70002, 2002, 4, 25, 3001); 

INSERT INTO DVerkauf(DVerkaufID, ProduktID, Anzahl ,Preis ,HVerkaufID) 
VALUES (70003, 2003, 3, 100, 3002); 

INSERT INTO DVerkauf(DVerkaufID, ProduktID, Anzahl ,Preis ,HVerkaufID) 
VALUES (70004, 2004, 2, 100, 3003); 

INSERT INTO DVerkauf(DVerkaufID, ProduktID, Anzahl ,Preis ,HVerkaufID) 
VALUES (70005, 2001, 1, 100, 3004); 



INSERT INTO HKauf(HKaufID, Datum, VersorgerID) 
VALUES (4001, '2016-09-25', 6001); 

INSERT INTO HKauf(HKaufID, Datum, VersorgerID) 
VALUES (4002, '2016-04-20', 6002); 

INSERT INTO HKauf(HKaufID, Datum, VersorgerID) 
VALUES (4003, '2016-08-15', 6001); 

INSERT INTO HKauf(HKaufID, Datum, VersorgerID) 
VALUES (4004, '2016-06-01', 6004); 



INSERT INTO DKauf(DKaufID, ProduktID, Anzahl ,Preis ,HKaufID) 
VALUES (80001, 2001, 25, 100, 4001); 

INSERT INTO DKauf(DKaufID, ProduktID, Anzahl ,Preis ,HKaufID) 
VALUES (80002, 2002, 40, 25, 4001); 

INSERT INTO DKauf(DKaufID, ProduktID, Anzahl ,Preis ,HKaufID) 
VALUES (80003, 2003, 30, 100, 4002); 

INSERT INTO DKauf(DKaufID, ProduktID, Anzahl ,Preis ,HKaufID) 
VALUES (80004, 2004, 20, 100, 4003); 

INSERT INTO DKauf(DKaufID, ProduktID, Anzahl ,Preis ,HKaufID) 
VALUES (80005, 2001, 15, 100, 4004);


