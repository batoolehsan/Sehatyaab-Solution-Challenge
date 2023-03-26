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


public class Medicine42 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"CLENIL","VENTOLIN","ATEM"};

    String mDescription[] = {"Clenil Nebules is used to prevent difficulty breathing, chest tightness, wheezing, and coughing caused by asthma in adults and children 5 years of age and older. Clenil are for inhalation use only, to be breathed in through the mouth, under the direction of a physician, using a suitable nebuliser.\n\n"+ "کلینیل کا استعمال سانس لینے میں دشواری، سینے میں جکڑن، گھرگھراہٹ، اور 5 سال اور اس سے زیادہ عمر کے بالغوں اور بچوں میں دمہ کی وجہ سے ہونے والی کھانسی کو روکنے کے لیے کیا جاتا ہے۔ کلینیل صرف سانس کے استعمال کے لیے ہیں، منہ کے ذریعے سانس لینے کے لیے، ڈاکٹر کی ہدایت پر، ایک مناسب نیبولائزر کا استعمال کرتے ہوئے۔",
            "oVentolin Nebules are indicated for use in the routine management of chronic bronchospasm unresponsive to conventional therapy, and in the treatment of acute severe asthma. Ventolin are for inhalation use only, to be breathed in through the mouth, under the direction of a physician, using a suitable nebuliser.\n\n"+"وینٹولین کو روایتی علاج کے لیے غیر جوابی دائمی برونکاسپاسم کے معمول کے انتظام میں، اور شدید شدید دمہ کے علاج میں استعمال کے لیے اشارہ کیا جاتا ہے۔ وینٹولین صرف سانس کے استعمال کے لیے ہیں، منہ کے ذریعے سانس لینے کے لیے، ڈاکٹر کی ہدایت پر، مناسب نیبولائزر کا استعمال کرتے ہوئے۔",
            "Atem is used for the treatment of bronchial asthma, chronic obstructive bronchopneumopathy with asthmatic component. Atem are for inhalation use only, to be breathed in through the mouth, under the direction of a physician, using a suitable nebuliser.\n\n"+
                    "ایٹم کو دمہ کے جزو کے ساتھ برونکئل دمہ، دائمی رکاوٹ برونکوپنیومیوپیتھی کے علاج کے لیے استعمال کیا جاتا ہے۔ ایٹیم صرف سانس کے استعمال کے لیے ہیں، منہ کے ذریعے سانس لینے کے لیے، معالج کی ہدایت پر، مناسب نیبولائزر کا استعمال کرتے ہوئے۔"};

    int images[] = {R.drawable.clenil,R.drawable.ventolin,R.drawable.atem};

    String mDosage[] = {"The usual starting dose is 1ml twice daily.\n\n"+"معمول کی ابتدائی خوراک روزانہ دو بار 1 ملی لیٹر ہے۔" ,
            "The usual starting dose is 1.25 mg in the nebulizer, take 3 or 4 times per day as needed.\n" +
            "\n"+"معمول کی ابتدائی خوراک نیبولائزر میں 1.25 ملی گرام ہے، ضرورت کے مطابق دن میں 3 یا 4 بار لیں۔\n" ,
            "The usual starting dose is 1ml in the nebulizer, take 3 or 4 times per day as needed.\n" +
            "\n" + "معمول کی ابتدائی خوراک نیبولائزر میں 1 ملی لیٹر ہے، ضرورت کے مطابق دن میں 3 یا 4 بار لیں۔\n"};

    String mSideEffects[] = {"Clenil may experience serious side effects, including nausea, loss of appetite, worsening asthma, weight loss, difficulty breathing, severe skin rash and irritation, numbness, bruising and muscle weakness.\n\n"+"کلینیل کو سنگین ضمنی اثرات کا سامنا کرنا پڑ سکتا ہے، بشمول متلی، بھوک میں کمی، دمہ کا بگڑنا، وزن میں کمی، سانس لینے میں دشواری، جلد پر شدید خارش اور جلن، بے حسی، خراشیں اور پٹھوں کی کمزوری۔",
            "Common side effects are shakiness in the legs, arms, hands, or feet trembling or shaking of the hands or feet.\n" +
                    "\n" +
                    "عام ضمنی اثرات ٹانگوں، بازوؤں، ہاتھوں، یا پاؤں میں لرزش یا ہاتھ پاؤں کا کانپنا یا لرزنا ہیں۔\n",
            "Allergic-type reactions such as skin rash, angio-oedema of the tongue, lips and face.\n" +
                    "\n" +
                    "الرجک قسم کے رد عمل جیسے کہ جلد پر خارش، زبان، ہونٹوں اور چہرے کا انجیو ایڈیما۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine42);
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
                Intent i = new Intent(Medicine42.this, LoginActivity.class);
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

