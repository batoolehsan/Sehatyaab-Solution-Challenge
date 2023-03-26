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


public class Medicine9 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"VIVARIN","MODAFINIL","AMANTADINE"};

    String mDescription[] = {"This medication is used occasionally to help you stay awake and alert when you are feeling tired or drowsy. Caffeine is a mild stimulant. This medication should not be used to replace sleep. This medication should not be used by children younger than 12 years old.\n\n"+ "جب آپ تھکے ہوئے یا غنودگی محسوس کر رہے ہوں تو یہ دوا آپ کو بیدار رہنے اور چوکنا رہنے میں مدد کے لیے کبھی کبھار استعمال کی جاتی ہے۔ کیفین ایک ہلکا محرک ہے۔ اس دوا کو نیند کو تبدیل کرنے کے لیے استعمال نہیں کیا جانا چاہیے۔ یہ دوا 12 سال سے کم عمر کے بچوں کو استعمال نہیں کرنی چاہیے۔",
            "Modafinil is used to treat excessive sleepiness caused by sleep apnea, narcolepsy, or shift work sleep disorder.\n\n"+"اس کا استعمال نیند کی کمی، نارکولیپسی، یا شفٹ ورک نیند کی خرابی کی وجہ سے ہونے والی ضرورت سے زیادہ نیند کے علاج کے لیے کیا جاتا ہے۔",
            "Amantadine is used to treat Parkinson's disease and Parkinson-like symptoms such as stiffness or tremors, shaking, and repetitive uncontrolled muscle movements that may be caused by the use of certain drugs.\n\n"+
                    "اس کا استعمال پارکنسنز کی بیماری اور پارکنسن جیسی علامات جیسے سختی یا جھٹکے، لرزنا، اور بار بار پٹھوں کی بے قابو حرکتوں کے علاج کے لیے کیا جاتا ہے جو بعض دوائیوں کے استعمال کی وجہ سے ہو سکتا ہے۔"};

    int images[] = {R.drawable.vivarin,R.drawable.modafinil,R.drawable.amantadine};

    String mDosage[] = {"Do not take more than 2 tablets at one time.\n\n"+"ایک وقت میں 2 سے زیادہ گولیاں نہ لیں۔" ,
            "Take 1 tablet once in a day.\n" +
            "\n"+"دن میں ایک بار 1 گولی لیں۔\n" ,
            "Take 1 tablet two times a day.\n" +
            "\n" + "ایک گولی دن میں دو بار لیں۔\n"};

    String mSideEffects[] = {"Common side effects may include feeling restless, loss of appetite or sleep problems ( insomnia ).\n\n"+"عام ضمنی اثرات میں بے چینی، بھوک میں کمی یا نیند کے مسائل (بے خوابی) شامل ہو سکتے ہیں۔",
            "Common side effects of modafinil may include headache, dizziness, feeling nervous or anxious, back pain, nausea, diarrhea, upset stomach, sleep problems ( insomnia ).\n" +
                    "\n" +
                    "موڈافینیل کے عام ضمنی اثرات میں سر درد، چکر آنا، گھبراہٹ یا بے چینی، کمر درد، متلی، اسہال، خراب پیٹ، نیند کے مسائل (بے خوابی) شامل ہو سکتے ہیں۔\n",
            "Common side effects may include swelling of the hands, legs, or feet, shortness of breath, depression or anxiety, difficulty urinating, rash.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں ہاتھ، ٹانگوں یا پیروں میں سوجن، سانس کی قلت، افسردگی یا پریشانی، پیشاب کرنے میں دشواری، دھبے شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine9);
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
                Intent i = new Intent(Medicine9.this, LoginActivity.class);
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

