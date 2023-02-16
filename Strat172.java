package strategies;

import cantstop.Jeu;

/**
 * Pour chaque choix du tableau lesChoix, on calcul un score. Le calcul du score
 * a été choisi afin de privilégié dans l'ordre les colonnes dans l'ordre
 * 7, (6,8), (2, 12), (5, 9), (4, 10), (3, 11). Le score permet de prendre en
 * compte l'avancement déjà fait dans la colonne et la probabilité d'obtenir
 * cette colonne au prochain lancer.
 * 
 * Pour le choix, on privilégie un choix où l'on avance que dans des colonnes où
 * l'on a déjà un bonze placé au tour en cours.
 * Sinon on choisit un choix où l'on peut finir ou être à 1 case de finir cette
 * colonne.
 * Sinon, l'on choisit le score le plus élevé.
 * 
 * Pour le stop, tant qu'il nous reste un bonze on continue de jouer quoi qu'il
 * arrive.
 * On s'arrête de jouer si l'on a finit une colonne où le résultat de la
 * fonction calculProba avec les 3 bonzes placés en paramètre dépasse un score
 * que l'on a choisit en fonction de notre score (de la partie), du score de
 * l'autre joueur (de la partie) et le nombre de coup effectué. La seule
 * exception à cete règle est si l'on possède un bonze pour lequel on a avancé a
 * plus de la moitié de la colonne et que l'adversaire a lui aussi avancé de
 * plus de la motié de la colonne. Dans ce cas, on continue de jouer tant que
 * nous n'avons pas fini la colonne.
 * 
 * @author Gabriel Ivanes
 */

public class Strat172 implements Strategie {

  // Trie le tableau en paramètre de manière croissante
  public void triTableau(int tab[]) {
    if (tab.length == 2) {
      int tmp = 0;
      if (tab[0] > tab[1]) {
        tmp = tab[1];
        tab[1] = tab[0];
        tab[0] = tmp;
      }
    } else if (tab.length == 3) {
      int tmp = 0;
      if (tab[1] > tab[2]) {
        tmp = tab[1];
        tab[1] = tab[2];
        tab[2] = tmp;
        if (tab[0] > tab[1]) {
          tmp = tab[0];
          tab[0] = tab[1];
          tab[1] = tmp;
          if (tab[1] > tab[2]) {
            tmp = tab[1];
            tab[1] = tab[2];
            tab[2] = tmp;
          }
        }
      } else if (tab[0] > tab[1]) {
        tmp = tab[0];
        tab[0] = tab[1];
        tab[1] = tmp;
        if (tab[1] > tab[2]) {
          tmp = tab[1];
          tab[1] = tab[2];
          tab[2] = tmp;
          if (tab[0] > tab[1]) {
            tmp = tab[0];
            tab[0] = tab[1];
            tab[1] = tmp;
          }
        }
      }
    }
  }

