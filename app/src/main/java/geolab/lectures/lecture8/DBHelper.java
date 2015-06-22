package geolab.lectures.lecture8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jay on 6/22/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "JemoDB";
    private static final int DATABASE_VERSION = 2;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATE_SHOPPING_LIST_TABLE =
            "CREATE TABLE " + ShoppingListContracts.SHOPPING_LIST_TABLE_NAME + "("
            + ShoppingListContracts.SHOPPING_LIST_ID + " integer,"
            + ShoppingListContracts.SHOPPING_LIST_TITLE + " text not null,"
            + ShoppingListContracts.SHOPPING_LIST_ITEM + " text);";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SHOPPING_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println();
    }
}
