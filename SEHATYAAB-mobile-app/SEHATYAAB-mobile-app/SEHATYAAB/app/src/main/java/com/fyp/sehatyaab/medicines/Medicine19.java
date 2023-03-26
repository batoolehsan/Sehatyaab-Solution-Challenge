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


public class Medicine19 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"AVAMYS","TRANSAMIN","SINEX"};

    String mDescription[] = {"Avamys works on your immune system to reduce the symptoms of inflammatory conditions and allergic reactions such as swelling, redness and itching. The nasal spray reduces swelling and mucus in your nose. It can take a little longer to work than antihistamine nasal sprays but the effects last for longer.\n\n"+ "یہ آپ کے مدافعتی نظام پر سوزش کی حالتوں اور الرجک رد عمل جیسے سوجن، لالی اور خارش کی علامات کو کم کرنے کے لیے کام کرتا ہے۔ ناک کا سپرے آپ کی ناک میں سوجن اور بلغم کو کم کرتا ہے۔ اینٹی ہسٹامائن ناک کے اسپرے کے مقابلے میں اسے کام کرنے میں تھوڑا زیادہ وقت لگ سکتا ہے لیکن اثرات زیادہ دیر تک رہتے ہیں۔",
            "Transamin is used to control heavy menstrual bleeding. It helps your blood to clot and is used for nosebleeds and heavy periods.\n\n"+"ٹرانسامین کا استعمال ماہواری کے بھاری خون کو کنٹرول کرنے کے لیے کیا جاتا ہے۔ یہ آپ کے خون کو جمنے میں مدد کرتا ہے اور ناک سے خون بہنے اور بھاری ادوار کے لیے استعمال ہوتا ہے۔",
            "Vicks Sinex Nasal Spray helps relieve the sinus and nasal congestion that often accompanies colds, hay fever, or upper respiratory allergies.\n\n"+
                    "یہ ہڈیوں اور ناک کی بھیڑ کو دور کرنے میں مدد کرتا ہے جو اکثر نزلہ، گھاس بخار، یا اوپری سانس کی الرجی کے ساتھ ہوتا ہے۔"};

    int images[] = {R.drawable.avamys,R.drawable.transamin,R.drawable.sinex};

    String mDosage[] = {"Do one sprays in each nostrils once daily.\n\n"+"روزانہ ایک بار ہر نتھنے میں ایک سپرے کریں۔" ,
            "Take 1 pill twice a day.\n" +
            "\n"+"ایک گولی دن میں 2 بار لیں۔\n" ,
            "do one sprays in each nostrils once daily.\n" +
            "\n" + "روزانہ ایک بار ہر نتھنے میں ایک سپرے کریں۔\n"};

    String mSideEffects[] = {"Common side effects are include throat irritation, dryness of the nose, nasal passage irritation, headache.\n\n"+"عام ضمنی اثرات میں گلے کی جلن، ناک کا خشک ہونا، ناک کے راستے میں جلن، سر درد شامل ہیں۔",
            "The more common side effects include nausea ,diarrhea ,stomach pain or discomfort vomiting ,chills fever ,severe headache ,throbbing, back or joint pain ,muscle pain.\n" +
                    "\n" +
                    "زیادہ عام ضمنی اثرات میں متلی، اسہال، پیٹ میں درد یا تکلیف قے، سردی لگنا، بخار، شدید سر درد، دھڑکن، کمر یا جوڑوں کا درد پٹھوں میں درد شامل ہیں۔\n",
            "Common side effects may include dizziness, Feeling nervous and excitable, trouble sleeping.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں چکر آنا، گھبراہٹ اور پرجوش محسوس کرنا، نیند میں دشواری شامل ہو سکتی ہے۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine19);
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
                Intent i = new Intent(Medicine19.this, LoginActivity.class);
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

