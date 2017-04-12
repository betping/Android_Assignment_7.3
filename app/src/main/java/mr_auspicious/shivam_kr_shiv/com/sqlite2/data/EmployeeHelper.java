package mr_auspicious.shivam_kr_shiv.com.sqlite2.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mr_auspicious.shivam_kr_shiv.com.sqlite2.data.Employee;

import static mr_auspicious.shivam_kr_shiv.com.sqlite2.data.E_Contract.FeedEntry.E_AGE;
import static mr_auspicious.shivam_kr_shiv.com.sqlite2.data.E_Contract.FeedEntry.E_Image;
import static mr_auspicious.shivam_kr_shiv.com.sqlite2.data.E_Contract.FeedEntry.E_NAME;
import static mr_auspicious.shivam_kr_shiv.com.sqlite2.data.E_Contract.FeedEntry.TABLE_NAME;
import static mr_auspicious.shivam_kr_shiv.com.sqlite2.data.E_Contract.SQL_CREATE_TABLE;
import static mr_auspicious.shivam_kr_shiv.com.sqlite2.data.E_Contract.SQL_UPDATE_TABLE;

public class EmployeeHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EmployeeReader.db";


    //Constructor
    public EmployeeHelper(Context context) { //Constructor
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creating the database
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_UPDATE_TABLE);
        onCreate(db);
    }

    //Adding the values in the database..
    public Long addEmployeeDetails(Employee employee){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(E_NAME,employee.getName());
        cv.put(E_AGE,employee.getAge());
        cv.put(E_Image,employee.getImage());

        long id = db.insert(TABLE_NAME,null,cv);

        return id;

    }

    //Getting the Lists of data from the database
    public List<Employee> getEmployeeDetails(){

        List<Employee> books = new ArrayList<>();

        //Select Book Query
        String query = "SELECT * FROM " +TABLE_NAME;

        //Getting the database reference..
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        Employee employee = null;
        if(cursor.moveToFirst()){
            do{
                employee = new Employee();
                employee.setName(cursor.getString(0));
                employee.setAge(cursor.getInt(1));
                employee.setImage(cursor.getBlob(2));

                books.add(employee);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return books; //Getting list of data..
    }

}
