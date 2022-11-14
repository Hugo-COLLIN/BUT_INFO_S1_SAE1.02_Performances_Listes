/**
 * permet de stocker un maillon de la liste chainee
 * un maillon possede sa valeur et la position du successeur
 *
 */
public class MaillonEntier {
	
	/**
	 * valeur du maillon
	 */
	private String val;
	
	/**
	 * indice ou trouver le successeur du maillon courant
	 */
	private int suc;
	
	/**
	 * permet de construire un Maillon en precisant sa valeur
	 * et l'indice du successeur
	 *  
	 * @param v valeur contenue a cet endroit
	 * @param s indice ou trouver le suivant
	 */
	public MaillonEntier(String v, int s)
	{
		this.val=v;
		this.suc=s;
	}
	
	/**
	 * permet d'acceder a la valeur du maillon
	 * 
	 * @return valeur associee au maillon 
	 */
	public String getVal()
	{
		return(this.val);
	}
	
	/**
	 * modifie la valeur associee a ce maillon
	 * 
	 * @param st String
	 */
	public void setVal(String st)
	{
		this.val=st;
	}
	
	/**
	 * permet d'acceder a l'indice du suivant de ce maillon
	 * 
	 * @return indice du suivant 
	 */
	public int getSuc()
	{
		return(this.suc);
	}
	
	/**
	 * permet de modifier le chainage dans la liste
	 * 
	 * @param i indice du Maillon suivant suivant 
	 */
	public void setSuc(int i)
	{
		this.suc=i;
	}

}
