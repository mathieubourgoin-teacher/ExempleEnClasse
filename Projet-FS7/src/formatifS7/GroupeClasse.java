package formatifS7;

/**
 * Cours 243- formatifS7
 *
 * @author Julien.Brunet
 * @since 2022-11-16
 */
public class GroupeClasse {
    public static final int MAX_ETUDIANTS = 26;

    private Etudiant[] etudiants = new Etudiant[MAX_ETUDIANTS];

    private String nom;

    //cette variable maintien le nombre d'etudiants reels pour eviter de parcourir la liste inutilement
    //Elle doit rester invisible de l'exterieur!!
    private int nombreEtudiants;

    public GroupeClasse(String nom) {
        this.nom = nom;
    }

    public void addEtudiant(Etudiant etudiant){
        if(nombreEtudiants < MAX_ETUDIANTS) {
            //on peut insérer
            etudiants[nombreEtudiants] = etudiant;
            nombreEtudiants++;
        }
        else {
            System.out.println("Impossible d'insérer " + etudiant.getNom() + " a la " + this);
        }

    }

    public void enleverEtudiant(Etudiant etudiant) {
       //Challenge implémenter ceci!!
    }



    public String[] listeNomsEtudiants(){
        String[] nonNulls = new String[nombreEtudiants];
        for (int i = 0; i < nombreEtudiants; i++) {
            nonNulls[i] = etudiants[i].getNom();
        }
        return nonNulls;
    }

    public int nombreEtudiants() {
        return nombreEtudiants;
    }

    @Override
    public String toString() {
        return "GroupeClasse{" +
                "nom='" + nom + '\'' + " avec "
                + nombreEtudiants() + " etudiants." +
                '}';
    }

}
