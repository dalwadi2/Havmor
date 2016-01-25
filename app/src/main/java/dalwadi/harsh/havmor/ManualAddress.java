package dalwadi.harsh.havmor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ManualAddress extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    Spinner mspinner;
    TextView fulladd;
    EditText frstname,lastname, add1, pin;
    String mfname, mlname, madd, mpin, area,str;
    Button confirm,skip;
    private Toolbar toolbar;                              // Declaring the Toolbar Object


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_address);


        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                             // this is the bluetoolbar

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mspinner = (Spinner) findViewById(R.id.spinner);
        frstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        add1 = (EditText) findViewById(R.id.address1);
        pin = (EditText) findViewById(R.id.pincode);
        fulladd = (TextView) findViewById(R.id.textView2);
        confirm = (Button) findViewById(R.id.cnfrmbtn);
        skip = (Button) findViewById(R.id.skipbtn);

        frstname.setFocusable(true);
        frstname.requestFocus();

        ArrayAdapter myadapter = ArrayAdapter.createFromResource(this, R.array.areanames, R.layout.support_simple_spinner_dropdown_item);
        mspinner.setAdapter(myadapter);
        mspinner.setOnItemSelectedListener(this);

       
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManualAddress.this, MainActivity.class);
                startActivity(intent);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mfname = frstname.getText().toString();
                mlname = lastname.getText().toString();
                madd = add1.getText().toString();
                mpin = pin.getText().toString();
                str = mfname + " " + mlname + "\n" + madd + " , " + area + " , " + mpin + "\nAhmedabad.";

                if (mfname.isEmpty() || mlname.isEmpty() || madd.isEmpty() || mpin.isEmpty())
                {
                    Toast.makeText(ManualAddress.this, "Please Enter All Data", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ManualAddress.this, mfname + " " + mlname + "\n" + madd + " , " + area + " , " + mpin + "\nAhmedabad.", Toast.LENGTH_LONG).show();
                    String mstring = mfname + " " + mlname + "\n" + madd + " , " + area + " , " + mpin + "\nAhmedabad.";
                    SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("FullAddress", mstring);
                    editor.commit();
                    Toast.makeText(ManualAddress.this, "Data saved" + mstring, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ManualAddress.this, Address_view.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView areaspinner = (TextView) view;
        area = areaspinner.getText().toString();
        Toast.makeText(ManualAddress.this, "you select " + areaspinner.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
