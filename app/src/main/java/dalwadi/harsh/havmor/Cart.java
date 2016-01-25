package dalwadi.harsh.havmor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import dalwadi.harsh.havmor.Objects.Student;

public class Cart extends AppCompatActivity {


    private Toolbar toolbar;                              // Declaring the Toolbar Object

    Button mbtn;
    TextView mytext, myprice, mytttttt;
    MyDBHelper mhelper;
    StringBuffer items, prices, total;
    int mm = 0;
    String[] hh;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                               // this is the bluetoolbar

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mbtn = (Button) findViewById(R.id.cartmy);
        items = new StringBuffer();
        prices = new StringBuffer();
        total = new StringBuffer();
        mytext = (TextView) findViewById(R.id.myitemstext);
        myprice = (TextView) findViewById(R.id.mypricetext);
        mytttttt = (TextView) findViewById(R.id.mytt);
        mhelper = new MyDBHelper(this);


        List<Student> mStudentList = mhelper.getAllData();
        for (Student mStudent : mStudentList) {
            items.append(mStudent.getName() + "\n");
            prices.append(mStudent.getId() + "\n");
            mm = mStudent.getId();
            total.append(mm + " ");
            hh = total.toString().split(" ");

            Log.e("harsh", "ID : " + mStudent.getId() + "   Name : " + mStudent.getName());
        }
        Toast.makeText(Cart.this, "" + total, Toast.LENGTH_LONG).show();
        //mytttttt.setText(total);
        for (int i=0 ; i<hh.length; i++)
        {

            sum= Integer.parseInt(hh[i])+sum;
        }
        mytext.setText(items);
        myprice.setText(prices);
        mytttttt.setText(String.valueOf(sum));
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
