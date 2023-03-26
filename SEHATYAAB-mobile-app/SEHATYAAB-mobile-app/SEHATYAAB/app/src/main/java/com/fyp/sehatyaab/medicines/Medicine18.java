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


public class Medicine18 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"ROLIP","LOWPLAT PLUS","PLAVIX"};

    String mDescription[] = {"It is used in the treatment of high cholesterol levels and to correct abnormal cholesterol. To slow down the progression of atherosclerosis, a condition of narrowing of blood vessels due to fat build-up. It is also known to reduce the risk of heart-related conditions such as stroke and heart attack.\n\n"+ "یہ ہائی کولیسٹرول کی سطح کے علاج اور غیر معمولی کولیسٹرول کو درست کرنے کے لیے استعمال کیا جاتا ہے۔ ایتھروسکلروسیس کی ترقی کو سست کرنے کے لیے، چربی جمع ہونے کی وجہ سے خون کی نالیوں کے تنگ ہونے کی حالت۔ یہ دل سے متعلق حالات جیسے اسٹروک اور ہارٹ اٹیک کے خطرے کو کم کرنے کے لیے بھی جانا جاتا ہے۔",
            "It is used to prevent heart attacks and strokes in persons with heart disease (recent heart attack), recent stroke, or blood circulation disease (peripheral vascular disease).\n\n"+"یہ دل کی بیماری (حالیہ دل کا دورہ)، حالیہ فالج، یا خون کی گردش کی بیماری (پردیی عروقی بیماری) والے افراد میں دل کے دورے اور فالج کو روکنے کے لیے استعمال کیا جاتا ہے۔",
            "It is used to prevent heart attacks and strokes in persons with heart disease (recent heart attack), recent stroke, or blood circulation disease (peripheral vascular disease).\n\n"+
                    "یہ دل کی بیماری (حالیہ دل کا دورہ)، حالیہ فالج، یا خون کی گردش کی بیماری (پردیی عروقی بیماری) والے افراد میں دل کے دورے اور فالج کو روکنے کے لیے استعمال کیا جاتا ہے۔"};

    int images[] = {R.drawable.rolip,R.drawable.lowplat,R.drawable.plavix};

    String mDosage[] = {"For adults the recommended dose is 1 tablet taken a day.\n\n"+"بالغوں کے لیے تجویز کردہ خوراک ایک دن میں 1 گولی ہے۔" ,
            "For adults the recommended dose is 1 to 3 tablets taken a day.\n" +
            "\n"+"بالغوں کے لیے تجویز کردہ خوراک ایک دن میں 1 سے 3 گولیاں ہیں۔\n" ,
            "For adults the recommended dose is 1 tablet taken a day.\n" +
            "\n" + "بالغوں کے لیے تجویز کردہ خوراک ایک دن میں 1 گولی ہے۔\n"};

    String mSideEffects[] = {"Common side effects include headache, muscle pain, abdominal. pain, weakness, nausea, dizziness, hypersensitivity reactions.\n\n"+"عام ضمنی اثرات میں سر درد، پٹھوں میں درد، پیٹ شامل ہیں۔ درد، کمزوری، متلی، چکر آنا، انتہائی حساسیت کے رد عمل۔",
            "Easy bleeding/bruising, stomach upset/pain, diarrhea, and constipation may occur. If any of these effects persist or worsen, tell your doctor or pharmacist promptly.\n" +
                    "\n" +
                    "آسانی سے خون بہنا/خوراک، پیٹ خراب/درد، اسہال، اور قبض ہو سکتا ہے۔ اگر ان میں سے کوئی بھی اثر برقرار رہتا ہے یا خراب ہوتا ہے، تو اپنے ڈاکٹر یا فارماسسٹ کو فوری طور پر بتائیں۔\n",
            "Easy bleeding/bruising, stomach upset/pain, diarrhea, and constipation may occur. If any of these effects persist or worsen, tell your doctor or pharmacist promptly.\n" +
                    "\n" +
                    "آسانی سے خون بہنا/خوراک، پیٹ خراب/درد، اسہال، اور قبض ہو سکتا ہے۔ اگر ان میں سے کوئی بھی اثر برقرار رہتا ہے یا خراب ہوتا ہے، تو اپنے ڈاکٹر یا فارماسسٹ کو فوری طور پر بتائیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine18);
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
                Intent i = new Intent(Medicine18.this, LoginActivity.class);
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

