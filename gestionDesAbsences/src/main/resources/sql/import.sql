--suppression de toutes les données avant insertion
TRUNCATE TABLE admin CASCADE;
TRUNCATE TABLE batiment CASCADE;
TRUNCATE TABLE demande CASCADE;
TRUNCATE TABLE etudiant CASCADE;
TRUNCATE TABLE formation CASCADE;
TRUNCATE TABLE groupe CASCADE;
TRUNCATE TABLE module CASCADE;
TRUNCATE TABLE presence CASCADE;
TRUNCATE TABLE responsable CASCADE;
TRUNCATE TABLE role CASCADE;
TRUNCATE TABLE role_user CASCADE;
TRUNCATE TABLE salle CASCADE;
TRUNCATE TABLE seance CASCADE;
TRUNCATE TABLE unite_etude CASCADE;

--importation liste des unités d'études
INSERT INTO unite_etude(id, codeue, nom)VALUES (1, 'S5INPROG', 'Méthodes de programmation');
INSERT INTO unite_etude(id, codeue, nom)VALUES (2, 'S5INCOMP', 'Linéaire et compléxité');
INSERT INTO unite_etude(id, codeue, nom)VALUES (3, 'S5INDVPT', 'Développement');
INSERT INTO unite_etude(id, codeue, nom)VALUES (4, 'S5INCHOI', 'Architecture et réseaux');
INSERT INTO unite_etude(id, codeue, nom)VALUES (5, 'S5ZCSHS', 'SHS 5');
INSERT INTO unite_etude(id, codeue, nom)VALUES (6, 'S5INOUVE', 'Ouverture');
INSERT INTO unite_etude(id, codeue, nom)VALUES (7, 'S6INGLBD', 'Génie logiciel et base de données');
INSERT INTO unite_etude(id, codeue, nom)VALUES (8, 'S6INOPTI', 'Optimisation');
INSERT INTO unite_etude(id, codeue, nom)VALUES (9, 'S6INPSYS', 'Langages et systèmes');
INSERT INTO unite_etude(id, codeue, nom)VALUES (10, 'S6INPROF', 'Professionalisation');
INSERT INTO unite_etude(id, codeue, nom)VALUES (11, 'S6ZCSHS', 'SHS 6');

--importation liste des modules
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (1, 'S5IN-PRF', 'Programmation fonctionnelle', 1);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (2, 'S5IN-PRL', 'Programmation logique', 1);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (3, 'S5IN-PLI', 'Programmation linéaire', 2);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (4, 'S5IN-CPL', 'Complexité', 2);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (5, 'S5IN-POO', 'Programmation orientée objet avancée', 3);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (6, 'S5IN-DEV', 'Algorithmique et développement', 3);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (7, 'S5IN-ARC', 'Architecture', 4);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (8, 'S5IN-RES', 'Réseaux', 4);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (9, 'S5ZC-ANG', 'Anglais', 5);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (10, 'S5ZC-ACT', 'EC transversal', 5);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (11, 'S5SIPAPI', 'Programmation avancée API', 6);
INSERT INTO public.module(id, codeec, nom, unite_etude_id)VALUES (12, 'S5INANNU', 'Analyse numérique', 6);

--importation liste des formation
INSERT INTO public.formation(id, annee, diplome, titre)VALUES (1, 3, 'Licence','Informatique');
INSERT INTO public.formation(id, annee, diplome, titre)VALUES (2, 3, 'Licence','Mathématiques');
INSERT INTO public.formation(id, annee, diplome, titre)VALUES (3, 3, 'Licence','Chimie');


--importation liste des groupes
INSERT INTO public.groupe(id, td, tp, formation_id, nom)VALUES (1, 1, 1, 1, 'Apprentissage');
INSERT INTO public.groupe(id, td, tp, formation_id, nom)VALUES (2, 2, 2, 1, 'Initiale 1');
INSERT INTO public.groupe(id, td, tp, formation_id, nom)VALUES (3, 2, 3, 1, 'Initiale 2');


