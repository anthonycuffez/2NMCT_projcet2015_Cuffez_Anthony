package be.howest.nmct.Loader;

import android.provider.BaseColumns;

/**
 * Created by Anthony on 4/05/2015.
 */
public class Contract {
    public interface PlacesColumns extends BaseColumns {
        public static final String COLUMN_NAAMPLAATS = "naamplaats";
        public static final String COLUMN_CATEGORIE = "categorie";
        public static final String COLUMN_LAT = "lat";
        public static final String COLUMN_LNG = "long";
    }

    public interface CategoryColumns extends BaseColumns{
        public static final String COLUMN_CATEGORIENAAM = "categorienaam";
    }
}
