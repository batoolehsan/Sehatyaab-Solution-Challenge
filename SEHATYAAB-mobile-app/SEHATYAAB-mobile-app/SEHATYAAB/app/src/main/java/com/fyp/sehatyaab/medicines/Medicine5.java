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


public class Medicine5 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"IMODIUM","FLAGYL","ENTOX-P","LOMOTIL"};

    String mDescription[] = {"Imodium is a prescription medicine used to treat the symptoms of acute diarrhea, chronic diarrhea and Traveler’s Diarrhea. Imodium may be used alone or with other medications.\n\n"+ "اموڈیم ایک نسخہ کی دوا ہے جو شدید اسہال، دائمی اسہال اور ٹریولرز ڈائریا کی علامات کے علاج کے لیے استعمال ہوتی ہے۔ اموڈیم اکیلے یا دیگر ادویات کے ساتھ استعمال کیا جا سکتا ہے۔",
            "Flagyl is an antibiotic that is used to treat bacterial infections of the vagina, loose stools, stomach, liver, skin, joints, brain and spinal cord, lungs, heart, or bloodstream.\n\n"+"یہ ایک اینٹی بائیوٹک ہے جو اندام نہانی، ڈھیلے پاخانہ، معدہ، جگر، جلد، جوڑوں، دماغ اور ریڑھ کی ہڈی، پھیپھڑوں، دل، یا خون کے بیکٹیریل انفیکشن کے علاج کے لیے استعمال ہوتی ہے۔",
            "Entox-P tab treats and prevents certain bowel problems, such as diarrhea and irritable bowl.\n\n"+
                    "یہ آنتوں کے بعض مسائل کا علاج کرتا ہے اور روکتا ہے، جیسے اسہال اور چڑچڑا پن۔","Lomotil is typically used to treat acute (short-term) diarrhea that’s been resistant to other medications. Acute diarrhea may be related to a short-term illness such as a stomach bug.\n\n"+
            "یہ عام طور پر شدید (مختصر مدتی) اسہال کے علاج کے لیے استعمال ہوتا ہے جو دوسری دوائیوں کے خلاف مزاحم ہے۔"};

    int images[] = {R.drawable.imodium,R.drawable.flagyl,R.drawable.entoxp,R.drawable.lomotil};

    String mDosage[] = {"The recommended initial dose is two capsules after each unformed stool. Daily dose should not exceed eight capsules.\n" + "Keep a gap of at least 4-6 hours between the dose and the next dose.\n\n"+"تجویز کردہ ابتدائی خوراک ہر بے ساختہ پاخانہ کے بعد دو کیپسول ہے۔ روزانہ کی خوراک آٹھ کیپسول سے زیادہ نہیں ہونی چاہیے۔" +
            "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "The usual adult oral dosage is 1 tablet.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n"+"بالغوں کی زبانی معمول کی خوراک 1 گولی ہے۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔",
            "The recommended initial dose is two tablets after each unformed stool.\n" +
                    "Daily dose should not exceed 12 tablets.\n" +
                    "\n" +
                    "تجویز کردہ ابتدائی خوراک ہر بے ساختہ پاخانہ کے بعد دو گولیاں ہیں۔\n" +
                    "روزانہ خوراک 12 گولیاں سے زیادہ نہیں ہونی چاہئے۔\n","The recommended initial dose is 2 tablets four times a day. Do not take more than 8 tablets (20 mg of diphenoxylate) a day. Continue this dosage until your diarrhea starts to improve (stools become firmer), which should happen within 48 hours.\n" +
            "\n" + "تجویز کردہ ابتدائی خوراک دو گولیاں دن میں چار بار ہے۔ ایک دن میں آٹھ سے زیادہ گولیاں نہ لیں۔ اس خوراک کو اس وقت تک جاری رکھیں جب تک کہ آپ کا اسہال بہتر ہونا شروع نہ ہو جائے (پاخانہ مضبوط ہو جائے)، جو کہ 48 گھنٹوں کے اندر ہونا چاہیے۔\n"};

    String mSideEffects[] = {"The common side effects of a therapeutic Imodium dose are Dizziness ,Constipation ,Abdominal cramps, Nausea.\n\n"+"عام ضمنی اثرات ہیں چکر آنا، قبض، پیٹ میں درد، متلی۔",
            "Common Flagyl side effects may include depression, trouble sleeping, feeling irritable; headache, dizziness, weakness; nausea, vomiting, loss of appetite, stomach pain.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں ڈپریشن، نیند میں دشواری، چڑچڑا پن شامل ہو سکتے ہیں۔ سر درد، چکر آنا، کمزوری؛ متلی، الٹی، بھوک میں کمی، پیٹ میں درد۔\n",
            "The common side effects are diarrhea bloating or gas nausea and vomiting.\n" +
                    "\n" +
                    "عام ضمنی اثرات اسہال کا اپھارہ یا گیس متلی اور الٹی ہیں۔\n", "Lomotil Tablet may cause side effects such as constipation, dry mouth, indigestion, dizziness, drowsiness or difficulty in urination.\n" +
            "\n" +
            "اس کے مضر اثرات جیسے قبض، خشک منہ، بدہضمی، چکر آنا، غنودگی یا پیشاب میں دشواری کا سبب بن سکتا ہے۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine5);
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
                Intent i = new Intent(Medicine5.this, LoginActivity.class);
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

