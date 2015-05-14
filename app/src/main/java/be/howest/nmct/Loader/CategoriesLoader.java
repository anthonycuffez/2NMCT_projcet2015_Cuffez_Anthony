package be.howest.nmct.Loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.BaseColumns;

import be.howest.nmct.data.Category;
import be.howest.nmct.data.CategoryAdmin;
import be.howest.nmct.data.Place;
import be.howest.nmct.data.PlaceAdmin;

public class CategoriesLoader extends AsyncTaskLoader<Cursor>{
    private Cursor cursor;
    private static Object lock = new Object();

    public final String[] mColumnNames = new String[]{
            BaseColumns._ID,
            Contract.CategoryColumns.COLUMN_CATEGORIENAAM
    };

    public CategoriesLoader(Context context){
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if(cursor != null){
            deliverResult(cursor);
        }

        if(takeContentChanged() || cursor == null){
            forceLoad();
        }
    }

    @Override
    public Cursor loadInBackground() {
        if (cursor == null){
            loadCursor();
        }
        return cursor;
    }

    private void loadCursor(){
        synchronized (lock){
            if(cursor != null){
                return;
            }
            MatrixCursor mCursor = new MatrixCursor(mColumnNames);
            int id = 1;
            for (Category cat : CategoryAdmin.getInstance().getCategories()){
                MatrixCursor.RowBuilder row = mCursor.newRow();
                row.add(id);
                row.add(cat.getCategorieNaam());
                id++;
            }
            cursor = mCursor;
        }
    }
}
