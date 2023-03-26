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


public class Medicine36 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"EYEPAT","HISTAZOLIN","BETNESOL - N"};

    String mDescription[] = {"This medication is an antihistamine used to treat itching and redness in the eyes due to allergies. This medication is not recommended for the treatment of eye irritation due to wearing contact lenses.\n\n"+ "یہ دوا ایک اینٹی ہسٹامائن ہے جو الرجی کی وجہ سے آنکھوں میں خارش اور لالی کے علاج کے لیے استعمال ہوتی ہے۔ کانٹیکٹ لینس پہننے کی وجہ سے آنکھوں کی جلن کے علاج کے لیے اس دوا کی سفارش نہیں کی جاتی ہے۔",
            "Histazolin is highly effective combination to control symptoms of burning, itching, tearing & photophobia. It is particularly suitable in eye allergic conditions like hay-fever conjunctivitis, acute and chronic allergic conjunctivitis, vernal keratoconjunctivitis, giant papillary conjunctivitis.\n\n"+"ہسٹازولن جلن، خارش، پھاڑ پھاڑ اور فوٹو فوبیا کی علامات کو کنٹرول کرنے کے لیے انتہائی موثر مرکب ہے۔ یہ آنکھوں کی الرجی والی حالتوں میں خاص طور پر موزوں ہے جیسے گھاس بخار آشوب چشم، شدید اور دائمی الرجک آشوب چشم، ورنل کیراٹوکونجیکٹیوائٹس، جائنٹ پیپلیری آشوب چشم۔",
            "Betnesol-N ear drop is used to treat outer ear, nose and eye infections caused by bacteria.\n\n"+
                    "یہ کان کا قطرہ بیکٹیریا کی وجہ سے ہونے والے بیرونی کان، ناک اور آنکھوں کے انفیکشن کے علاج کے لیے استعمال ہوتا ہے۔"};

    int images[] = {R.drawable.eyepat,R.drawable.histazolin,R.drawable.betnesol};

    String mDosage[] = {"Apply this medication in the affected eye as directed by the product package or by your doctor, usually once or twice a day.\n\n"+"اس دوا کو متاثرہ آنکھ میں لگائیں جیسا کہ پروڈکٹ پیکج یا آپ کے ڈاکٹر کی ہدایت ہے، عام طور پر دن میں ایک یا دو بار۔" ,
            "Apply this medication in the affected eye as directed by the product package or by your doctor, usually once or twice a day.\n" +
            "\n"+"اس دوا کو متاثرہ آنکھ میں لگائیں جیسا کہ پروڈکٹ پیکج یا آپ کے ڈاکٹر کی ہدایت ہے، عام طور پر دن میں ایک یا دو بار۔\n" ,
            "1 to 2 drops every 3-4 hourly.\n" +
            "\n" + "ہر 3-4 گھنٹے میں 1 سے 2 قطرے۔\n"};

    String mSideEffects[] = {"Headache, blurred vision, burning, stinging, redness, dryness of the eye, eyelid swelling.\n\n"+"سر درد، نظر کا دھندلا پن، جلن، بخل، لالی، آنکھ کا خشک ہونا، پلکوں کا سوجن۔",
            "Headache, blurred vision, burning, stinging, redness, dryness of the eye, eyelid swelling.\n" +
                    "\n" +
                    "سر درد، نظر کا دھندلا پن، جلن، بخل، لالی، آنکھ کا خشک ہونا، پلکوں کا سوجن۔\n",
            "Common side effects are burning sensation or itching.\n" +
                    "\n" +
                    "عام ضمنی اثرات جلن یا خارش ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine36);
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
                Intent i = new Intent(Medicine36.this, LoginActivity.class);
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