  /**
   * Utilisée pour connaître la probabilté des bonzes que l'on a déjà
   * placé.
   * 
   * @param tab[] tableau de int
   * 
   * @return probabilité d'obtenir une ou plusieurs colonnes données en paramètre
   *         dans le tableau.
   */
  public int calculProba(int tab[]) {
    triTableau(tab);

    if (tab.length == 1) {
      switch (tab[0]) {
        case 2:
          return 13;
        case 3:
          return 23;
        case 4:
          return 36;
        case 5:
          return 46;
        case 6:
          return 56;
        case 7:
          return 64;
        case 8:
          return 56;
        case 9:
          return 46;
        case 10:
          return 36;
        case 11:
          return 23;
        case 12:
          return 13;
      }
    } else if (tab.length == 2) {
      if (tab[0] == 2 && tab[1] == 3) {
        return 32;
      } else if (tab[0] == 2 && tab[1] == 4) {
        return 44;
      } else if (tab[0] == 2 && tab[1] == 5) {
        return 53;
      } else if (tab[0] == 2 && tab[1] == 6) {
        return 63;
      } else if (tab[0] == 2 && tab[1] == 7) {
        return 71;
      } else if (tab[0] == 2 && tab[1] == 8) {
        return 67;
      } else if (tab[0] == 2 && tab[1] == 9) {
        return 56;
      } else if (tab[0] == 2 && tab[1] == 10) {
        return 47;
      } else if (tab[0] == 2 && tab[1] == 11) {
        return 36;
      } else if (tab[0] == 2 && tab[1] == 12) {
        return 26;
      } else if (tab[0] == 3 && tab[1] == 4) {
        return 47;
      } else if (tab[0] == 3 && tab[1] == 5) {
        return 53;
      } else if (tab[0] == 3 && tab[1] == 6) {
        return 64;
      } else if (tab[0] == 3 && tab[1] == 7) {
        return 71;
      } else if (tab[0] == 3 && tab[1] == 8) {
        return 68;
      } else if (tab[0] == 3 && tab[1] == 9) {
        return 64;
      } else if (tab[0] == 3 && tab[1] == 10) {
        return 56;
      } else if (tab[0] == 3 && tab[1] == 11) {
        return 45;
      } else if (tab[0] == 3 && tab[1] == 12) {
        return 36;
      } else if (tab[0] == 4 && tab[1] == 5) {
        return 61;
      } else if (tab[0] == 4 && tab[1] == 6) {
        return 72;
      } else if (tab[0] == 4 && tab[1] == 7) {
        return 77;
      } else if (tab[0] == 4 && tab[1] == 8) {
        return 75;
      } else if (tab[0] == 4 && tab[1] == 9) {
        return 68;
      } else if (tab[0] == 4 && tab[1] == 10) {
        return 67;
      } else if (tab[0] == 4 && tab[1] == 11) {
        return 56;
      } else if (tab[0] == 4 && tab[1] == 12) {
        return 47;
      } else if (tab[0] == 5 && tab[1] == 6) {
        return 73;
      } else if (tab[0] == 5 && tab[1] == 7) {
        return 78;
      } else if (tab[0] == 5 && tab[1] == 8) {
        return 77;
      } else if (tab[0] == 5 && tab[1] == 9) {
        return 69;
      } else if (tab[0] == 5 && tab[1] == 10) {
        return 68;
      } else if (tab[0] == 5 && tab[1] == 11) {
        return 64;
      } else if (tab[0] == 5 && tab[1] == 12) {
        return 56;
      } else if (tab[0] == 6 && tab[1] == 7) {
        return 84;
      } else if (tab[0] == 6 && tab[1] == 8) {
        return 82;
      } else if (tab[0] == 6 && tab[1] == 9) {
        return 77;
      } else if (tab[0] == 6 && tab[1] == 10) {
        return 75;
      } else if (tab[0] == 6 && tab[1] == 11) {
        return 68;
      } else if (tab[0] == 6 && tab[1] == 12) {
        return 67;
      } else if (tab[0] == 7 && tab[1] == 8) {
        return 84;
      } else if (tab[0] == 7 && tab[1] == 9) {
        return 78;
      } else if (tab[0] == 7 && tab[1] == 10) {
        return 77;
      } else if (tab[0] == 7 && tab[1] == 11) {
        return 71;
      } else if (tab[0] == 7 && tab[1] == 12) {
        return 71;
      } else if (tab[0] == 8 && tab[1] == 9) {
        return 73;
      } else if (tab[0] == 8 && tab[1] == 10) {
        return 72;
      } else if (tab[0] == 8 && tab[1] == 11) {
        return 64;
      } else if (tab[0] == 8 && tab[1] == 12) {
        return 63;
      } else if (tab[0] == 9 && tab[1] == 10) {
        return 61;
      } else if (tab[0] == 9 && tab[1] == 11) {
        return 53;
      } else if (tab[0] == 9 && tab[1] == 12) {
        return 53;
      } else if (tab[0] == 10 && tab[1] == 11) {
        return 47;
      } else if (tab[0] == 10 && tab[1] == 12) {
        return 44;
      } else if (tab[0] == 11 && tab[1] == 12) {
        return 32;
      }
    } else if (tab.length == 3) {
      if (tab[0] == 2 && tab[1] == 3 && tab[2] == 4) {
        return 52;
      } else if (tab[0] == 2 && tab[1] == 3 && tab[2] == 5) {
        return 58;
      } else if (tab[0] == 2 && tab[1] == 3 && tab[2] == 6) {
        return 68;
      } else if (tab[0] == 2 && tab[1] == 3 && tab[2] == 7) {
        return 75;
      } else if (tab[0] == 2 && tab[1] == 3 && tab[2] == 8) {
        return 75;
      } else if (tab[0] == 2 && tab[1] == 3 && tab[2] == 9) {
        return 71;
      } else if (tab[0] == 2 && tab[1] == 3 && tab[2] == 10) {
        return 63;
      } else if (tab[0] == 2 && tab[1] == 3 && tab[2] == 11) {
        return 52;
      } else if (tab[0] == 2 && tab[1] == 3 && tab[2] == 12) {
        return 43;
      } else if (tab[0] == 2 && tab[1] == 4 && tab[2] == 5) {
        return 65;
      } else if (tab[0] == 2 && tab[1] == 4 && tab[2] == 6) {
        return 75;
      } else if (tab[0] == 2 && tab[1] == 4 && tab[2] == 7) {
        return 80;
      } else if (tab[0] == 2 && tab[1] == 4 && tab[2] == 8) {
        return 81;
      } else if (tab[0] == 2 && tab[1] == 4 && tab[2] == 9) {
        return 75;
      } else if (tab[0] == 2 && tab[1] == 4 && tab[2] == 10) {
        return 73;
      } else if (tab[0] == 2 && tab[1] == 4 && tab[2] == 11) {
        return 63;
      } else if (tab[0] == 2 && tab[1] == 4 && tab[2] == 12) {
        return 55;
      } else if (tab[0] == 2 && tab[1] == 5 && tab[2] == 6) {
        return 77;
      } else if (tab[0] == 2 && tab[1] == 5 && tab[2] == 7) {
        return 80;
      } else if (tab[0] == 2 && tab[1] == 5 && tab[2] == 8) {
        return 82;
      } else if (tab[0] == 2 && tab[1] == 5 && tab[2] == 9) {
        return 76;
      } else if (tab[0] == 2 && tab[1] == 5 && tab[2] == 10) {
        return 75;
      } else if (tab[0] == 2 && tab[1] == 5 && tab[2] == 11) {
        return 71;
      } else if (tab[0] == 2 && tab[1] == 5 && tab[2] == 12) {
        return 63;
      } else if (tab[0] == 2 && tab[1] == 6 && tab[2] == 7) {
        return 86;
      } else if (tab[0] == 2 && tab[1] == 6 && tab[2] == 8) {
        return 88;
      } else if (tab[0] == 2 && tab[1] == 6 && tab[2] == 9) {
        return 83;
      } else if (tab[0] == 2 && tab[1] == 6 && tab[2] == 10) {
        return 81;
      } else if (tab[0] == 2 && tab[1] == 6 && tab[2] == 11) {
        return 75;
      } else if (tab[0] == 2 && tab[1] == 6 && tab[2] == 12) {
        return 73;
      } else if (tab[0] == 2 && tab[1] == 7 && tab[2] == 8) {
        return 89;
      } else if (tab[0] == 2 && tab[1] == 7 && tab[2] == 9) {
        return 83;
      } else if (tab[0] == 2 && tab[1] == 7 && tab[2] == 10) {
        return 83;
      } else if (tab[0] == 2 && tab[1] == 7 && tab[2] == 11) {
        return 77;
      } else if (tab[0] == 2 && tab[1] == 7 && tab[2] == 12) {
        return 78;
      } else if (tab[0] == 2 && tab[1] == 8 && tab[2] == 9) {
        return 82;
      } else if (tab[0] == 2 && tab[1] == 8 && tab[2] == 10) {
        return 81;
      } else if (tab[0] == 2 && tab[1] == 8 && tab[2] == 11) {
        return 73;
      } else if (tab[0] == 2 && tab[1] == 8 && tab[2] == 12) {
        return 73;
      } else if (tab[0] == 2 && tab[1] == 9 && tab[2] == 10) {
        return 71;
      } else if (tab[0] == 2 && tab[1] == 9 && tab[2] == 11) {
        return 63;
      } else if (tab[0] == 2 && tab[1] == 9 && tab[2] == 12) {
        return 63;
      } else if (tab[0] == 2 && tab[1] == 10 && tab[2] == 11) {
        return 57;
      } else if (tab[0] == 2 && tab[1] == 10 && tab[2] == 12) {
        return 55;
      } else if (tab[0] == 2 && tab[1] == 11 && tab[2] == 12) {
        return 43;
      } else if (tab[0] == 3 && tab[1] == 4 && tab[2] == 5) {
        return 66;
      } else if (tab[0] == 3 && tab[1] == 4 && tab[2] == 6) {
        return 74;
      } else if (tab[0] == 3 && tab[1] == 4 && tab[2] == 7) {
        return 79;
      } else if (tab[0] == 3 && tab[1] == 4 && tab[2] == 8) {
        return 79;
      } else if (tab[0] == 3 && tab[1] == 4 && tab[2] == 9) {
        return 77;
      } else if (tab[0] == 3 && tab[1] == 4 && tab[2] == 10) {
        return 75;
      } else if (tab[0] == 3 && tab[1] == 4 && tab[2] == 11) {
        return 65;
      } else if (tab[0] == 3 && tab[1] == 4 && tab[2] == 12) {
        return 57;
      } else if (tab[0] == 3 && tab[1] == 5 && tab[2] == 6) {
        return 77;
      } else if (tab[0] == 3 && tab[1] == 5 && tab[2] == 7) {
        return 78;
      } else if (tab[0] == 3 && tab[1] == 5 && tab[2] == 8) {
        return 80;
      } else if (tab[0] == 3 && tab[1] == 5 && tab[2] == 9) {
        return 77;
      } else if (tab[0] == 3 && tab[1] == 5 && tab[2] == 10) {
        return 75;
      } else if (tab[0] == 3 && tab[1] == 5 && tab[2] == 11) {
        return 71;
      } else if (tab[0] == 3 && tab[1] == 5 && tab[2] == 12) {
        return 63;
      } else if (tab[0] == 3 && tab[1] == 6 && tab[2] == 7) {
        return 86;
      } else if (tab[0] == 3 && tab[1] == 6 && tab[2] == 8) {
        return 85;
      } else if (tab[0] == 3 && tab[1] == 6 && tab[2] == 9) {
        return 82;
      } else if (tab[0] == 3 && tab[1] == 6 && tab[2] == 10) {
        return 82;
      } else if (tab[0] == 3 && tab[1] == 6 && tab[2] == 11) {
        return 75;
      } else if (tab[0] == 3 && tab[1] == 6 && tab[2] == 12) {
        return 73;
      } else if (tab[0] == 3 && tab[1] == 7 && tab[2] == 8) {
        return 89;
      } else if (tab[0] == 3 && tab[1] == 7 && tab[2] == 9) {
        return 84;
      } else if (tab[0] == 3 && tab[1] == 7 && tab[2] == 10) {
        return 83;
      } else if (tab[0] == 3 && tab[1] == 7 && tab[2] == 11) {
        return 77;
      } else if (tab[0] == 3 && tab[1] == 7 && tab[2] == 12) {
        return 77;
      } else if (tab[0] == 3 && tab[1] == 8 && tab[2] == 9) {
        return 83;
      } else if (tab[0] == 3 && tab[1] == 8 && tab[2] == 10) {
        return 83;
      } else if (tab[0] == 3 && tab[1] == 8 && tab[2] == 11) {
        return 75;
      } else if (tab[0] == 3 && tab[1] == 8 && tab[2] == 12) {
        return 75;
      } else if (tab[0] == 3 && tab[1] == 9 && tab[2] == 10) {
        return 77;
      } else if (tab[0] == 3 && tab[1] == 9 && tab[2] == 11) {
        return 71;
      } else if (tab[0] == 3 && tab[1] == 9 && tab[2] == 12) {
        return 71;
      } else if (tab[0] == 3 && tab[1] == 10 && tab[2] == 11) {
        return 65;
      } else if (tab[0] == 3 && tab[1] == 10 && tab[2] == 12) {
        return 63;
      } else if (tab[0] == 3 && tab[1] == 11 && tab[2] == 12) {
        return 52;
      } else if (tab[0] == 4 && tab[1] == 5 && tab[2] == 6) {
        return 79;
      } else if (tab[0] == 4 && tab[1] == 5 && tab[2] == 7) {
        return 84;
      } else if (tab[0] == 4 && tab[1] == 5 && tab[2] == 8) {
        return 84;
      } else if (tab[0] == 4 && tab[1] == 5 && tab[2] == 9) {
        return 79;
      } else if (tab[0] == 4 && tab[1] == 5 && tab[2] == 10) {
        return 82;
      } else if (tab[0] == 4 && tab[1] == 5 && tab[2] == 11) {
        return 77;
      } else if (tab[0] == 4 && tab[1] == 5 && tab[2] == 12) {
        return 71;
      } else if (tab[0] == 4 && tab[1] == 6 && tab[2] == 7) {
        return 88;
      } else if (tab[0] == 4 && tab[1] == 6 && tab[2] == 8) {
        return 91;
      } else if (tab[0] == 4 && tab[1] == 6 && tab[2] == 9) {
        return 86;
      } else if (tab[0] == 4 && tab[1] == 6 && tab[2] == 10) {
        return 88;
      } else if (tab[0] == 4 && tab[1] == 6 && tab[2] == 11) {
        return 83;
      } else if (tab[0] == 4 && tab[1] == 6 && tab[2] == 12) {
        return 81;
      } else if (tab[0] == 4 && tab[1] == 7 && tab[2] == 8) {
        return 90;
      } else if (tab[0] == 4 && tab[1] == 7 && tab[2] == 9) {
        return 89;
      } else if (tab[0] == 4 && tab[1] == 7 && tab[2] == 10) {
        return 87;
      } else if (tab[0] == 4 && tab[1] == 7 && tab[2] == 11) {
        return 83;
      } else if (tab[0] == 4 && tab[1] == 7 && tab[2] == 12) {
        return 83;
      } else if (tab[0] == 4 && tab[1] == 8 && tab[2] == 9) {
        return 86;
      } else if (tab[0] == 4 && tab[1] == 8 && tab[2] == 10) {
        return 88;
      } else if (tab[0] == 4 && tab[1] == 8 && tab[2] == 11) {
        return 82;
      } else if (tab[0] == 4 && tab[1] == 8 && tab[2] == 12) {
        return 81;
      } else if (tab[0] == 4 && tab[1] == 9 && tab[2] == 10) {
        return 82;
      } else if (tab[0] == 4 && tab[1] == 9 && tab[2] == 11) {
        return 75;
      } else if (tab[0] == 4 && tab[1] == 9 && tab[2] == 12) {
        return 75;
      } else if (tab[0] == 4 && tab[1] == 10 && tab[2] == 11) {
        return 75;
      } else if (tab[0] == 4 && tab[1] == 10 && tab[2] == 12) {
        return 73;
      } else if (tab[0] == 4 && tab[1] == 11 && tab[2] == 12) {
        return 63;
      } else if (tab[0] == 5 && tab[1] == 6 && tab[2] == 7) {
        return 88;
      } else if (tab[0] == 5 && tab[1] == 6 && tab[2] == 8) {
        return 89;
      } else if (tab[0] == 5 && tab[1] == 6 && tab[2] == 9) {
        return 86;
      } else if (tab[0] == 5 && tab[1] == 6 && tab[2] == 10) {
        return 86;
      } else if (tab[0] == 5 && tab[1] == 6 && tab[2] == 11) {
        return 83;
      } else if (tab[0] == 5 && tab[1] == 6 && tab[2] == 12) {
        return 82;
      } else if (tab[0] == 5 && tab[1] == 7 && tab[2] == 8) {
        return 91;
      } else if (tab[0] == 5 && tab[1] == 7 && tab[2] == 9) {
        return 85;
      } else if (tab[0] == 5 && tab[1] == 7 && tab[2] == 10) {
        return 89;
      } else if (tab[0] == 5 && tab[1] == 7 && tab[2] == 11) {
        return 84;
      } else if (tab[0] == 5 && tab[1] == 7 && tab[2] == 12) {
        return 83;
      } else if (tab[0] == 5 && tab[1] == 8 && tab[2] == 9) {
        return 86;
      } else if (tab[0] == 5 && tab[1] == 8 && tab[2] == 10) {
        return 86;
      } else if (tab[0] == 5 && tab[1] == 8 && tab[2] == 11) {
        return 82;
      } else if (tab[0] == 5 && tab[1] == 8 && tab[2] == 12) {
        return 83;
      } else if (tab[0] == 5 && tab[1] == 9 && tab[2] == 10) {
        return 79;
      } else if (tab[0] == 5 && tab[1] == 9 && tab[2] == 11) {
        return 77;
      } else if (tab[0] == 5 && tab[1] == 9 && tab[2] == 12) {
        return 76;
      } else if (tab[0] == 5 && tab[1] == 10 && tab[2] == 11) {
        return 77;
      } else if (tab[0] == 5 && tab[1] == 10 && tab[2] == 12) {
        return 75;
      } else if (tab[0] == 5 && tab[1] == 11 && tab[2] == 12) {
        return 71;
      } else if (tab[0] == 6 && tab[1] == 7 && tab[2] == 8) {
        return 92;
      } else if (tab[0] == 6 && tab[1] == 7 && tab[2] == 9) {
        return 91;
      } else if (tab[0] == 6 && tab[1] == 7 && tab[2] == 10) {
        return 90;
      } else if (tab[0] == 6 && tab[1] == 7 && tab[2] == 11) {
        return 89;
      } else if (tab[0] == 6 && tab[1] == 7 && tab[2] == 12) {
        return 89;
      } else if (tab[0] == 6 && tab[1] == 8 && tab[2] == 9) {
        return 89;
      } else if (tab[0] == 6 && tab[1] == 8 && tab[2] == 10) {
        return 91;
      } else if (tab[0] == 6 && tab[1] == 8 && tab[2] == 11) {
        return 85;
      } else if (tab[0] == 6 && tab[1] == 8 && tab[2] == 12) {
        return 88;
      } else if (tab[0] == 6 && tab[1] == 9 && tab[2] == 10) {
        return 84;
      } else if (tab[0] == 6 && tab[1] == 9 && tab[2] == 11) {
        return 80;
      } else if (tab[0] == 6 && tab[1] == 9 && tab[2] == 12) {
        return 82;
      } else if (tab[0] == 6 && tab[1] == 10 && tab[2] == 11) {
        return 79;
      } else if (tab[0] == 6 && tab[1] == 10 && tab[2] == 12) {
        return 81;
      } else if (tab[0] == 6 && tab[1] == 11 && tab[2] == 12) {
        return 75;
      } else if (tab[0] == 7 && tab[1] == 8 && tab[2] == 9) {
        return 88;
      } else if (tab[0] == 7 && tab[1] == 8 && tab[2] == 10) {
        return 88;
      } else if (tab[0] == 7 && tab[1] == 8 && tab[2] == 11) {
        return 86;
      } else if (tab[0] == 7 && tab[1] == 8 && tab[2] == 12) {
        return 86;
      } else if (tab[0] == 7 && tab[1] == 9 && tab[2] == 10) {
        return 84;
      } else if (tab[0] == 7 && tab[1] == 9 && tab[2] == 11) {
        return 78;
      } else if (tab[0] == 7 && tab[1] == 9 && tab[2] == 12) {
        return 80;
      } else if (tab[0] == 7 && tab[1] == 10 && tab[2] == 11) {
        return 79;
      } else if (tab[0] == 7 && tab[1] == 10 && tab[2] == 12) {
        return 80;
      } else if (tab[0] == 7 && tab[1] == 11 && tab[2] == 12) {
        return 75;
      } else if (tab[0] == 8 && tab[1] == 9 && tab[2] == 10) {
        return 79;
      } else if (tab[0] == 8 && tab[1] == 9 && tab[2] == 11) {
        return 77;
      } else if (tab[0] == 8 && tab[1] == 9 && tab[2] == 12) {
        return 77;
      } else if (tab[0] == 8 && tab[1] == 10 && tab[2] == 11) {
        return 74;
      } else if (tab[0] == 8 && tab[1] == 10 && tab[2] == 12) {
        return 75;
      } else if (tab[0] == 8 && tab[1] == 11 && tab[2] == 12) {
        return 68;
      } else if (tab[0] == 9 && tab[1] == 10 && tab[2] == 11) {
        return 66;
      } else if (tab[0] == 9 && tab[1] == 10 && tab[2] == 12) {
        return 65;
      } else if (tab[0] == 9 && tab[1] == 11 && tab[2] == 12) {
        return 58;
      } else if (tab[0] == 10 && tab[1] == 11 && tab[2] == 12) {
        return 52;
      }
    }
    return 0;
  }

