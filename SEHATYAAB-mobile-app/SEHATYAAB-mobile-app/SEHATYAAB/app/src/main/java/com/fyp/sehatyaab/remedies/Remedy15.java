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


public class Remedy15 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. SPORTS DRINK","2. AVOID CARBONATED DRINKS","3. STAYING HYDERATED","4. VOMITING"};

    String mDescription[] = {"Salty liquids, such as those found in electrolyte replacement sports drinks like gatorade may help to reduce nausea.\n\n" +
            "نمکین مائعات، جیسے کہ الیکٹرولائٹ کے متبادل اسپورٹس ڈرنک میں پائے جاتے ہیں جیسے کہ گیٹورڈ متلی کو کم کرنے میں مدد کر سکتا ہے۔" ,
            "Carbonated drinks, such as pepsi, can cause bloating and worsen nausea.\n\n" +
                    "کاربونیٹیڈ مشروبات نہ لیں، جیسے پیپسی، 7 اپ، سپرائٹ وغیرہ اپھارہ اور متلی کا سبب بن سکتے ہیں۔",
            "If nausea is accompanied by vomiting, it is essential to stay hydrated by taking small sips of water on a regular basis. Eating salty foods or drinking a non-carbonated, sugary drink can be helpful to restore the sugars and salts lost through vomiting.\n\n" +
                    "اگر متلی کے ساتھ الٹی بھی ہو تو پانی کے چھوٹے گھونٹ باقاعدگی سے پی کر ہائیڈریٹ رہنا ضروری ہے۔ نمکین غذائیں کھانا یا غیر کاربونیٹیڈ، شکر والا مشروب پینا متلی کے ذریعے ضائع ہونے والی شگر اور نمکیات کو بحال کرنے میں مددگار ثابت ہو سکتا ہے۔","Vomiting can help to reduce nausea in some cases, such as when the nausea is caused by food poisoning or alcohol. However, this will usually only provide short-term relief and can also worsen nausea.\n\n" +
            "الٹی بعض صورتوں میں متلی کو کم کرنے میں مدد کر سکتی ہے، جیسے کہ جب متلی فوڈ پوائزننگ یا الکحل کی وجہ سے ہو۔ تاہم، یہ عام طور پر صرف قلیل مدتی ریلیف فراہم کرے گا اور متلی کو بھی خراب کر سکتا ہے۔"};

    int images[] = {R.drawable.remedy46,R.drawable.remedy64,R.drawable.remedy18,R.drawable.remedy65};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy15);
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
                Intent i = new Intent(Remedy15.this, LoginActivity.class);
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

