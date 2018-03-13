CREATE TABLE Course(
   id_Course Serial PRIMARY KEY,
   nom_course VARCHAR(50),
   format_course VARCHAR(50),
   date_course DATE,
   description_course TEXT,
   lieu VARCHAR(50),
   agrementFTTri boolean,
   budget decimal (10,2),
   nb_participants int,
   parcours VARCHAR(50),
   nom_ville VARCHAR(50),
   CP_ville int,
   type_epreuve VARCHAR(50)
   
   
   
);

CREATE TABLE Contact_Ext(
   id_Contact SERIAL PRIMARY KEY,
   type_contact VARCHAR(50),
   civilite VARCHAR(1),
   commentaire_contact TEXT ,
   nom_societe VARCHAR(50),
   nom_contact VARCHAR(50),
   prenom_contact VARCHAR(50),
   adresse1_contact VARCHAR(255),
   code_Postal_contact VARCHAR(5),
   ville_contact VARCHAR(50),
   telephone_contact VARCHAR(10),
   mail_contact VARCHAR(255)
);

CREATE TABLE Benevole(
   id_Personne SERIAL PRIMARY KEY,
   commentaire_benevole TEXT,
   civilite_benevole VARCHAR(1) ,
   nom_benevole VARCHAR(50),
   prenom_benevole VARCHAR(50),
   adresse_benevole VARCHAR(255),
   codePostal_benevole VARCHAR(5),
   ville_benevole VARCHAR(50),
   mail_personnel VARCHAR(50),
   telephone_benevole VARCHAR(50)
);

CREATE TABLE Tache(
   id_Tache SERIAL PRIMARY KEY,
   libelle VARCHAR(50),
   commentaire TEXT,
   dateDebut DATE,
   dateEcheance DATE,
   etatAvancement float,
   dateRappel DATE,
   priorite int,
   predefinie boolean,
   date_creation_tache DATE,
   nom_createur VARCHAR(50),
   id_Personne INT REFERENCES Benevole(id_Personne)
  
);

CREATE TABLE Contacter(
   id_Contact INT REFERENCES Contact_Ext(id_Contact),
   id_Course INT REFERENCES Course(id_Course),
   PRIMARY KEY(id_Contact, id_Course)
);

CREATE TABLE Gérer(
   id_Personne INT REFERENCES benevole(id_Personne),
   id_Tache INT REFERENCES tache(id_Tache),
   PRIMARY KEY(id_Personne, id_Tache),
   poste VARCHAR(50)
);

CREATE TABLE Contenir(
   id_Tache INT REFERENCES Tache(id_Tache) ,
   id_Course INT REFERENCES Course(id_Course),
   PRIMARY KEY(id_Tache, id_Course)
);