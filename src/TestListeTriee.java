import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe ListeTriee
 * fonctionne correctement
 */
public class TestListeTriee {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestListeTriee(), args);
	}

	/**
	 * Teste que adjlisT ajoute correctement l’élément en paramètre dans la liste, 
	 * en représentation contigue. 
	 */
	public void test01_adjlisT_contigueAjoutTrie ()
	{
		Liste l = new ListeContigue(200);
		ListeTriee lTri = new ListeTriee(l);

		lTri.adjlisT("Bambou");
		lTri.adjlisT("Aligator");
		lTri.adjlisT("Sublime");
		lTri.adjlisT("Satisfait");

		//assertEquals("devrait etre dans l'ordre alphabetique", "Aligator, Bambou, Satisfait, Sublime", lTri.toString());

		String c = "Aligator, Bambou, Satisfait, Sublime";
		boolean res = c.equals(lTri.toString());

		assertEquals("devrait etre dans l'ordre alphabetique", true, res);
	}

	/**
	 * Teste que adjlisT ajoute correctement l’élément en paramètre dans la liste, 
	 * en représentation chainee. 
	 */
	public void test02_adjlisT_chaineeAjoutTrie ()
	{
		Liste l = new ListeChainee(200);
		ListeTriee lTri = new ListeTriee(l);

		lTri.adjlisT("Bambou");
		lTri.adjlisT("Aligator");
		lTri.adjlisT("Sublime");
		lTri.adjlisT("Satisfait");

		//assertEquals("devrait etre dans l'ordre alphabetique", "Aligator, Bambou, Satisfait, Sublime", lTri.toString());

		String c = "Aligator, Bambou, Satisfait, Sublime";
		boolean res = c.equals(lTri.toString());

		assertEquals("devrait etre dans l'ordre alphabetique", true, res);
	}

	/**
	 * Teste que suplisT supprime correctement l’élément en paramètre s'il est present 
	 * dans la liste, en représentation contigue. 
	 */
	public void test03_suplisT_contigueSupListe ()
	{
		Liste l = new ListeContigue(200);
		l.adjtlis("Aligator");
		int p = l.tete();
		l.adjlis(p, "Bambou");
		p = l.suc(p);
		l.adjlis(p, "Satisfait");
		p = l.suc(p);
		l.adjlis(p, "Sublime");
		ListeTriee lTri = new ListeTriee(l);

		lTri.suplisT("Bambou");

		//assertEquals("l'element doit etre supprime", "Aligator, Satisfait, Sublime", lTri.toString());
		
		String c = "Aligator, Satisfait, Sublime";
		boolean res = c.equals(lTri.toString());

		assertEquals("l'element doit etre supprime", true, res);
	}

	/**
	 * Teste que suplisT supprime correctement l’élément en paramètre s'il est present 
	 * dans la liste, en représentation chainee. 
	 */
	public void test04_suplisT_chaineeSupListe ()
	{
		Liste l = new ListeChainee(200);
		l.adjtlis("Aligator");
		int p = l.tete();
		l.adjlis(p, "Bambou");
		p = l.suc(p);
		l.adjlis(p, "Satisfait");
		p = l.suc(p);
		l.adjlis(p, "Sublime");
		ListeTriee lTri = new ListeTriee(l);

		lTri.suplisT("Bambou");

		//assertEquals("l'element doit etre supprime", "Aligator, Satisfait, Sublime", lTri.toString());
		
		String c = "Aligator, Satisfait, Sublime";
		boolean res = c.equals(lTri.toString());

		assertEquals("l'element doit etre supprime", true, res);
	}

	/**
	 * Teste que suplisT n'opère aucun changement sur la liste si l’élément en paramètre 
	 * n'appartient pas à la liste, en représentation contigue. 
	 */
	public void test05_suplisT_contigueSupHorsListe ()
	{
		Liste l = new ListeContigue(200);
		l.adjtlis("Aligator");
		int p = l.tete();
		l.adjlis(p, "Bambou");
		p = l.suc(p);
		l.adjlis(p, "Satisfait");
		p = l.suc(p);
		l.adjlis(p, "Sublime");
		ListeTriee lTri = new ListeTriee(l);

		lTri.suplisT("Caillou");

		//assertEquals("aucun changement ne doit avoir lieu dans la liste", "Aligator, Bambou, Satisfait, Sublime", lTri.toString());
		
		String c = "Aligator, Bambou, Satisfait, Sublime";
		boolean res = c.equals(lTri.toString());

		assertEquals("aucun changement ne doit avoir lieu dans la liste", true, res);
	}

	/**
	 * Teste que suplisT n'opère aucun changement sur la liste si l’élément en paramètre 
	 * n'appartient pas à la liste, en représentation chainee. 
	 */
	public void test06_suplisT_chaineeSupHorsListe ()
	{
		Liste l = new ListeChainee(200);
		l.adjtlis("Aligator");
		int p = l.tete();
		l.adjlis(p, "Bambou");
		p = l.suc(p);
		l.adjlis(p, "Satisfait");
		p = l.suc(p);
		l.adjlis(p, "Sublime");
		ListeTriee lTri = new ListeTriee(l);

		lTri.suplisT("Caillou");

		//assertEquals("aucun changement ne doit avoir lieu dans la liste", "Aligator, Bambou, Satisfait, Sublime", lTri.toString());
		
		String c = "Aligator, Bambou, Satisfait, Sublime";
		boolean res = c.equals(lTri.toString());

		assertEquals("aucun changement ne doit avoir lieu dans la liste", true, res);
	}
}
