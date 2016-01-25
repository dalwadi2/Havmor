package dalwadi.harsh.havmor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;


public class Milk_Shakes extends ActionBarActivity implements communicator {


    private Toolbar toolbar;                              // Declaring the Toolbar Object
    GridView gv;
    public static int gt = 0;
    TextView gtotal;
    LinearLayout ml;
    public static String[] prgmNameList = {"Cookie Cream", "Almond Mocha", "Mango Magic", "Pink Current", "Choco Truffle"};
    public static int[] qunt = {0, 0, 0, 0, 0};
    public static int[] prgmImages = {R.drawable.chic_choc_sundae, R.drawable.choco_sundae, R.drawable.super_sundae, R.drawable.mango_sundae, R.drawable.super_sundae};
    public static int[] price = {40, 40, 40, 40, 50};
    public static final String DEFAULT = "N/A";
    String myTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk__shakes);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                               // this is the bluetoolbar

        ml= (LinearLayout) findViewById(R.id.linearLayout);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Adapter adapter = new CustomAdapter(Milk_Shakes.this, prgmNameList, prgmImages, qunt, gt, price);
        gv = (GridView) findViewById(R.id.milkshakegrid);
        gv.setAdapter((ListAdapter) adapter);
        gv.smoothScrollToPosition(AbsListView.TRANSCRIPT_MODE_NORMAL);
        gv.setSelection(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        gtotal = (TextView) findViewById(R.id.grandtotal);

       /* SharedPreferences sharedPreferences = getSharedPreferences("mycart", Context.MODE_PRIVATE);
        myTotal = sharedPreferences.getString("finaltotal", DEFAULT);
        if (myTotal.equals( DEFAULT)) {
            Toast.makeText(Milk_Shakes.this, "No quantity found !!", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(Milk_Shakes.this, "Previous quantity loaded Successfully", Toast.LENGTH_SHORT).show();
            gtotal.setText(myTotal);
        }*/

    }

    public void cart(View v) {
        Intent mintent = new Intent(Milk_Shakes.this, Cart.class);
        startActivity(mintent);
    }

   /* public void maintoatal(int i) {
        gtotal.setText(Integer.parseInt(String.valueOf(i)));
    }*/

    public void updatetotal(int i) {
        ml.setVisibility(View.VISIBLE);
        gtotal.setText(String.valueOf(i));

       /* SharedPreferences sharedPreferences = getSharedPreferences("mycart", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("finaltotal", String.valueOf(i));
        editor.commit();*/
    }

}
