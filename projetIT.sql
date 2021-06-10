#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

DROP DATABASE IF EXISTS projetit;
CREATE DATABASE projetit;
USE projetit;

#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Role
#------------------------------------------------------------

CREATE TABLE Role(
        id_role     Int  Auto_increment  NOT NULL ,
        nom         Varchar (50) NOT NULL ,
        description Varchar (100) NOT NULL
	,CONSTRAINT Role_PK PRIMARY KEY (id_role)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Utilisateur
#------------------------------------------------------------

CREATE TABLE Utilisateur(
        id_user  Int  Auto_increment  NOT NULL ,
        nom      Varchar (50) NOT NULL ,
        prenom   Varchar (50) NOT NULL ,
        login    Varchar (50) NOT NULL UNIQUE,
        password Varchar (100) NOT NULL ,
        id_role  Int NOT NULL
	,CONSTRAINT Utilisateur_PK PRIMARY KEY (id_user)

	,CONSTRAINT Utilisateur_Role_FK FOREIGN KEY (id_role) REFERENCES Role(id_role)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Type
#------------------------------------------------------------

CREATE TABLE Type(
        nom Varchar (100) NOT NULL
	,CONSTRAINT Type_PK PRIMARY KEY (nom)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Document
#------------------------------------------------------------

CREATE TABLE Document(
        id_doc      Int  Auto_increment  NOT NULL ,
        nom         Varchar (100) NOT NULL ,
        taille      Float NOT NULL ,
        date_insert Date NOT NULL ,
        description Varchar (100) NOT NULL ,
        chemin      Varchar (50) NOT NULL ,
        id_user     Int NOT NULL ,
        nom_Type    Varchar (100) NOT NULL
	,CONSTRAINT Document_PK PRIMARY KEY (id_doc)

	,CONSTRAINT Document_Utilisateur_FK FOREIGN KEY (id_user) REFERENCES Utilisateur(id_user)
	,CONSTRAINT Document_Type0_FK FOREIGN KEY (nom_Type) REFERENCES Type(nom)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: accèder
#------------------------------------------------------------

CREATE TABLE acceder(
        id_doc  Int NOT NULL ,
        id_user Int NOT NULL
	,CONSTRAINT acceder_PK PRIMARY KEY (id_doc,id_user)

	,CONSTRAINT acceder_Document_FK FOREIGN KEY (id_doc) REFERENCES Document(id_doc)
	,CONSTRAINT acceder_Utilisateur0_FK FOREIGN KEY (id_user) REFERENCES Utilisateur(id_user)
)ENGINE=InnoDB;

