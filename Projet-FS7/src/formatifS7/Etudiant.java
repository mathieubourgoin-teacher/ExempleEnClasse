package formatifS7;

/**
 * Cours 243- formatifS7
 *
 * @author Julien.Brunet
 * @since 2022-11-11
 */
public class Etudiant {

    /* Les constantes de la classe étudiant     */
    public static final String INFORMATIQUE = "Informatique-DEC";
    public static final String REGION = "Quebec";
    public static final String LETTRES = "Lettres";
    public static final String SPORT = "Sport";
    public static final String DEFAULT_PROGRAMME = SPORT;
    public static final int DEFAULT_SESSION = 1;
    public static final int DERNIERE_SESSION = 6;

    /* Les attributes d'un étudiant     */

    private String nom;

    private String programme = DEFAULT_PROGRAMME;


    private int session = DEFAULT_SESSION;

    /* les constructeurs*/

    /**
     * Constructeur qui initialise un étudiant.
     * Si la programme est invalide on le met en sport
     * on le met en premiere
     *
     * @param nom       son nom
     * @param programme son programme (sport si invalide)
     */
    public Etudiant(String nom, String programme) {
        this.nom = nom;
        setProgramme(programme);
        setSession(DEFAULT_SESSION);
    }

    /**
     * Constructeur qui initialise un étudiant en premeire session
     * et en programme par defaut
     *
     * @param nom       son nom

     */
    public Etudiant(String nom) {
        this(nom,DEFAULT_PROGRAMME);
    }

    /**
     * accesseur sur le nom
     *
     * @return le nom de l'etudiant
     */
    public String getNom() {
        return nom;
    }

    /**
     * mutateur sur le nom  ne doit pas etre accessible de l'extérieur
     *
     * @param nom le nouveau nom
     */
    private void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * accesseur sur le programme
     *
     * @return le programme de l'etudiant
     */
    public String getProgramme() {
        return programme;
    }

    /**
     * Change le programme si c'est possible
     *
     * @param programme le nouvveau
     */
    public void setProgramme(String programme) {
        if (programmeEstValide(programme)) {
            this.programme = programme;
        }
    }

    /**
     * accesseur sur la session
     *
     * @return le session de l'etudiant
     */
    public int getSession() {
        return session;
    }

    /**
     * change la session, ne doit pas etre accessibke de l'extérieur
     *
     * @param session
     */
    private void setSession(int session) {
        if (sessionEstValide(session)) {
            this.session = session;
        }
    }

    /**
     * Valide si la session est un programme existant
     *
     * @param session la session a valider
     * @return true si la session existe
     */
    private boolean sessionEstValide(int session) {
        return 1 <= session && session <= DERNIERE_SESSION;
    }

    /**
     * Valide si le programme est un programme existant
     *
     * @param programme le programme a valider
     * @return true si le programme
     */
    private boolean programmeEstValide(String programme) {
        boolean valide = false;
        if (programme != null) {
            valide = programme.equals(INFORMATIQUE) || programme.equals(LETTRES) || programme.equals(SPORT);
        }
        return valide;
    }

    /**
     * Faire passer l'étudiant à la session suivante si cela est possible
     * le laisse en derniere sinon
     */
    public void changerSession() {
        setSession(session + 1);
        //TODO implémenter la diplomation
    }

    @Override
    public String toString() {

        String description = "Etudiant{" +
                "nom='" + nom + '\'' +
                ", programme='" + programme + '\'' +
                ", session=" + session  +
                '}';
        return description;
    }

}
