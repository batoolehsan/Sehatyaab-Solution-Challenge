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


public class Medicine4 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"ACTIFIED-P","ARINAC","RONDECC"};

    String mDescription[] = {"Actifed-P Tablet is used for Cough, Flu, Upper respiratory symptoms, Nasal congestion due to allergy, Common cold, Nasal congestion, Hay fever, Upper respiratory allergies, Sinus congestion and pressure, Headache and other conditions.\n\n"+ "یہ کھانسی , فلو , اوپری سانس کی علامات , الرجی کی وجہ سے ناک بند ہونا , عام سردی , ناک بند ہونا , گھاس بخار , اوپری سانس کی الرجی , ہڈیوں کی بھیڑ , دباؤ اور سر درد کے لیے استعمال کی جاتی ہے۔",
            "Arinac is recommended for the treatment of fever, nasal congestion, flu and headache.\n\n"+"اریناک بخار، ناک بند ہونا، فلو اور سر درد کے علاج کے لیے استعمال کی جاتی ہے۔",
            "This combination medication is used to temporarily relieve symptoms caused by the common cold, flu, allergies, or other breathing illnesses (such as sinusitis, bronchitis).\n\n"+
                    "اس امتزاج کی دوائی کو عام سردی، فلو، الرجی، یا سانس کی دیگر بیماریوں (جیسے سائنوسائٹس، برونکائٹس) کی وجہ سے ہونے والی علامات کو عارضی طور پر دور کرنے کے لیے استعمال کیا جاتا ہے۔"};

    int images[] = {R.drawable.actified,R.drawable.arinac,R.drawable.rondecc};

    String mDosage[] = {"Take one tablet every four hours. Do not take more than six tablets in 24 hours.\n" + "Keep a gap of at least 4-6 hours between the dose and the next dose.\n\n"+"ہر چار گھنٹے بعد ایک گولی لیں۔ 24 گھنٹے میں چھ سے زیادہ گولیاں نہ لیں۔" +
            "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "The usual dose for adults is 1 or 2 tablets.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n"+"بالغوں کے لئے معمول کی خوراک 1 یا 2 گولیاں ہیں۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "For adults & children (above 12 years), take 4-6 tablespoons of Rondec C 120ml Syrup in divided doses.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n" +
                    "ببالغوں اور بچوں (12 سال سے اوپر) کے لیے خوراک 4-6 کھانے کے چمچ لیں۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔\n"};

    String mSideEffects[] = {"Drowsiness, dizziness, dry mouth/nose/throat, headache, upset stomach, constipation, or trouble sleeping may occur. If any of these effects last or get worse, tell your doctor or pharmacist promptly.\n\n"+"غنودگی، چکر آنا، خشک منہ/ناک/گلا، سر درد، پیٹ کی خرابی، قبض، یا نیند میں پریشانی ہو سکتی ہے۔ اگر ان میں سے کوئی اثر دیر تک رہتا ہے یا بدتر ہو جاتا ہے، تو اپنے ڈاکٹر یا فارماسسٹ کو فوری طور پر بتائیں۔",
            "Usually arinac has a low incidence of side effects. The most frequent side effects are gastrointestinal disturbances. Peptic ulceration and gastrointestinal bleeding have occasionally been reported. Other side effects include headache, dizziness, nervousness, skin rash, pruritus, drowsiness, insomnia, blurred vision and other ocular reactions, hypersensitivity reaction, abnormal liver function test, impairment of renal function, agranulocytosis and thrombocytopenia.\n" +
                    "\n" +
                    "عام طور پر اریناک کے ضمنی اثرات کے واقعات کم ہوتے ہیں۔ سب سے زیادہ کثرت سے ضمنی اثرات معدے کی خرابی ہیں۔ پیپٹک السریشن اور معدے سے خون بہنے کی کبھی کبھار اطلاع ملی ہے۔ دیگر ضمنی اثرات میں سر درد، چکر آنا، گھبراہٹ، جلد پر خارش، خارش، غنودگی، بے خوابی، دھندلا پن اور آنکھوں کے دیگر رد عمل، انتہائی حساسیت کا رد عمل، غیر معمولی جگر کے فنکشن ٹیسٹ، رینل فنکشن کی خرابی، ایگرانولو سائیٹوسس اور تھرومبوسائٹوپینیا شامل ہیں۔\n",
            "Drowsiness, dizziness, dry mouth/nose/throat, headache, upset stomach, constipation, or trouble sleeping may occur. If any of these effects last or get worse, tell your doctor or pharmacist promptly.\n" +
                    "\n" +
                    "غنودگی، چکر آنا، خشک منہ/ناک/گلا، سر درد، پیٹ کی خرابی، قبض، یا نیند میں پریشانی ہو سکتی ہے۔ اگر ان میں سے کوئی اثر دیر تک رہتا ہے یا بدتر ہو جاتا ہے، تو اپنے ڈاکٹر یا فارماسسٹ کو فوری طور پر بتائیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine4);
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
                Intent i = new Intent(Medicine4.this, LoginActivity.class);
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

