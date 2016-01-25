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

public class Havmor_Specials extends ActionBarActivity implements communicator{

    private Toolbar toolbar;                              // Declaring the Toolbar Object
    GridView gv;
    LinearLayout ml;
    public static int gt = 0;
    TextView gtotal;
    public static String[] prgmNameList = {"Black Forest Pastry", "Bon Bon", "Cookies Ice-cream Chocolate", "Rasmataz", "Sandwich Ice-cream"};
    public static int[] qunt = {0, 0, 0, 0, 0};
    public static int[] prgmImages = {R.drawable.black_forest_i_i_pastry, R.drawable.bon_bon, R.drawable.cookies_ice_crem_chocolate, R.drawable.rasmataz, R.drawable.sandwich_ice_cream};
    public static int[] price = {40, 40, 40, 40, 50};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_havmor__specials);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                               // this is the bluetoolbar

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ml = (LinearLayout) findViewById(R.id.linearLayout);

        Adapter adapter = new CustomAdapter(Havmor_Specials.this,prgmNameList,prgmImages,qunt,gt,price);
        gv=(GridView) findViewById(R.id.havmorspecialgrid);
        gv.setAdapter((ListAdapter) adapter);
        gv.smoothScrollToPosition(AbsListView.TRANSCRIPT_MODE_NORMAL);
        gv.setSelection(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        gtotal = (TextView) findViewById(R.id.grandtotal);
    }
    public void cart(View v)
    {
        Intent mintent = new Intent(Havmor_Specials.this,Cart.class);
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
