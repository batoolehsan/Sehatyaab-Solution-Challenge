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


public class Medicine3 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"NITROSTAT","CARDNIT","ANGISED"};

    String mDescription[] = {"Nitroglycerin extended-release tablets are used to prevent chest pain (angina) in people with a certain heart condition (coronary artery disease).\n\n"+ "نائٹروگلسرین کی توسیعی ریلیز گولیاں سینے کے درد (انجینا) کو روکنے کے لیے استعمال کی جاتی ہیں جن میں دل کی ایک مخصوص حالت (کورونری شریان کی بیماری) ہے۔",
            "Nitroglycerin extended-release capsules are used to prevent chest pain (angina) in people with a certain heart condition (coronary artery disease).\n\n"+"نائٹروگلیسرین کے توسیعی کیپسول کا استعمال سینے میں درد (انجینا) کو روکنے کے لیے کیا جاتا ہے جن لوگوں میں دل کی ایک مخصوص حالت (کورونری شریان کی بیماری) ہے۔",
            "This medication is used to treat and prevent heart-related chest pain (angina) in people.\n\n"+
                    "یہ دوا لوگوں میں دل سے متعلق سینے کے درد (انجینا) کے علاج اور روکنے کے لیے استعمال ہوتی ہے۔"};

    int images[] = {R.drawable.nitroglyceringlyceryl,R.drawable.cardnit,R.drawable.angised};

    String mDosage[] = {"Take this medication by mouth, usually 3 to 4 times daily or as directed by your doctor.\n" + "Keep a gap of at least 4-6 hours between the dose and the next dose.\n\n"+"اس دوا کو منہ سے لیں، عام طور پر روزانہ 3 سے 4 بار یا اپنے ڈاکٹر کی ہدایت کے مطابق۔" +
            "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "Dosage should be adjusted to the requirements of the individual patient but will usually be 1 or 2 tablets taken three times daily. The lowest effective dose should be used.\n" +
                    "\n"+"خوراک کو انفرادی مریض کی ضروریات کے مطابق ایڈجسٹ کیا جانا چاہئے لیکن عام طور پر روزانہ تین بار 1 یا 2 گولیاں لی جائیں گی۔ سب سے کم مؤثر خوراک استعمال کی جانی چاہئے۔\n",
            "Take this medication by mouth, 1 tablet daily or as directed by your doctor.\n" +
                    "\n" +
                    "روزانہ 1 گولی لیں یا اپنے ڈاکٹر کی ہدایت کے مطابق لیں۔\n"};

    String mSideEffects[] = {"Common side effects of Nitrostat include headache, dizziness, lightheadedness, nausea, flushing, and burning/tingling under the tongue.\n\n"+"نائٹروسٹیٹ کے عام ضمنی اثرات میں سر درد، چکر آنا، سر کا ہلکا پن، متلی، فلشنگ، اور زبان کے نیچے جلن/جھنجھنا شامل ہیں۔",
            "Side-effects include facial flushing, headache, dizziness and postural hypotension which may be associated with reflex tachycardia or paradoxical bradycardia. Toxic effects of Cardnit include vomiting, restlessness, cyanosis, methaemoglobinaemia and syncope.\n" +
                    "\n" +
                    "ضمنی اثرات میں چہرے کی چمک، سر درد، چکر آنا اور پوسٹورل ہائپوٹینشن شامل ہیں جو کہ اضطراری ٹاکی کارڈیا یا پیراڈوکسیکل بریڈی کارڈیا سے منسلک ہو سکتے ہیں۔ زہریلے اثرات میں الٹی، بے چینی، سائانوسس، میتھیموگلوبینیمیا اور سنکوپ شامل ہیں۔\n",
            "Headache dizziness lightheadedness nausea and flushing may occur. If any of these effects persist or worsen tell your doctor or pharmacist promptly.\n" +
                    "\n" +
                    "سر درد چکر آنا ہلکا سر متلی اور فلشنگ ہو سکتی ہے۔ اگر ان میں سے کوئی اثر برقرار رہتا ہے یا خراب ہوتا ہے تو اپنے ڈاکٹر یا فارماسسٹ کو فوری طور پر بتائیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine3);
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
                Intent i = new Intent(Medicine3.this, LoginActivity.class);
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

