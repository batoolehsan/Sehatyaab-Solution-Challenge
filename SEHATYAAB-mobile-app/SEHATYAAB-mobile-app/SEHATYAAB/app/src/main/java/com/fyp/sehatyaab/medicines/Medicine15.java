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


public class Medicine15 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"HYDROZOLE","BETADERM - N","DERMOSPORIN"};

    String mDescription[] = {"Hydrozole Cream is used on the skin to relieve the redness, swelling, itching and discomfort of many skin problems. This includes conditions such as fungal infected dermatitis, intertrigo and Candida nappy rash.\n\n"+ "اس کا استعمال جلد پر لالی، سوجن، خارش اور جلد کے بہت سے مسائل کی تکلیف کو دور کرنے کے لیے کیا جاتا ہے۔ اس میں فنگل سے متاثرہ ڈرمیٹیٹائٹس، انٹرٹریگو اور کینڈیڈا نیپی ریش جیسے حالات شامل ہیں۔",
            "Betaderm-N treats various skin conditions like rash, dermatitis, and allergies. It also reduces swelling and itching. It must be used on the skin. Avoid using it on the groin, face, or underarms as it causes severe infection.\n\n"+"یہ جلد کی مختلف حالتوں جیسے خارش، جلد کی سوزش اور الرجی کا علاج کرتا ہے۔ یہ سوجن اور خارش کو بھی کم کرتا ہے۔ اسے جلد پر استعمال کرنا چاہیے۔ اسے کمر، چہرے یا انڈر آرمز پر استعمال کرنے سے گریز کریں کیونکہ یہ شدید انفیکشن کا سبب بنتا ہے۔",
            "Dermosporin cream is used to treat a skin condition known as pityriasis (tinea versicolor), a fungal infection that causes a lightening or darkening of the skin of the neck, chest, arms, or legs.\n\n"+
                    "اس کا استعمال جلد کی ایسی حالت کے علاج کے لیے کیا جاتا ہے جسے پیٹیریاسس (ٹینیا ورسکلر) کہا جاتا ہے، ایک فنگل انفیکشن جو گردن، سینے، بازوؤں یا ٹانگوں کی جلد کو ہلکا یا سیاہ کرنے کا سبب بنتا ہے۔"};

    int images[] = {R.drawable.hydrozole,R.drawable.betaderm,R.drawable.dermosporin};

    String mDosage[] = {"Hydrozole Cream should be applied to the affected area of skin, once or twice a day.\n\n"+"اسے دن میں ایک یا دو بار جلد کے متاثرہ حصے پر لگانا چاہیے۔" ,
            "Betaderm-N cream should be applied to the affected area(s) of skin, once or twice a day.\n" +
            "\n"+"اسے دن میں ایک یا دو بار جلد کے متاثرہ حصے پر لگانا چاہیے۔\n" ,
            "Dermosporin cream should be applied to the affected area(s) of skin, once or twice a day..\n" +
            "\n" + "اسے دن میں ایک یا دو بار جلد کے متاثرہ حصے پر لگانا چاہیے۔\n"};

    String mSideEffects[] = {"It may cause burning, itching, and redness at the applying area.\n\n"+"عام ضمنی اثرات جلن یا خارش ہیں۔",
            "The most commonly reported side effects were pruritus, burning, itching, irritation.\n" +
                    "\n" +
                    "سب سے زیادہ عام طور پر رپورٹ ہونے والے ضمنی اثرات خارش، جلن، خارش، جلن تھے۔\n",
            "The side effects of this medication include Local mild burning, irritation, hypersensitivity reaction (allergic reaction), or erythema (redness of the skin).\n" +
                    "\n" +
                    "اس دوا کے ضمنی اثرات میں ہلکا جلنا، انتہائی حساسیت کا ردعمل شامل ہے۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine15);
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
                Intent i = new Intent(Medicine15.this, LoginActivity.class);
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

