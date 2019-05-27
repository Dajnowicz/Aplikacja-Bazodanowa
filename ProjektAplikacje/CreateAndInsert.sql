

CREATE TABLE administrator
(id_administrator int primary key identity,
login VARCHAR(50) NOT NULL, 
haslo VARCHAR(50) NOT NULL
)
go

CREATE TABLE uzytkownik
(id_uzytkownik int primary key identity,
login VARCHAR(50) NOT NULL, 
haslo VARCHAR(50) NOT NULL
)
go

CREATE TABLE logs
(id_logs int primary key identity,
nazwa_uzytkownika VARCHAR(50) NOT NULL, 
data_logowania datetime,
uzytkownik_id int,
FOREIGN KEY (uzytkownik_id) REFERENCES uzytkownik(id_uzytkownik)
)
go


INSERT INTO administrator VALUES ('admin', 'haslo')
go


INSERT INTO uzytkownik VALUES ('us1', 'haslo1');
INSERT INTO uzytkownik VALUES ('us2', 'haslo2');
INSERT INTO uzytkownik VALUES ('us3', 'haslo3');
INSERT INTO uzytkownik VALUES ('us4', 'haslo4');
INSERT INTO uzytkownik VALUES ('us5', 'haslo5');
INSERT INTO uzytkownik VALUES ('us6', 'haslo6');



CREATE TABLE klasa_samolotowa (
  id_klasa_samolotowa int IDENTITY(1,1) PRIMARY KEY,
  nazwa_klasy VARCHAR(20) NOT NULL,
  opis_klasy VARCHAR(20) NULL
);

INSERT INTO klasa_samolotowa(nazwa_klasy,opis_klasy) VALUES ('Economic','tanie');
INSERT INTO klasa_samolotowa(nazwa_klasy,opis_klasy) VALUES ('Super-economic','super tanie');
INSERT INTO klasa_samolotowa(nazwa_klasy,opis_klasy) VALUES ('luxary','dla bogaczy');
INSERT INTO klasa_samolotowa(nazwa_klasy,opis_klasy) VALUES ('super-luxary','dla super bogaczy');
INSERT INTO klasa_samolotowa(nazwa_klasy,opis_klasy) VALUES ('normal','dla sredniakow');


CREATE TABLE typ_samolotu (
  id_typ_samolotu int IDENTITY(1,1) PRIMARY KEY,
  nazwa_typu VARCHAR(10) NOT NULL,
  opis VARCHAR(100) NOT NULL
);


INSERT INTO typ_samolotu(nazwa_typu, opis) VALUES ('BOJING','potwor');
INSERT INTO typ_samolotu(nazwa_typu, opis) VALUES ('Posejdon','przewozi czolgi');
INSERT INTO typ_samolotu(nazwa_typu, opis) VALUES ('Mars','leci na wojne');
INSERT INTO typ_samolotu(nazwa_typu, opis) VALUES ('Copter','maly');
INSERT INTO typ_samolotu(nazwa_typu, opis) VALUES ('AIRFORCE 1','malo-wazny');





CREATE TABLE producent_samolotu (
  id_producent_samolotu int IDENTITY(1,1) PRIMARY KEY,
  nazwa_producenta VARCHAR(10) NOT NULL,
  ceo VARCHAR(20) NOT NULL,
  rok_zalozenia DATE NULL
);


INSERT INTO producent_samolotu(nazwa_producenta, ceo, rok_zalozenia) VALUES ('Ferrari','Adam Johnson', '2008-05-09');
INSERT INTO producent_samolotu(nazwa_producenta, ceo, rok_zalozenia) VALUES ('Bugatti', 'Adam Johnson','2010-03-29');
INSERT INTO producent_samolotu(nazwa_producenta, ceo, rok_zalozenia) VALUES ('Maluch', 'Adam Johnson','2007-03-19');
INSERT INTO producent_samolotu(nazwa_producenta, ceo, rok_zalozenia) VALUES ('Amrix', 'Adam Johnson','1997-12-01');
INSERT INTO producent_samolotu(nazwa_producenta, ceo, rok_zalozenia) VALUES ('Intel', 'Adam Johnson','1997-09-19');
INSERT INTO producent_samolotu(nazwa_producenta, ceo, rok_zalozenia) VALUES ('IBM', 'Adam Johnson','1996-09-19');
INSERT INTO producent_samolotu(nazwa_producenta, ceo, rok_zalozenia) VALUES ('SpaceX', 'Adam Johnson','2018-01-19');


