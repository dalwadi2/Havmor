package dalwadi.harsh.havmor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

public class Topo_Cones extends AppCompatActivity implements communicator {

    private Toolbar toolbar;                              // Declaring the Toolbar Object
    GridView gv;
    public static int gt = 0;
    TextView gtotal;
    LinearLayout ml ;
    public static String[] prgmNameList = {"Butter Scotch", "Chic Choc", "Choco Almond", "Chocolate", "Havmore Cone", "Kesar Pista", "Mango Cone", "Raja Rani", "Ringo Bingo"};
    public static int[] qunt = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] prgmImages = {R.drawable.butter_scotch1, R.drawable.chic_choc_cone, R.drawable.choco_almond, R.drawable.chocolate, R.drawable.havmor_cone, R.drawable.kesar_pista, R.drawable.mango_cone, R.drawable.raja_rani1, R.drawable.ringo_bingo};
    public static int[] price = {40, 40, 40, 40, 40, 40, 40, 40, 40};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topo__cones);


        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                               // this is the bluetoolbar

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ml = (LinearLayout) findViewById(R.id.linearLayout);
        Adapter adapter = new CustomAdapter(Topo_Cones.this, prgmNameList, prgmImages, qunt, gt, price);
        gv = (GridView) findViewById(R.id.topocongrid);
        gv.setAdapter((ListAdapter) adapter);
        gv.smoothScrollToPosition(AbsListView.TRANSCRIPT_MODE_NORMAL);
        gv.setSelection(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        gtotal = (TextView) findViewById(R.id.grandtotal);
    }

    public void cart(View v) {
        Intent mintent = new Intent(Topo_Cones.this, Cart.class);
        startActivity(mintent);
    }

    public void maintoatal(int i) {
        gtotal.setText(Integer.parseInt(String.valueOf(i)));
    }

    public void updatetotal(int i) {
        ml.setVisibility(View.VISIBLE);
        gtotal.setText(String.valueOf(i));
    }

}
