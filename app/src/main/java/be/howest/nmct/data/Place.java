package be.howest.nmct.data;

/**
 * Created by Anthony on 4/05/2015.
 */
public class Place {
    private String naamPlaats;
    private int categorie;

    private double lat;
    private double lng;

    public Place(String naamPlaats, int categorie, double lat, double lng){
        this.naamPlaats = naamPlaats;
        this.categorie = categorie;
        this.lat = lat;
        this.lng = lng;
    }

    public String getNaamPlaats(){
        return naamPlaats;
    }
    public void setNaamPlaats(String naamPlaats) { this.naamPlaats = naamPlaats; }

    public int getCategorie(){
        return categorie;
    }
    public void setCategorie(int categorie) { this.categorie = categorie; }

    public double getLat(){
        return lat;
    }
    public void setLat(float lat) { this.lat = lat; }

    public double getLng(){
        return lng;
    }
    public void setLng(float lng) { this.lng = lng; }

    @Override
    public String toString(){
        String categorieString = "";
        switch(categorie){
            case 0:
                categorieString = "restaurant";
                break;
            case 1:
                categorieString = "bar";
                break;
            default:
                categorieString = "onbekend";
                break;
        }
        return ""+naamPlaats+" ("+categorieString+")";
    }

}
