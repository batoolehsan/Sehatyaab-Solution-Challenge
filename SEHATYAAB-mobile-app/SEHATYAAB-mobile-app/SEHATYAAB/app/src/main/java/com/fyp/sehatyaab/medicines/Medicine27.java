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


public class Medicine27 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"CYCLOPAM","PEDIALYTE","BRUFEN"};

    String mDescription[] = {"Cyclopam is an 'antispasmodic' (spasm and cramps reliever) agent containing Dicyclomine and Simethicone, primarily used for reducing stomach pain.\n\n"+ "یہ ایک 'اینٹی اسپاسموڈک' (ایٹھن اور درد کو دور کرنے والا) ایجنٹ ہے جس میں ڈائسائیکلومین اور سیمیتھیکون شامل ہیں، بنیادی طور پر پیٹ کے درد کو کم کرنے کے لیے استعمال کیا جاتا ہے۔",
            "Pedialyte is a flavored, ready-to-drink, Oral Rehydration Solution that provides children with the appropriate amount of electrolytes and fluids they need during mild to moderate dehydration.\n\n"+"پیڈیالائٹ ایک ذائقہ دار، پینے کے لیے تیار، اورل ری ہائیڈریشن سلوشن ہے جو بچوں کو مناسب مقدار میں الیکٹرولائٹس اور سیال فراہم کرتا ہے جس کی انہیں ہلکے سے اعتدال پسند پانی کی کمی کے دوران ضرورت ہوتی ہے۔",
            "Brufen syrup is often recommended to treat inflammation. Treating sore throat to teething pain as well as sprains, stomach pain and muscular pains, brufen uses are multiple and diverse.\n\n"+
                    "سوزش کے علاج کے لیے اکثر بروفن شربت کی سفارش کی جاتی ہے۔ گلے کی خراش سے لے کر دانتوں کے درد کے ساتھ ساتھ موچ، پیٹ کے درد اور پٹھوں کے درد کا علاج، بروفین کے استعمال متعدد اور متنوع ہیں۔"};

    int images[] = {R.drawable.cyclopam,R.drawable.pedialyte,R.drawable.brufen2};

    String mDosage[] = {"Take 1 tablespoon three times a day.\n\n"+"ایک چمچ دن میں تین بار لیں۔" ,
            "Take this medication 1 or 2 tablespoons every 15 to 20 minutes.\n" +
                    "\n"+"اس دوا کو ہر 15 سے 20 منٹ میں 1 یا 2 کھانے کے چمچ لیں۔\n" ,
            "The usual dose for kids is 1 tablespoon up to 3 times in 24 hours.\n" +
                    "Keep a gap of at least 4-6 hours between the dose and the next dose.\n" +
                    "\n" +
                    "بچوں کے لیے معمول کی خوراک 24 گھنٹوں میں 3 بار تک 1 چمچ ہے۔\n" +
                    "خوراک اور اگلی خوراک کے درمیان کم از کم 4-6 گھنٹے کا وقفہ رکھیں۔\n"};

    String mSideEffects[] = {"Common side effects may include nausea, blurred vision, drowsiness, nervousness, constipation, loss of appetite.\n\n"+"عام ضمنی اثرات میں متلی، دھندلا پن، غنودگی، گھبراہٹ، قبض، بھوک میں کمی شامل ہو سکتے ہیں۔",
            "Dizziness, fast heartbeat, high blood pressure, irritability, muscle twitching, restlessness swelling of feet or lower legs weakness.\n" +
                    "\n" +
                    "چکر آنا، تیز دل کی دھڑکن، ہائی بلڈ پریشر، چڑچڑاپن، پٹھوں کا مروڑنا، بے چینی پاؤں میں سوجن یا پیروں کے نچلے حصے کی کمزوری۔\n",
            "Common side effects includes vomiting, nausea, diarrhea, indigestion etc.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں الٹی، متلی، اسہال، بدہضمی وغیرہ شامل ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine27);
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
                Intent i = new Intent(Medicine27.this, LoginActivity.class);
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

