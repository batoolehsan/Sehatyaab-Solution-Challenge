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


public class Medicine24 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"OTOSPORIN","BETNESOL - N","CIPOTIC"};

    String mDescription[] = {"Otosporin ear drop is used to treat outer ear infections caused by bacteria (also known as swimmer's ear).\n\n"+ "یہ کان کا قطرہ بیکٹیریا (جسے تیراک کان بھی کہا جاتا ہے) کی وجہ سے ہونے والے بیرونی کان کے انفیکشن کے علاج کے لیے استعمال کیا جاتا ہے۔",
            "Betnesol-N ear drop is used to treat outer ear, nose and eye infections caused by bacteria.\n\n"+"یہ کان کا قطرہ بیکٹیریا کی وجہ سے ہونے والے بیرونی کان، ناک اور آنکھوں کے انفیکشن کے علاج کے لیے استعمال ہوتا ہے۔",
            "Cipotic Drops are used to treat the symptoms of ear infection.\n"+
                    "یہ کان کے انفیکشن کی علامات کے علاج کے لیے استعمال ہوتا ہے۔"};

    int images[] = {R.drawable.otosporin,R.drawable.betnesol,R.drawable.cipotic};

    String mDosage[] = {"1 to 2 drops every 3-4 hourly.\n\n"+"ہر 3-4 گھنٹے میں 1 سے 2 قطرے۔" ,

            "1 to 2 drops every 3-4 hourly.\n\n"+"ہر 3-4 گھنٹے میں 1 سے 2 قطرے۔" ,

            "1 to 2 drops every 3-4 hourly.\n\n"+"ہر 3-4 گھنٹے میں 1 سے 2 قطرے۔" };

    String mSideEffects[] = {"Common side effects are irritation, increased intraocular pressure, glaucoma, posterior subcapsular cataract formation, delayed wound healing, secondary infections.\n\n"+"عام ضمنی اثرات میں جلن، انٹراوکولر پریشر میں اضافہ، گلوکوما، پوسٹرئیر سب کیپسولر موتیابند کی تشکیل، زخموں کا ٹھیک ہونے میں تاخیر، ثانوی انفیکشنز ہیں۔",
            "Common side effects are burning sensation or itching.\n" +
                    "\n" +
                    "عام ضمنی اثرات جلن یا خارش ہیں۔\n",
            "Side effects can include hypersensitivity ,allergic reactions ,ear pain, ,ear discomfort, ear residue ,irritability, headache.\n" +
                    "\n" +
                    "ضمنی اثرات میں انتہائی حساسیت، الرجک رد عمل، کان میں درد،  کان میں تکلیف، کان کی باقیات، چڑچڑاپن، سر درد شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine24);
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
                Intent i = new Intent(Medicine24.this, LoginActivity.class);
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

