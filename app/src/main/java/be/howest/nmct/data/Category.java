package be.howest.nmct.data;

public class Category {
    private String categorieNaam;

    public Category(String categorieNaam){
        this.categorieNaam = categorieNaam;
    }

    public String getCategorieNaam(){
        return categorieNaam;
    }
    public void setCategorieNaam(String categorieNaam) { this.categorieNaam = categorieNaam; }

    @Override
    public String toString(){
        return categorieNaam;
    }
}
