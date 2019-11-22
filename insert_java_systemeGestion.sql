INSERT INTO role (libelle) VALUES ("Chef de projet") ;
INSERT INTO role (libelle) VALUES ("Developpeur") ;
INSERT INTO projet(libelle) VALUES ("Madera") ;

INSERT INTO collaborateur (mail,nom, prenom, pwd, id_role) VALUES ("monmail@gg.fr", "Dupond", "Jean", "pwd", 1) ;
INSERT INTO collaborateur (mail,nom, prenom, pwd, id_role) VALUES ("mondevmail@gg.fr", "Durand", "Marc", "pwd", 2) ;
INSERT INTO reunion (compteRendu, date, lieu, objectif, id_createur, id_projet) VALUES ("mon super compte rendu de la mort qui tue", "2005-04-8 2:00:00.000", "Salle 01", "Mock-up", 1, 1) ;
INSERT INTO tache(echeance, libelle, id_reunion) VALUES ("2005-06-20 2:00:00.000","Réalisation Mock-up", 1) ;
INSERT INTO participer(collaborateur_id, reunion_id) VALUES (1,1) ;
INSERT INTO participer(collaborateur_id, reunion_id) VALUES (2,1) ;