Il s'agit ici de l'implémentation les listes triées, utilisant les implémentations contiguë et chainée, avant de comparer leurs performances pour l’ajout et la suppression d’éléments, en début puis en fin de liste.

Classes présentes :
- EcritureFichier.java permet d'écrire dans un fichier texte.
- LectureFichier.java permet de lire le contenu d'un fichier texte.
- Liste.java est l'interface permettant l'implémentation des listes.
- ListeChainee.java correspond à l'implémentation chainée de l'interface Liste.java.
- ListeContigue.java correspond à l'implémentation contigue de l'interface Liste.java.
- ListeTriee.java permet d'obtenir une liste triée dans l'ordre alphabétique, peu importe son implémentation.
- MaillonEntier.java permet de créer des couples <valeur, successeur> pour l'implémentation chainée des listes.
- Principale.java permet de tester la rapidité d'exécution des commandes d'ajout et de suppression d'éléments, au début et à la fin des listes contigues et chainées.
- TestListeTriee.java contient les tests nécessaires pour vérifier que les méthodes de ListeTriee.java fonctionnent correctement.