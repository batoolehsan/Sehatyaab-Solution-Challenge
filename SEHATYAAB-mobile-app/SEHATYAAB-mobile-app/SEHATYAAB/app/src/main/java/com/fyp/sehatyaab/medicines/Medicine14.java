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


public class Medicine14 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"BISMUTH SUBSALICYLATE","TRIORAL","IMODIUM"};

    String mDescription[] = {"Bismuth subsalicylate is used to treat diarrhea, heartburn, and upset stomach in adults and children 12 years of age and older. Bismuth subsalicylate is in a class of medications called antidiarrheal agents.\n\n"+ "بسمتھ سبسیلیٹ کا استعمال 12 سال اور اس سے زیادہ عمر کے بالغوں اور بچوں میں اسہال، سینے کی جلن، اور پیٹ کی خرابی کے علاج کے لیے کیا جاتا ہے۔ بسمتھ سبسیلیسیلیٹ ادویات کی ایک کلاس میں ہے جسے اینٹی ڈائیریل ایجنٹ کہتے ہیں۔",
            "TRIORAL treat food poisoning by making sure you don’t get dehydrated. One of the symptoms of food poisoning is diarrhea, which dehydrates you.\n\n"+"یہ اس بات کو یقینی بنا کر فوڈ پوائزننگ کا علاج کرتا ہے کہ آپ کو پانی کی کمی نہ ہو۔ فوڈ پوائزننگ کی علامات میں سے ایک اسہال ہے، جو آپ کو پانی کی کمی کا باعث بنتا ہے۔",
            "Imodium is a prescription medicine used to treat the symptoms of acute diarrhea, chronic diarrhea and Traveler’s Diarrhea. This is an effective medicine for food poisoning as it relieves diarrhea.\n\n"+
                    "اموڈیم ایک نسخہ کی دوا ہے جو شدید اسہال، دائمی اسہال اور ٹریولرز ڈائریا کی علامات کے علاج کے لیے استعمال ہوتی ہے۔ یہ فوڈ پوائزننگ کے لیے ایک موثر دوا ہے کیونکہ یہ اسہال کو دور کرتی ہے۔"};

    int images[] = {R.drawable.bismuthsubsalicylate,R.drawable.trioral,R.drawable.imodium};

    String mDosage[] = {"The usual dose is 2 tablets every half-hour to one hour.\n" + "You should not take more than 16 tablets in 24 hours.\n\n"+"معمول کی خوراک ہر آدھے گھنٹے سے ایک گھنٹے میں 2 گولیاں ہے۔" +
            "آپ کو چوبیس گھنٹوں میں 16 گولیاں سے زیادہ نہیں لینا چاہیے۔",
            "Just mix 1 packet with water and drink.\n" +"\n"+"بس 1 پیکٹ پانی میں ملا کر پی لیں۔\n",
            "The recommended initial dose is two capsules after each unformed stool. Daily dose should not exceed eight capsules.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n" +
                    "تجویز کردہ ابتدائی خوراک ہر بے ساختہ پاخانہ کے بعد دو کیپسول ہے۔ روزانہ کی خوراک آٹھ کیپسول سے زیادہ نہیں ہونی چاہیے۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔\n"};

    String mSideEffects[] = {"Common side effects may include dark tongue and/or grayish black stools.\n\n"+"عام ضمنی اثرات میں سیاہ زبان اور/یا سرمئی سیاہ پاخانہ شامل ہو سکتے ہیں۔",
            "Common side effects may include mild nausea, diarrhea, constipation, dizziness, headache, blurred vision, dry mouth, skin rash.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں ہلکی متلی، اسہال، قبض، چکر آنا، سر درد، دھندلا پن، خشک منہ، جلد پر خارش شامل ہو سکتے ہیں۔\n",
            "The common side effects of a therapeutic Imodium dose are Dizziness ,Constipation ,Abdominal cramps, Nausea.\n" +
                    "\n" +
                    "عام ضمنی اثرات ہیں چکر آنا، قبض، پیٹ میں درد، متلی۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine14);
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
                Intent i = new Intent(Medicine14.this, LoginActivity.class);
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

