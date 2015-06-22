package geolab.lectures.lecture8;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<ListItem> shoppingList = new ArrayList();
        shoppingList.add(new ListItem("1", "Shaurma", "Gldanis Shaurma 2 c."));
        shoppingList.add(new ListItem("1", "Comeuli", "Xinkali"));
        shoppingList.add(new ListItem("2", "Comeuli", "Xachapuri"));

        DBHelper dbHelper = new DBHelper(this);

        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        Button insertbt = (Button) findViewById(R.id.insert);
        insertbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                for (int i = 0; i < shoppingList.size(); i++){
                    ListItem item = shoppingList.get(i);
                    values.put(ShoppingListContracts.SHOPPING_LIST_ID, item.getId());
                    values.put(ShoppingListContracts.SHOPPING_LIST_TITLE, item.getTitle());
                    values.put(ShoppingListContracts.SHOPPING_LIST_ITEM, item.getItem());
                    db.insert(ShoppingListContracts.SHOPPING_LIST_TABLE_NAME, null, values);
                }
            }
        });

        Button selectBtn = (Button) findViewById(R.id.select);
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                Cursor c = db.query(ShoppingListContracts.SHOPPING_LIST_TABLE_NAME, null, ShoppingListContracts.SHOPPING_LIST_ID + " = 1", null, null, null, null);
                int count = c.getCount();
                if(c.moveToFirst()){
                    do {
                        String id = c.getString(c.getColumnIndex(ShoppingListContracts.SHOPPING_LIST_ID));
                        String title = c.getString(c.getColumnIndex(ShoppingListContracts.SHOPPING_LIST_TITLE));
                        String item = c.getString(c.getColumnIndex(ShoppingListContracts.SHOPPING_LIST_ITEM));
                        ListItem item2 = new ListItem(id, title, item);
                        result += item2.toString() + "   ---   ";
                    } while(c.moveToNext());
                }

                TextView mda = (TextView) findViewById(R.id.text);
                mda.setText(result);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
