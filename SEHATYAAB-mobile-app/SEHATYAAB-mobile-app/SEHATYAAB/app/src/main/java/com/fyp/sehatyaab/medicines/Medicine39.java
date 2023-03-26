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


public class Medicine39 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"HEPA-MERZ","HEPASAN","ICTERENE"};

    String mDescription[] = {"It is commonly used for the diagnosis or treatment of liver cirrhosis , hepatitis, jaundice.\n\n"+ "یہ عام طور پر جگر کی سروسس، ہیپاٹائٹس، یرقان کی تشخیص یا علاج کے لیے استعمال ہوتا ہے۔",
            "Hepasan Forte contains natural substances that help maintain normal liver health. Choline helps maintain normal lipid and homocysteine metabolism and helps maintain normal liver function. Sea buckthorn and artichoke extracts support normal liver health, protect liver cells and promote bile production.\n\n"+"اس میں قدرتی مادے ہوتے ہیں جو جگر کی عام صحت کو برقرار رکھنے میں مدد کرتے ہیں۔ چولین عام لپڈ اور ہومو سسٹین میٹابولزم کو برقرار رکھنے میں مدد کرتا ہے اور جگر کے معمول کے کام کو برقرار رکھنے میں مدد کرتا ہے۔ سی بکتھورن اور آرٹچوک کے عرق جگر کی عام صحت کو سہارا دیتے ہیں، جگر کے خلیوں کی حفاظت کرتے ہیں اور پت کی پیداوار کو فروغ دیتے ہیں۔",
            "lcterene has a therapeutic value in the treatment of hepatic and biliary disorders, especially jaundice.\n\n"+
                    "یہ جگر اور بلاری کی خرابیوں، خاص طور پر یرقان کے علاج میں علاج کی اہمیت رکھتا ہے۔"};

    int images[] = {R.drawable.hepamerz,R.drawable.hepasan,R.drawable.icterene};

    String mDosage[] = {"Take this medication 1 tablespoon twice daily.\n\n"+"اس دوا کو 1 چمچ دن میں دو بار لیں۔" ,
            "Take this medication half to 1 tablespoon twice a day.\n" +
            "\n"+"اس دوا کو دن میں دو بار آدھا سے ایک چمچ لیں۔\n" ,
            "Take 1 tablet of this medication three times a day for three days are enough to bring about therapeutic results.\n" +
            "\n" + "اس دوا کی 1 گولی دن میں تین بار تین دن تک لینا علاج کے نتائج لانے کے لیے کافی ہے۔\n"};

    String mSideEffects[] = {"Possible side effects may include nausea, vomiting, gas, stomach pain and diarrhea.\n\n"+"ممکنہ ضمنی اثرات میں متلی، الٹی، گیس، پیٹ میں درد اور اسہال شامل ہو سکتے ہیں۔",
            "This medicine's most common side effects are abdominal pain, diarrhea, hair loss, itching, nausea, and rash.\n" +
                    "\n" +
                    "اس دوا کے سب سے عام ضمنی اثرات پیٹ میں درد، اسہال، بالوں کا گرنا، کھجلی، متلی اور دھبے ہیں۔\n",
            "No serious side effects have been reported with the use of this medication.\n" +
                    "\n" +
                    "اس دوا کے استعمال سے کوئی سنگین ضمنی اثرات رپورٹ نہیں ہوئے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine39);
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
                Intent i = new Intent(Medicine39.this, LoginActivity.class);
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

