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
INSERT INTO public.groupe(id, td, tp, formation_id)VALUES (1, 1, 1, 1);
INSERT INTO public.groupe(id, td, tp, formation_id)VALUES (2, 2, 2, 1);
INSERT INTO public.groupe(id, td, tp, formation_id)VALUES (3, 2, 3, 1);
INSERT INTO public.groupe(id, td, tp, formation_id)VALUES (4, 3, 4, 1);
INSERT INTO public.groupe(id, td, tp, formation_id)VALUES (5, 4, 5, 1);


--importation des roles
INSERT INTO public.role_user(id, type_user)VALUES 
(1, 'admin'),--admin
(2, 'responsable'),--responsable
(3, 'etudiant');--etudiant

--importation liste des étudiants
INSERT INTO public.etudiant(id, mail, nom, password, prenom, role_user_id, reserve, groupe_id)VALUES 
(1, 'nicolas.zafitina@mail.fr', 'ZAFITINA', 'nicolas','Nicolas', 3, false, 1);





--importation liste des responsable












