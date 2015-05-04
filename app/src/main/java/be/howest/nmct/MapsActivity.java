package be.howest.nmct;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private GoogleApiClient mGoogleApiClient;
    private Boolean isReady = false;

    ArrayList<Float> lats = new ArrayList();
    ArrayList<Float> lngs = new ArrayList();
    ArrayList<String> names = new ArrayList();
    ArrayList<String> omschrijvingen = new ArrayList<>();

    JSONObject json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        String clientId = "SEXPMO5VHLZECD1RKAP0XSK33MOSWXWBKIAQ1WQIDSRD5XD2";
        String clientSecret = "GDITNVWNFXYJXS1DVTVKY5KPJ53553ADOUGH3IEKE32QBUBJ";
        String lat = "50.849999999999990000";
        String lon = "2.883333300000004000";
        String query = "bar,restaurant";
        new FoursquareAsyncTask().execute("https://api.foursquare.com/v2/venues/search?client_id="+clientId+"&client_secret="+clientSecret+"&v=20130815&ll="+lat+","+lon+"&query="+query);
        setUpMapIfNeeded();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    public void addData(){



        lats.add((float)50.85185992853622);
        lngs.add((float)2.8835191941471883);
        names.add("Gossip Illy bar");
        omschrijvingen.add("Bar");

        lats.add((float)50.85122659184856);
        lngs.add((float)2.884404216351548);
        names.add("Restaurant De Stove");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.849765084291775);
        lngs.add((float)2.8754066291389644);
        names.add("bar d'office");
        omschrijvingen.add("Bar");

        lats.add((float)50.849470612523);
        lngs.add((float)2.8754597624788065);
        names.add("bar syntrawest");
        omschrijvingen.add("Bar");

        lats.add((float)50.85105514526367);
        lngs.add((float)2.8805601596832275);
        names.add("Art19 Bar");
        omschrijvingen.add("Bar");

        lats.add((float)50.84574128059754);
        lngs.add((float)2.8777524984665646);
        names.add("Restaurant Sterrenbosch");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.857914);
        lngs.add((float)2.884378);
        names.add("BAR JUDOCLUB NEKO IEPER 🍻");
        omschrijvingen.add("Bar");

        lats.add((float)50.84813);
        lngs.add((float)2.88854);
        names.add("restaurant chez ally");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.846603);
        lngs.add((float)2.884022);
        names.add("restaurant belastingen");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.84616040196381);
        lngs.add((float)2.8841812251774464);
        names.add("FOD restaurant Ieper");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.853275);
        lngs.add((float)2.889647);
        names.add("Restaurant chez pa");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.84659194946289);
        lngs.add((float)2.8913793563842773);
        names.add("restaurant de frigo");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.85291750593996);
        lngs.add((float)2.8759853379715374);
        names.add("Restaurant Ma");

        lats.add((float)50.850648);
        lngs.add((float)2.889679);
        names.add("Foodsquare Bar Brasserie");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.85340118408203);
        lngs.add((float)2.872934341430664);
        names.add("Restaurant Cisca");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.84480667114258);
        lngs.add((float)2.8953773975372314);
        names.add("versleten bar van de sporthalle");
        omschrijvingen.add("Bar");

        lats.add((float)50.85034873871047);
        lngs.add((float)2.896385732689499);
        names.add("Haems Alcohol-bar");
        omschrijvingen.add("Bar");

        lats.add((float)50.85117074569335);
        lngs.add((float)2.897563014739729);
        names.add("lounge bar Denys🍸");
        omschrijvingen.add("Bar");

        lats.add((float)50.85332786280261);
        lngs.add((float)2.8857470446346554);
        names.add("Souvenir Restaurant");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.85466766357422);
        lngs.add((float)2.7283618450164795);
        names.add("Hopperie - Belgian Beer Bar");
        omschrijvingen.add("Bar");

        lats.add((float)50.8510264803986);
        lngs.add((float)2.884324486768318);
        names.add("Hotel Bar Restaurant Palace");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.84631296648687);
        lngs.add((float)2.9512453079223633);
        names.add("Lounge Bar Celona");
        omschrijvingen.add("Bar");

        lats.add((float)50.94351577758789);
        lngs.add((float)3.1288092136383057);
        names.add("Carrousel Self Service Restaurant");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.72564129328465);
        lngs.add((float)3.129659288862651);
        names.add("Bar Sporthal");
        omschrijvingen.add("Bar");

        lats.add((float)50.79639511731603);
        lngs.add((float)3.12057497646961);
        names.add("La Baratte Restaurant");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.80870450781267);
        lngs.add((float)3.261887206040241);
        names.add("Hotel - Restaurant De Sterre");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.68824740486765);
        lngs.add((float)3.104259967803955);
        names.add("Bar Hoorens");
        omschrijvingen.add("Bar");

        lats.add((float)50.827130357893765);
        lngs.add((float)3.258001804420059);
        names.add("Inesis Golf Restaurant");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.64227621899096);
        lngs.add((float)3.0607223510742188);
        names.add("Villa Restaurant School");
        omschrijvingen.add("Restaurant");

        lats.add((float)50.64227621899096);
        lngs.add((float)3.0607223510742188);
        names.add("Aux Antipodes (restaurant&bar tapas)");
        omschrijvingen.add("Restaurant");
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        addData();

        //mMap.addMarker(new MarkerOptions().position(new LatLng(50.849999999999990000, 2.883333300000004000)).title("Marker"));
        // Enable MyLocation Layer of Google Map
        mMap.setMyLocationEnabled(true);

        // Get LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // Create a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Get the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Get Current Location
        Location myLocation = locationManager.getLastKnownLocation(provider);

        // set map type
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Get latitude of the current location
        double latitude = myLocation.getLatitude();

        // Get longitude of the current location
        double longitude = myLocation.getLongitude();

        // Create a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Show the current location in Google Map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20));
        //mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("You are here!").snippet("Consider yourself located"));

        /*CLIENT ID = SEXPMO5VHLZECD1RKAP0XSK33MOSWXWBKIAQ1WQIDSRD5XD2

        SECRET = GDITNVWNFXYJXS1DVTVKY5KPJ53553ADOUGH3IEKE32QBUBJ*/

        /*
            https://api.foursquare.com/v2/venues/search?client_id=SEXPMO5VHLZECD1RKAP0XSK33MOSWXWBKIAQ1WQIDSRD5XD2&client_secret=GDITNVWNFXYJXS1DVTVKY5KPJ53553ADOUGH3IEKE32QBUBJ&v=20130815&ll=50.849999999999990000,2.883333300000004000
        */

        /*
            https://api.foursquare.com/v2/venues/search?client_id=SEXPMO5VHLZECD1RKAP0XSK33MOSWXWBKIAQ1WQIDSRD5XD2&client_secret=GDITNVWNFXYJXS1DVTVKY5KPJ53553ADOUGH3IEKE32QBUBJ&v=20130815&ll=50.849999999999990000,2.883333300000004000&query=bar,restaurant
        */
        URL url1;
        URL url2;
        try{
            url1 = new URL("https://maps.google.com/mapfiles/kml/shapes/dining.png");
            Drawable drw1 = getResources().getDrawable(R.drawable.dining);
            Bitmap bmpLarge1 = ((BitmapDrawable)drw1).getBitmap();
            Matrix matrix1 = new Matrix();
            matrix1.postScale((float)80/bmpLarge1.getWidth(), (float)80/bmpLarge1.getHeight());
            Bitmap bmp1 = Bitmap.createBitmap(bmpLarge1, 0,0,bmpLarge1.getWidth(), bmpLarge1.getHeight(),matrix1,false);

            //
            Drawable drw2 = getResources().getDrawable(R.drawable.coffee);
            Bitmap bmpLarge2 = ((BitmapDrawable)drw2).getBitmap();
            Matrix matrix2 = new Matrix();
            matrix2.postScale((float)80/bmpLarge2.getWidth(), (float)80/bmpLarge2.getHeight());
            Bitmap bmp2 = Bitmap.createBitmap(bmpLarge2, 0,0,bmpLarge2.getWidth(), bmpLarge2.getHeight(),matrix2,false);

            int lengte = lats.size();
            for(int i=0; i<lengte; i++){
                if(omschrijvingen.get(i) == "Restaurant"){
                    mMap.addMarker(new MarkerOptions().position(new LatLng(lats.get(i),lngs.get(i))).title(names.get(i)).snippet(omschrijvingen.get(i)).icon(BitmapDescriptorFactory.fromBitmap(bmp1)));
                }
                else if(omschrijvingen.get(i) == "Bar"){
                    mMap.addMarker(new MarkerOptions().position(new LatLng(lats.get(i),lngs.get(i))).title(names.get(i)).snippet(omschrijvingen.get(i)).icon(BitmapDescriptorFactory.fromBitmap(bmp2)));
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }



        /*String clientId = "SEXPMO5VHLZECD1RKAP0XSK33MOSWXWBKIAQ1WQIDSRD5XD2";
        String clientSecret = "GDITNVWNFXYJXS1DVTVKY5KPJ53553ADOUGH3IEKE32QBUBJ";
        String lat = "50.849999999999990000";
        String lon = "2.883333300000004000";
        String query = "bar,restaurant";*/
        //String uri = "https://api.foursquare.com/v2/venues/search?client_id="+clientId+"&client_secret="+clientSecret+"&v=20130815&ll="+lat+","+lon+"&query="+query;
        //json = new JSONObject("https://api.foursquare.com/v2/venues/search?client_id="+clientId+"&client_secret="+clientSecret+"&v=20130815&ll="+lat+","+lon+"&query="+query);

    }

    public class FoursquareAsyncTask extends AsyncTask<String, Void, Boolean> {
        JSONObject jObj;
        @Override
        protected Boolean doInBackground(String... params) {
            try{
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(params[0]);
                HttpResponse httpResponse = client.execute(post);

                int status = httpResponse.getStatusLine().getStatusCode();

                if(status==200){
                    HttpEntity entity = httpResponse.getEntity();
                    String data = EntityUtils.toString(entity);
                    System.out.println(data);
                    //Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT);
                    jObj = new JSONObject(data);


                    JSONObject response = jObj.getJSONObject("response");
                    JSONArray venues = jObj.getJSONArray("venues");

                    int length = venues.length();

                    for(int i=0; i<length; i++){
                        JSONObject item = venues.getJSONObject(i);
                        JSONObject location = item.getJSONObject("location");
                        lats.add((float)location.getDouble("lat"));
                        lngs.add((float)location.getDouble("lon"));
                    }

                    /*
                    Bovenstaande werkt nog niet volledig: de length blijft 0
                     daarom hieronder van één plaats (thuis) enkele locaties:
                    */
                    addData();

                }

            }
            catch (ClientProtocolException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            catch(JSONException e){
                e.printStackTrace();
            }
            return null;
        }



        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);


        }
    }
}
