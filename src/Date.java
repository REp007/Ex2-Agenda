public class Date {
    private int jour;
    private int mois;
    private int annee;

    public Date(
            int jour,
            int mois,
            int annee
    ){
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

//    Gatters
    public int getJour() { return jour; }
    public int getMois() { return mois; }
    public int getAnnes() { return annee; }

    //    Setters
    public void setJour(int jour) { this.jour = jour; }
    public void setMois(int mois) { this.mois = mois; }
    public void setAnnes(int annes) { this.annee = annes; }

    @Override
    public String toString(){
        return this.jour + "/" + this.mois + "/" + this.annee;
    }

    public boolean estAvant(Date d){
        if (this.annee < d.annee){ return true; }
        if (this.annee == d.annee && this.mois < d.mois) { return true; }
        return this.annee == d.annee && this.mois == d.mois && this.jour < d.jour;
    }

    public boolean equals(Date other) {
        return this.jour == other.jour &&
                this.mois == other.mois &&
                this.annee == other.annee;
    }
}
