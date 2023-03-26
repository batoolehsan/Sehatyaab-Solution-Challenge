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


public class Medicine38 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"HERPEZOSTIN","CONTRACTUBEX","POLYFAX"};

    String mDescription[] = {"Herpezostin is an effective homeopathic medicine for skin disorders like chickenpox. It is designed to cure herpes zoster i.e. a viral infection that causes painful blisters on the skin.\n\n"+ "یہ جلد کے امراض جیسے چکن پاکس کے لیے ایک موثر ہومیوپیتھک دوا ہے۔ اسے ہرپس زسٹر یعنی ایک وائرل انفیکشن کے علاج کے لیے ڈیزائن کیا گیا ہے جو جلد پر تکلیف دہ چھالوں کا سبب بنتا ہے۔",
            "Contractubex Gel is an anti-scar medicine used to reduce the appearance of scars after surgery, burns, or wounds. It reduces redness, swelling, and pain around the scars.\n\n"+"یہ ایک اینٹی اسکار دوا ہے جو سرجری، جلنے یا زخموں کے بعد داغوں کی ظاہری شکل کو کم کرنے کے لیے استعمال ہوتی ہے۔ یہ نشانات کے ارد گرد لالی، سوجن اور درد کو کم کرتا ہے۔",
            "This combination product is used to treat minor wounds (e.g., cuts, scrapes, burns) and to help prevent or treat mild skin infections.\n\n"+
                    "یہ مرکب پروڈکٹ معمولی زخموں کے علاج کے لیے استعمال کیا جاتا ہے (مثلاً، کٹے، کھرچنے، جلنے) اور جلد کے ہلکے انفیکشن کو روکنے یا علاج کرنے میں مدد کرنے کے لیے۔"};

    int images[] = {R.drawable.herpezostin,R.drawable.contractubex,R.drawable.polyfax};

    String mDosage[] = {"In acute cases give initially 1 to 2 hourly 10 drops in some water. Once improvement becomes apparent reduce dosage to 2 to 3 hourly 10-15 drops.\n\n"+"شدید حالت میں ابتدائی طور پر 1 سے 2 گھنٹے کے حساب سے 10 قطرے پانی میں ڈالیں۔ ایک بار جب بہتری ظاہر ہو جائے تو خوراک کو 2 سے 3 گھنٹے میں 10-15 قطروں تک کم کریں۔" ,
            "Gently massage into the skin or scar tissue several times daily until the gel has been completely absorbed.\n" +
            "\n"+"روزانہ کئی بار جلد یا داغ کے ٹشو میں آہستہ سے مساج کریں جب تک کہ جیل مکمل طور پر جذب نہ ہوجائے۔\n" ,
            "Polyfax ointment must be used twice a day on the affected areas.\n" +
            "\n" + "پولی فیکس مرہم کو متاثرہ جگہوں پر دن میں دو بار استعمال کرنا چاہیے۔\n"};

    String mSideEffects[] = {"In very rare cases skin reactions or gastrointestinal complaints may occur after use. In this case discontinue use of medicine.\n\n"+"بہت کم معاملات میں استعمال کے بعد جلد کے رد عمل یا معدے کی شکایات ہو سکتی ہیں۔ اس صورت میں دوا کا استعمال بند کر دیں۔",
            "Some patients may experience a mild rash or itching after applying the gel.\n" +
                    "\n" +
                    "کچھ مریضوں کو جیل لگانے کے بعد ہلکے دانے یا خارش ہو سکتی ہے۔\n",
            "Common side effects include are irritation of the skin may occur.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں جلد کی جلن ہوسکتی ہے۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine38);
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
                Intent i = new Intent(Medicine38.this, LoginActivity.class);
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

