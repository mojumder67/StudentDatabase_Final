package studentdatabase.nayan.com.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nayan on 3/20/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Students.db";
    public static final  String TABLE_NAME = "student_table";

    public static final  String ID = "ID";
    public static final  String NAME= "NAME";
    public static final  String STID= "STUDENT_ID";
    public static final  String MOBILE= "MOBILE";
    public static final  String EMAIL= "EMAIL";

    private static final String qurey = "CREATE TABLE " + TABLE_NAME + " ("
            + ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME+" TEXT, "
            + STID+" TEXT, "
            + MOBILE+" TEXT, "
            + EMAIL+" TEXT) ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(qurey);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name,String studentId,String mobile, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(STID, studentId);
        contentValues.put(MOBILE, mobile);
        contentValues.put(EMAIL, email);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
