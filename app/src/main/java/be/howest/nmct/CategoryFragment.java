package be.howest.nmct;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;

import be.howest.nmct.Loader.Contract;
import be.howest.nmct.Loader.PlacesLoader;


public class CategoryFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor>{
    class StudentAdapter extends SimpleCursorAdapter {
        private int layout;

        public StudentAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
            super(context, layout, c, from, to, flags);
            this.layout = layout;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            super.bindView(view, context, cursor);

            /*
            ImageView icon = (ImageView) view.findViewById(R.id.imageViewStudent);
            int colnr = cursor.getColumnIndex(Contract.StudentsColumns.COLUMN_STUDENT_SCORE_TOTAL);
            double score = cursor.getDouble(colnr);
            DecimalFormat df = new DecimalFormat("##.00");
            TextView textViewScoreTotaal = (TextView) view.findViewById(R.id.textViewScoreResultaat);
            textViewScoreTotaal.setText(df.format(score));*/

            /*if(cursor.getDouble(colnr) < 8){
                //icon.setImageResource(R.drawable.student_red);
            }
            else if(cursor.getDouble(colnr) < 10){
                //icon.setImageResource(R.drawable.student_orange);
            }
            else {
                //icon.setImageResource(R.drawable.student_green);
            }*/
        }
    }

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_category, container, false);
        return v;
    }

    private StudentAdapter adapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*String[] columns = new String[]{Contract.PlacesColumns.COLUMN_NAAMPLAATS, Contract.PlacesColumns.COLUMN_CATEGORIE, Contract.PlacesColumns.COLUMN_LAT, Contract.PlacesColumns.COLUMN_LNG};
        int[] viewIds = new int[]{R.id.textViewName, R.id.textViewFirstName, R.id.textViewEmail, R.id.textViewScoreResultaat};*/
        String[] columns = new String[]{Contract.PlacesColumns.COLUMN_NAAMPLAATS};
        int[] viewIds = new int[]{R.id.textViewName};

        adapter = new StudentAdapter(getActivity(), R.layout.row_category, null, columns, viewIds, 0);
        setListAdapter(adapter);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new PlacesLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }
}
