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

public class Ice_Cream_Scoops extends ActionBarActivity implements communicator {


    private Toolbar toolbar;                              // Declaring the Toolbar Object
    GridView gv;
    LinearLayout ml;
    public static int gt = 0;
    TextView gtotal;
    public static String[] prgmNameList = {"Almond Carnival","American Nuts","Bonanza","Butter Scotch","Chocolate Chips","Cookie Cream","Kaju Draksh","Kesar Pista","Lonavali","Nutty Love","Pina Chips","Rajbhog","Strawberry","Vanilla"};
    public static int[] qunt = {0, 0, 0, 0, 0,0,0,0,0,0,0,0,0,0};
    public static int[] prgmImages = {R.drawable.almond_carnival, R.drawable.american_nuts, R.drawable.bonanza, R.drawable.butter_scotch_cup, R.drawable.chocolate_chips, R.drawable.cookie_creak_jumbo_cup, R.drawable.kaju_draksh, R.drawable.kesar_pista_cup, R.drawable.lonavali_jumbo_cup, R.drawable.nutty_love, R.drawable.pina_chips, R.drawable.rajbhog, R.drawable.strawberry, R.drawable.vanilla_bg_cups};
    public static int[] price = {40, 40, 40, 40, 50,40,40,40,40,40,40,40,40,40};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice__cream__scoops);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                             // this is the bluetoolbar

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ml= (LinearLayout) findViewById(R.id.linearLayout);

        Adapter adapter = new CustomAdapter(Ice_Cream_Scoops.this,prgmNameList,prgmImages,qunt,gt,price);
        gv=(GridView) findViewById(R.id.icecreamgrid);
        gv.setAdapter((ListAdapter) adapter);
        gv.smoothScrollToPosition(AbsListView.TRANSCRIPT_MODE_NORMAL);
        gv.setSelection(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        gtotal = (TextView) findViewById(R.id.grandtotal);

    }


    public void cart(View v)
    {
        Intent mintent = new Intent(Ice_Cream_Scoops.this,Cart.class);
        startActivity(mintent);
    }
    public  void maintoatal(int i)
    {
        gtotal.setText(Integer.parseInt(String.valueOf(i)));
    }
    public void updatetotal(int i) {
        ml.setVisibility(View.VISIBLE);
        gtotal.setText(String.valueOf(i));
    }

}
