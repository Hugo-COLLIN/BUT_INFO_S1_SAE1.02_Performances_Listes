public class ListeTriee{

	// Attribut de liste sous-jacente
	private Liste liste;
	
	public ListeTriee(Liste listevide){
		// Affectation de la liste vide a l'attribut prive
		liste = listevide;
	}

	/**
	 * ajoute un element au bon endroit dans la liste triee
	 * @param chaine element a inserer
	 */
	public void adjlisT(String chaine)
	{
        int p = liste.tete();
		if(liste.finliste(p))
		{
			liste.adjtlis(chaine);
        }
		else
		{
			int pprec = p;
			boolean trouve = false;
			while(!liste.finliste(p) && !trouve)
			{
				if(chaine.compareTo(liste.val(p)) < 0)
				{
					if (p == liste.tete())
					{
						liste.adjtlis(chaine);
					}
					else
					{
						liste.adjlis(pprec, chaine);
					}
					trouve = true;
				}
				else
				{
					pprec = p;
					p = liste.suc(p);
				}
			}
			if(!trouve)
			{
				liste.adjlis(pprec, chaine);
			}			
        }
	}
	
	/**
	 * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
	 * @param chaine l'element a supprimer 
	 */
	public void suplisT(String chaine)
	{
		int p = liste.tete();
		boolean trouve = false;
		while(!trouve && !liste.finliste(p))
		{
			if(chaine.equals(liste.val(p)))
			{
				liste.suplis(p);
				trouve = true;
			}
			else
			{
				p = liste.suc(p);
			}
		}
	}
	
	/**
	 * Retourne vrai si au moins un element de la liste a une valeur egale a "chaine", et retourne faux sinon.
	 * @param chaine l'element que l'on recherche
	 */
	public boolean memlisT(String chaine)
	{
		int p = liste.tete();
		boolean trouve = false;
		while (!trouve && !liste.finliste(p))
		{
			if (chaine.equals(liste.val(p)))
			{
				trouve = true;
			}
			else
			{
				p = liste.suc(p);
			}
		}
		return trouve;
	}

	/**
	 * Permet d'afficher le contenu de l'attribut liste lors de l'appel d'un objet de type ListeTriee
	 */
	public String toString()
	{
		int p = liste.tete();
		String s = liste.val(p);
		p = liste.suc(p);
		while(!liste.finliste(p))
		{
			s =  s + ", " + liste.val(p);
			p = liste.suc(p);
		}
		return s;
	}
}
