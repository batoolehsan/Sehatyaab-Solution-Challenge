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


public class Medicine13 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"BRUFEN CREAM","VOLTRAL EMULGEL","WINTOGENO","IODEX"};

    String mDescription[] = {"Brufen cream is a topical analgesic and anti-inflammatory gel to relieve pain and inflammation in your body. It is most commonly used for the relief of rheumatic pain (pain caused by problems with muscles, tendons, joints or bones) Muscular aches and pains.\n\n"+ "یہ آپ کے جسم میں درد اور سوزش کو دور کرنے کے لیے استعمال ہوتا ہے۔ یہ عام طور پر گٹھیا کے درد (پٹھوں، کنڈرا، جوڑوں یا ہڈیوں کے مسائل کی وجہ سے ہونے والا درد) پٹھوں کے درد اور درد سے نجات کے لیے استعمال کیا جاتا ہے۔",
            "Voltral Emulgel is used to relieve pain and reduce swelling in a number of painful conditions affecting the joints and muscles, e.g. sprains, strains and bruises.\n\n"+"وولٹرل ایمولجیل کا استعمال درد کو دور کرنے اور جوڑوں اور پٹھوں کو متاثر کرنے والی کئی تکلیف دہ حالتوں میں سوجن کو کم کرنے کے لیے کیا جاتا ہے، جیسے موچ، تناؤ اور زخم۔",
            "Wintogeno used as a topical application for the symptomatic relief of muscular pains and stiffness, including backache, fibrositis, lumbago, muscular aches, neuralgia, painful bruises, sciatica, sprains and strains.\n\n"+
                    "ونٹوجینو کو پٹھوں کے درد، سختی، بشمول کمر درد، فائبروسائٹس، لمباگو، پٹھوں میں درد، اعصابی درد، دردناک زخموں، موچوں اور تناؤ کے لیے استعمال کیا جاتا ہے۔","Iodex is used on the skin to treat or prevent skin infection in minor cuts, scrapes, or burns. Iodex is also used in a medical setting to help prevent infection and promote healing in skin wounds, pressure sores, or surgical incisions.\n\n"+
            "آئوڈیکس کا استعمال جلد پر معمولی کٹوتیوں، کھرچوں یا جلنے میں جلد کے انفیکشن کے علاج یا روک تھام کے لیے کیا جاتا ہے۔ اس کا استعمال طبی ترتیب میں انفیکشن کو روکنے اور جلد کے زخموں، دباؤ کے زخموں، یا جراحی کے چیراوں میں شفا یابی کو فروغ دینے کے لیے بھی کیا جاتا ہے۔"};

    int images[] = {R.drawable.brufen,R.drawable.voltral,R.drawable.wintogeno,R.drawable.iodex};

    String mDosage[] = {"Use up to four times daily with individual doses administered at least 4 hours apart.\n\n"+"کم از کم 4 گھنٹے کے وقفے سے دی جانے والی انفرادی خوراک کے ساتھ روزانہ چار بار تک استعمال کریں۔" ,
            "Use up to four times daily with individual doses administered at least 4 hours apart.\n" +
            "\n"+"کم از کم 4 گھنٹے کے وقفے سے دی جانے والی انفرادی خوراک کے ساتھ روزانہ چار بار تک استعمال کریں۔\n" ,
            "Use up to four times daily with individual doses administered at least 4 hours apart.\n" +
            "\n" + "کم از کم 4 گھنٹے کے وقفے سے دی جانے والی انفرادی خوراک کے ساتھ روزانہ چار بار تک استعمال کریں۔\n",
                    "Use up to four times daily with individual doses administered at least 4 hours apart.\n" +
            "\n" + "کم از کم 4 گھنٹے کے وقفے سے دی جانے والی انفرادی خوراک کے ساتھ روزانہ چار بار تک استعمال کریں۔\n"};

    String mSideEffects[] = {"Common side effects may include swelling, skin rash or burning.\n\n"+"عام ضمنی اثرات میں سوجن، جلد پر خارش یا جلن شامل ہو سکتے ہیں۔",
            "Common side effects may include skin irritation, itching or redness.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں جلد کی جلن، خارش یا لالی شامل ہوسکتی ہے۔\n",
            "Common side effects may include Redness or swelling of the treated region, increasing discomfort, severe burning, or skin irritation such as a rash, itching, soreness, or blistering.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں علاج شدہ علاقے کی لالی یا سوجن، بڑھتی ہوئی تکلیف، شدید جلن، یا جلد کی جلن جیسے خارش، خارش، درد، یا چھالے شامل ہو سکتے ہیں۔\n", "Common side effects may include swelling, pain or other signs of infection, blistering, crusting, itching or burning.\n" +
            "\n" +
            "عام ضمنی اثرات میں سوجن، درد یا انفیکشن کی دیگر علامات، چھالے، کرسٹنگ، خارش یا جلن شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine13);
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
                Intent i = new Intent(Medicine13.this, LoginActivity.class);
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

