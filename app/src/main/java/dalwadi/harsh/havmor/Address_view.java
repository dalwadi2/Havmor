package dalwadi.harsh.havmor;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Address_view extends ActionBarActivity {

    public static final String DEFAULT = "N/A";
    TextView add;
    RadioButton myaddreadiobtn;
    String myaddress;
    Button movetoad , skiptomain;
    private Toolbar toolbar;                              // Declaring the Toolbar Object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_view);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);                         // this is the bluetoolbar


        add = (TextView) findViewById(R.id.fetch);
        myaddreadiobtn = (RadioButton) findViewById(R.id.MyAdressRadio);
        movetoad = (Button) findViewById(R.id.addnewaddressbtn);
        skiptomain = (Button) findViewById(R.id.Skiptomain);

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        myaddress = sharedPreferences.getString("FullAddress", DEFAULT);
        add.setText(myaddress);

        if (add.getText().toString() == DEFAULT) {
            Toast.makeText(Address_view.this, "No data found !!", Toast.LENGTH_LONG).show();
            skiptomain.setText("Skip & Continue");
           /* Toast t = new Toast(Address_view.this);
            t.setText("No data Found");
            t.setDuration(Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();*/
        } else {
            Toast.makeText(Address_view.this, "Previous Data loaded Successfully", Toast.LENGTH_SHORT).show();
            myaddreadiobtn.setText(myaddress);
            myaddreadiobtn.setVisibility(View.VISIBLE);
            skiptomain.setText("Continue with this Address");

        }
        skiptomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Address_view.this, MainActivity.class);
                startActivity(intent);
            }
        });
        movetoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Address_view.this, ManualAddress.class);
                startActivity(intent);
            }
        });
    }

}
