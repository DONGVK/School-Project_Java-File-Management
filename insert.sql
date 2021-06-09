use projetit;

#------------------------------------------------------------
# Table: Utilisateur
#------------------------------------------------------------
INSERT INTO Utilisateur (nom, prenom, login, password) VALUES
("DONG", "Viet Khoi", "Vk", "f9824ba4a0c1053d3c448d752236fe4f"), -- mdr
("EL BAIED", "Sami", "Sami", "202cb962ac59075b964b07152d234b70"), -- 123
("YAO", "Kouame", "Kouame", "aa36dc6e81e2ac7ad03e12fedcb6a2c0"), -- mdp
("DAYO TAGHE", "Danielle", "Danielle", "4e4d6c332b6fe62a63afe56171fd3725") -- haha
;

#------------------------------------------------------------
# Table: Role
#------------------------------------------------------------
INSERT INTO Role (nom, description) VALUES
("admin", "Creation, modification et suppresion"),
("user", "simple utilisateur")
;

#------------------------------------------------------------
# Table: Permission
#------------------------------------------------------------
INSERT INTO Permission (id_user, id_role) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2)
;