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
        //RESTAURANTS:
        Place p1 = new Place("Capella", 3, 50.849152, 2.883246);
        Place p2 = new Place("Paul's Boutique", 3, 50.850308, 2.883594);
        Place p3 = new Place("De Ruyffelaer", 3, 50.850126, 2.880947);
        Place p4 = new Place("Mimi's", 3, 50.850127, 2.882300);
        Place p5 = new Place("Het Moment", 3, 50.850287, 2.882795);
        Place p6 = new Place("Ariane", 3, 50.854405, 2.883069);
        Place p7 = new Place("In 't Klein Stadhuis", 3, 50.850792, 2.885651);
        Place p8 = new Place("De Steenen Haene", 3, 50.835976, 2.901908);
        Place p9 = new Place("Den Olifant", 3, 50.858483, 2.878180);
        Place p10 = new Place("Hostellerie Saint-Nicolas", 3, 50.885301, 2.819477);
        Place p11 = new Place("Trattoria Alloro", 3, 50.850015, 2.882818);
        Place p12 = new Place("Utopia", 3, 50.852318, 2.882694);
        Place p13 = new Place("De Kollebloeme", 3, 50.851053, 2.886802);
        Place p14 = new Place("Restaurant 'Captain Cook'", 3, 50.851651, 2.888883);
        Place p15 = new Place("Petrus", 3, 50.851207, 2.887020);
        Place p16 = new Place("Souvenir", 3, 50.849423, 2.878289);
        Place p17 = new Place("Ypra Inn", 3, 50.851206, 2.899592);
        Place p18 = new Place("De Voerman", 3, 50.843319, 2.889404);
        Place p19 = new Place("De Fonderie", 3, 50.856073, 2.886250);
        Place p20 = new Place("Marktcafe Les Halles", 3, 50.850976, 2.886418);
        Place p21 = new Place("In de Rustplaats", 3, 50.863901, 2.860555);
        Place p22 = new Place("Il Gusto D'Italia", 3, 50.850858, 2.885861);
        Place p23 = new Place("In Flanders Field Museumcafe", 3, 50.851151, 2.885449);
        Place p24 = new Place("Karamel", 3, 50.853097, 2.895351);
        Place p25 = new Place("Decouverte", 3, 50.834337, 2.887607);
        Place p26 = new Place("Old Tom Restaurant", 3, 50.851687, 2.888044);
        Place p27 = new Place("De Wijngaard", 3, 50.849314, 2.876740);
        Place p28 = new Place("Ieperlee", 3, 50.852265, 2.883606);
        Place p29 = new Place("De Trompet", 3, 50.850950, 2.886330);
        Place p30 = new Place("Brasserie Kazematten", 3, 50.851723, 2.890709);
        Place p31 = new Place("Ypres Burger", 3, 50.851079, 2.886769);
        Place p32 = new Place("'t Leetvermaak", 3, 50.851669, 2.883342);
        Place p33 = new Place("Frituur de Leet", 3, 50.852483, 2.883529);
        Place p34 = new Place("Pacific Eiland", 3, 50.846389, 2.878858);
        Place p35 = new Place("Au Carillon Bar/Pub", 3, 50.851987, 2.883793);
        Place p36 = new Place("Het Zilveren hoofd - De Ecurie", 3, 50.834088, 2.887597);
        Place p37 = new Place("Tempelpoort", 3, 50.850083, 2.881747);
        Place p38 = new Place("Decroos food boutique", 3, 50.852338, 2.892537);
        Place p39 = new Place("Bistro Terra Nossa", 3, 50.849916, 2.876345);
        Place p40 = new Place("Markt 22", 3, 50.851044, 2.887056);
        Place p41 = new Place("D'Alice", 3, 50.841593, 2.8714339);
        Place p42 = new Place("Cyper", 3, 50.851421, 2.888007);
        Place p43 = new Place("The Walker", 3, 50.853114, 2.895055);
        Place p44 = new Place("New Shanghai City", 3, 50.852155, 2.883678);
        Place p45 = new Place("Spirelli", 3, 50.850850, 2.885278);
        Place p46 = new Place("Kom Il Foo", 3, 50.849822, 2.881910);
        Place p47 = new Place("Central Cafe", 3, 50.849233, 2.877945);
        Place p48 = new Place("'t Ganzeke", 3, 50.851404, 2.883894);
        Place p49 = new Place("Frituur 't Kattekwaad", 3, 50.851188, 2.887209);
        Place p50 = new Place("Coffee Break", 3, 50.851283, 2.899435);
        Place p51 = new Place("Hotel Regina", 3, 50.850807, 2.885803);
        Place p52 = new Place("Bistro Fino", 3, 50.849929, 2.881769);
        Place p53 = new Place("Restaurant Gasthof 't Zweerd", 3, 50.851623, 2.888075);
        Place p54 = new Place("Au Gourmand", 3, 50.834325, 2.887629);
        Place p55 = new Place("Brasserie Central", 3, 50.851761, 2.887992);
        Place p56 = new Place("Vivaldi", 3, 50.851221, 2.887250);
        Place p57 = new Place("The Porter House Irish Pub and Restaurant", 3, 50.852806, 2.890076);
        Place p58 = new Place("De Vuile Seule", 3, 50.876123, 2.790591);
        Place p59 = new Place("Pizerria Babilonia", 3, 50.852043, 2.897854);
        Place p60 = new Place("De Warande", 3, 50.885783, 2.817703);
        Place p61 = new Place("Den Anker", 3, 50.850866, 2.886037);
        Place p62 = new Place("De Vauban", 3, 50.853017, 2.890088);
        Place p63 = new Place("Pita Agadir", 3, 50.849570, 2.886443);
        Place p64 = new Place("Passim", 3, 50.846677, 2.950331);
        Place p65 = new Place("Pitstop", 3, 50.850553, 2.884069);
        Place p66 = new Place("De Palingbeek", 3, 50.813940, 2.920177);
        Place p67 = new Place("De Waterpoort", 3, 50.857565, 2.887999);
        Place p68 = new Place("Frituur 't Kanon", 3, 50.847289, 2.929143);
        Place p69 = new Place("Sandwichbar Jome", 3, 50.848856, 2.879816);
        Place p70 = new Place("De Stoove", 3, 50.849233, 2.877924);
        Place p71 = new Place("Au Miroir", 3, 50.851080, 2.886778);
        Place p72 = new Place("Allegria Food Bar", 3, 50.851275, 2.884086);
        Place p73 = new Place("Kasteel de Plaisance", 3, 50.846675, 2.950333);
        Place p74 = new Place("Gossip", 3, 50.851801, 2.883729);
        //ACTIVITEITEN
        Place p75 = new Place("Menin Gate Memorial", 2, 50.851986, 2.891134);
        Place p76 = new Place("Flanders Battlefield Tours", 2, 50.854324, 2.883070);
        Place p77 = new Place("In Flanders Fields Museum", 2, 50.850933, 2.885479);
        Place p78 = new Place("Lest We Forget Battlefield Tours (Flanders)", 2, 50.853448, 2.884932);
        Place p79 = new Place("Frontline Tours", 2, 50.851686, 2.888020);
        Place p80 = new Place("A Foreign Field WW1 Tours", 2, 50.851596, 2.881097);
        Place p81 = new Place("Hooge Crater museum", 2, 50.846643, 2.939632);
        Place p82 = new Place("Hill 60", 2, 50.824569, 2.929052);
        Place p83 = new Place("Saint Martin's Cathedral", 2, 50.851810, 2.885100);
        Place p84 = new Place("The seventeenth century Vauban ramparts", 2, 50.854543, 2.891910);
        Place p85 = new Place("Bellewaerde", 2, 50.846673, 2.950331);
        Place p86 = new Place("Ramparts War Museum", 2, 50.810153, 2.892070);
        //VAKANTIEWONINGEN:
        Place p87 = new Place("Loobeek Farm", 1, 50.851201, 2.886614);
        Place p88 = new Place("Wipers Times triplex apartment", 1, 50.851201, 2.886614);
        Place p89 = new Place("Ipericus", 1, 50.851201, 2.886614);
        Place p90 = new Place("Wipers Times", 1, 50.851201, 2.886614);
        Place p91 = new Place("Menin Gate House", 1, 50.851201, 2.886614);
        Place p92 = new Place("Stations3t House", 1, 50.851201, 2.886614);
        Place p93 = new Place("IeperMarketSquare - LOFT", 1, 50.851201, 2.886614);
        Place p94 = new Place("St-Coryn", 1, 50.851201, 2.886614);
        Place p95 = new Place("Apartment Aurora", 1, 50.851201, 2.886614);
        Place p96 = new Place("St-Coryn", 1, 50.851201, 2.886614);
        Place p97 = new Place("IeperMarketSquare", 1, 50.851201, 2.886614);
        Place p98 = new Place("Daniel's house", 1, 50.851201, 2.886614);
        Place p99 = new Place("La Ferme de Gabrielle", 1, 50.851201, 2.886614);
        //HOTELS:
        Place p100 = new Place("Main Street Hotel", 0, 50.846645, 2.889183);
        Place p101 = new Place("Hotel Ariane", 0, 50.854430, 2.883030);
        Place p102 = new Place("Albion Hotel", 0, 50.849837, 2.889667);
        Place p103 = new Place("Ambrosia Hotel", 0, 50.849307, 2.888273);
        Place p104 = new Place("Novotel Ieper Centrum", 0, 50.850871, 2.888631);
        Place p105 = new Place("Kasteelhof 't Hooghe", 0, 50.846532, 2.946051);
        Place p106 = new Place("Hotel Regina", 0, 50.850688, 2.885928);
        Place p107 = new Place("BEST WESTERN Flanders Lodge", 0, 50.867036, 2.887652);
        Place p108 = new Place("B&B @Room's", 0, 50.856184, 2.886913);
        Place p109 = new Place("B&B Hoeve 37", 0, 50.859881, 2.864689);
        Place p110 = new Place("Yoake Bed and Breakfast", 0, 50.849036, 2.881982);
        Place p111 = new Place("La Porte Cochere", 0, 50.849568, 2.882935);
        Place p112 = new Place("B&B Fresco", 0, 50.861184, 2.869446);
        Place p113 = new Place("De Nacht Wacht", 0, 50.849918, 2.877233);
        Place p114 = new Place("Fields of Gold", 0, 50.854434, 3.017713);
        Place p115 = new Place("Cocoon", 0, 50.850808, 2.880709);
        Place p116 = new Place("Villa Vanilla", 0, 50.865797, 2.903680);
        Place p117 = new Place("B&B Deja Vu", 0, 50.849976, 2.881352);
        Place p118 = new Place("B&B Hortensia", 0, 50.845187, 2.890553);
        Place p119 = new Place("B&B De Potyze", 0, 50.863043, 2.918148);
        Place p120 = new Place("B&B La Passarelle - Hooghe Crater", 0, 50.847166, 2.935276);

        //plaatsen toevoegen:
        places.add(p1);places.add(p2);places.add(p3);places.add(p4);places.add(p5);places.add(p6);places.add(p7);places.add(p8);places.add(p9);
        places.add(p10);places.add(p11);places.add(p12);places.add(p13);places.add(p14);places.add(p15);places.add(p16);places.add(p17);places.add(p18);places.add(p19);
        places.add(p20);places.add(p21);places.add(p22);places.add(p23);places.add(p24);places.add(p25);places.add(p26);places.add(p27);places.add(p28);places.add(p29);
        places.add(p30);places.add(p31);places.add(p32);places.add(p33);places.add(p34);places.add(p35);places.add(p36);places.add(p37);places.add(p38);places.add(p39);
        places.add(p40);places.add(p41);places.add(p42);places.add(p43);places.add(p44);places.add(p45);places.add(p46);places.add(p47);places.add(p48);places.add(p49);
        places.add(p50);places.add(p51);places.add(p52);places.add(p53);places.add(p54);places.add(p55);places.add(p56);places.add(p57);places.add(p58);places.add(p59);
        places.add(p60);places.add(p61);places.add(p62);places.add(p63);places.add(p64);places.add(p65);places.add(p66);places.add(p67);places.add(p68);places.add(p69);
        places.add(p70);places.add(p71);places.add(p72);places.add(p73);places.add(p74);places.add(p75);places.add(p76);places.add(p77);places.add(p78);places.add(p79);
        places.add(p80);places.add(p81);places.add(p82);places.add(p83);places.add(p84);places.add(p85);places.add(p86);places.add(p87);places.add(p88);places.add(p89);
        places.add(p90);places.add(p91);places.add(p92);places.add(p93);places.add(p94);places.add(p95);places.add(p96);places.add(p97);places.add(p98);places.add(p99);
        places.add(p100);places.add(p101);places.add(p102);places.add(p103);places.add(p104);places.add(p105);places.add(p106);places.add(p107);places.add(p108);places.add(p109);
        places.add(p110);places.add(p111);places.add(p112);places.add(p113);places.add(p114);places.add(p115);places.add(p116);places.add(p117);places.add(p118);places.add(p119);
        places.add(p120);

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