  /**
   * Utilisée pour connaître quel est "le meilleur choix" parmi les choix du
   * tableau lesChoix.
   * 
   * 
   * @param j
   * @param s1 j.getLesChoix[i][0]
   * @param s2 j.getLesChoix[i][0]
   * 
   * @return Le résultat du choix de l'indice i
   */
  public double strategieChoix(Jeu j, int s1, int s2) {

    boolean queChoixDouble = true;
    boolean pluDeBonze = true;
    double tmp = 0;

    // Permet de savoir si l'on a placé ou non tout nos bonzes.
    if (j.getBonzesRestants() > 0) {
      pluDeBonze = false;
    }

    /**
     * Permet de savoir si parmis tous les choix du tableau lesChoix, tous les choix
     * sont des choix doubles différents par exemple :
     * {4, 7}
     * {6, 5}
     * {3, 8}
     */
    for (int i = 0; i < j.getNbChoix(); i++) {
      if ((j.getLesChoix()[i][1] == 0) || (j.getLesChoix()[i][0] == j.getLesChoix()[i][1])) {
        queChoixDouble = false;
      }
    }

    // Vérifie si l'élément en colonne 1 du tableau lesChoix est vide ou non
    if (s2 != 0) {

      int indexBonze[] = new int[2];

      double taux = 0;
      double taux1 = 0;
      double taux2 = 0;

      indexBonze[0] = 3;
      indexBonze[1] = 3;

      /**
       * Vérifie si les sommes de dé en colonne [i][0] et [i][1] du tableau lesChoix
       * sont identiques
       */
      if (s1 == s2) {

        /**
         * Permet de savoir si l'on a déjà avancé dans la colonne du choix double
         * identique.
         * Si le tableau indexBonze est différent de 3 (qui est choisi car 3 ne peux pas
         * être un index du tableau Bonzes) alors c'est que l'on a déjà avancé dans la
         * colonne.
         */
        for (int i = 0; i < 3; i++) {

          if (j.getBonzes()[i][0] == s1) {
            indexBonze[0] = i;
            indexBonze[1] = i;
          }
        }

        /**
         * Si s1 est dans le tableau de Bonze (et donc s2 aussi) on utilise le tableau
         * de Bonze pour calculer le taux
         */
        if (indexBonze[0] != 3) {

          /**
           * Permet de connaître l'avancement que l'on gagnerait à avancer dans une
           * colonne.
           * Par exemple si l'on avance de 1 case dans la colonne 3 alors on avance de
           * 1/5
           */
          taux = 1.0 / (j.getMaximum()[s1 - 2] - (j.getBonzes()[indexBonze[0]][1]));

          int tmpTab[] = new int[1];
          tmpTab[0] = s1;

          /**
           * Si l'on peut finir une colonne ou être à 1 case de la finir alors on retourne
           * notre taux * 2 pour que le poids de notre score soit plus fort étant donné
           * que le choix i est un choix double.
           * Sinon, l'on retourne l'on retourne 2 * (163 * taux + calculProba(tmpTab)).
           * 163 * taux + calculProba(tmpTab) permet de prendre en compte notre avancement
           * dans la colonne en question et sa probabilité d'être une somme de 2 dés au
           * prochain lancer. L'on mutiplie le taux par 163 pour que si l'on a avancé dans
           * aucune des colonnes du tableau lesChoix, les colonnes choisies soient dans
           * l'ordre 7, (6, 8), (2, 12), (5, 9), (4, 10), (3, 11)
           * On mutiplie encore le résultat par 2 pour lui donner plus de poids toujours
           * pour la même raison
           */
          if ((taux * 2 == 1) || (taux * 2 == 0.5)) {
            tmp = taux * 2;
          } else {
            tmp = 2 * (163 * taux + calculProba(tmpTab));
          }
        }
        // Si s1 n'est pas dans le tableau de Bonze (et donc s2 non plus) on utilise
        // l'avancement du joueur en cours pour calculer le taux
        else {
          taux = 1.0 /
              (j.getMaximum()[s1 - 2] - (j.avancementJoueurEnCours()[s1 - 2]));

          int tmpTab[] = new int[1];
          tmpTab[0] = s1;

          /**
           * Idem que au-dessus
           */
          if ((taux * 2 == 1) || (taux * 2 == 0.5)) {
            tmp = taux * 2;
          } else {
            tmp = 2 * (163 * taux + calculProba(tmpTab));
          }
        }
      }
      // Si s1 est différent de s2 mais s2 non nulle
      else {

        double tmp1 = 0;
        double tmp2 = 0;

        int tmpTab1[] = new int[1];
        int tmpTab2[] = new int[1];

        tmpTab1[0] = s1;
        tmpTab2[0] = s2;

        /**
         * Idem que si s1 et s2 sont identiques
         */
        for (int i = 0; i < 3; i++) {
          if (j.getBonzes()[i][0] == s1) {
            indexBonze[0] = i;
          } else if (j.getBonzes()[i][0] == s2) {
            indexBonze[1] = i;
          }
        }

        // Si s1 et s2 sont dans le tableau de Bonze
        if (indexBonze[0] != 3 && indexBonze[1] != 3) {
          taux1 = 1.0 / (j.getMaximum()[s1 - 2] - (j.getBonzes()[indexBonze[0]][1]));
          taux2 = 1.0 / (j.getMaximum()[s2 - 2] - (j.getBonzes()[indexBonze[1]][1]));

          tmp1 = 163 * taux1 + calculProba(tmpTab1);
          tmp2 = 163 * taux2 + calculProba(tmpTab2);

          /**
           * Si l'on peut finir la colonne en [i][0] ou être à 1 case de la finir alors on
           * retourne notre taux
           */
          if ((taux1 == 1) || (taux1 == 0.5)) {
            tmp = taux1;
          }

          /**
           * Si l'on peut finir la colonne en [i][1] ou être à 1 case de la finir alors on
           * retourne notre taux
           */
          else if ((taux2 == 1) || (taux2 == 0.5)) {
            tmp = taux2;
          }

          /**
           * Si tous les choix sont doubles, on additionne le score des 2 colonnes.
           */
          else if (queChoixDouble) {
            tmp = tmp1 + tmp2;
          }

          /**
           * Si l'on a placé tous nos bonzes, on additionne aussi le score des 2 colonnes.
           */

          else if (pluDeBonze) {
            tmp = tmp1 + tmp2;
          }

          /**
           * Si le score de la colonne 1 est plus élevé que celui de la colonne 2 alors on
           * prend ce score pour le choix.
           * Sinon on prend le score de la colonne 2.
           */
          else if (tmp1 > tmp2) {
            tmp = tmp1;
          }

          else if (tmp1 < tmp2) {
            tmp = tmp2;
          }
        }

        // Si s1 est dans le tableau de Bonze mais pas s2
        else if (indexBonze[0] != 3 && indexBonze[1] == 3) {

          taux1 = 1.0 / (j.getMaximum()[s1 - 2] - (j.getBonzes()[indexBonze[0]][1]));
          taux2 = 1.0 /
              (j.getMaximum()[s2 - 2] - (j.avancementJoueurEnCours()[s2 - 2]));

          tmp1 = 163 * taux1 + calculProba(tmpTab1);
          tmp2 = 163 * taux2 + calculProba(tmpTab2);

          /**
           * Idem que au-dessus
           */
          if ((taux1 == 1) || (taux1 == 0.5)) {
            tmp = taux1;
          }

          else if ((taux2 == 1) || (taux2 == 0.5)) {
            tmp = taux2;
          }

          else if (queChoixDouble) {
            tmp = tmp1 + tmp2;
          }

          else if (tmp1 > tmp2) {
            tmp = tmp1;
          }

          else if (tmp1 < tmp2) {
            tmp = tmp2;
          }
        }

        // Si s1 n'est pas dans le tableau de Bonze mais s2 oui
        else if (indexBonze[0] == 3 && indexBonze[1] != 3) {
          taux1 = 1.0 /
              (j.getMaximum()[s1 - 2] - (j.avancementJoueurEnCours()[s1 - 2]));
          taux2 = 1.0 / (j.getMaximum()[s2 - 2] - (j.getBonzes()[indexBonze[1]][1]));

          tmp1 = 163 * taux1 + calculProba(tmpTab1);
          tmp2 = 163 * taux2 + calculProba(tmpTab2);

          /**
           * Idem que au-dessus
           */
          if ((taux1 == 1) || (taux1 == 0.5)) {
            tmp = taux1;
          }

          else if ((taux2 == 1) || (taux2 == 0.5)) {
            tmp = taux2;
          }

          else if (queChoixDouble) {
            tmp = tmp1 + tmp2;
          }

          else if (tmp1 > tmp2) {
            tmp = tmp1;
          }

          else if (tmp1 < tmp2) {
            tmp = tmp2;
          }
        }

        // Si ni s1 ni s2 sont dans le tableau de Bonze
        else {
          taux1 = 1.0 /
              (j.getMaximum()[s1 - 2] - (j.avancementJoueurEnCours()[s1 - 2]));
          taux2 = 1.0 /
              (j.getMaximum()[s2 - 2] - (j.avancementJoueurEnCours()[s2 - 2]));

          tmp1 = 163 * taux1 + calculProba(tmpTab1);
          tmp2 = 163 * taux2 + calculProba(tmpTab2);

          /**
           * Idem que au-dessus
           */
          if ((taux1 == 1) || (taux1 == 0.5)) {
            tmp = taux1;
          }

          else if ((taux2 == 1) || (taux2 == 0.5)) {
            tmp = taux2;
          }

          else if (queChoixDouble) {
            tmp = tmp1 + tmp2;
          }

          else if (tmp1 > tmp2) {
            tmp = tmp1;
          }

          else if (tmp1 < tmp2) {
            tmp = tmp2;
          }
        }
      }
    }

    // Si s2 est nulle
    else {

      int indexBonze = 3;
      double taux = 0;

      int tmpTab[] = new int[1];
      tmpTab[0] = s1;

      /**
       * On vérifie si s1 est dans le tableau de bonzes.
       */
      for (int i = 0; i < 3; i++) {
        if (j.getBonzes()[i][0] == s1) {
          indexBonze = i;
        }
      }

      if (indexBonze != 3) {
        taux = 1.0 / (j.getMaximum()[s1 - 2] - (j.getBonzes()[indexBonze][1]));

        if ((taux == 1) || (taux == 0.5)) {
          tmp = taux;
        } else {
          tmp = 163 * taux + calculProba(tmpTab);
        }

      } else {
        taux = 1.0 /
            (j.getMaximum()[s1 - 2] - (j.avancementJoueurEnCours()[s1 - 2]));

        if ((taux == 1) || (taux == 0.5)) {
          tmp = taux;
        } else {
          tmp = 163 * taux + calculProba(tmpTab);
        }
      }
    }
    return tmp;
  }

