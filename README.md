# Can-t-stop-IA

Projet d'IA dans le cadre de ma première année de formation d'ingénieur.

Thème : Créer une IA pour le jeu can't stop.

Le plateau ainsi que les modalités du jeu ont été créés par mon professeur.

Les différentes fonctions que je pouvais appeler étaient : 

  - getBonzesRestants : retourne le nombre de Bonze qu'il me reste à jouer.
  - getNbChoix : retourne le nombre de choix possibles pour le tour en cours.
  - getLesChoix : matrice permettant d'avoir toutes les possibilités d'assemblage de dés pour le tour en cours. Si pour un assemblage de dé, il n'y a qu'une seule possibilité alors la deuxième colonne prend un 0.
  - getBonzes : matrice permettant d'avoir le numéro de la colonne où nous avons posé un bonze et notre avancement.
  - getMaximum : tableau permettant de connaître le maximum de chaque colonne.
  - avancementJoueurEnCours : tableau permettant de connaître l'avancement que l'on a sur chaque colonne au début de notre tour.
  - avancementAutreJoueur : tableau permettant de connaître l'avancement de notre adversaire sur chaque colonne.
  - getBloque : tableau permettant de savoir si l'on est arrivé à la fin d'une colonne durant notre tour.
  - scoreAutreJoueur : retourne le nombre de colonnes prises et validées par l'adversaire.
  - scoreJoueurEnCours : retourne le nombre de colonnes prises et validées par nous.
  - getNbCoup : retourne le nombre de tours que l'on a effectué.

Les deux fonctions appelées à chaque tour étaient : 
  - choix : qui permettait de donner le numéro du choix choisi.
  - stop : qui permettait de savoir si on continuait de jouer ou non.

