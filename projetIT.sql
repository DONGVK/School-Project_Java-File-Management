#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

DROP DATABASE IF EXISTS projetit;
CREATE DATABASE projetit;
USE projetit;

#------------------------------------------------------------
# Table: Utilisateur
#------------------------------------------------------------

CREATE TABLE Utilisateur(
        id_user  Int  Auto_increment  NOT NULL ,
        nom      Varchar (50) NOT NULL ,
        prenom   Varchar (50) NOT NULL ,
        login    Varchar (50) NOT NULL ,
        password Varchar (100) NOT NULL
	,CONSTRAINT Utilisateur_PK PRIMARY KEY (id_user)
)ENGINE=InnoDB;


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
# Table: Permission
#------------------------------------------------------------

CREATE TABLE Permission(
        id_permi Int  Auto_increment  NOT NULL ,
        id_user  Int NOT NULL ,
        id_role  Int NOT NULL
	,CONSTRAINT Permission_PK PRIMARY KEY (id_permi)

	,CONSTRAINT Permission_Utilisateur_FK FOREIGN KEY (id_user) REFERENCES Utilisateur(id_user)
	,CONSTRAINT Permission_Role0_FK FOREIGN KEY (id_role) REFERENCES Role(id_role)
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
        nom_Type    Varchar (100) NOT NULL
	,CONSTRAINT Document_PK PRIMARY KEY (id_doc)

	,CONSTRAINT Document_Type_FK FOREIGN KEY (nom_Type) REFERENCES Type(nom)
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