  /**
   * 1. Si on peut prendre un choix où l'on avancerait que sur des bonzes déjà
   * placés et qu'il nous en reste au moins 1 alors on choisit ce choix)
   * 2. On choisit le choix où l'on a le meilleur score avec la fonction
   * strategieChoix.
   * 
   * @param j
   * 
   * @return le numéro du choix choisi
   */
  public int choix(Jeu j) {

    int resUnique = 0;
    int resDouble = 0;

    int colonneTmp[] = new int[2];
    int colonneRes[] = new int[2];

    int colonneTmpUnique[] = new int[1];
    int colonneResUnique[] = new int[1];

    if ((j.getBonzesRestants() == 1) || (j.getBonzesRestants() == 2)) {
      for (int i = 0; i < j.getNbChoix(); i++) {

        if (j.getLesChoix()[i][1] != 0) {

          colonneTmp[0] = j.getLesChoix()[i][0];
          colonneTmp[1] = j.getLesChoix()[i][1];

          if ((j.getLesChoix()[i][0] == j.getBonzes()[0][0])
              && ((j.getLesChoix()[i][1] == j.getBonzes()[0][0])
                  || (j.getLesChoix()[i][1] == j.getBonzes()[1][0])
                  || (j.getLesChoix()[i][1] == j.getBonzes()[2][0]))) {

            if (colonneRes[0] == 0) {

              resDouble = i;
              colonneRes[0] = colonneTmp[0];
              colonneRes[1] = colonneTmp[1];

            } else if ((strategieChoix(j, colonneTmp[0], colonneTmp[1]) > strategieChoix(j,
                colonneRes[0], colonneRes[1]))) {

              resDouble = i;
              colonneRes[0] = colonneTmp[0];
              colonneRes[1] = colonneTmp[1];
            }
          }
        } else {

          colonneTmpUnique[0] = j.getLesChoix()[i][0];

          if ((j.getLesChoix()[i][0] == j.getBonzes()[0][0]) || (j.getLesChoix()[i][0] == j.getBonzes()[1][0])
              || (j.getLesChoix()[i][0] == j.getBonzes()[2][0])) {

            if (colonneResUnique[0] == 0) {

              resUnique = i;
              colonneResUnique[0] = colonneTmpUnique[0];

            } else if ((strategieChoix(j, colonneTmpUnique[0], j.getLesChoix()[i][1]) > strategieChoix(
                j, colonneResUnique[0], j.getLesChoix()[i][1]))) {

              resUnique = i;
              colonneResUnique[0] = colonneTmpUnique[0];

            }
          }
        }
      }

      if (colonneRes[0] != 0) {
        return resDouble;
      } else if (colonneRes[0] != 0) {
        return resUnique;
      }
    }

    int res = 0;
    double maxTaux = 0;

    // Choisi le choix où le taux d'avancement pour la ligne est le meilleur
    for (int i = 0; i < j.getNbChoix(); i++) {
      double taux = strategieChoix(
          j,
          j.getLesChoix()[i][0],
          j.getLesChoix()[i][1]);
      if ((i == 0)) {
        maxTaux = taux;
        res = i;
      } else if (taux == 1) {
        maxTaux = taux;
        res = i;
      } else if ((maxTaux != 1) && (taux == 0.5)) {
        maxTaux = taux;
        res = i;
      } else if ((taux > maxTaux) && (maxTaux != 1) && (maxTaux != 0.5)) {
        maxTaux = taux;
        res = i;
      }
    }
    return res;
  }

