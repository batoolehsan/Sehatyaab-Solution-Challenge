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


public class Medicine26 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"Q - PLEX","FLAGYL","IMODIUM"};

    String mDescription[] = {"Q-Plex syrup is an oral suspension, that treats and prevents certain bowel problems, such as diarrhea, loose stool and irritable bowl.\n\n"+ "یہ ایک زبانی معطلی ہے، جو آنتوں کے بعض مسائل کا علاج اور روک تھام کرتی ہے، جیسے کہ اسہال، ڈھیلا پاخانہ اور چڑچڑا پن۔",
            "Flagyl is an antibiotic that is used to treat bacterial infections of the vagina, loose stools, stomach, liver, skin, joints, brain and spinal cord, lungs, heart, or bloodstream.\n\n"+"یہ ایک اینٹی بائیوٹک ہے جو اندام نہانی، ڈھیلے پاخانہ، معدہ، جگر، جلد، جوڑوں، دماغ اور ریڑھ کی ہڈی، پھیپھڑوں، دل، یا خون کے بیکٹیریل انفیکشن کے علاج کے لیے استعمال ہوتی ہے۔",
            "Imodium syrup is used to treat diarrhea and reduce the amount of loose stools.\n"+
                    "اموڈیم سیرپ اسہال کے علاج اور ڈھیلے پاخانے کی مقدار کو کم کرنے کے لیے استعمال کیا جاتا ہے۔"};

    int images[] = {R.drawable.qplex,R.drawable.flagyl2,R.drawable.imodium2};

    String mDosage[] = {"Take 1 teaspoon twice a day.\n\n" + "Keep a gap of at least 4-6 hours between the dose and the next dose.\n\n"+"ایک چائے کا چمچ دن میں دو بار لیں۔" +
            "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "Take 1 teaspoon twice a day.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n"+"ایک چائے کا چمچ دن میں دو بار لیں۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "Take 1 teaspoon twice a day.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n" +
                    "ایک چائے کا چمچ دن میں دو بار لیں۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔\n"};

    String mSideEffects[] = {"Common side effects are constipation, tiredness, drowsiness and dizziness.\n\n"+"عام ضمنی اثرات قبض، تھکاوٹ، غنودگی اور چکر آنا ہیں۔",
            "Common Flagyl side effects may include depression, trouble sleeping, feeling irritable; headache, dizziness, weakness; nausea, vomiting, loss of appetite, stomach pain.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں ڈپریشن، نیند میں دشواری، چڑچڑا پن شامل ہو سکتے ہیں۔ سر درد، چکر آنا، کمزوری؛ متلی، الٹی، بھوک میں کمی، پیٹ میں درد۔\n",
            "Common side effects may include acidity , belching, dizziness, drowsiness, dryness of mouth, full feeling heartburn, indigestion and stomach upset.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں تیزابیت، ڈکارنا، چکر آنا، غنودگی، منہ کا خشک ہونا، سینے میں جلن، بدہضمی اور پیٹ کی خرابی شامل ہو سکتی ہے۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine26);
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
                Intent i = new Intent(Medicine26.this, LoginActivity.class);
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

