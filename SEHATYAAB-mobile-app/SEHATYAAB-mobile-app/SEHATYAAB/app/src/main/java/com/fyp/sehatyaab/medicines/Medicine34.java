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


public class Medicine34 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"RASHNIL","SUDOCREM","HYDROZOLE"};

    String mDescription[] = {"Rasnil is used to associated treatment of Wounds, Dermatitis, Diaper Rash, Skin Irritation, Sunburn, Damaged skin, Dry or cracked skin, Facial rash, Heat rash.\n\n"+ "رسنیل کا استعمال زخموں، جلد کی سوزش، ڈایپر ریش، جلد کی جلن، سنبرن، خراب ہونے والی جلد، خشک یا پھٹی ہوئی جلد، چہرے کے دانے، ہیٹ ریش کے علاج کے لیے استعمال کیا جاتا ہے۔",
            "Sudocrem can be used to soothe nappy rash, eczema, wounds, sunburn, burn, acne.\n\n"+"سوڈوکرم کو نیپی ریش، ایگزیما، زخموں، سنبرن، جلن، مہاسوں کو دور کرنے کے لیے استعمال کیا جا سکتا ہے۔",
            "Hydrozole Cream is used on the skin to relieve the redness, swelling, itching and discomfort of many skin problems. This includes conditions such as fungal infected dermatitis, intertrigo and Candida nappy rash.\n\n"+
                    "اس کا استعمال جلد پر لالی، سوجن، خارش اور جلد کے بہت سے مسائل کی تکلیف کو دور کرنے کے لیے کیا جاتا ہے۔ اس میں فنگل سے متاثرہ ڈرمیٹیٹائٹس، انٹرٹریگو اور کینڈیڈا نیپی ریش جیسے حالات شامل ہیں۔"};

    int images[] = {R.drawable.rashnil,R.drawable.sudocrem,R.drawable.hydrozole};

    String mDosage[] = {"Apply this medication to the affected area of skin, once or twice a day.\n\n"+"اس دوا کو دن میں ایک یا دو بار جلد کے متاثرہ حصے پر لگائیں۔" ,
            "Apply this medication to the affected area of skin, once or twice a day.\n" +
            "\n"+"اس دوا کو دن میں ایک یا دو بار جلد کے متاثرہ حصے پر لگائیں۔\n" ,
            "Apply this medication to the affected area of skin, once or twice a day.\n" +
            "\n" + "اس دوا کو دن میں ایک یا دو بار جلد کے متاثرہ حصے پر لگائیں۔\n"};

    String mSideEffects[] = {"It usually don't have any side effects but sometimes dizziness or lightheadedness, sleepiness, decrease in urination may occur.\n\n"+"اس کے عام طور پر کوئی مضر اثرات نہیں ہوتے لیکن بعض اوقات چکر آنا یا ہلکا سر ہونا، نیند آنا، پیشاب میں کمی ہو سکتی ہے۔",
            "It may cause burning, itching, and redness at the applying area.\n" +
                    "\n" +
                    "عام ضمنی اثرات جلن یا خارش ہیں۔\n",
            "It may cause burning, itching, and redness at the applying area.\n" +
                    "\n" +
                    "عام ضمنی اثرات جلن یا خارش ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine34);
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
                Intent i = new Intent(Medicine34.this, LoginActivity.class);
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