  /**
   * 
   * @param j
   * @param colonne
   * @return le nombre de case qu'il manque au joueur adversaire pour finir la
   *         colonne en paramètre
   */
  public int resteAAvancerAdversaire(Jeu j, int colonne) {
    int res = j.getMaximum()[colonne - 2] - j.avancementAutreJoueur()[colonne - 2];
    return res;
  }

  /**
   * 
   * @param j
   * @param colonne
   * @return Le nombre de case qu'il nous manque pour finir la colonne en
   *         paramètre
   */
  public int resteAAvancer(Jeu j, int colonne) {
    int res = 0;
    if (j.getBonzes()[0][0] == colonne) {
      res = j.getMaximum()[colonne - 2] - j.getBonzes()[0][1];
    } else if (j.getBonzes()[1][0] == colonne) {
      res = j.getMaximum()[colonne - 2] - j.getBonzes()[1][1];
    } else if (j.getBonzes()[2][0] == colonne) {
      res = j.getMaximum()[colonne - 2] - j.getBonzes()[2][1];
    } else {
      res = j.getMaximum()[colonne - 2] - j.avancementJoueurEnCours()[colonne - 2];
    }
    return res;
  }

  /**
   * @param j le jeu
   * @return
   *         vrai si :
   *         1. l'on a plus de bonze et une colonne bloquée.
   *         2. Si le résultat de la fonction calculProba() avec nos bonzes placés
   *         dépasse un certain score
   *         faux si :
   *         1. S'il reste moins de la moitié des cases à avancer dans une colonne
   *         à mon adversaire et que j'ai un bonze placé dans cette colonne aussi
   *         a plus de la moitié de la colonne
   *         2. S'il nous reste au moins 1 bonze
   * 
   */
  public boolean stop(Jeu j) {
    // Si l'on a atteint la fin d'une colonne et que l'on a plus de Bonze on
    // s'arrête
    for (int i = 0; i < 11; i++) {
      if (j.getBloque()[i] == true && j.getBonzesRestants() == 0) {
        return true;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (j.getBonzes()[i][0] != 0) {
        if ((resteAAvancerAdversaire(j,
            j.getBonzes()[i][0]) < ((1.0 / 2.0) * j.getMaximum()[j.getBonzes()[i][0] - 2]))
            && (resteAAvancer(j,
                j.getBonzes()[i][0]) < ((1.0 / 2.0) * j.getMaximum()[j.getBonzes()[i][0] - 2]))) {
          return false;
        }
      }
    }

    // Si l'on a plus de Bonze
    if (j.getBonzesRestants() == 0) {
      int tmpTab[] = new int[3];
      int probaMin = 60;

      if (j.scoreAutreJoueur() > j.scoreJoueurEnCours()) {
        probaMin = 50;
      } else if (j.scoreJoueurEnCours() > j.scoreAutreJoueur()) {
        probaMin = 70;
      }

      tmpTab[0] = j.getBonzes()[0][0];
      tmpTab[1] = j.getBonzes()[1][0];
      tmpTab[2] = j.getBonzes()[2][0];

      int comparaisonProba = probaMin + (j.getNbCoup() * 2);
      if (calculProba(tmpTab) < comparaisonProba) {
        return true;
      } else {
        return false;
      }
    }
    // S'il nous reste au moins 1 bonze, on continue
    else {
      return false;
    }
  }

  /**
   * @return vos noms
   */
  public String getName() {
    return "GABRIEL IVANES";
  }
}
