package be.howest.nmct;

import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import be.howest.nmct.Loader.CategoriesLoader;
import be.howest.nmct.Loader.Contract;
import be.howest.nmct.Loader.PlacesLoader;


public class CategoryListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor>{
    class CategoryAdapter extends SimpleCursorAdapter {
        private int layout;

        public CategoryAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
            super(context, layout, c, from, to, flags);
            this.layout = layout;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            super.bindView(view, context, cursor);
        }
    }

    private CategoryAdapter mAdapter;
    private OnCategoryListFragmentListener onCategoryListFragmentListener;
    public interface OnCategoryListFragmentListener{
        public void onSelectCategory(String naam);
    }

    public CategoryListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            onCategoryListFragmentListener = (OnCategoryListFragmentListener) activity;
        } catch (ClassCastException ex){
            throw new ClassCastException(activity.toString() + "implement interface OnCategoryListFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onCategoryListFragmentListener = null;
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
        String[] columns = new String[]{Contract.CategoryColumns.COLUMN_CATEGORIENAAM};
        int[] viewIds = new int[]{R.id.textViewName};

        mAdapter = new CategoryAdapter(getActivity(), R.layout.row_category, null, columns, viewIds, 0);
        setListAdapter(mAdapter);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CategoriesLoader(getActivity());
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
        String selectedCategory = c.getString(c.getColumnIndex(Contract.CategoryColumns.COLUMN_CATEGORIENAAM));
        String temp = selectedCategory;
        if(onCategoryListFragmentListener != null){
            onCategoryListFragmentListener.onSelectCategory((selectedCategory));
        }
    }
}
