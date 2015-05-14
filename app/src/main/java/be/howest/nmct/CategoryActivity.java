package be.howest.nmct;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class CategoryActivity extends Activity implements CategoryListFragment.OnCategoryListFragmentListener, CategoryDetailListFragment.OnCategoryDetailListFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        if(savedInstanceState == null){
            getFragmentManager().beginTransaction().add(R.id.container, new CategoryListFragment()).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
        A placeholder fragment containing a simple view.
    */

    @Override
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount() == 0){ //set to 1 to close the app
            finish();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public void onSelectCategory(String naam){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        CategoryDetailListFragment categoryDetailListFragment = CategoryDetailListFragment.newCategoryDetailListFragment(naam);

        fragmentTransaction.replace(R.id.container, categoryDetailListFragment);
        fragmentTransaction.addToBackStack("showCategoryDetailListFragment");

        fragmentTransaction.commit();
    }

    @Override
    public void onSelectPlace(String naam){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        CategoryDetailListFragment categoryDetailListFragment = CategoryDetailListFragment.newCategoryDetailListFragment(naam);

        fragmentTransaction.replace(R.id.container, categoryDetailListFragment);
        fragmentTransaction.addToBackStack("showCategoryDetailListFragment");

        fragmentTransaction.commit();
    }
}
