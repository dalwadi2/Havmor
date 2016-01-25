package dalwadi.harsh.havmor;

/**
 * Created by Dalwadi on 21-09-2015.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

    public String rupee;
    String[] result;
    Context context;
    String myTotal;
    int[] sinpri;
    int[] imageId;
    int[] quntity1;
    TextView gtotal;
    int textView, persnal = 0;
    LinearLayout ll;
    public static final String DEFAULT = "N/A";
    communicator com;
    MyDBHelper myhalper;
    private static LayoutInflater inflater = null;

    public CustomAdapter(Context mainActivity, String[] prgmNameList, int[] prgmImages, int[] quntity, int mtextView, int[] sin) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        sinpri = sin;
        quntity1 = quntity;
        context = mainActivity;
        com = (communicator) mainActivity;
        imageId = prgmImages;
        textView = mtextView;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rupee = mainActivity.getResources().getString(R.string.Rs) + " ";
        myhalper = new MyDBHelper(context);

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

        TextView tv, total, singelprice;
        ImageView img;
        ImageButton plus, minus;

        Holder(View v) {
            tv = (TextView) v.findViewById(R.id.mytext);
            img = (ImageView) v.findViewById(R.id.imageView);
            plus = (ImageButton) v.findViewById(R.id.addbutton);
            minus = (ImageButton) v.findViewById(R.id.minusbutton);
            total = (TextView) v.findViewById(R.id.sum);
            singelprice = (TextView) v.findViewById(R.id.price);
        }

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = null;

        final View row;

        if (convertView == null) {
            row = inflater.inflate(R.layout.single_item_lay, null);
            holder = new Holder(row);

            row.setTag(holder);
        } else {
            row = convertView;
            holder = (Holder) row.getTag();
        }

        holder.singelprice.setText(rupee + String.valueOf(sinpri[position]));
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        holder.total.setText(String.valueOf(quntity1[position]));
        holder.plus.setId(position);
        holder.minus.setId(position);
        holder.total.setId(position);
        row.setId(position);
        final String myItemName = result[position];
        final int myItemPrice = sinpri[position];
        row.setId(position);
        final int pp = holder.plus.getId();
        final int mm = holder.minus.getId();
        //final int totalsum = holder.total.getId();
       // final int im2 = row.getId();


        final Holder finalHolder = holder;

        holder.plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, row.getId()+ " You Clicked " + " add button "+ pp+" minus button "+ mm, Toast.LENGTH_LONG).show();

                ll = (LinearLayout) v.findViewById(R.id.linearLayout);

                Toast.makeText(context, "you click " + pp + " add button " + myItemName + "price:" + myItemPrice, Toast.LENGTH_SHORT).show();
                if (quntity1[position] == 0 || quntity1[position] < 5) {
                    // ll.setVisibility(View.VISIBLE);
                    quntity1[position] = quntity1[position] + 1;
                    finalHolder.total.setText(String.valueOf(quntity1[position]));
                    textView = textView + 1;
                    persnal = persnal + 1;
                    Toast.makeText(context, " " + textView, Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = context.getSharedPreferences("mycart", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("finaltotal", String.valueOf(textView));
                    editor.commit();


                    myhalper.InsertValues(myItemName, myItemPrice);
                    Log.e("harsh", "data inserted");

                   /* int tmp = persnal;
                    String mycartitems = "myitems" + tmp;
                    String mymoney = "mymoney" + tmp;
                    sharedPreferences = context.getSharedPreferences("cartitems", context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedPreferences.edit();
                    editor1.putString(mycartitems, myItemName);
                    editor1.putInt(mymoney, myItemPrice);
                    editor1.commit();*/

                    com.updatetotal(textView);
                    /*Intent myqunt = new Intent(context,MainActivity.class);
                    Bundle mybundle = new Bundle();
                    mybundle.putInt("myquntity",textView);
                    myqunt.putExtra("quntity", mybundle);
                    context.startActivity(myqunt);*/
                    //   gtotal.setText(String.valueOf(textView));

                } else if (quntity1[position] >= 5) {
                    Toast.makeText(context, "You cannot order morethan 5 items", Toast.LENGTH_SHORT).show();
                    return;
                }


            }

        });
        holder.minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "you click " + mm + " minus button ", Toast.LENGTH_SHORT).show();
                if (quntity1[position] > 0) {
                    quntity1[position] = quntity1[position] - 1;

                    finalHolder.total.setText(String.valueOf(quntity1[position]));
                    textView = textView - 1;
                    Toast.makeText(context, " " + textView, Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = context.getSharedPreferences("mycart", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("finaltotal", String.valueOf(textView));
                    editor.commit();

                   /* sharedPreferences = context.getSharedPreferences("cartitems", context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedPreferences.edit();
                    editor1.remove(myItemName);
                    editor1.remove(String.valueOf(myItemPrice));
                    editor1.commit();*/

                    com.updatetotal(textView);


                    //  mainActivity.maintoatal(textView);
                    Toast.makeText(context, " " + textView, Toast.LENGTH_SHORT).show();

                } else if (quntity1[position] == 0) {
                    Toast.makeText(context, "You cannot order lessthan 0 item", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });

        /*row.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, row.getId() + " You Clicked " + result[position], Toast.LENGTH_LONG).show();

                if (im2 == 0) {
                    Intent i = new Intent(context, next.class);
                    context.startActivity(i);
                }
                if (im2 == 1) {
                    Intent i = new Intent(context, three.class);
                    context.startActivity(i);
                }
            }
        });*/

        return row;

    }


}