public class ListeChainee implements Liste{
    MaillonEntier[] tab;
    int tete;

    public ListeChainee(int nb){
        this.tab = new MaillonEntier[nb];
        this.tete = -1;
        for(int i = 0; i < nb; i++){
            this.tab[i] = new MaillonEntier(null, -2);
        }
    }

    public int retournerPlaceLibre(){
        boolean trouve = false;
        int place = 0;
        while(!trouve && place < this.tab.length){
            if(suc(place) == -2){
                trouve = true;
            }else{
                place++;
            }
        }
        if(trouve == true){
            return place;
        }else{
            return -1;
        }
    }

    public void libererPlace(int p){
        this.tab[p].setSuc(-2);
    }

    public void suplis(int p)
    {
        if(p == tete)
        {
            this.tete = suc(p);
            libererPlace(p);
        }
        else if(finliste(p)){
            int i = this.tete;
            while(suc(i) != p){
                i = suc(i);
            }
            this.tab[i].setSuc(-1);
            libererPlace(p);
        }
        else
        {
            int j = this.tete;
            while(suc(j) != p){
                j = suc(j);
            }
            this.tab[j].setSuc(suc(p));
            libererPlace(p);
        }

    }

	public void adjtlis(String s)
    {
        int PL = retournerPlaceLibre();
        this.tab[PL].setSuc(tete);
        this.tab[PL].setVal(s);
        this.tete = PL;
    }
    
	public void adjlis(int p, String s){
        int PL = retournerPlaceLibre();
        if(suc(p) == -1){
            this.tab[p].setSuc(PL);
            this.tab[PL].setSuc(-1);
            this.tab[PL].setVal(s);
        }else{
            this.tab[PL].setSuc(suc(p));
            this.tab[PL].setVal(s);
            this.tab[p].setSuc(PL);
        }

    }

	public boolean finliste(int p){
        return p == -1;
    }

	public int tete(){
        return this.tete;
    }

	public int suc(int p){
        return this.tab[p].getSuc();
    }

	public String val(int p){
        return this.tab[p].getVal();
    }




}