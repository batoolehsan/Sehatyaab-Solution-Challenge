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


public class Medicine25 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"DISPROL","ARINAC","RONDECC"};

    String mDescription[] = {"Disprol syrup is used to temporarily relieve symptoms caused by the common cold, flu, allergies, or other breathing illnesses (such as sinusitis, bronchitis ).\n\n"+ "پیناڈوڈسپرول سیرپ کا استعمال عام سردی، فلو، الرجی، یا سانس کی دیگر بیماریوں (جیسے سائنوسائٹس، برونکائٹس) کی وجہ سے ہونے والی علامات کو عارضی طور پر دور کرنے کے لیے کیا جاتا ہے۔",
            "Arinac is recommended for the treatment of fever, cough, nasal congestion, flu and headache.\n\n"+"اریناک بخار، ناک بند ہونا، فلو اور سر درد کے علاج کے لیے استعمال کی جاتی ہے۔",
            "This combination medication is used to temporarily relieve symptoms caused by the common cold, flu, allergies, or other breathing illnesses (such as sinusitis, bronchitis).\n"+
                    "اس امتزاج کی دوائی کو عام سردی، فلو، الرجی، یا سانس کی دیگر بیماریوں (جیسے سائنوسائٹس، برونکائٹس) کی وجہ سے ہونے والی علامات کو عارضی طور پر دور کرنے کے لیے استعمال کیا جاتا ہے۔"};

    int images[] = {R.drawable.disprol,R.drawable.arinac2,R.drawable.rondecc};

    String mDosage[] = {"The usual dose for kids is 1 tablespoon up to 3 times in 24 hours.\n\n" + "Keep a gap of at least 4-6 hours between the dose and the next dose.\n\n"+"بچوں کے لیے معمول کی خوراک 24 گھنٹوں میں 3 بار تک 1 چمچ ہے۔" +
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

    String mSideEffects[] = {"Drowsiness, dizziness, dry mouth/nose/throat, headache, upset stomach, constipation, or trouble sleeping may occur. If any of these effects last or get worse, tell your doctor or pharmacist promptly.\n\n"+"غنودگی، چکر آنا، خشک منہ/ناک/گلا، سر درد، پیٹ کی خرابی، قبض، یا نیند میں پریشانی ہو سکتی ہے۔ اگر ان میں سے کوئی اثر دیر تک رہتا ہے یا بدتر ہو جاتا ہے، تو اپنے ڈاکٹر یا فارماسسٹ کو فوری طور پر بتائیں۔",
            "Common side effects may include stomach pain, gastrointestinal disturbances, nausea and vomiting, and diarrhea.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں پیٹ میں درد، معدے کی خرابی، متلی اور الٹی، اور اسہال شامل ہو سکتے ہیں۔\n",
            "Drowsiness, dizziness, dry mouth/nose/throat, headache, upset stomach, constipation, or trouble sleeping may occur. If any of these effects last or get worse, tell your doctor or pharmacist promptly.\n" +
                    "\n" +
                    "غنودگی، چکر آنا، خشک منہ/ناک/گلا، سر درد، پیٹ کی خرابی، قبض، یا نیند میں پریشانی ہو سکتی ہے۔ اگر ان میں سے کوئی اثر دیر تک رہتا ہے یا بدتر ہو جاتا ہے، تو اپنے ڈاکٹر یا فارماسسٹ کو فوری طور پر بتائیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine25);
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
                Intent i = new Intent(Medicine25.this, LoginActivity.class);
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

