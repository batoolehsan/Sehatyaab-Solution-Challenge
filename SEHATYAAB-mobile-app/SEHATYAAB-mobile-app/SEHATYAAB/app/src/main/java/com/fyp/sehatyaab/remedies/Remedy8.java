package com.fyp.sehatyaab.remedies;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Remedy8 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. PEPPERMINT","2. SALT WATER GARGLE","3. TURMERIC"};

    String mDescription[] = {"Peppermint leaves are well known for their healing properties. Menthol in peppermint can help soothe the throat and may make breathing seem easier. You can benefit by drinking peppermint tea or inhaling peppermint vapors from a steam treatment. To make a steam treatment, add 7 or 8 drops of peppermint essential oil to about a cup of water that’s just boiled. Drape a towel over your head and take deep breaths directly above the water.\n\n" +
            "پودینہ کے پتے ان کی شفا یابی کی خصوصیات کے لئے مشہور ہیں۔ پیپرمنٹ میں مینتھول گلے کو آرام دہ اور پرسکون بنانے میں مدد کرسکتا ہے اور سانس لینے میں آسانی پیدا کرسکتا ہے۔ آپ پیپرمنٹ کی چائے پینے یا بھاپ کے علاج سے پیپرمنٹ بخارات کو سانس لینے سے فائدہ اٹھا سکتے ہیں۔ بھاپ کا علاج کرنے کے لئے ، تقریبا ایک کپ ابلے ہوئے پانی میں پیپرمنٹ کے تیل کے 7 یا 8 قطرے شامل کریں۔ اپنے سر پر ایک تولیہ لپیٹیں اور فوراً پانی کے اوپر گہری سانس لیں۔" ,
            "While the remedy may seem relatively simple, a salt and water gargle can help soothe a scratchy throat that causes you to cough. Mixing 1/4 to 1/2 teaspoon of salt with 8 ounces of warm water can help to relieve irritation. Note that since children under 6 years old are not especially good at gargling, it’s best to try other remedies for this age group.\n\n" +
                    "نمک اور پانی کے غرارے سے گلے میں خراش کو کم کرنے میں مدد مل سکتی ہے۔8 اونس گرم پانی کے ساتھ 1/4 سے 1/2 چائے کا چمچ نمک مکس کریں۔",
            "Turmeric has been used traditionally for many ailments over the years, including coughing. Its active compound, curcumin, has potent anti-inflammatory properties. It’s recommended to consume turmeric with black pepper. That’s because piperine, the major compound in black pepper, increases the bioavailability of turmeric. This supports your body’s absorption of turmeric. Try sipping warm turmeric tea or golden milk. Add a dash of black pepper and some honey for sweetness.\n\n" +
                    "ہلدی روایتی طور پر کئی سالوں سے بہت سی بیماریوں کے لئے استعمال کی جاتی رہی ہے ، جس میں کھانسی بھی شامل ہے۔ کالی مرچ کے ساتھ ہلدی کا استعمال کریں۔ گرم ہلدی والی چائے یا ہلدی کا دودھ پئیں۔ مٹھاس کے لئے ایک چٹکی کالی مرچ اور کچھ شہد شامل کریں۔"
    };
    int images[] = {R.drawable.remedy25,R.drawable.remedy8,R.drawable.remedy26};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy8);
        listView = (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();


        // now set item click on list view
        // so item click is done now check list view
    }
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String[] title, String[] description, int[] imgs) {
            super(c, R.layout.row_home_remedies, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_home_remedies, parent, false);
            ImageView images =(ImageView) row.findViewById(R.id.image);
            TextView myTitle = (TextView) row.findViewById(R.id.textView1);
            TextView myDescription = (TextView) row.findViewById(R.id.textView2);
            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
        public boolean isEnabled(int position) {

            return false;
        }


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
                Intent i = new Intent(Remedy8.this, LoginActivity.class);
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

}