--importation des role_user
INSERT INTO public.role_user(id, type_user)VALUES 
(1, 'admin'),--admin
(2, 'responsable'),--responsable
(3, 'etudiant');--etudiant

--import des roles
INSERT INTO public.role(id, description, nom, role_user_id)VALUES (1, 'Privilèges des admins', 'ADMIN', 1);
INSERT INTO public.role(id, description, nom, role_user_id)VALUES (2, 'Privilèges des responsables', 'PROF', 2);
INSERT INTO public.role(id, description, nom, role_user_id)VALUES (3, 'Privilèges des étudiants', 'STUDENT', 3);


--importation liste des étudiants
INSERT INTO public.etudiant(id, mail, nom, password, prenom, role_user_id, reserve, groupe_id)VALUES 
(1, 'nicolas@etu.fr', 'NICOLAS', 'nicolas','Nicolas', 3, false, 1),
(2, 'zafitina@etu.fr', 'ZAFITINA', 'zafitina','zafitina', 3, false, 2),
(3, 'mamadou@etu.fr', 'MAMADOU', 'mamadou','mamadou', 3, false, 2),
(4, 'bah@etu.fr', 'BAH', 'bah','bah', 3, false, 3),
(5, 'theo@etu.fr', 'THEO', 'theo','theo', 3, false, 2),
(6, 'nakote@etu.fr', 'NAKOTE', 'nakote','nakote', 3, false, 3),
(7, 'mohamed@etu.fr', 'MOHAMED', 'mohamed','mohamed', 3, false, 1),
(8, 'sacko@etu.fr', 'SACKO', 'sacko','sacko', 3, false, 2),
(9, 'amine@etu.fr', 'AMINE', 'amine','amine', 3, false, 1),
(10, 'boumoussou@etu.fr', 'BOUMOUSSOU', 'boumoussou','boumoussou', 3, false, 3)
;

 
--importation liste des responsable
INSERT INTO public.responsable(id, mail, nom, password, prenom, role_user_id, reserve, formation_id)VALUES 
(11, 'kolski@prof.fr', 'kolski', 'kolski', 'kolski', 2, false, 1),
(12, 'grislin@prof.fr', 'grislin', 'grislin', 'grislin', 2, false, 1),
(13, 'bilegan@prof.fr', 'bilegan', 'bilegan', 'bilegan', 2, false, 1),
(14, 'mandiau@prof.fr', 'mandiau', 'mandiau', 'mandiau', 2, false, 1),
(15, 'adam@prof.fr', 'adam', 'adam', 'adam', 2, false, 1)
;

--import des admins
INSERT INTO public.admin(id, mail, nom, password, prenom, role_user_id)VALUES (20, 'admin@admin.fr', 'admin', 'admin', 'admin', 1);


--importation liste des batiments
INSERT INTO public.batiment(id, nom)VALUES (1, 'AB1');
INSERT INTO public.batiment(id, nom)VALUES (2, 'AB2');
INSERT INTO public.batiment(id, nom)VALUES (3, 'AB3');
INSERT INTO public.batiment(id, nom)VALUES (4, 'MATISSE');
INSERT INTO public.batiment(id, nom)VALUES (5, 'AB0');

--importation liste des salles
--les salles AB1
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (1, 004, false, 1);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (2, 102, false, 1);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (3, 005, false, 1);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (4, 202, false, 1);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (5, 204, false, 1);
--salles AB2
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (6, 100, false, 2);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (7, 175, false, 2);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (8, 114, false, 2);
--salles AB3
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (9, 104, false, 3);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (10, 106, false, 3);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (11, 111, false, 3);
--salles MATISSE
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (12, 100, false, 4);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (13, 200, false, 4);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (14, 300, false, 4);
--salles AB0
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (15, 105, false, 5);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (16, 102, false, 5);
INSERT INTO public.salle(id, numero, reserve, batiment_id)VALUES (17, 110, false, 5);