CREATE TABLE samolot (
  id_samolot int IDENTITY(1,1) PRIMARY KEY,
  nazwa VARCHAR(20) NOT NULL UNIQUE,
  numer VARCHAR(20) NOT NULL UNIQUE,
  model VARCHAR(20) NOT NULL UNIQUE,
  pojemnosc VARCHAR(10) NOT NULL,
);


INSERT INTO samolot(nazwa,numer,model, pojemnosc) VALUES ('Markotny','23','1 Generacja','201');
INSERT INTO samolot(nazwa,numer,model, pojemnosc) VALUES ('Latajacy','223','X1X','5');
INSERT INTO samolot(nazwa,numer,model, pojemnosc) VALUES ('Nurek','1','Supreme','566');
INSERT INTO samolot(nazwa,numer,model, pojemnosc) VALUES ('SuperSlim','235','Stealth','23');
INSERT INTO samolot(nazwa,numer,model, pojemnosc) VALUES ('Pitchfork','2','Short','1');
INSERT INTO samolot(nazwa,numer,model, pojemnosc) VALUES ('Niszczyciel','12223','SuperHej','66');
INSERT INTO samolot(nazwa,numer,model, pojemnosc) VALUES ('Furiat','278','Quicki','234');
INSERT INTO samolot(nazwa,numer,model, pojemnosc) VALUES ('SuperFer','2232','Space','1');



CREATE TABLE status_lotu (
  id_status_lotu int IDENTITY(1,1) PRIMARY KEY,
  nazwa VARCHAR(20) NOT NULL UNIQUE,
  opis VARCHAR(30) NOT NULL,
  data DATE NOT NULL,
  opoznienia VARCHAR(20) NULL
  );


INSERT INTO status_lotu(nazwa, opis,data,opoznienia) VALUES ('Great Line','papieros na pokaldzie','2012-02-03','');
INSERT INTO status_lotu(nazwa, opis,data,opoznienia) VALUES ('MAGA','cos nie tak','2016-11-14','');
INSERT INTO status_lotu(nazwa, opis,data,opoznienia) VALUES ('InterCont','atak','2017-10-25','2 godziny');
INSERT INTO status_lotu(nazwa, opis,data,opoznienia) VALUES ('WOHO','wszystko w normie','2014-01-12','');
INSERT INTO status_lotu(nazwa, opis,data,opoznienia) VALUES ('LETSGO','wszystko w normie','2018-12-03','dwa dni');

CREATE TABLE kraj (
  kraj_id int IDENTITY(1,1) PRIMARY KEY,
  nazwa VARCHAR(20) NOT NULL,
);
GO

INSERT INTO kraj(nazwa) VALUES ('Polska');
INSERT INTO kraj(nazwa) VALUES ('USA');
INSERT INTO kraj(nazwa) VALUES ('Argentyna');
INSERT INTO kraj(nazwa) VALUES ('Niemcy');
INSERT INTO kraj(nazwa) VALUES ('UK');



CREATE TABLE pasazer (
  id_pasazer int IDENTITY(1,1) PRIMARY KEY,
  imie VARCHAR(20) NOT NULL,
  nazwisko VARCHAR(30) NOT NULL,
  data_urodzenia DATE,
  czy_wyda³_w_liniach NUMERIC,
  kraj_id INTEGER NOT NULL REFERENCES kraj(kraj_id) ON UPDATE CASCADE
);



