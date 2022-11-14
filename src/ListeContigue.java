public class ListeContigue implements Liste{
    private String[] tab;
    private int nbElements;

    public ListeContigue(int tailleMax){
        if(tailleMax > 0){
            this.tab = new String[tailleMax];
            this.nbElements = 0;
        }
    }

    public ListeContigue(String[] s){
        if(s != null){
            this.tab = new String[s.length+2];
            for(int i = s.length-1; i > -1 ; i--){
                this.adjtlis(s[i]);
            }
            this.nbElements = s.length;
        }
    }

    public void suplis(int p){
        if(p > -1 && p < nbElements){
            for(int i=p;i<nbElements-1;i++){ //nbElements-1 ou nbElements 
                tab[i] = tab[i+1];
            }
            this.nbElements --;
        }
    }

	public void adjtlis(String s){
        if(s != null){
            for(int i = nbElements-1;i > -1;i--){
                tab[i+1] = tab[i];
            }
            tab[this.tete()] = s;
            this.nbElements ++;
        }
    }

	public void adjlis(int p, String s){
        if(s != null && p > -1 && p < nbElements){
            for(int i = nbElements-1; i > p; i--){
                tab[i+1] = tab[i];
            }
            tab[p+1] = s;
            this.nbElements ++;
        }
    }

	public boolean finliste(int p){
        if(p == nbElements){
            return true;
        }else{
            return false;
        }
    }

	public int tete(){
        return 0;
    }

	public int suc(int p){
        return p+1;
    }

	public String val(int p){
        return tab[p];
    }

    public String toString(){
        String s = "-----------";
        for(int i = this.tete();i < nbElements; i++){
            s = s+"\n"+this.val(i);
        }
        s = s + "\n-----------";
        return s;
    }


}
