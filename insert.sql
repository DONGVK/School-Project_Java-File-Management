use projetit;

#------------------------------------------------------------
# Table: Role
#------------------------------------------------------------
INSERT INTO Role (nom, description) VALUES
("admin", "Creation, modification et suppresion"),
("user", "simple utilisateur")
;

#------------------------------------------------------------
# Table: Utilisateur
#------------------------------------------------------------
INSERT INTO Utilisateur (nom, prenom, login, password, id_role) VALUES
("DONG", "Viet Khoi", "Vk", "f9824ba4a0c1053d3c448d752236fe4f", 1), -- mdr
("EL BAIED", "Sami", "Sami", "202cb962ac59075b964b07152d234b70", 1), -- 123
("YAO", "Kouame", "Kouame", "aa36dc6e81e2ac7ad03e12fedcb6a2c0", 2), -- mdp
("DAYO TAGHE", "Danielle", "Danielle", "4e4d6c332b6fe62a63afe56171fd3725", 2) -- haha
;

#------------------------------------------------------------
# Table : Type
#------------------------------------------------------------
INSERT INTO Type(nom) VALUES
("exe"), ("com"), ("sh"), ("bat"),
("arc"), ("zip"), ("rar"), ("z"), ("arj"), ("sit"), ("gz"), ("7z"),
("gif"), ("jpg"), ("bmp"), ("png"), ("eps"), ("tif"),
("au"), ("wav"), ("mp3"), ("oga"), ("ram"),
("avi"), ("mpg"), ("mov"), ("mp4"),
("docx"), ("odt"), ("doc"), ("pdf"), ("txt"), 
("ini"), ("csv"), ("log"), ("conf"),
("java"), ("jar"), ("py"), ("c"), ("html")
;

#------------------------------------------------------------
# Table : Document
#------------------------------------------------------------
INSERT INTO Document(nom, taille, date_insert, description, chemin, nom_type, id_user) VALUES
("grapefruit", 17.6, CURDATE(), "une image", "./stock_file/grapefruit.jpg", "jpg", 1),
("stackoverflow", 105, CURDATE(), "un logo", "./stock_file/stackoverflow.png", "png", 1),
("sujet5", 112, CURDATE(), "le sujet du projet", "./stock_file/sujet5.pdf", "pdf", 1)
;
