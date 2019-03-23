package net.mysirg.customlist3;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] Atitle;
    String[] ADescription;
    int[] Aimage={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);

        Resources res = getResources();
       Atitle= res.getStringArray(R.array.arrTitle);

       ADescription=res.getStringArray(R.array.arrDescription);
       vivzadapter adapter =new vivzadapter(this,Atitle,ADescription,Aimage);
       listView.setAdapter(adapter);


    }

    class vivzadapter extends ArrayAdapter<String> {

        int[] PrImage;
        String[] PrTitle;
        String[] Prdescription;

        public vivzadapter(Context context, String[] prTitle, String[] prdescription, int[] prImage) {
            super(context, R.layout.row_layout,Atitle);
            PrImage = prImage;
            PrTitle = prTitle;
            Prdescription = prdescription;
        }

        class MyviewHolder {

            ImageView imageViewVh;
            TextView textView1Vh;
            TextView textView2Vh;

            public MyviewHolder(View V) {
                imageViewVh = (ImageView)V.findViewById(R.id.imageview_id);
                textView1Vh = (TextView)V.findViewById(R.id.textview1_id);
                textView2Vh = (TextView)V.findViewById(R.id.textview2_id);


            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            MyviewHolder holder = null;
            if (row == null) {

                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.row_layout, parent, false);

                holder = new MyviewHolder(row);

                row.setTag(holder);

            }
            else {

               holder=  (MyviewHolder) row.getTag();
                Log.d("vivz","Recycler Stuff");
               }
               holder.imageViewVh.setImageResource(PrImage[position]);
            holder.textView1Vh.setText(PrTitle[position]);
            holder.textView2Vh.setText(Prdescription[position]);

            return row;
        }

    }
}
