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


public class Medicine17 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"DAKTACORT","BETAGENIC","HEALIT"};

    String mDescription[] = {"Daktacort cream is a medicine which is used to treat inflamed conditions of the skin such as eczema and dermatitis which may be caused by infection with certain fungi and bacteria.\n\n"+ "یہ ایک ایسی دوا ہے جو جلد کی سوجن والی حالتوں جیسے کہ ایکزیما اور ڈرمیٹائٹس کے علاج کے لیے استعمال ہوتی ہے جو بعض کوک اور بیکٹیریا کے انفیکشن کی وجہ سے ہو سکتی ہے۔",
            "This medication is used to treat a variety of skin conditions (e.g., eczema, dermatitis, allergies, rash). It reduces the swelling, itching, and redness that can occur in these types of conditions.\n\n"+"یہ دوا جلد کی مختلف حالتوں کے علاج کے لیے استعمال ہوتی ہے (جیسے، ایکزیما، ڈرمیٹیٹائٹس، الرجی، ددورا)۔ یہ سوجن، خارش اور لالی کو کم کرتا ہے جو اس قسم کے حالات میں ہو سکتا ہے۔",
            "It is used to avoid or treat skin infections and to ease pain from skin irritations.\n\n"+
                    "یہ جلد کے انفیکشن سے بچنے یا علاج کرنے اور جلد کی جلن سے درد کو کم کرنے کے لیے استعمال کیا جاتا ہے۔"};

    int images[] = {R.drawable.daktacort,R.drawable.betagenic,R.drawable.healit};

    String mDosage[] = {"Twice a day apply a small amount of the cream on the affected areas, Rub the cream gently.\n\n"+"دن میں دو بار کریم کی تھوڑی سی مقدار متاثرہ جگہوں پر لگائیں، کریم کو آہستہ سے رگڑیں۔" ,
            "Twice a day apply a small amount of the cream on the affected areas, Rub the cream gently.\n" +
            "\n"+"دن میں دو بار کریم کی تھوڑی سی مقدار متاثرہ جگہوں پر لگائیں، کریم کو آہستہ سے رگڑیں۔\n" ,
            "Apply a thin layer to the affected area(s) twice a day allowing at least 8 hours between applications.\n" +
            "\n" + "متاثرہ جگہ پر دن میں دو بار ایک پتلی تہہ لگائیں اور ایپلی کیشنز کے درمیان کم از کم 8 گھنٹے کا وقفہ کریں۔\n"};

    String mSideEffects[] = {"The common side-effects of this medicine include redness, rash, skin irritation, etc.\n\n"+"اس دوا کے عام ضمنی اثرات میں لالی، خارش، جلد کی جلن وغیرہ شامل ہیں۔",
            "The common side-effects of this medicine include Burning, Itching, Irritation, Dryness, Folliculitis, Hypopigmentation, Allergic contact dermatitis.\n" +
                    "\n" +
                    "اس دوا کے عام ضمنی اثرات میں جلن، خارش، جلن، خشکی، فولیکولائٹس، ہائپوپگمنٹیشن، الرجک کانٹیکٹ ڈرمیٹیٹائٹس شامل ہیں۔\n",
            "Rashes, hives, itching, red , swollen, blistered, peeling skin with or without fever.\n" +
                    "\n" +
                    "خارش، چھتے، خارش، سرخ، سوجن، چھالے، بخار کے ساتھ یا بغیر جلد کا چھلکا۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine17);
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
                Intent i = new Intent(Medicine17.this, LoginActivity.class);
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

