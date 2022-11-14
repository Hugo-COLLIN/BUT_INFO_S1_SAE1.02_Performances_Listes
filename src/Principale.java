/**
 * Classe principale de la SAE 1.02
 * @author Hugo COLLIN, Xin ZHANG
 * @since 2022-01-18
 *
 */


public class Principale{

	//Attributs
	private static final String [] AJOUT_DEBUT = {"A", "AA", "AAA", "AAAA", 
	"AAAAA", "AAAAAA", "AAAAAAA", "AAAAAAAA", "AAAAAAAAA", "AAAAAAAAAA"};
	
	private static final String [] AJOUT_FIN = {"Z", "ZZ", "ZZZ", "ZZZZ", 
	"ZZZZZ", "ZZZZZZ", "ZZZZZZZ", "ZZZZZZZZ", "ZZZZZZZZZ", "ZZZZZZZZZZ"};

	private static final String [] VAL_DEBUT = {"AARAB", "ABAD", "ABADIE", 
	"ABASSI", "ABBADI", "ABBAS", "ABBASSI", "ABBES", "ABBOU", "ABDALLAH"};
	
	private static final String [] VAL_FIN = {"ZIMMERMANN", "ZINCK", "ZINS", 
	"ZITOUNI", "ZITTE", "ZOUAOUI", "ZOUARI", "ZOUBIR", "ZULIANI", "ZUNINO"};
	
	/**
	 * Exemple d'utilisation de LectureFichier et remplissage d'une liste
	 * @author Etienne Andre
	 */
	public static void remplir_liste(ListeTriee liste, String nom_fichier){
		LectureFichier lf = new LectureFichier(nom_fichier);

		String[] liste_noms = lf.lireFichier();
		for (String s : liste_noms) {
			liste.adjlisT(s);
		}
	}

	public static long tpsAjoutChaines (ListeTriee liste, String [] tab)
	{
		long dateDebut = System.nanoTime();
		for (int j = 0 ; j < 10 ; j ++)
		{
			liste.adjlisT(tab[j]);
		}
		long dateFin = System.nanoTime();
		long tps = dateFin - dateDebut;
		return tps;
	}

	public static long tpsSuppChaines (ListeTriee liste, String [] tab)
	{
		long dateDebut = System.nanoTime();
		for (int j = 0 ; j < 10 ; j ++)
		{
			liste.suplisT(tab[j]);
		}
		long dateFin = System.nanoTime();
		long tps = dateFin - dateDebut;
		return tps;
	}
	
	public static long tpsAppartientChaines (ListeTriee liste, String [] tab)
	{
		long dateDebut = System.nanoTime();
		for (int j = 0 ; j < 10 ; j ++)
		{
			liste.memlisT(tab[j]);
		}
		long dateFin = System.nanoTime();
		long tps = dateFin - dateDebut;
		return tps;
	}

