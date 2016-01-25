package dalwadi.harsh.havmor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import dalwadi.harsh.havmor.Objects.Student;

/**
 * Created by dalwadi on 10/1/2015.
 */
public class MyDBHelper extends SQLiteOpenHelper {

    Context context;
    public static final String DB_NAME = "Cart_Items";
    public static final String Table_cart = "CART";
    public static final String COLUMN_ItemName = "Item_Name";
    public static final String COLUMN_ItemPrice = "Item_Price";
    public int flag = 0;

    public MyDBHelper(Context context) {

        super(context, DB_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        flag = 1;
        db.execSQL("CREATE TABLE " + Table_cart + " (" + COLUMN_ItemName + " varchar2(15) , " + COLUMN_ItemPrice + " varchar2(15))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        flag = 2;
        db.execSQL("DROP TABLE IF EXISTS " + Table_cart);
        onCreate(db);
    }

    public boolean InsertValues(String myitem, int myprice) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues mContentValues = new ContentValues();
        mContentValues.put(COLUMN_ItemName, myitem);
        mContentValues.put(COLUMN_ItemPrice, myprice);
        db.insert(Table_cart, null, mContentValues);
        //db.execSQL();
        return true;
    }

    public List<Student> getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + Table_cart, null);
        mCursor.moveToFirst();
        List<Student> mStudentList = new ArrayList<>();

        while (mCursor.isAfterLast() == false) {
            Student mStudent = new Student();
            mStudent.setName(mCursor.getString(mCursor.getColumnIndex(COLUMN_ItemName)));
            mStudent.setId(mCursor.getInt(mCursor.getColumnIndex(COLUMN_ItemPrice)));
            mStudentList.add(mStudent);
            mCursor.moveToNext();
        }
        return mStudentList;
    }

    public int updatedb(String oldName, String newName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues mContentValues = new ContentValues();
        mContentValues.put(COLUMN_ItemPrice, newName);
        String[] param = {oldName};
        //Update Student set Name='LDRP' where Name='Jashvant Dave'
        int cnt = db.update(Table_cart, mContentValues, COLUMN_ItemPrice + " =? ", param);
        return cnt;
    }
    public int deleteAll(String tablename){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(tablename, null, null);
    }

    public int deletedb(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] param = {name};
        //Delete from Student where Name='Jashvant Dave'
        int cnt = db.delete(Table_cart, COLUMN_ItemPrice + " =? ", param);
        return cnt;
    }

    public int login(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] param = {name};
        String q = "SELECT * FROM " + Table_cart + " where name=?";
        Cursor mCursor = db.rawQuery(q, param);
        mCursor.moveToFirst();
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return mCursor.getInt(mCursor.getColumnIndex(COLUMN_ItemName));
            }
        }
        return 0;
    }


}
