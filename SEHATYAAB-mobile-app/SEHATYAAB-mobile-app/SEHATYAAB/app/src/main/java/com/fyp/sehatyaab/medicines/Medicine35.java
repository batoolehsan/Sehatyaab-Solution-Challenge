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


public class Medicine35 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"HIDRASEC","Q - PLEX","TRIORAL"};

    String mDescription[] = {"Hidrasec is used for the treatment of symptoms of acute diarrhea in children.\n\n"+ "یہ بچوں میں شدید اسہال کی علامات کے علاج کے لیے استعمال ہوتا ہے۔",
            "Q-Plex syrup is an oral suspension, that treats and prevents certain bowel problems, such as diarrhea, loose stool and irritable bowl.\n\n"+"یہ ایک زبانی معطلی ہے، جو آنتوں کے بعض مسائل کا علاج اور روک تھام کرتی ہے، جیسے کہ اسہال، ڈھیلا پاخانہ اور چڑچڑا پن۔",
            "TRIORAL treat food poisoning by making sure you don’t get dehydrated. One of the symptoms of food poisoning is diarrhea, which dehydrates you.\n\n"+
                    "یہ اس بات کو یقینی بنا کر فوڈ پوائزننگ کا علاج کرتا ہے کہ آپ کو پانی کی کمی نہ ہو۔ فوڈ پوائزننگ کی علامات میں سے ایک اسہال ہے، جو آپ کو پانی کی کمی کا باعث بنتا ہے۔"};

    int images[] = {R.drawable.hidrasec,R.drawable.qplex,R.drawable.trioral};

    String mDosage[] = {"Take one 30 mg sachet 3 times daily.\n\n" + "دن میں 3 بار ایک 30 ملی گرام کا ساشے لیں۔" ,
            "Take 1 teaspoon twice a day.\n" +
            "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
            "\n" +
            "ایک چائے کا چمچ دن میں دو بار لیں۔\n" +
            "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔\n" ,
            "Just mix 1 packet with water and drink.\n" +
            "\n" +
            "بس 1 پیکٹ پانی میں ملا کر پی لیں۔\n" +
            "\n"};

    String mSideEffects[] = {"Swelling of the face, tongue, lips or eyelids, Severe skin rash such as multiforme, Tender red lumps under the skin, usually on the calves (erythema nodosum), Skin reactions such as rash, hives (urticaria), redness or itching.\n\n"+"چہرے، زبان، ہونٹوں یا پلکوں کی سوجن، جلد کے شدید دانے جیسے ملٹیفارم، جلد کے نیچے نرم سرخ گانٹھیں، عام طور پر پنڈلیوں پر (ایریتھیما نوڈوسم)، جلد کے رد عمل جیسے دانے، چھتے (چھپاکی)، لالی یا خارش۔",
            "Common side effects are constipation, tiredness, drowsiness and dizziness.\n" +
                    "\n" +
                    "عام ضمنی اثرات قبض، تھکاوٹ، غنودگی اور چکر آنا ہیں۔\n",
            "Common side effects may include mild nausea, diarrhea, constipation, dizziness, headache, blurred vision, dry mouth, skin rash.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں ہلکی متلی، اسہال، قبض، چکر آنا، سر درد، دھندلا پن، خشک منہ، جلد پر خارش شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine35);
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
                Intent i = new Intent(Medicine35.this, LoginActivity.class);
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
