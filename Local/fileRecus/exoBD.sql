CREATE TABLE magasin(
    numCmd INT,
    nomClient VARCHAR(20),
    article VARCHAR(20),
    PrixUnitaire INT,
    quantite INT,
    dateAchat DATE,
    Quartier VARCHAR(20)
);

INSERT INTO magasin VALUES(1,'Paul','console',2000,1,'2018-02-23','Analakely');
INSERT INTO magasin VALUES(2,'Pierre','console',1800,2,'2018-06-20','Ivato');
INSERT INTO magasin VALUES(3,'Maurice','console',2100,1,'2018-05-15','Andoharanofotsy');
INSERT INTO magasin VALUES(4,'Gérard','carte',100,2,'2018-06-02','Andoharanofotsy');
INSERT INTO magasin VALUES(5,'Paul','CD',5,3,'2018-06-06','Analakely');
INSERT INTO magasin VALUES(6,'Maurice','manette',100,4,'2018-03-11','Andoharanofotsy');
INSERT INTO magasin VALUES(7,'Paul','CD',10,2,'2018-06-27','Analakely');
INSERT INTO magasin VALUES(8,'Guy','console',2000,1,'2018-03-30','Ankadifotsy');
INSERT INTO magasin VALUES(9,'Maurice','carte',110,2,'2018-06-23','Andoharanofotsy');
INSERT INTO magasin VALUES(10,'Maurice','CD',8,12,'2018-06-21','Andoharanofotsy');


1)-SELECT *FROM magasin WHERE dateAchat<'2018-06-15';
2)-SELECT *FROM magasin WHERE dateAchat>'2018-06-10' AND dateAchat<'2018-06-15';
3)-SELECT *FROM magasin WHERE dateAchat<'2018-06-15' AND Quartier='Analakely' OR Quartier='Andoharanofotsy';
4)-SELECT MAX(PrixUnitaire) , MIN(PrixUnitaire) FROM magasin;
5)-SELECT MAX(quantite) FROM magasin;
6)-SELECT AVG(quantite) , AVG(PrixUnitaire) FROM magasin;
7)-SELECT COUNT(numCmd) FROM magasin;
8)-SELECT COUNT(numCmd) FROM magasin WHERE dateAchat<'2018-06-30' AND dateAchat>'2018-06-01';
9)-SELECT SUM(PrixUnitaire) FROM magasin WHERE dateAchat<'2018-06-30' AND dateAchat>'2018-06-01';
10)-SELECT nomClient FROM magasin;
11)-SELECT SUM(quantite) FROM magasin;
12)-SELECT article FROM magasin;
ou SELECT DISTINCT article FROM magasin;
13)-
