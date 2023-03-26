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


public class Medicine2 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"ACEFYL COUGH SYRUP","BENADRYL COUGH SYRUP","HYDRYLLIN COUGH SYRUP"};

    String mDescription[] = {"Acefyl syrup is a combination of two ingredients, acefylline, and diphenhydramine a bronchodilator and an antiallergic medication. Both these drugs help in suppressing coughs and allergies that cause coughing.\n\n"+ "یہ دو اجزاء، ایسفیلائن، اور ڈیفن ہائیڈرمائن ایک برونکڈیلیٹر اور ایک اینٹی الرجک دوائیوں کا مجموعہ ہے۔ یہ دونوں ادویات کھانسی اور الرجی کو دبانے میں مدد کرتی ہیں جو کھانسی کا سبب بنتی ہیں۔",
            "Benadryl Cough Formula Syrup is an antihistamine, which is used as the treatment of cough which is accompanied by a runny nose, sneezing, sore throat, watery eyes, etc. It also prevents and treats nausea, vomiting and dizziness which is caused by motion sickness. This syrup can also help you relax and fall asleep.\n\n"+"یہ ایک اینٹی ہسٹامائن ہے، جسے کھانسی کے علاج کے طور پر استعمال کیا جاتا ہے جس کے ساتھ ناک بہنا، چھینکیں، گلے میں خراش، پانی بھری آنکھیں وغیرہ شامل ہیں۔ یہ شربت آپ کو آرام کرنے اور سونے میں بھی مدد دے سکتا ہے۔",
            "Hydryllin Syrup is used for Cough, Back pain, Reversible airflow obstruction, Body fat reducer, Relief of runny nose, Sneezing, Itchy, Watery eyes, Itchy nose, Itchy throat due to fever or allergy.\n\n"+
                    "اس کا استعمال کھانسی، کمر میں درد، ہوا کے بہاؤ میں ردوبدل، جسم کی چربی کم کرنے والا، بہتی ہوئی ناک سے نجات، چھینکیں، خارش، پانی بھری آنکھوں، ناک میں خارش، بخار یا الرجی کی وجہ سے گلے کی خارش کے لیے استعمال کیا جاتا ہے۔"};

    int images[] = {R.drawable.acefylcoughsyrup,R.drawable.benadryl,R.drawable.hydryllin};

    String mDosage[] = {"For adults, 18 years and above, the recommended oral dose is 2 tablespoons 3 to 4 times daily.\n" + "Keep a gap of at least 4-6 hours between the dose and the next dose.\n\n"+"بالغوں کے لیے، 18 سال اور اس سے زیادہ، تجویز کردہ زبانی خوراک روزانہ 3 سے 4 بار 2 کھانے کے چمچ ہے۔" +
            "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "For adults, 18 years and above, the recommended oral dose is 1 tablespoon 3 times daily.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n"+"بالغوں کے لیے، 18 سال اور اس سے زیادہ، تجویز کردہ زبانی خوراک روزانہ 3 بار 1 چمچ ہے۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "For adults, 18 years and above, the recommended oral dose is 2 tablespoons 3 to 4 times daily.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n" +
                    "بالغوں کے لیے، 18 سال اور اس سے زیادہ، تجویز کردہ زبانی خوراک روزانہ 3 سے 4  بار 2 کھانے کے چمچ ہے۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔\n"};

    String mSideEffects[] = {"Side effect includes sedation, dizziness, tinnitus, fatigue, ataxia, blurred vision, diplopia, euphoria, and epigastric discomfort.\n\n"+"ضمنی اثر میں بے سکونی، چکر آنا، ٹنائٹس، تھکاوٹ، ایٹیکسیا، دھندلا نظر آنا، ڈپلوپیا، خوشی، اور ایپی گیسٹرک تکلیف شامل ہیں۔",
            "Common Benadryl side effects may include dizziness, drowsiness, loss of coordination, dry mouth, nose, or throat, constipation, upset stomach, dry eyes, blurred vision or day-time drowsiness or \"hangover\" feeling after night-time use.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں چکر آنا، غنودگی، ہم آہنگی میں کمی، خشک منہ، ناک، یا گلا، قبض، پیٹ کی خرابی، خشک آنکھیں، دھندلا نظر یا دن کے وقت غنودگی یا رات کے وقت استعمال کے بعد \"ہنگ اوور\" کا احساس شامل ہوسکتا ہے۔\n",
            "Side effect includes sedation, dizziness, tinnitus, fatigue, ataxia, blurred vision, diplopia, euphoria, and epigastric discomfort. Excitation, confusion and respiratory depression may occur after overdosage.\n" +
                    "\n" +
                    "ضمنی اثر میں بے سکونی، چکر آنا، ٹنائٹس، تھکاوٹ، ایٹیکسیا، دھندلا نظر آنا، ڈپلوپیا، خوشی، اور ایپی گیسٹرک تکلیف شامل ہیں۔ زیادہ مقدار کے بعد حوصلہ افزائی، الجھن اور سانس کی ڈپریشن ہوسکتی ہے۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine2);
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
                Intent i = new Intent(Medicine2.this, LoginActivity.class);
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

