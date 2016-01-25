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

public class Roll_cuts extends AppCompatActivity implements communicator {

    private Toolbar toolbar;                              // Declaring the Toolbar Object
    GridView gv;
    LinearLayout ml ;
    public static int gt = 0;
    TextView gtotal;
    public static String[] prgmNameList = {"Cassata Cut", "Malai Kulfi", "Raja Rani", "Slice Cassata"};
    public static int[] qunt = {0, 0, 0, 0};
    public static int[] prgmImages = {R.drawable.cassata_cut, R.drawable.malai_kulfi, R.drawable.raja_rani, R.drawable.slice_cassata};
    public static int[] price = {40, 40, 40, 50};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll__cuts);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                               // this is the bluetoolbar

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ml= (LinearLayout) findViewById(R.id.linearLayout);
        Adapter adapter = new CustomAdapter(Roll_cuts.this,prgmNameList,prgmImages,qunt,gt,price);
        gv=(GridView) findViewById(R.id.exoticsundaegrid);
        gv.setAdapter((ListAdapter) adapter);
        gv.smoothScrollToPosition(AbsListView.TRANSCRIPT_MODE_NORMAL);
        gv.setSelection(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        gtotal = (TextView) findViewById(R.id.grandtotal);

    }
    public void cart(View v)
    {
        Intent mintent = new Intent(Roll_cuts.this,Cart.class);
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
