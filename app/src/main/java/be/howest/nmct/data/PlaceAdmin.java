package be.howest.nmct.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony on 4/05/2015.
 */
public final class PlaceAdmin {
    private List<Place> places;

    private static PlaceAdmin instance = new PlaceAdmin();

    private PlaceAdmin(){
        loadPlaces();
    }

    public static PlaceAdmin getInstance() { return instance; }

    public List<Place> getPlaces() { return places; }

    private void loadPlaces(){
        places = new ArrayList<Place>();


        Place p1 = new Place("Capella", 0, 50.849152,2.883246);
        Place p2 = new Place("Paul's Boutique", 0, 50.850308,2.883594);
        Place p3 = new Place("De Ruyffelaer", 0, 50.850126,2.880947);
        Place p4 = new Place("Mimi's", 0, 50.850127,2.882300);
        Place p5 = new Place("Het Moment", 0, 50.850287,2.882795);




    }

}
