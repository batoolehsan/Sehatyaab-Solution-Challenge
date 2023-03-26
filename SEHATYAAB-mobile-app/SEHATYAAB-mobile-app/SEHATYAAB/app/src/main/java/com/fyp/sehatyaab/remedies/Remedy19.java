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


public class Remedy19 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. VINEGAR","2. BAKING SODA","3. NEEM","4. TEA TREE OIL"};

    String mDescription[] = {"Vinegar helps in treating itchy, dry skin and also helps to kill dandruff-causing fungus and bacteria. The acidic content of vinegar is supremely beneficial to drastically reduce flaking. Apply an equal quantity mixture of white vinegar with water on the scalp skin about half an hour before a head wash.\n\n" +
            "سرکہ خارش، خشک جلد کے علاج میں مدد کرتا ہے اور خشکی پیدا کرنے والے فنگس اور بیکٹیریا کو مارنے میں بھی مدد کرتا ہے۔ سرکہ کا تیزابی مواد فلکنگ کو کافی حد تک کم کرنے کے لیے انتہائی فائدہ مند ہے۔ سر دھونے سے تقریباً آدھا گھنٹہ پہلے سفید سرکہ کے برابر مقدار میں مکسچر کو سر کی جلد پر پانی کے ساتھ لگائیں۔" ,
            "You can simply add some baking soda to your shampoo while washing hair to derive its benefits. Baking soda, along with its exfoliation and anti-fungal properties, also soothes the scalp and reduces redness and itching.\n\n" +
                    "اس کے فوائد حاصل کرنے کے لیے آپ بالوں کو دھوتے وقت اپنے شیمپو میں کچھ بیکنگ سوڈا شامل کر سکتے ہیں۔ بیکنگ سوڈا اپنی ایکسفولیئشن اور اینٹی فنگل خصوصیات کے ساتھ سر کی جلد کو بھی سکون بخشتا ہے اور سرخی اور خارش کو کم کرتا ہے۔",
            "All of us are aware of the role that neem extract plays in almost all skin medications because of its antibacterial and antifungal qualities. Since dandruff can mostly be attributed to fungal colonization of scalp, it is only right to turn to this age-old remedy for skin ailments. Natural is always the best way to go. Use a very diluted version of neem (neem boiled in water) for the scalp as concentrated versions may only irritate the skin further.\n\n" +
                    "ہم سب اس کردار سے واقف ہیں جو نیم کا عرق اپنی اینٹی بیکٹیریل اور اینٹی فنگل خصوصیات کی وجہ سے جلد کی تقریباً تمام ادویات میں ادا کرتا ہے۔ چونکہ خشکی کو زیادہ تر کھوپڑی کے فنگل کالونائزیشن سے منسوب کیا جا سکتا ہے، اس لیے جلد کی بیماریوں کے لیے اس قدیم علاج کی طرف رجوع کرنا ہی درست ہے۔ قدرتی ہمیشہ جانے کا بہترین طریقہ ہے۔ کھوپڑی کے لیے نیم (پانی میں ابلا ہوا نیم) کا ایک بہت ہی پتلا ورژن استعمال کریں کیونکہ مرتکز ورژن صرف جلد کو مزید خارش کر سکتے ہیں۔",
            " All anti-acne and anti-fungal medications boast of tea tree oil due to its exceptional power to fight fungal and bacterial infections. Add a drop or two of tea tree oil to your shampoo and wash normally and notice the results sitting in the comfort of your home!.\n\n" +
                    "تمام اینٹی ایکنی اور اینٹی فنگل ادویات ٹیٹری آئل پر فخر کرتی ہیں کیونکہ فنگل اور بیکٹیریل انفیکشن سے لڑنے کی اس کی غیر معمولی طاقت ہے۔ اپنے شیمپو میں ایک یا دو قطرے ٹیٹری آئل شامل کریں، اسے اپنی کھوپڑی پر لگائیں اور دھو لیں۔"};
    int images[] = {R.drawable.remedy55,R.drawable.remedy35,R.drawable.remedy57,R.drawable.remedy21};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy19);
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
                Intent i = new Intent(Remedy19.this, LoginActivity.class);
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

