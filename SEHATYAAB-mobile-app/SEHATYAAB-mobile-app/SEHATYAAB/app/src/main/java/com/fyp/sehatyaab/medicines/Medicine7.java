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


public class Medicine7 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"AMOXIl","ERYTHROCIN","STREPSILS"};

    String mDescription[] = {"Amoxil is a penicillin antibiotic that fights bacterial infections, such as tonsillitis, bronchitis, pneumonia, and infections of the ear, nose, throat, skin, or urinary tract.\n\n"+ "اموکسیل ایک پینسلن اینٹی بائیوٹک ہے جو بیکٹیریل انفیکشن سے لڑتی ہے، جیسے ٹنسلائٹس، برونکائٹس، نمونیا، اور کان، ناک، گلے، جلد، یا پیشاب کی نالی کے انفیکشن۔",
            "Erythrocin is used to treat or prevent many different types of infections caused by bacteria.\n\n"+"اریتھروسن بیکٹیریا کی وجہ سے ہونے والے بہت سے مختلف قسم کے انفیکشن کے علاج یا روکنے کے لیے استعمال کیا جاتا ہے۔",
            "Strepsils fights infection and provides soothing relief to comfort your throat.\n\n"+
                    "یہ انفیکشن سے لڑتا ہے اور آپ کے گلے کو سکون دینے کے لیے سکون بخش راحت فراہم کرتا ہے۔"};

    int images[] = {R.drawable.amoxil,R.drawable.erythrocin,R.drawable.strepsils};

    String mDosage[] = {"Take this medication 2 times a day.\n\n"+"اس دوا کو دن میں 2 بار لیں۔" ,
            "Take this medication once a day.\n" +
            "\n"+"یہ دوا دن میں ایک بار لیں۔\n" ,
            "The recommended dosage is one lozenge every 2–3 hours for adults.\n" +
            "\n" + "بالغوں کے لیے تجویز کردہ خوراک ہر 2-3 گھنٹے میں ایک گولی ہے۔\n"};

    String mSideEffects[] = {"The most frequently reported side effects were diarrhea, nausea, and skin rash.\n\n"+"سب سے زیادہ کثرت سے رپورٹ ہونے والے ضمنی اثرات اسہال، متلی، اور جلد پر خارش تھے۔",
            "Common side effects include diarrhea, vomiting and abdominal cramps.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں اسہال، الٹی اور پیٹ کے درد شامل ہیں۔\n",
            "Less common or rare side effects are confusion, constipation, dizziness, drowsiness, headache, nausea or vomiting and stomach pain.\n" +
                    "\n" +
                    "کم عام یا نایاب ضمنی اثرات الجھن، قبض، چکر آنا، غنودگی، سر درد، متلی یا الٹی اور پیٹ میں درد ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine7);
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
                Intent i = new Intent(Medicine7.this, LoginActivity.class);
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

