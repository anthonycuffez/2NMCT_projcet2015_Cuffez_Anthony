package be.howest.nmct;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

import be.howest.nmct.data.Place;

public class PlaceMapFragment extends Fragment {
    public static final String ARG_PLACE_NAAM = "place_naam";
    public LocationManager locationManager;
    public Place currentPlace;
    public List<Place> places;

    private MapView mapView;
    private GoogleMap googleMap;

    private static double longitude;
    private static double latitude;
    private static String name;
    private static String cat;

    private LatLng CENTER = null;
    private Location location;

    public PlaceMapFragment() {
        // Required empty public constructor
    }

    public static PlaceMapFragment newPlaceMapFragment(String naam, double lat, double lng, String category){
        PlaceMapFragment placeMapFragment = new PlaceMapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PLACE_NAAM, naam);
        longitude = lng;
        latitude = lat;
        name = naam;
        cat = category;
        placeMapFragment.setArguments(args);
        return placeMapFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_place_map2, container, false);

        mapView = (MapView) v.findViewById(R.id.mapViewPlace);
        mapView.onCreate(savedInstanceState);
        mapView.onResume(); //ACTIVEER MAP

        setMapView(mapView);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            /*currentClub = ClubProvider.getClub(getArguments().getString(ARG_CLUB_NAAM));
            clubs = ClubProvider.getClubs();*/
        }
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;

        try {
            MapsInitializer.initialize(getActivity());

            switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity())){
                case ConnectionResult.SUCCESS:

                    if (mapView != null) {
                        locationManager = ((LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE));
                        Boolean network = Boolean.valueOf(locationManager.isProviderEnabled("network"));

                        if (network == true){
                            try {
                                Geocoder coder = new Geocoder(getActivity(), Locale.getDefault());
                                List<Address> addresses;

                                /*addresses = coder.getFromLocationName(currentClub.getAdres(), 1);
                                Address location = addresses.get(0);*/

                                CENTER = new LatLng(latitude, longitude);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        } else {
                            Toast.makeText(getActivity(), "Locatie is niet gevonden", Toast.LENGTH_LONG).show();
                        }

                        googleMap = mapView.getMap();
                        googleMap.clear();

                        try {
                            if(cat=="0"){
                                cat = "Hotel";
                            }
                            else if(cat=="1"){
                                cat = "Vakantiewoning";
                            }
                            else if(cat=="2"){
                                cat = "Activiteit";
                            }
                            else if(cat=="3"){
                                cat = "Restaurant";
                            }
                            else{
                                cat = "Ongekende locatie";
                            }

                            googleMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(latitude, longitude))
                                    .title(name)
                                    .snippet(cat));
                        } catch (Exception ex){
                            System.out.println(ex);
                            Toast.makeText(getActivity(), "Er is geen internetverbinding...", Toast.LENGTH_LONG).show();
                        }

                        googleMap.setIndoorEnabled(true);
                        googleMap.setMyLocationEnabled(true);
                        googleMap.moveCamera(CameraUpdateFactory.zoomTo(16));

                        if (CENTER != null) {
                            googleMap.animateCamera(CameraUpdateFactory.newLatLng(CENTER), 1750, null);
                        }

                        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    }
                    break;
                case ConnectionResult.SERVICE_MISSING:
                    System.out.println("SERVICE IS MISSING");
                    Toast.makeText(getActivity(), "Service is niet gevonden", Toast.LENGTH_LONG).show();
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                    System.out.println("SERVICE NEEDS UPDATE");
                    Toast.makeText(getActivity(), "Service moet worden upgedate", Toast.LENGTH_LONG).show();
                    break;
                default:

            }
        } catch (Exception ex) {
            System.out.println(ex);
            Toast.makeText(getActivity(), "Er is een onbekende fout opgetreden", Toast.LENGTH_LONG).show();
        }
    }
}