INSERT INTO pasazer(imie,nazwisko,   data_urodzenia, czy_wyda³_w_liniach, kraj_id) VALUES ('Marcel','Dajnowicz','1998-12-03',22000,1);
INSERT INTO pasazer(imie,nazwisko,   data_urodzenia, czy_wyda³_w_liniach, kraj_id) VALUES ('Julia','Zubka','1997-05-09',19534,2);
INSERT INTO pasazer(imie,nazwisko,  data_urodzenia, czy_wyda³_w_liniach, kraj_id) VALUES ('Magda','Czekalska','1996-05-17',0,2);
INSERT INTO pasazer(imie,nazwisko,  data_urodzenia, czy_wyda³_w_liniach, kraj_id) VALUES ('Jakub','Nowak','1995-02-03',0,4);
INSERT INTO pasazer(imie,nazwisko,   data_urodzenia, czy_wyda³_w_liniach, kraj_id) VALUES ('Jakub','Rachwa³','1994-04-03',4324,5);


CREATE TABLE rezerwacja (
  id_rezerwacja int IDENTITY(1,1) PRIMARY KEY,
  pasazer_id INTEGER NOT NULL REFERENCES pasazer(id_pasazer) ON UPDATE CASCADE,
  uwagi VARCHAR(30) NULL
);

INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (1,'meh');
INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (1,'sad');
INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (1,'wooooow');
INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (1,'nice');
INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (2,'zly system');
INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (2,'jest oki');
INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (2,'swietna sprawa');
INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (3,'genialny system');
INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (4,'SUPER BAZA DANYCH');
INSERT INTO rezerwacja(pasazer_id,uwagi) VALUES (5,'ok');


CREATE TABLE lotnisko (
  id_lotnisko int IDENTITY(1,1) PRIMARY KEY,
  nazwa_lotniska VARCHAR(20) NOT NULL,
  miasto VARCHAR(20) NOT NULL,
  ulica VARCHAR(30) NOT NULL,
  numer_ulicy VARCHAR(10) NOT NULL,
  kod_pocztowy VARCHAR(10) NOT NULL,
  kraj_id INTEGER NOT NULL REFERENCES kraj(kraj_id) ON UPDATE CASCADE,
);


INSERT INTO lotnisko(nazwa_lotniska,miasto,ulica, numer_ulicy, kod_pocztowy, kraj_id ) VALUES ('Lech Walesa','Gdansk','legionow','201','12-344',1);
INSERT INTO lotnisko(nazwa_lotniska,miasto,ulica, numer_ulicy, kod_pocztowy, kraj_id ) VALUES ('Marcel Airport','Marcelolandia','Marcela','1','57-784',1);
INSERT INTO lotnisko(nazwa_lotniska,miasto,ulica, numer_ulicy, kod_pocztowy, kraj_id ) VALUES ('Okecie','Warszawa','legionow','201','12-344',1);
INSERT INTO lotnisko(nazwa_lotniska,miasto,ulica, numer_ulicy, kod_pocztowy, kraj_id ) VALUES ('Luton','London','legionow','201','12-344',5);
INSERT INTO lotnisko(nazwa_lotniska,miasto,ulica, numer_ulicy, kod_pocztowy, kraj_id ) VALUES ('Dutch','Amsterdam','legionow','201','12-344',4);


CREATE TABLE plan_lotu (
  id_plan_lotu int IDENTITY(1,1) PRIMARY KEY,
  czas_wylotu DATE NOT NULL,
  czas_przylotu DATE NOT NULL,
);
select * from plan_lotu

INSERT INTO plan_lotu(czas_wylotu, czas_przylotu) VALUES ('2014-01-12','2014-01-12');
INSERT INTO plan_lotu(czas_wylotu, czas_przylotu) VALUES ('2017-10-25','2017-10-25');
INSERT INTO plan_lotu(czas_wylotu, czas_przylotu) VALUES ('2016-11-13','2016-11-14');
INSERT INTO plan_lotu(czas_wylotu, czas_przylotu) VALUES ('2012-02-03','2012-02-04');
INSERT INTO plan_lotu(czas_wylotu, czas_przylotu) VALUES ('2018-05-06','2018-05-07');
INSERT INTO plan_lotu(czas_wylotu, czas_przylotu) VALUES ('2018-05-01','2018-05-02');
INSERT INTO plan_lotu(czas_wylotu, czas_przylotu) VALUES ('2018-05-28','2018-05-29');

insert into logs values( 'user3', getdate(), 5);