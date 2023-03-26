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


public class Medicine31 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"DOMEL","GRAVINATE","MOTILIUM"};

    String mDescription[] = {"Domel syrup is used to treat nausea and vomiting and stomach pain.\n\n"+ "ڈومیل متلی اور الٹی اور پیٹ کے درد کے علاج کے لیے استعمال ہوتا ہے۔",
            "Gravinate syrup is used to prevent nausea and vomiting. It is a combination medicine containing doxylamine and pyridoxine as active ingredient.\n\n"+"یہ متلی اور الٹی کو روکنے کے لیے استعمال ہوتا ہے۔",
            "Motilium syrup help to stop feeling or being sick like as nausea or vomiting. It can also be used to treat stomach pain.\n\n"+
                    "یہ متلی یا الٹی جیسے محسوس ہونے یا بیمار ہونے کو روکنے میں مدد کرتا ہے۔ اسے پیٹ کے درد کے علاج کے لیے بھی استعمال کیا جا سکتا ہے۔"};

    int images[] = {R.drawable.domel2,R.drawable.gravinate2,R.drawable.motilium};

    String mDosage[] = {"Take 1 tablespoon of this medication twice daily.\n\n"+"اس دوا کا 1 چمچ دن میں دو بار لیں۔" ,
            "Take 1 tablespoon of this medication twice daily.\n" +
            "\n"+"اس دوا کا 1 چمچ دن میں دو بار لیں۔\n" ,
            "Take this medication one or 2 tablespoon every 4 - 8 hours daily.\n" +
            "\n" + "اس دوا کو ہر 4 سے 8 گھنٹے میں ایک یا 2 چمچ روزانہ لیں۔\n"};

    String mSideEffects[] = {"Common side effects like dry mouth, dizziness, tiredness, chest pain, difficulty in breathing, heartburn..\n\n"+"عام ضمنی اثرات جیسے خشک منہ، چکر آنا، تھکاوٹ، سینے میں درد، سانس لینے میں دشواری، دل کی جلن۔",
            "Drowsiness, headache, blurred vision, tinnitus, dryness of the mouth and respiratory passages, incoordination, palpitation, dizziness, hypotension.\n" +
                    "\n" +
                    "غنودگی، سر درد، دھندلا پن، ٹنائٹس، منہ اور سانس کی نالیوں کا خشک ہونا، ہم آہنگی، دھڑکن، چکر آنا، ہائپوٹینشن۔\n",
            "Abdominal cramps, Dry mouth, Diarrhea, Nausea, Rash, Itching, Hives, Breast enlargement, Galactorrhea.\n" +
                    "\n" +
                    "پیٹ میں درد، خشک منہ، اسہال، متلی، ددورا، خارش، چھتے، چھاتی کا بڑھ جانا، گیلاکٹوریا۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine31);
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
                Intent i = new Intent(Medicine31.this, LoginActivity.class);
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

