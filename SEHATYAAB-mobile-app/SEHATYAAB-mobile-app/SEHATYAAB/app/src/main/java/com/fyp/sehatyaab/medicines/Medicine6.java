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


public class Medicine6 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"RISEK","RULING-40","OMEGA","NEXIUM"};

    String mDescription[] = {"Used in the treatment of peptic ulcer and gastro-oesophageal reflux disease (GERD).\n\n"+ "پیپٹک السر اور گیسٹرو سوفیجل ریفلوکس بیماری کے علاج میں استعمال کیا جاتا ہے۔",
            "It is used to treat certain stomach and esophagus problems (such as acid reflux, ulcers).\n\n"+"یہ معدہ اور غذائی نالی کے بعض مسائل (جیسے ایسڈ ریفلوکس، السر) کے علاج کے لیے استعمال ہوتا ہے۔",
            "Omega 20mg Capsule is a medicine that reduces the amount of acid produced in your stomach. It helps treat acid-related diseases of the stomach and intestine such as heartburn, acid reflux, and peptic ulcer disease.\n\n"+
                    "یہ ایک ایسی دوا ہے جو آپ کے پیٹ میں پیدا ہونے والے تیزاب کی مقدار کو کم کرتی ہے۔ یہ معدے اور آنت کی تیزابیت سے متعلق بیماریوں جیسے دل کی جلن، ایسڈ ریفلوکس، اور پیپٹک السر کی بیماری کے علاج میں مدد کرتا ہے۔",
            "Nexium is used to treat or prevent certain conditions caused by the excessive production of stomach acid.\n\n"+
            "یہ معدے میں تیزاب کی ضرورت سے زیادہ پیداوار کی وجہ سے پیدا ہونے والی بعض شرائط کے علاج یا روک تھام کے لیے استعمال ہوتا ہے۔"};

    int images[] = {R.drawable.risek,R.drawable.ruling,R.drawable.omega,R.drawable.nexium};

    String mDosage[] = {"Take this medication 15- 30 minutes before meal.\n\n"+"اس دوا کو کھانے سے 15-30 منٹ پہلے لیں۔" ,
            "The initial dose is 1 tablet a day. Take this medication 15- 30 minutes before meal.\n" +
            "\n"+"ابتدائی خوراک ایک دن میں 1 گولی ہے۔ اس دوا کو کھانے سے 15-30 منٹ پہلے لیں۔\n" ,
            "Take this medication once daily.\n" +
            "\n" + "اس دوا کو روزانہ ایک بار لیں۔\n",
            "Take this medication twice a day.\n" +
            "\n" + "اس دوا کو دن میں دو بار لیں۔\n"};

    String mSideEffects[] = {"Abdominal pain, asthenia, constipation, diarrhea, flatulence, nausea, vomiting, acid regurgitation, headache.\n\n"+"پیٹ میں درد، استھینیا، قبض، اسہال، پیٹ پھولنا، متلی، الٹی، تیزابیت، سر درد۔",
            "Dizziness, a rise in liver enzymes, joint discomfort, muscular ache, headaches, and allergies are all possible side effects of Ruling 40.\n" +
                    "\n" +
                    "چکر آنا، جگر کے خامروں میں اضافہ، جوڑوں کی تکلیف، پٹھوں میں درد، سر درد، اور الرجی تمام ممکنہ ضمنی اثرات ہیں۔\n",
            "Diarrhea, Stomach pain, Headache, Nausea, Vomiting, Dizziness, Drowsiness, Muscle pain, Sleepiness.\n" +
                    "\n" +
                    "اسہال، پیٹ میں درد، سر درد، متلی، الٹی، چکر آنا، غنودگی، پٹھوں میں درد، نیند۔\n", "Headache, Dizziness, drowsiness, or irritability, Risk of kidney affection, Itching and pruritis, Abdominal pain, constipation, diarrhea, or flatulence.\n" +
            "\n" +
            "سر درد، چکر آنا، غنودگی، یا چڑچڑاپن، گردے کے پیار کا خطرہ، خارش اور خارش، پیٹ میں درد، قبض، اسہال، یا پیٹ پھولنا۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine6);
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
                Intent i = new Intent(Medicine6.this, LoginActivity.class);
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

