package mr_auspicious.shivam_kr_shiv.com.sqlite2.data;

import android.provider.BaseColumns;

//Contract class

public class E_Contract {

    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + FeedEntry.TABLE_NAME + "(" +FeedEntry.E_NAME
            + " TEXT," + FeedEntry.E_AGE + " INTEGER," + FeedEntry.E_Image + " BLOB);";


    public static final String SQL_UPDATE_TABLE = "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;


    public static class FeedEntry implements BaseColumns {

        public static final String TABLE_NAME = "Employee";

        public static final String E_NAME = "Name";

        public static final String E_AGE = "Age";

        public static final String E_Image = "Image";


    }

}