	public static void main(String [] args){
		System.out.println("Main Principale.java :");
		String fichier = "../fichiers/noms10000.txt";

		/*Q13*/
		Liste lContigue = new ListeContigue(10010);
		ListeTriee lTriContigue = new ListeTriee(lContigue);
		remplir_liste(lTriContigue, fichier);
		System.out.println("Q13 liste contigue ok");

		Liste lChainee = new ListeChainee(10010);
		ListeTriee lTriChainee = new ListeTriee(lChainee);
		remplir_liste(lTriChainee, fichier);
		System.out.println("Q13 liste chainee ok \n");
		
		
		/*Q16 -> Q21*/
		
		Liste [] tabLContigue = new ListeContigue[6];
		Liste [] tabLChainee = new ListeChainee[6];
		ListeTriee [] tabLTri = new ListeTriee[12];
		long [] res = new long[12];
		
		for (int i = 0 ; i < 6 ; i ++)
		{
			tabLContigue[i] = new ListeContigue(10010);
			tabLChainee[i] = new ListeChainee(10010);

			tabLTri[i*2] = new ListeTriee(tabLContigue[i]);
			remplir_liste(tabLTri[i*2], fichier);

			tabLTri[i*2 + 1] = new ListeTriee(tabLChainee[i]);
			remplir_liste(tabLTri[i*2 + 1], fichier);
			
		}
		
		//Q16
		res[0] = tpsAjoutChaines(tabLTri[0], AJOUT_DEBUT);
		System.out.println("Liste contigue, ajout debut : " + res[0]);
		res[1] = tpsAjoutChaines(tabLTri[1], AJOUT_DEBUT);
		System.out.println("Liste chainee, ajout debut : " + res[1]);

		//Q17
		res[2] = tpsAjoutChaines(tabLTri[2], AJOUT_FIN);
		System.out.println("Liste contigue, ajout fin : " + res[2]);
		res[3] = tpsAjoutChaines(tabLTri[3], AJOUT_FIN);
		System.out.println("Liste chainee, ajout fin : " + res[3]);

		//Q18
		res[4] = tpsSuppChaines(tabLTri[4], VAL_DEBUT);
		System.out.println("Liste contigue, suppression debut : " + res[4]);
		res[5] = tpsSuppChaines(tabLTri[5], VAL_DEBUT);
		System.out.println("Liste chainee, suppression debut : " + res[5]);

		//Q19
		res[6] = tpsSuppChaines(tabLTri[6], VAL_FIN);
		System.out.println("Liste contigue, suppression fin : " + res[6]);
		res[7] = tpsSuppChaines(tabLTri[7], VAL_FIN);
		System.out.println("Liste chainee, suppression fin : " + res[7]);

		
		//Q20
		res[8] = tpsAppartientChaines(tabLTri[8], VAL_DEBUT);
		System.out.println("Liste contigue, appartient debut : " + res[8]);
		res[9] = tpsAppartientChaines(tabLTri[9], VAL_DEBUT);
		System.out.println("Liste chainee, appartient debut : " + res[9]);

		//Q21
		res[10] = tpsAppartientChaines(tabLTri[10], VAL_FIN);
		System.out.println("Liste contigue, appartient fin : " + res[10]);
		res[11] = tpsAppartientChaines(tabLTri[11], VAL_FIN);
		System.out.println("Liste chainee, appartient fin : " + res[11]);
		


		/* TENTATIVE DE FACTORISATION DU CODE RECUPERANT LES TEMPS D'EXECUTION

		String [] listeChemin = {"AJOUT_DEBUT", "AJOUT_FIN", "VAL_DEBUT", "VAL_FIN"};
		for (int k = 0 ; k < 4 ; k ++)
		{
			for (int j = 0 ; j < 4 ; j ++)
			{
				if (j % 4 == 0)
				{
					res[j] = tpsAjoutChaines(tabLTriee[i], listeChemin[k * 2]);
				} 
				else if (j % 4 == 1)
				{

				}
				else if
				{
					res[j] = listeChemin[k * 2 + 1]
				}
			}
		}
		for (int i = 0 ; i < 12 ; i ++)
		{
			if (i % 2 == 0)
			{
				tabLTriee[i] = new ListeTriee(tabLContigue[i]);
				remplir_liste(tabLTriee[i], fichier);
			}
			else
			{
				
				tabLTriee[i] = new ListeTriee(tabLChainee[i]);
				remplir_liste(tabLTriee[i], fichier);
			}
			
		}*/


		/*
		//Q16
		Liste lAj1 = new ListeContigue(10010);
		long resAj1 = tpsAjoutChaines(lAj1, "../fichiers/noms10000.txt", ELEMENTS_DEBUT);
		System.out.println(resAj1);

		Liste lAj2 = new ListeChainee(10010);
		long resAj2 = tpsAjoutChaines(lAj2, "../fichiers/noms10000.txt", ELEMENTS_DEBUT);
		System.out.println(resAj2);


		//Q17
		Liste lAj3 = new ListeContigue(10010);
		long resAj3 = tpsAjoutChaines(lAj3, "../fichiers/noms10000.txt", ELEMENTS_FIN);
		System.out.println(resAj3);

		Liste lAj4 = new ListeChainee(10010);
		long resAj4 = tpsAjoutChaines(lAj4, "../fichiers/noms10000.txt", ELEMENTS_FIN);
		System.out.println(resAj4);


		//Q18
		Liste lSupp1 = new ListeContigue(10010);
		long resSupp1 = tpsSuppChaines(lSupp1, "../fichiers/noms10000.txt", ELEMENTS_DEBUT);
		System.out.println(resSupp1);

		Liste lSupp2 = new ListeContigue(10010);
		long resSupp2 = tpsSuppChaines(lSupp2, "../fichiers/noms10000.txt", ELEMENTS_DEBUT);
		System.out.println(resSupp2);


		//Q19
		Liste lSupp3 = new ListeContigue(10010);
		long resSupp3 = tpsSuppChaines(lSupp3, "../fichiers/noms10000.txt", ELEMENTS_FIN);
		System.out.println(resSupp3);

		Liste lSupp4 = new ListeContigue(10010);
		long resSupp4 = tpsSuppChaines(lSupp4, "../fichiers/noms10000.txt", ELEMENTS_FIN);
		System.out.println(resSupp4);

		String [] tab = */
	}
}
