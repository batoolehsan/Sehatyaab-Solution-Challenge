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


public class Medicine30 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"TRIMETABOL","APTIMAX PLUS","EPITIZE"};

    String mDescription[] = {"Trimetabol is a famous Spanish nutritional supplement that is used to treat lack or loss of appetite. This syrup is composed of appetite stimulants, amino acids, and nutrients that are essential to reduce the symptoms of lack of appetite.\n\n"+ "یہ ایک مشہور ہسپانوی غذائی ضمیمہ ہے جو بھوک کی کمی یا کمی کے علاج کے لیے استعمال ہوتا ہے۔ یہ شربت بھوک بڑھانے والے، امینو ایسڈز اور غذائی اجزاء پر مشتمل ہے جو بھوک کی کمی کی علامات کو کم کرنے کے لیے ضروری ہیں۔",
            "AptiMax Plus syrup is used for the treatment of loss of appetite, constipation, upset stomach, and gallbladder disorders.\n\n"+"اپٹیمیکس پلس سیرپ بھوک میں کمی، قبض، خراب پیٹ، اور پتتاشی کے امراض کے علاج کے لیے استعمال کیا جاتا ہے۔",
            "Epitize Syrup Sugar Free stimulates appetite by improving metabolism of the body. It works by improving liver function which boosts your digestion process and thus makes you feel hungry.\n\n"+
                    "ایپیٹائز سرپ شوگر فری جسم کے میٹابولزم کو بہتر بنا کر بھوک کو متحرک کرتا ہے۔ یہ جگر کے افعال کو بہتر بنا کر کام کرتا ہے جو آپ کے ہاضمے کے عمل کو بڑھاتا ہے اور اس طرح آپ کو بھوک لگتی ہے۔"};

    int images[] = {R.drawable.trimetabol,R.drawable.aptimax,R.drawable.epitize};

    String mDosage[] = {"Take 1 - 2 teaspoons of this medication three times a day.\n\n"+"اس دوا کے ایک سے دو چمچ دن میں تین بار لیں۔" ,
            "Take 1 - 2 teaspoons of this medication three times a day.\n" +
            "\n"+"اس دوا کے ایک سے دو چمچ دن میں تین بار لیں۔\n" ,
            "Take 1 - 2 teaspoons of this medication three times a day.\n" +
            "\n" + "اس دوا کے ایک سے دو چمچ دن میں تین بار لیں۔\n"};

    String mSideEffects[] = {"Possible side effects may include dizziness, mild drowsiness, feeling excited or restlessness, sleeping problems, tired feelings.\n\n"+"ممکنہ ضمنی اثرات میں چکر آنا، ہلکی غنودگی، پرجوش یا بےچینی، نیند کے مسائل، تھکاوٹ کے احساسات شامل ہو سکتے ہیں۔",
            "Possible side effects may include itchy bumps, nasal swelling, swelling inside the mouth, asthma.\n" +
                    "\n" +
                    "ممکنہ ضمنی اثرات میں خارش، ناک میں سوجن، منہ کے اندر سوجن، دمہ شامل ہو سکتے ہیں۔\n",
            "Common side effects like constipation, drowsiness, dryness in mouth, sleepiness, blurred vision.\n" +
                    "\n" +
                    "عام ضمنی اثرات جیسے قبض، غنودگی، منہ میں خشکی، نیند آنا، دھندلا پن۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine30);
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
                Intent i = new Intent(Medicine30.this, LoginActivity.class);
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

