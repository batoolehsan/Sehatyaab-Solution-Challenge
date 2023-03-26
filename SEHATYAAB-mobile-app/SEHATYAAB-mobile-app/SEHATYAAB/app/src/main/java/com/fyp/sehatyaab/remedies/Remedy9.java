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


public class Remedy9 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. LEMON AND WATER","2. SALT WATER GARGLE","3. GREEN TEA"};

    String mDescription[] = {"Mix 1 teaspoon lemon juice in 1 cup water for this home remedy for sore throats; the astringent juice will help shrink swollen throat tissue and create a hostile (acidic) environment for viruses and bacteria.\n\n" +
            "گلے کی خراش کے اس گھریلو علاج کے لئے 1 کپ پانی میں 1 چائے کا چمچ لیموں کا رس مکس کریں۔ قابض دوا گلے کے ٹشو وں کو سکڑنے میں مدد کرے گا اور وائرس اور جَراثيم کے لئے ایک معاندانہ (تیزابی) ماحول پیدا کرے گا۔" ,
            "While the remedy may seem relatively simple, a salt and water gargle can help soothe a scratchy throat that causes you to cough. Mixing 1/4 to 1/2 teaspoon of salt with 8 ounces of warm water can help to relieve irritation. Note that since children under 6 years old are not especially good at gargling, it’s best to try other remedies for this age group.\n\n" +
                    "نمک اور پانی کے غرارے سے گلے میں خراش کو کم کرنے میں مدد مل سکتی ہے۔8 اونس گرم پانی کے ساتھ 1/4 سے 1/2 چائے کا چمچ نمک مکس کریں۔",
            "Green tea is known to naturally fight infections. Next time you brew a cup, make a little extra and gargle with some of this remedy to kill any bacteria your sore throat may be harbouring.\n\n" +
                    "سبز چائے قدرتی طور پر انفیکشن سے لڑنے کے لئے جانا جاتا ہے. اگلی بار جب آپ ایک کپ تیار کرتے ہیں تو ، تھوڑا سا اضافی بنائیں اورکسی بھی بیکٹیریا کو مارنے کے لئے اس میں سے کچھ علاج کے ساتھ غرارے کریں جو آپ کے گلے میں درد ہوسکتا ہے۔"
    };
    int images[] = {R.drawable.remedy27,R.drawable.remedy8,R.drawable.remedy16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy9);
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
                Intent i = new Intent(Remedy9.this, LoginActivity.class);
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

