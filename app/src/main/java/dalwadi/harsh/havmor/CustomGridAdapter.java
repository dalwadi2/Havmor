package dalwadi.harsh.havmor;

/**
 * Created by Dalwadi on 21-09-2015.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomGridAdapter extends BaseAdapter {

    String[] result;
    Context context;
    public static final String DEFAULT = "N/A";
    String myTotal;
    int textView, persnal = 0;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public CustomGridAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        context = mainActivity;
        imageId = prgmImages;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        SharedPreferences sharedPreferences = context.getSharedPreferences("mycart", Context.MODE_PRIVATE);
        myTotal = sharedPreferences.getString("finaltotal", DEFAULT);
        if (myTotal.equals(DEFAULT)) {
            Toast.makeText(context, "No quantity found !!", Toast.LENGTH_SHORT).show();
            textView = 0;
        } else {
            Toast.makeText(context, "Previous quantity loaded Successfully" + myTotal, Toast.LENGTH_SHORT).show();
            textView = Integer.parseInt(myTotal);
            Toast.makeText(context, "Previous " + textView, Toast.LENGTH_SHORT).show();

            // com.updatetotal(textView);
        }
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder = new Holder();
        final View rowView;

        rowView = inflater.inflate(R.layout.single_item, null);
        holder.tv = (TextView) rowView.findViewById(R.id.itemnametext);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setId(position);
        final int im2 = rowView.getId();

       // final String aa = (String) holder.tv.getText();   // this work also
        final String aa = result[position];
        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "" + aa, Toast.LENGTH_LONG).show();
                Toast.makeText(context, rowView.getId() + " You Clicked " + result[position], Toast.LENGTH_LONG).show();
                if (im2 == 0) {
                    Intent i = new Intent(context, Ice_Cream_Scoops.class);
                    context.startActivity(i);
                }
                if (im2 == 1) {
                    Intent i = new Intent(context, Milk_Shakes.class);
                    context.startActivity(i);
                }
                if (im2 == 2) {
                    Intent i = new Intent(context, Roll_cuts.class);
                    context.startActivity(i);
                }
                if (im2 == 3) {
                    Intent i = new Intent(context, Candies.class);
                    context.startActivity(i);
                }
                if (im2 == 4) {
                    Intent i = new Intent(context, Blockbuster_Bar.class);
                    context.startActivity(i);
                }
                if (im2 == 5) {
                    Intent i = new Intent(context, Havmor_Specials.class);
                    context.startActivity(i);
                }
                if (im2 == 6) {
                    Intent i = new Intent(context, Topo_Cones.class);
                    context.startActivity(i);
                }
                if (im2 == 7) {
                    Intent i = new Intent(context, Sundae_Tub.class);
                    context.startActivity(i);
                }
                if (im2 == 8) {
                    Intent i = new Intent(context, Party_Packs.class);
                    context.startActivity(i);
                }

            }
        });

        return rowView;
    }

}