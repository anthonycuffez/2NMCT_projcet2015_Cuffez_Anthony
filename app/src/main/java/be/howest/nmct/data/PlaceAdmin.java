package be.howest.nmct.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony on 4/05/2015.
 */
public final class PlaceAdmin {
    private List<Place> places;
    private List<Place> hotels;
    private List<Place> vakantiewoningen;
    private List<Place> activiteiten;
    private List<Place> restaurants;

    private static PlaceAdmin instance = new PlaceAdmin();

    private PlaceAdmin(){
        loadPlaces();
    }

    public static PlaceAdmin getInstance() { return instance; }

    public List<Place> getPlaces() { return places; }

    public List<Place> getHotels() { return hotels; }

    public List<Place> getVakantieWoningen(){ return vakantiewoningen; }

    public List<Place> getActiviteiten(){ return activiteiten; }

    public List<Place> getRestaurants(){ return restaurants; }

    private void loadPlaces(){
        places = new ArrayList<Place>();

        //plaatsen aanmaken:
        Place p1 = new Place("Capella", 3, 50.849152,2.883246);
        Place p2 = new Place("Paul's Boutique", 3, 50.850308,2.883594);
        Place p3 = new Place("De Ruyffelaer", 3, 50.850126,2.880947);
        Place p4 = new Place("Mimi's", 3, 50.850127,2.882300);
        Place p5 = new Place("Het Moment", 3, 50.850287,2.882795);

        //plaatsen toevoegen:
        places.add(p1);
        places.add(p2);
        places.add(p3);
        places.add(p4);
        places.add(p5);

        // alle plaatsen sorteren over de verschillende soorten categorieën:
        hotels = new ArrayList<Place>();
        vakantiewoningen = new ArrayList<Place>();
        activiteiten = new ArrayList<Place>();
        restaurants = new ArrayList<Place>();

        int lengte = places.size();

        for(int i=0; i<lengte; i++){
            switch(places.get(i).getCategorie()){
                case 0:
                    hotels.add(places.get(i));
                    break;
                case 1:
                    vakantiewoningen.add(places.get(i));
                    break;
                case 2:
                    activiteiten.add(places.get(i));
                    break;
                case 3:
                    restaurants.add(places.get(i));
                    break;
            }
        }
    }

}
