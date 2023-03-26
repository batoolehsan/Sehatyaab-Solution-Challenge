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


public class Medicine12 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"NORVASC","TENORMIN","ALDOMET","AVSAR PLUS"};

    String mDescription[] = {"Norvasc is used as an anti-hypertensive medicine to treat hypertension.\n\n"+ "یہ ہائی بلڈ پریشر کے علاج کے لیے ایک اینٹی ہائی بلڈ پریشر دوا کے طور پر استعمال ہوتا ہے۔",
            "Tenormin is used as an anti-hypertensive medicine to treat hypertension.\n\n"+"ٹینورمین ہائی بلڈ پریشر کے علاج کے لیے ایک اینٹی ہائی بلڈ پریشر دوا کے طور پر استعمال ہوتی ہے۔",
            "Aldomet is used as an anti-hypertensive medicine to treat hypertension.\n\n"+
                    "ہائی بلڈ پریشر کے علاج کے لیے الڈومیٹ کو اینٹی ہائی بلڈ پریشر دوا کے طور پر استعمال کیا جاتا ہے۔",
            "Avsar plus is used as an anti-hypertensive medicine to treat hypertension.\n\n"+
            "یہ دوا ہائی بلڈ پریشر کے علاج کے لیے استعمال ہوتی ہے۔"};

    int images[] = {R.drawable.norvasc,R.drawable.tenormin,R.drawable.aldomet,R.drawable.avsar};

    String mDosage[] = {"Take 1 tablet once daily.\n\n"+"روزانہ ایک بار 1 گولی لیں۔" ,
            "Take 1 tablet once in a day.\n" +
            "\n"+"دن میں ایک بار 1 گولی لیں۔\n" ,
            "The usual dose for adults is 1 tablet ,take two or three times a day.\n"+"Keep a gap of at least 4-6 hours between the dose and the next dose.\n"+
            "\n" + "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔\n"+"بالغوں کے لیے معمول کی خوراک 1 گولی ہے، دن میں دو یا تین بار لیں۔",
            "Take one dose of this medicine, every day.\n" +
            "\n" + "اس دوا کی ایک خوراک، ہر روز لیں۔\n"};

    String mSideEffects[] = {"Common side effects include headache, edema, rash, fatigue, and dizziness.\n\n"+"عام ضمنی اثرات میں سر درد، ورم، خارش، تھکاوٹ اور چکر آنا شامل ہیں۔",
            "Common side effects of tenormin include cardiac failure, bradycardia, dizziness, fatigue, and cold extremity.\n" +
                    "\n" +
                    "ٹینورمین کے عام ضمنی اثرات میں کارڈیک فیل ہونا، بریڈی کارڈیا، چکر آنا، تھکاوٹ، اور سردی کی انتہا شامل ہیں۔\n",
            "Common side effects of aldomet may include drowsiness, weakness or headache.\n" +
                    "\n" +
                    "الڈومیٹ کے عام ضمنی اثرات میں غنودگی، کمزوری یا سر درد شامل ہوسکتا ہے۔\n", "Patients using this medicine may commonly experience headache, edema, fatigue, nausea, dizziness (lightheadedness), flushing (reddening of the skin), rashes, and gingival hyperplasia (overgrowth of gum). Patients may rarely experience alopecia (spot baldness), pruritus (itching), abdominal and back pain, hyperglycemia, increased urination, palpitations, and GI (stomach) upset.\n" +
            "\n" +
            "اس دوا کا استعمال کرنے والے مریضوں کو عام طور پر سر درد، ورم، تھکاوٹ، متلی، چکر آنا (ہلکا سر کا ہونا)، فلشنگ (جلد کا سرخ ہونا)، دانے، اور مسوڑھوں کے ہائپرپلاسیا (مسوڑھوں کی زیادہ نشوونما) کا تجربہ ہو سکتا ہے۔ مریضوں کو شاذ و نادر ہی ایلوپیسیا (گنج کا پن)، خارش (خارش)، پیٹ اور کمر میں درد، ہائپرگلیسیمیا، پیشاب میں اضافہ، دھڑکن اور جی آئی (پیٹ) کی خرابی کا تجربہ ہوسکتا ہے۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine12);
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
                Intent i = new Intent(Medicine12.this, LoginActivity.class);
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

