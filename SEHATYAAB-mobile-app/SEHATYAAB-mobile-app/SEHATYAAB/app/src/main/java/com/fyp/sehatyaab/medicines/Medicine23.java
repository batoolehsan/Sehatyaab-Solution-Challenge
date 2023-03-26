package com.fyp.sehatyaab.medicines;

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
import com.fyp.sehatyaab.adultsymptoms;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Medicine23 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"SANCOS","BRUFEN","ARINAC"};

    String mDescription[] = {"Sancos Syrup is used to treat cough. It thins, decreases the stickiness and loosens mucus in the nose and windpipe making it easier to cough out.\n\n"+ "یہ کھانسی کے علاج کے لئے استعمال کیا جاتا ہے. یہ پتلا، چپچپا پن کو کم کرتا ہے اور ناک اور ہوا کی نالی میں بلغم کو ڈھیلا کرتا ہے، کھانسی کو باہر نکالنا آسان بناتا ہے۔",
            "Brufen syrup is often recommended to treat inflammation. Treating sore throat to teething pain as well as sprains and muscular pains,brufen uses are multiple and diverse.\n\n"+"سوزش کے علاج کے لیے اکثر بروفین سیرپ کی سفارش کی جاتی ہے۔ گلے کی خراش سے لے کر دانتوں کے درد کے ساتھ ساتھ موچ اور پٹھوں کے درد کا علاج، بروفین کے استعمال متعدد اور متنوع ہیں۔",
            "Arinac is recommended for the treatment of fever, nasal congestion, flu and headache.\n"+
                    "اریناک بخار، ناک بند ہونا، فلو اور سر درد کے علاج کے لیے استعمال کی جاتی ہے۔"};

    int images[] = {R.drawable.sancos,R.drawable.brufen2,R.drawable.arinac2};

    String mDosage[] = {"The usual dose for kids is 1 tablespoon up to 3 times in 24 hours.\n" + "Keep a gap of at least 4-6 hours between the dose and the next dose.\n\n"+"بچوں کے لیے معمول کی خوراک 24 گھنٹوں میں 3 بار تک 1 چمچ ہے۔" +
            "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "The usual dose for kids is 1 tablespoon up to 3 times in 24 hours.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n"+"بچوں کے لیے معمول کی خوراک 24 گھنٹوں میں 3 بار تک 1 چمچ ہے۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "The usual dose for kids is 1 tablespoon up to 3 times in 24 hours.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n" +
                    "بچوں کے لیے معمول کی خوراک 24 گھنٹوں میں 3 بار تک 1 چمچ ہے۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔\n"};

    String mSideEffects[] = {"Common side effects constipation, stomach pain, muscle cramps or headache.\n\n"+"عام ضمنی اثرات قبض، پیٹ میں درد، پٹھوں میں درد یا سر درد۔ ",
            "Common side effects includes vomiting, nausea, diarrhea, indigestion etc.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں الٹی، متلی، اسہال، بدہضمی وغیرہ شامل ہیں۔\n",
            "Common side effects may include stomach pain, gastrointestinal disturbances, nausea and vomiting, and diarrhea.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں پیٹ میں درد، معدے کی خرابی، متلی اور الٹی، اور اسہال شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine23);
        listView = (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images, mDosage, mSideEffects);
        listView.setAdapter(adapter);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        // now set item click on list view
        // so item click is done now check list view
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
                Intent i = new Intent(Medicine23.this, LoginActivity.class);
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
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        String rDosage[];
        String rSideEffects[];

        MyAdapter(Context c, String[] title, String[] description, int[] imgs, String[] dosage, String[] sideeffects) {
            super(c, R.layout.row_medicines, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rDosage = dosage;
            this.rImgs = imgs;
            this.rSideEffects = sideeffects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_medicines, parent, false);
            ImageView images =(ImageView) row.findViewById(R.id.image);
            TextView myTitle = (TextView) row.findViewById(R.id.textView1);
            TextView myDescription = (TextView) row.findViewById(R.id.textView2);
            TextView myDosage = (TextView) row.findViewById(R.id.textView3);
            TextView mySideEffects = (TextView) row.findViewById(R.id.textView4);
            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            myDosage.setText(rDosage[position]);
            mySideEffects.setText(rSideEffects[position]);


            return row;
        }
        public boolean isEnabled(int position) {

            return false;
        }


    }
}

