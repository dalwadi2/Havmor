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

public class Party_Packs extends AppCompatActivity implements communicator {

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    GridView gv;
    LinearLayout ml;
    public static int gt = 0;
    TextView gtotal;
    public static String[] prgmNameList = {"American Nutts", "Black Currant", "Bonanza", "Butter Scotch", "Chocolate Chips", "Cookie Cream", "Double Sundae Puding Tub", "Hazelnutt", "Kaju Draksh", "Lonavali", "Pan Flavour", "Pina Chips", "Plain Pista", "Real Mnago", "Straberry", "Vanilla", "Vanilla Gold"};
    public static int[] qunt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] prgmImages = {R.drawable.american_nuts1, R.drawable.black_currant, R.drawable.bonanza_party_pack, R.drawable.butter_scotch, R.drawable.chocolate_chips_party, R.drawable.cookie_cream_party, R.drawable.double_sunday_puding_tubes_thumb, R.drawable.hazelnutt, R.drawable.kaju_draksha, R.drawable.lonavali, R.drawable.pan_ice_cream, R.drawable.pina_chips_party, R.drawable.plain_pista, R.drawable.real_mango, R.drawable.strawberry1, R.drawable.vanilla, R.drawable.vanilla_gold};
    public static int[] price = {40, 40, 40, 40, 50, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party__packs);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                               // this is the bluetoolbar

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ml = (LinearLayout) findViewById(R.id.linearLayout);
        Adapter adapter = new CustomAdapter(Party_Packs.this, prgmNameList, prgmImages, qunt, gt, price);
        gv = (GridView) findViewById(R.id.partypackgrid);
        gv.setAdapter((ListAdapter) adapter);
        gv.smoothScrollToPosition(AbsListView.TRANSCRIPT_MODE_NORMAL);
        gv.setSelection(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        gtotal = (TextView) findViewById(R.id.grandtotal);

    }

    public void cart(View v) {
        Intent mintent = new Intent(Party_Packs.this, Cart.class);
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
