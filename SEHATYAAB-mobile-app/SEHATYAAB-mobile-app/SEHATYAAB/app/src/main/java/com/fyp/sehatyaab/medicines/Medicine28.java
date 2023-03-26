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


public class Medicine28 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"AMOXIl","OLCUF","COFERB"};

    String mDescription[] = {"Amoxil is a penicillin antibiotic that fights bacterial infections, such as tonsillitis, bronchitis, pneumonia, and infections of the ear, nose, throat, skin, or urinary tract.\n\n"+ "اموکسیل ایک پینسلن اینٹی بائیوٹک ہے جو بیکٹیریل انفیکشن سے لڑتی ہے، جیسے ٹنسلائٹس، برونکائٹس، نمونیا، اور کان، ناک، گلے، جلد، یا پیشاب کی نالی کے انفیکشن۔",
            "Its use is indicated in conditions like cough, bronchitis, throat irritation, and shortness of breath. It has a soothing effect on the throat, and reduces chest tightness while restoring normal breathing function.\n\n"+"کھانسی، برونکائٹس، گلے کی جلن اور سانس کی قلت جیسی حالتوں میں اس کا استعمال ظاہر ہوتا ہے۔ اس کا گلے پر آرام دہ اثر پڑتا ہے، اور سانس لینے کے معمول کے افعال کو بحال کرتے ہوئے سینے کی جکڑن کو کم کرتا ہے۔",
            "Coferb syrup helps treat cough and improve breathing by thinning and clearing mucus from the chest.\n\n"+
                    "یہ کھانسی کے علاج میں مدد کرتا ہے اور سینے سے بلغم کو پتلا کرکے اور صاف کرکے سانس لینے میں بہتری لاتا ہے۔"};

    int images[] = {R.drawable.amoxil2,R.drawable.olcuf,R.drawable.coferb};

    String mDosage[] = {"Take 1 tablespoon of this medication 2 times a day.\n\n"+"اس دوا کا 1 چمچ دن میں 2 بار لی۔" ,
            "Take 1 tablespoon of this medication twice daily.\n" +
            "\n"+"اس دوا کا 1 چمچ دن میں دو بار لیں۔\n" ,
            "Take 1 tablespoon of this medication twice daily.\n" +
            "\n" + "اس دوا کا 1 چمچ دن میں دو بار لیں۔\n"};

    String mSideEffects[] = {"The most frequently reported side effects were diarrhea, nausea, and skin rash.\n\n"+"سب سے زیادہ کثرت سے رپورٹ ہونے والے ضمنی اثرات اسہال، متلی، اور جلد پر خارش تھے۔",
            "Possible side effects of this cough syrup include diarrhea, vomiting, nausea, and abdominal pain.\n" +
                    "\n" +
                    "کھانسی کے اس شربت کے ممکنہ ضمنی اثرات میں اسہال، الٹی، متلی اور پیٹ میں درد شامل ہیں۔\n",
            "Possible side effects of using Coferb plus may include, dizziness, vomiting, itching, drowsiness, stomach pain, and breathing difficulties.\n" +
                    "\n" +
                    "کوفرب پلس کے استعمال کے ممکنہ ضمنی اثرات میں چکر آنا، الٹی، خارش، غنودگی، پیٹ میں درد، اور سانس لینے میں دشواری شامل ہو سکتی ہے۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine28);
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
                Intent i = new Intent(Medicine28.this, LoginActivity.class);
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

