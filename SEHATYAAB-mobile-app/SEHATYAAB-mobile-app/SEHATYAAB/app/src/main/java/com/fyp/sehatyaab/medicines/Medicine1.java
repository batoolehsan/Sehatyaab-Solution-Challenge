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


public class Medicine1 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"PARACETAMOL","PANADOL EXTRA","ARINAC"};

    String mDescription[] = {"Paracetamol is a commonly used medicine that can help treat pain and reduce a high temperature. It's typically used to relieve mild or moderate pain, such as headaches, toothache or sprains, and reduce fevers caused by illnesses such as colds and flu.\n\n"+ "پیراسیٹامول ایک عام طور پر استعمال ہونے والی دوا ہے جو درد کے علاج اور اعلی درجہ حرارت کو کم کرنے میں مدد کر سکتی ہے۔ یہ عام طور پر ہلکے یا اعتدال پسند درد کو دور کرنے کے لیے استعمال کیا جاتا ہے، جیسے سر درد، دانت کا درد یا موچ، اور نزلہ اور فلو جیسی بیماریوں کی وجہ سے بخار کو کم کرنے کے لیے۔",
            "Panadol Extra is recommended for the treatment of most symptoms of mild to moderate pain and fever, eg: Headache, migraine, backache, toothache, joint pain, menstrual pain, relief of cold symptoms colds, flu and sore throat.\n\n"+"یہ ہلکے سے اعتدال پسند درد اور بخار کی زیادہ تر علامات کے علاج کے لیے ہے، جیسے: سر درد، درد شقیقہ، کمر درد، دانت کا درد، جوڑوں کا درد، ماہواری میں درد، سردی کی علامات سے نجات، زکام، فلو اور گلے کی سوزش۔",
            "Arinac is recommended for the treatment of fever, nasal congestion, flu and headache.\n\n"+
                    "اریناک بخار، ناک بند ہونا، فلو اور سر درد کے علاج کے لیے استعمال کی جاتی ہے۔"};

    int images[] = {R.drawable.paracetamol,R.drawable.panadol,R.drawable.arinac};

    String mDosage[] = {"The usual dose for adults is 1 or 2 500mg tablets up to 4 times in 24 hours.\n" + "Keep a gap of at least 4-6 hours between the dose and the next dose.\n\n"+"بالغوں کے لئے معمول کی خوراک 1 یا 2 گولیاں 24 گھنٹوں میں 4 بار تک ہے۔" +
            "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "The usual dose for adults is 1 or 2 tablets up to 4 times in 24 hours.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n"+"بالغوں کے لئے معمول کی خوراک 1 یا 2 گولیاں 24 گھنٹوں میں 4 بار تک ہے۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "The usual dose for adults is 1 or 2 tablets.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n" +
                    "بالغوں کے لئے معمول کی خوراک 1 یا 2 گولیاں ہیں۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔\n"};

    String mSideEffects[] = {"This medicine has no known side effects. However if you do experience any unusual side effects please make sure to consult your doctor. An allergic reaction to this medicine is uncommon. If you do experience a rash, itching, swelling, dizziness or trouble breathing, seek medical attention immediately.\n\n"+"اس دوا کے کوئی معروف ضمنی اثرات نہیں ہیں۔ تاہم اگر آپ کسی غیر معمولی ضمنی اثرات کا تجربہ کرتے ہیں تو براہ کرم اپنے ڈاکٹر سے مشورہ یقینی بنائیں۔ اس دوا سے الرجک رد عمل غیر معمولی ہے۔ اگر آپ کو خارش، خارش، سوجن، چکر آنا یا سانس لینے میں دشواری کا سامنا ہے تو فوری طور پر طبی امداد حاصل کریں۔",
            "In general, the drug is safe when taken at the recommended dose. Some people may experience the following side effects: dizziness, headache, constipation, insomnia, restlessness, anxiety, digestive upset.\n" +
                    "\n" +
                    "عام طور پر، جب دی گئی خوراک پر لیا جائے تو دوا محفوظ رہتی ہے۔ کچھ لوگ درج ذیل ضمنی اثرات کا تجربہ کر سکتے ہیں: چکر آنا، سر درد، قبض، بے خوابی، بے چینی، بے چینی، ہاضمہ خراب ہونا۔\n",
            "Usually arinac has a low incidence of side effects. The most frequent side effects are gastrointestinal disturbances. Peptic ulceration and gastrointestinal bleeding have occasionally been reported. Other side effects include headache, dizziness, nervousness, skin rash, pruritus, drowsiness, insomnia, blurred vision and other ocular reactions, hypersensitivity reaction, abnormal liver function test, impairment of renal function, agranulocytosis and thrombocytopenia.\n" +
                    "\n" +
                    "عام طور پر اریناک کے ضمنی اثرات کے واقعات کم ہوتے ہیں۔ سب سے زیادہ کثرت سے ضمنی اثرات معدے کی خرابی ہیں۔ پیپٹک السریشن اور معدے سے خون بہنے کی کبھی کبھار اطلاع ملی ہے۔ دیگر ضمنی اثرات میں سر درد، چکر آنا، گھبراہٹ، جلد پر خارش، خارش، غنودگی، بے خوابی، دھندلا پن اور آنکھوں کے دیگر رد عمل، انتہائی حساسیت کا رد عمل، غیر معمولی جگر کے فنکشن ٹیسٹ، رینل فنکشن کی خرابی، ایگرانولو سائیٹوسس اور تھرومبوسائٹوپینیا شامل ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine1);
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
                Intent i = new Intent(Medicine1.this, LoginActivity.class);
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

