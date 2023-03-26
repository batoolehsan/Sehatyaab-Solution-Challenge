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


public class Medicine20 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"BEPANTHEN","HYDROCORTISONE CREAM","FUSIL HC CREAM"};

    String mDescription[] = {"Bepanthen Antiseptic Cream is a multi-purpose antiseptic cream that helps protect damaged skin from infection and also assists in the treatment of cuts, abrasions, insect bites, stings, and sunburn.\n\n"+ "یہ ایک کثیر مقصدی جراثیم کش کریم ہے جو خراب شدہ جلد کو انفیکشن سے بچانے میں مدد کرتی ہے اور کٹوتیوں، رگڑنے، کیڑوں کے کاٹنے، ڈنک اور سنبرن کے علاج میں بھی مدد کرتی ہے۔",
            "This medication is used to treat a variety of skin conditions (e.g., insect bites, poison oak/ivy, eczema, dermatitis, allergies, rash, itching of the outer female genitals, anal itching).\n\n"+"اس دوا کو جلد کی مختلف حالتوں کے علاج کے لیے استعمال کیا جاتا ہے (مثلاً، کیڑوں کے کاٹنے، زہر کا بلوط/آئیوی، ایکزیما، ڈرمیٹیٹائٹس، الرجی، ددورا، بیرونی خواتین کے جنسی اعضاء کی خارش، مقعد کی خارش)۔",
            "It is used to treat Conditions where the skin is inflamed (eczema or dermatitis) and also infected by germs (bacteria).\n\n"+
                    "اس کا استعمال ان حالات کے علاج کے لیے کیا جاتا ہے جہاں جلد سوجن ہو (ایگزیما یا ڈرمیٹیٹائٹس) اور جراثیم (بیکٹیریا) سے بھی متاثر ہو۔"};

    int images[] = {R.drawable.bepanthene,R.drawable.hydrocortisone,R.drawable.fusil};

    String mDosage[] = {"Apply one or more times daily as directed by a physician.\n\n"+"ڈاکٹر کی ہدایت کے مطابق روزانہ ایک یا زیادہ بار لگائیں۔" ,
            "Apply to the affected area of the skin two to four times per day.\n" +
            "\n"+"جلد کے متاثرہ حصے پر دن میں دو سے چار بار لگائیں۔\n" ,
            "Apply one or more times daily as directed by a physician.\n" +
            "\n" + "ڈاکٹر کی ہدایت کے مطابق روزانہ ایک یا زیادہ بار لگائیں۔\n"};

    String mSideEffects[] = {"Common side effects are include itching, tingling or red patches of skin.\n\n"+"عام ضمنی اثرات میں خارش، ٹنگلنگ یا جلد کے سرخ دھبے شامل ہیں۔",
            "The most common side effects of hydrocortisone cream are burning ,itching ,irritation ,skin dryness, changes in skin color (redness or lighter color than normal), excessive hair growth ,pimples resembling acne, softened or wrinkled skin.\n" +
                    "\n" +
                    "ہائیڈروکارٹیسون کریم کے سب سے عام ضمنی اثرات میں جلن، خارش، جلن، جلد کا خشک ہونا، جلد کی رنگت میں تبدیلی (سرخ یا نارمل سے ہلکا رنگ)، بالوں کی ضرورت سے زیادہ بڑھنا، مہاسوں سے مشابہہ مہاسے، نرم یا جھریوں والی جلد ہیں۔\n",
            "Common side effects may include itching, burning, irritation, redness, swelling.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں خارش، جلن، جلن، لالی، سوجن شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine20);
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
                Intent i = new Intent(Medicine20.this, LoginActivity.class);
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

