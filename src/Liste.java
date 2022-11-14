/**
 * interface de la classe Liste 
 */
public interface Liste
{
	
	/**
	 * permet de supprimer un element d'une liste
	 * @param p place de l'element  supprimer 
	 */
	public void suplis(int p);
	
	/**
	 * ajoute un element en tete de Liste
	 * @param s Element a ajouter en tete
	 */
	public void adjtlis(String s);
	
	/**
	 * ajoute un element a un endroit quelconque dans la liste
	 * @param p place apres laquelle inserer
	 * @param s element a inserer
	 */
	public void adjlis(int p, String s);
	
	/**
	 * permet de savoir si on se trouve en fin de liste
	 * @param p place ou on se trouve
	 * @return true si et seuelement si p est fin de liste
	 */
	public boolean finliste(int p);
	
	/**
	 * retourne la premiere place de la liste
	 * @return tete de liste
	 */
	public int tete();
	
	/**
	 * permet de connaitre la place suivante dans la liste
	 * @param p place en cours
	 * @return place derriere p dans la liste
	 */
	public int suc(int p);
	
	/**
	 * retourne la valeur associee a la place p
	 * @param p place de la liste
	 * @return la valeur associee a p
	 */
	public String val(int p);
}