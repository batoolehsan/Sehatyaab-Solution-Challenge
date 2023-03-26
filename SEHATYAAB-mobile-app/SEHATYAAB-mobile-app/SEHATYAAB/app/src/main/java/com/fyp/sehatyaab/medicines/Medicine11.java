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


public class Medicine11 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"HYDROCORTISONE CREAM","AVIL 25","RIGIX"};

    String mDescription[] = {"It is used to treat a number of different conditions, such as inflammation (swelling), severe allergies, adrenal problems, arthritis, asthma, blood or bone marrow problems, eye or vision problems, lupus, skin conditions, and ulcerative colitis. Hydrocortisone is a corticosteroid (cortisone-like medicine or steroid).\n\n"+ "اس کا استعمال متعدد مختلف حالتوں کے علاج کے لیے کیا جاتا ہے، جیسے سوزش (سوجن)، شدید الرجی، ایڈرینل مسائل، گٹھیا، دمہ، خون یا بون میرو کے مسائل، آنکھ یا بینائی کے مسائل، لیوپس، جلد کے حالات، اور السرٹیو کولائٹس۔",
            "Avil is anti-allergic or anti-histamine in nature. So it curbs the symptoms like running nose, skin rashes, sneezing, blocked nose, etc.\n\n"+"ایول اینٹی الرجک یا اینٹی ہسٹامین فطرت میں ہے۔ لہذا یہ بہتی ہوئی ناک، جلد پر خارش، چھینکیں، بند ناک وغیرہ جیسی علامات کو روکتا ہے۔",
            "Rigix is used to treat allergy, urticaria, and allergy-induced asthma, and to decrease hives and pruritus.\n\n"+
                    "اس کا استعمال الرجی، چھپاکی، اور الرجی سے پیدا ہونے والے دمہ کے علاج کے لیے، اور چھتے اور خارش کو کم کرنے کے لیے کیا جاتا ہے۔"};

    int images[] = {R.drawable.hydrocortisone,R.drawable.avil,R.drawable.rigix};

    String mDosage[] = {"Apply to the affected area of the skin two to four times per day.\n\n"+"جلد کے متاثرہ حصے پر دن میں دو سے چار بار لگائیں۔" ,
            "Take 1 tablet once in a day.\n" +
            "\n"+"دن میں ایک بار 1 گولی لیں۔\n" ,
            "Take 1 tablet once in a day.\n" +
            "\n" + "دن میں ایک بار 1 گولی لیں۔\n"};

    String mSideEffects[] = {"The most common side effects of hydrocortisone cream are burning ,itching ,irritation ,skin dryness, changes in skin color (redness or lighter color than normal), excessive hair growth ,pimples resembling acne, softened or wrinkled skin.\n\n"+"ہائیڈروکارٹیسون کریم کے سب سے عام ضمنی اثرات میں جلن، خارش، جلن، جلد کا خشک ہونا، جلد کی رنگت میں تبدیلی (سرخ یا نارمل سے ہلکا رنگ)، بالوں کی ضرورت سے زیادہ بڑھنا، مہاسوں سے مشابہہ مہاسے، نرم یا جھریوں والی جلد ہیں۔",
            "Common side effects of avil may include stomach pain, heartburn, nausea, vomiting, gas, constipation, diarrhea.\n" +
                    "\n" +
                    "ایول کے عام ضمنی اثرات میں پیٹ میں درد، جلن، متلی، الٹی، گیس، قبض، اسہال شامل ہو سکتے ہیں۔\n",
            "Common side effects may include dizziness, dry mouth, dry nose and dry throat after using this drug.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں اس دوا کو استعمال کرنے کے بعد چکر آنا، منہ خشک ہونا، خشک ناک اور خشک حلق شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine11);
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
                Intent i = new Intent(Medicine11.this, LoginActivity.class);
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

