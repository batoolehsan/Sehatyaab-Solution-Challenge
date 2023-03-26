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


public class Medicine10 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"CIPRALEX","ZAVGET"};

    String mDescription[] = {"Cipralex is used to treat treat depression and other mental health conditions like anxiety, panic disorder, and obsessive-compulsive disorder.\n\n"+ "اس کا استعمال ڈپریشن اور دیگر دماغی صحت کی حالتوں جیسے بے چینی، گھبراہٹ کی خرابی، اور جنونی مجبوری کی خرابی کے علاج کے لیے کیا جاتا ہے۔",
            "Zavget is used for Depressive illness, Generalized anxiety disorder, Obsessive-compulsive disorder, Social anxiety disorder.\n\n"+"یہ ڈپریشن کی بیماری، عمومی تشویش کی خرابی، جنونی مجبوری خرابی، سماجی تشویش کی خرابی کے لئے استعمال کیا جاتا ہے۔"};

    int images[] = {R.drawable.cipralex,R.drawable.zavget};

    String mDosage[] = {"The normally recommended dose is 1 tablet taken as one daily dose.\n\n"+"عام طور پر تجویز کردہ خوراک 1 گولی ہے جو ایک روزانہ خوراک کے طور پر لی جاتی ہے۔" ,
            "Take 1 Tablet a day with or without food.\n" +
            "\n"+"کھانے کے ساتھ یا بغیر ایک دن میں 1 گولی لیں۔\n"};

    String mSideEffects[] = {"Common side effects may include apetite loss, insomnia, drowsiness, dizziness, sinusitis, increased sweating, constipation or diarrhea, nausea, fatigue, fever, confusion, tremor, seizures, agitation, muscle and joint pain, visual disturbance and nervousness or anxiety.\n\n"+"عام ضمنی اثرات میں بھوک میں کمی، بے خوابی، غنودگی، چکر آنا، سائنوسائٹس، زیادہ پسینہ آنا، قبض یا اسہال، متلی، تھکاوٹ، بخار، الجھن، کپکپاہٹ، دورے، اشتعال انگیزی، پٹھوں اور جوڑوں کا درد، بصری خلل اور گھبراہٹ شامل ہو سکتے ہیں۔",
            "Common side effects may include nausea, insomnia, problems with ejaculation, drowsiness, increased sweating and fatigue.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں متلی، بے خوابی، انزال کے مسائل، غنودگی، پسینہ میں اضافہ اور تھکاوٹ شامل ہوسکتی ہے۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine10);
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
                Intent i = new Intent(Medicine10.this, LoginActivity.class);
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

