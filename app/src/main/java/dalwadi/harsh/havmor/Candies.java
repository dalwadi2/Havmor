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

public class Candies extends ActionBarActivity implements communicator{


    private Toolbar toolbar;                              // Declaring the Toolbar Object
    GridView gv;
    LinearLayout ml;
    public static int gt=0;
    TextView gtotal;
    public static String [] prgmNameList={"Almond Chocobar","Bombay Kulfi","Choco Bite","Chowpaty Kulfi","Classic Chocobar","Fruito Grape","Fruito Guava","Kachhi Keri","Kesar Chowpaty Kulfi","Khatta Meetha Aam","Lolly Pop","Mango Doodle","Mini Chocobar","Raspberry Dolly","Raspberry Doodle","Rocket Candy","Zulubar"};
    public static int[] qunt = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int [] prgmImages={R.drawable.almond_chocobar, R.drawable.bombay_kulfi, R.drawable.choco_bite, R.drawable.chowpaty_kulfi, R.drawable.classic_choco_bar, R.drawable.fruito_grape, R.drawable.fruito_guava, R.drawable.kacchi_keri, R.drawable.kesar_chowpaty_kulfi, R.drawable.khatta_metha_aam, R.drawable.lolly_pop, R.drawable.mango_doodle, R.drawable.mini_choco_bar, R.drawable.rasberry_dolly, R.drawable.raspberry_doodle, R.drawable.rocket_candy, R.drawable.zulubar};
    public static int[] price = {40,40,40,40,40,50,40,50,40,40,40,40,40,40,40,40,40};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candies);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                               // this is the bluetoolbar

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ml= (LinearLayout) findViewById(R.id.linearLayout);
        Adapter adapter = new CustomAdapter(Candies.this,prgmNameList,prgmImages,qunt,gt,price);
        gv=(GridView) findViewById(R.id.candiegrid);
        gv.setAdapter((ListAdapter) adapter);
        gv.smoothScrollToPosition(AbsListView.TRANSCRIPT_MODE_NORMAL);
        gv.setSelection(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        gtotal = (TextView) findViewById(R.id.grandtotal);
    }


    public void cart(View v)
    {
        Intent mintent = new Intent(Candies.this,Cart.class);
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
