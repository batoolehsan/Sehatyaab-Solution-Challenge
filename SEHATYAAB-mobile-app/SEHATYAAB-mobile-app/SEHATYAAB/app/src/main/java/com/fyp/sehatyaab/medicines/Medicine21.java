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


public class Medicine21 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"MYTEKA","MONTIGET","QUIBRON - T / SR","SERETIDE EVOHALAR"};

    String mDescription[] = {"It is used regularly to prevent the wheezing and shortness of breath caused by asthma and decrease the number of asthma attacks.\n\n"+ "یہ دمہ کی وجہ سے گھرگھراہٹ اور سانس کی قلت کو روکنے اور دمہ کے حملوں کی تعداد کو کم کرنے کے لیے باقاعدگی سے استعمال کیا جاتا ہے۔",
            "It is used regularly to prevent the wheezing and shortness of breath caused by asthma and decrease the number of asthma attacks.\n\n"+"یہ دمہ کی وجہ سے گھرگھراہٹ اور سانس کی قلت کو روکنے اور دمہ کے حملوں کی تعداد کو کم کرنے کے لیے باقاعدگی سے استعمال کیا جاتا ہے۔",
            "It is used to treat lung diseases such as asthma and COPD (bronchitis, emphysema). It must be used regularly to prevent wheezing and shortness of breath.\n\n"+
                    "یہ پھیپھڑوں کی بیماریوں جیسے دمہ اور (برونائٹس، واتسفیتی) کے علاج کے لیے استعمال ہوتا ہے۔ گھرگھراہٹ اور سانس کی قلت کو روکنے کے لیے اسے باقاعدگی سے استعمال کرنا چاہیے۔",
            "It is used to treat lung diseases such as asthma and COPD (bronchitis, emphysema). It must be used regularly to prevent wheezing and shortness of breath.\n\n"+
            "یہ پھیپھڑوں کی بیماریوں جیسے دمہ اور (برونائٹس، واتسفیتی) کے علاج کے لیے استعمال ہوتا ہے۔ گھرگھراہٹ اور سانس کی قلت کو روکنے کے لیے اسے باقاعدگی سے استعمال کرنا چاہیے۔"};

    int images[] = {R.drawable.myteka,R.drawable.montiget,R.drawable.quibron,R.drawable.seretide};

    String mDosage[] = {"The dosage is 1 tablet daily.\n\n"+"خوراک روزانہ 1 گولی ہے۔" ,
            "The dosage is 1 tablet daily.\n" +
            "\n"+"خوراک روزانہ 1 گولی ہے۔\n" ,
            "The dosage is 1 tablet daily.\n" +
            "\n" + "خوراک روزانہ 1 گولی ہے۔\n",
            "Take 2 puffs twice daily..\n" +
            "\n" + "روزانہ دو بار 2 پف لیں۔\n"};

    String mSideEffects[] = {"Common side effects are include headache, restlessness, abdominal pain, increased sweating, anaphylaxis.\n\n"+"عام ضمنی اثرات میں سر درد، بے چینی، پیٹ میں درد، پسینہ بڑھنا، انفیلیکسس شامل ہیں۔",
            "Common side effects are include headache, restlessness, abdominal pain, increased sweating, anaphylaxis.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں سر درد، بے چینی، پیٹ میں درد، پسینہ بڑھنا، انفیلیکسس شامل ہیں۔\n",
            "Nausea/vomiting, stomach/abdominal pain, headache, trouble sleeping, diarrhea, irritability, restlessness, nervousness, shaking, or increased urination may occur. If any of these effects last or get worse, tell your doctor or pharmacist promptly.\n" +
                    "\n" +
                    "متلی/الٹی، پیٹ/پیٹ میں درد، سر درد، نیند میں دشواری، اسہال، چڑچڑاپن، بے چینی، گھبراہٹ، کپکپاہٹ، یا پیشاب میں اضافہ ہو سکتا ہے۔ اگر ان میں سے کوئی اثر دیر تک رہتا ہے یا بدتر ہو جاتا ہے، تو اپنے ڈاکٹر یا فارماسسٹ کو فوری طور پر بتائیں۔\n", "Hoarseness, throat irritation, headache, or stomach upset may occur. If any of these effects persist or worsen, tell your doctor promptly.\n" +
            "\n" +
            "کھردرا پن، گلے میں جلن، سر درد، یا پیٹ کی خرابی ہو سکتی ہے۔ اگر ان میں سے کوئی بھی اثر برقرار رہتا ہے یا خراب ہوتا ہے، تو اپنے ڈاکٹر کو فوری طور پر بتائیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine21);
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
                Intent i = new Intent(Medicine21.this, LoginActivity.class);
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

