package be.howest.nmct;

import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import be.howest.nmct.Loader.ActiviteitenLoader;
import be.howest.nmct.Loader.CategoriesLoader;
import be.howest.nmct.Loader.Contract;
import be.howest.nmct.Loader.HotelLoader;
import be.howest.nmct.Loader.PlacesLoader;
import be.howest.nmct.Loader.RestaurantsLoader;
import be.howest.nmct.Loader.VakantiewoningenLoader;

public class CategoryDetailListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {
    //private static String nameCategory;
    private static final String ARG_CATEGORY_NAME = "category_name";
    private static String CategoryName;

    class CategoryDetailAdapter extends SimpleCursorAdapter {
            private int layout;

            public CategoryDetailAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
                super(context, layout, c, from, to, flags);
                this.layout = layout;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                super.bindView(view, context, cursor);
            }
    }



    private CategoryDetailAdapter mAdapter;
    private OnCategoryDetailListFragmentListener onCategoryDetailListFragmentListener;
    public interface OnCategoryDetailListFragmentListener{
        public void onSelectPlace(String naam);
    }
    public CategoryDetailListFragment() {
        // Required empty public constructor
    }
    public static CategoryDetailListFragment newCategoryDetailListFragment(String naam) {
        CategoryDetailListFragment categoryDetailListFragment = new CategoryDetailListFragment();
        Bundle args = new Bundle();
        CategoryName = naam;
        args.putString(ARG_CATEGORY_NAME, naam);
        categoryDetailListFragment.setArguments(args);
        return categoryDetailListFragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            onCategoryDetailListFragmentListener = (OnCategoryDetailListFragmentListener) activity;
        } catch (ClassCastException ex){
            throw new ClassCastException(activity.toString() + "implement interface OnCategoryListFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onCategoryDetailListFragmentListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_category, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*String[] columns = new String[]{Contract.PlacesColumns.COLUMN_NAAMPLAATS, Contract.PlacesColumns.COLUMN_CATEGORIE, Contract.PlacesColumns.COLUMN_LAT, Contract.PlacesColumns.COLUMN_LNG};
        int[] viewIds = new int[]{R.id.textViewName, R.id.textViewFirstName, R.id.textViewEmail, R.id.textViewScoreResultaat};*/
        String[] columns = new String[]{Contract.PlacesColumns.COLUMN_NAAMPLAATS};
       /* if(CategoryName == "Hotels"){
            columns = new String[]{Contract.HotelsColumns.COLUMN_NAAMPLAATS};
        }
        else if(CategoryName == "Vakantiewoningen"){
            columns = new String[]{Contract.VakantiewoningenColumns.COLUMN_NAAMPLAATS};
        }
        else if(CategoryName == "Activiteiten"){
            columns = new String[]{Contract.ActiviteitenColumns.COLUMN_NAAMPLAATS};
        }
        else if(CategoryName == "Restaurants"){
            columns = new String[]{Contract.RestaurantsColumns.COLUMN_NAAMPLAATS};
        }
        else{
            //columns = new String[]{Contract.PlacesColumns.COLUMN_NAAMPLAATS};
            columns = null;
        }*/

        int[] viewIds = new int[]{R.id.textViewName};

        mAdapter = new CategoryDetailAdapter(getActivity(), R.layout.row_category, null, columns, viewIds, 0);
        setListAdapter(mAdapter);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if(CategoryName == "Hotels"){
            return new HotelLoader(getActivity());
        }
        else if(CategoryName == "Vakantiewoningen"){
            return new VakantiewoningenLoader(getActivity());
        }
        else if(CategoryName == "Activiteiten"){
            return new ActiviteitenLoader(getActivity());
        }
        else if(CategoryName == "Restaurants"){
            return new RestaurantsLoader(getActivity());
        }
        else{
            return new PlacesLoader(getActivity());
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Cursor c = (Cursor) mAdapter.getItem(position);
        String selectedPlace = c.getString(c.getColumnIndex(Contract.PlacesColumns.COLUMN_NAAMPLAATS));
        if(onCategoryDetailListFragmentListener != null){
            onCategoryDetailListFragmentListener.onSelectPlace((selectedPlace));
        }
    }
}
