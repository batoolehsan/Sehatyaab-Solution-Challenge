package com.fyp.sehatyaab.remedies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.sehatyaab.LoginActivity;
import com.fyp.sehatyaab.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Remedy10 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. OLIVE OIL AND LEMON JUICE","2. SOAKED RAISINS","3. FLAXSEEDS"};

    String mDescription[] = {"Consume the pure olive oil in the morning when having an empty stomach.You can also add the lemon juice to the pure olive oil to lighten the flavor. Consume this mixture in the morning on an empty stomach. Take 1 tablespoon of pure olive oil & 1 teaspoon of lemon juice (optional).\n\n" +
            "خالص زیتون کا تیل صبح خالی پیٹ استعمال کریں۔ذائقہ ہلکا کرنے کے لئے آپ خالص زیتون کے تیل میں لیموں کا رس بھی شامل کرسکتے ہیں۔اس مکسچر کو صبح سویرے خالی پیٹ کھائیں۔ ایک کھانے کا چمچ خالص زیتون کا تیل اور ایک چائے کا چمچ لیموں کا رس لیں۔" ,
            "Take 1 cup of raisins and 1 ½ cups of fresh water , soak the raisins overnight and eat in the morning.Then you drink the water that raisins were soaked in.You should repeat this way daily as needed.\n\n" +
                    "ایک کپ کشمش اور ڈیڑھ کپ پانی لے کر کشمش کو رات بھر بھگو کر صبح نہار منہ کھائیں۔ اس کے بعد وہ پانی پئیں جس میں کشمش بھیگی ہوئی تھی۔ آپ اس نسخہ کو روزانہ حسب ضرورت دہرا سکتے ہیں۔",
            "Add 1 tablespoon of flaxseeds into a glass of water. Let it rest for about 2 to 3 hours. Drink this water daily before you go to bed. Just follow this solution for a few days and your bowel movement can be much better Or, simply you eat 2 to 3 tablespoons of ground flaxseeds and drink a glass of water.\n\n" +
                    "ایک گلاس پانی میں 1 کھانے کا چمچ فلیکسیڈ ڈالیں۔ اسے تقریباً 2 سے 3 گھنٹے تک رکھیں۔ اس پانی کو روزانہ سونے سے پہلے پئیں۔ بس کچھ دنوں تک اس حل پر عمل کریں یا پھر آپ 2 سے 3 کھانے کے چمچ پسے ہوئے فلیکس سیڈز کھائیں اور ایک گلاس پانی پی لیں۔"
    };
    int images[] = {R.drawable.remedy29,R.drawable.remedy32,R.drawable.remedy33};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy10);
        listView = (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();


        // now set item click on list view
        // so item click is done now check list view
    }
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String[] title, String[] description, int[] imgs) {
            super(c, R.layout.row_home_remedies, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_home_remedies, parent, false);
            ImageView images =(ImageView) row.findViewById(R.id.image);
            TextView myTitle = (TextView) row.findViewById(R.id.textView1);
            TextView myDescription = (TextView) row.findViewById(R.id.textView2);
            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
        public boolean isEnabled(int position) {

            return false;
        }


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // adding a click listener for option selected on below line.
        int id = item.getItemId();
        switch (id) {
            case R.id.idLogOut:
                // displaying a toast message on user logged out inside on click.
                Toast.makeText(getApplicationContext(), "User Logged Out", Toast.LENGTH_LONG).show();
                // on below line we are signing out our user.
                mAuth.signOut();
                // on below line we are opening our login activity.
                Intent i = new Intent(Remedy10.this, LoginActivity.class);
                startActivity(i);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // on below line we are inflating our menu
        // file for displaying our menu options.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}

