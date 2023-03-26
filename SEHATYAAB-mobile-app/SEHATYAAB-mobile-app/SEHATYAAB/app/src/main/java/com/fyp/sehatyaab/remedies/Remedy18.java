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


public class Remedy18 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. CANDY OR SUGAR","2. HONEY AND CASHEW","3. TOMATOES","4. APPLE","5. BARLEY","6. SUNFLOWER SEEDS"};

    String mDescription[] = {"When you notice the symptoms of low blood sugar, you should consume sugar and candy immediately. That can increase the blood sugar level in your body. Sugar is digested easily, and it is the primary remedy for low blood sugar level.\n\n" +
            "جب آپ کو کم بلڈ شوگر کی علامات نظر آئیں تو آپ کو فوراً چینی اور کینڈی کا استعمال کرنا چاہیے۔ یہ آپ کے جسم میں بلڈ شوگر کی سطح کو بڑھا سکتا ہے۔ شوگر آسانی سے ہضم ہو جاتی ہے، اور یہ بلڈ شوگر کی کم سطح کا بنیادی علاج ہے۔" ,
            "Both honey and cashew have natural sugars. Therefore, it helps to make the blood sugar level turn to normal. It is a reason why we would like to introduce honey and cashew in this article about home remedies for low blood sugar level treatment related to diabetes and stress. You just need to mix one teaspoon of honey with three teaspoons of cashew powder and add water into this mixture. After that, you can consume this mixture before bedtime daily.\n\n" +
                    "شہد اور کاجو دونوں میں قدرتی شکر ہوتی ہے۔ اس لیے یہ بلڈ شوگر لیول کو نارمل کرنے میں مدد کرتا ہے۔ یہی وجہ ہے کہ ہم اس مضمون میں شہد اور کاجو کو ذیابیطس اور تناؤ سے متعلق کم بلڈ شوگر لیول کے گھریلو علاج کے بارے میں بتانا چاہتے ہیں۔ آپ کو صرف ایک چائے کا چمچ شہد میں تین چمچ کاجو پاؤڈر ملا کر اس میں پانی ملانا ہے۔ اس کے بعد آپ اس مرکب کو روزانہ سونے سے پہلے کھا سکتے ہیں۔",
            "Tomatoes also provide your body sugar and keep low blood sugar at bay. Therefore, tomatoes are one of the amazing natural home remedies for low blood sugar level treatment you should not ignore in this article. It is recommended for eating four to five tomatoes daily.\n\n" +
                    "ٹماٹر آپ کے جسم کو شوگر بھی فراہم کرتا ہے اور بلڈ شوگر کو کم رکھتا ہے۔ لہذا، ٹماٹر کم بلڈ شوگر لیول کے علاج کے لیے ایک حیرت انگیز قدرتی گھریلو علاج ہے جسے آپ کو اس مضمون میں نظر انداز نہیں کرنا چاہیے۔ روزانہ چار سے پانچ ٹماٹر کھانا ضروری ہے۔","Apple is a great source of fiber and has great sugar content. It is a reason why apple is one of the amazing home remedies for low blood sugar level treatment. Eating apple can help regulate the blood sugar levels and keep them in steady condition. Furthermore, much scientific evidence showed that eating apples on a regular basis is good for your digestion. Apple also decreases the risk of metabolic syndrome, diabetes, and cardiovascular disease. If you want to look for the natural remedies for high blood pressure and overweight, you should not ignore apple..\n\n" +
            "سیب فائبر کا ایک بڑا ذریعہ ہے اور اس میں چینی کی مقدار بہت زیادہ ہے۔ یہی وجہ ہے کہ سیب کم بلڈ شوگر لیول کے علاج کے لیے حیرت انگیز گھریلو علاج میں سے ایک ہے۔ سیب کھانے سے خون میں شوگر کی سطح کو کنٹرول کرنے اور اسے مستحکم حالت میں رکھنے میں مدد مل سکتی ہے۔ مزید برآں، بہت سارے سائنسی شواہد سے پتہ چلتا ہے کہ باقاعدگی سے سیب کھانا آپ کے ہاضمے کے لیے اچھا ہے۔ سیب میٹابولک سنڈروم، ذیابیطس اور قلبی امراض کے خطرے کو بھی کم کرتا ہے۔ اگر آپ ہائی بلڈ پریشر اور زیادہ وزن کا قدرتی علاج تلاش کرنا چاہتے ہیں تو آپ کو سیب کو نظر انداز نہیں کرنا چاہیے۔","Barley is a recommended food for type 2 diabetes or patients with low blood sugar level. Therefore, barley should be included in a list of amazing natural home remedies for low blood sugar level treatment. Barley is loaded with essential minerals, vitamins, and dietary fibers. Furthermore, the magnesium and beta-glucan present in barley help control the blood’s glucose absorption.\n\n" +
            "لو بلڈ شوگر لیول والے مریضوں کے لیے جو ایک تجویز کردہ خوراک ہے۔ لہٰذا، جو کو بلڈ شوگر کی کم سطح کے علاج کے لیے حیرت انگیز قدرتی گھریلو علاج کی فہرست میں شامل کیا جانا چاہیے۔ جو ضروری معدنیات، وٹامنز اور غذائی ریشوں سے بھری ہوئی ہے۔ جو میں موجود میگنیشیم اور بیٹا گلوکن خون میں گلوکوز کے جذب کو کنٹرول کرنے میں مدد کرتے ہیں۔","Sunflower seeds are loaded with polyphenols such as quinic acid, chlorogenic acid, and caffeic acid which are responsible for reducing the destructive oxidants from the liver and pancreas. Furthermore, chlorogenic acid can control the blood sugar levels in your body by promoting the glycogen synthesis. Therefore, in this article about home remedies for low blood sugar level related to diabetes and stress, we would like to mention sunflower seeds."+"To increase the blood sugar levels, you can consume sunflower seed raw or add powdered sunflower seeds in a glass of warm water and then drink it.\n\n"+
    "سورج مکھی کے بیج پولی فینول جیسے کوئنک ایسڈ، کلوروجینک ایسڈ، اور کیفیک ایسڈ سے بھرے ہوتے ہیں جو جگر اور لبلبے سے تباہ کن آکسیڈینٹ کو کم کرنے کے ذمہ دار ہیں۔ مزید برآں، کلوروجینک ایسڈ گلائکوجن کی ترکیب کو فروغ دے کر آپ کے جسم میں خون میں شکر کی سطح کو کنٹرول کر سکتا ہے۔ لہذا، ذیابیطس اور تناؤ سے متعلق کم بلڈ شوگر کی سطح کے گھریلو علاج کے بارے میں اس مضمون میں، ہم سورج مکھی کے بیجوں کا ذکر کرنا چاہیں گے۔ بلڈ شوگر کی سطح بڑھانے کے لیے آپ سورج مکھی کے بیجوں کو کچا کھا سکتے ہیں یا ایک گلاس گرم پانی میں سورج مکھی کے بیجوں کا پاؤڈر ملا کر پی سکتے ہیں"};
    int images[] = {R.drawable.remedy50,R.drawable.remedy51,R.drawable.remedy52,R.drawable.remedy53,R.drawable.remedy54,R.drawable.remedy56};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy18);
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
                Intent i = new Intent(Remedy18.this, LoginActivity.class);
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

