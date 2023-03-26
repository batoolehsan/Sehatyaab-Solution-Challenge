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


public class Remedy11 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. BAKING SODA AND WATER","2. AT HOME EXFOLIATION","3. KASTURI TUMERIC","4. EGG WHITE"};

    String mDescription[] = {"Baking soda is such a common kitchen item that you might not realize you can eliminate blackheads with it. Doctors says baking soda helps to neutralize any pH imbalance your skin may have, as well as work as an exfoliant to remove dirt, oil and dead skin cells. To use this on your blackheads, mix two tablespoons of baking soda and two tablespoons of water together to form a paste. Massage the paste onto your face, rinse off with warm water, and then be sure to moisturize afterward. This mixture could dry your skin, so don’t use it more than two or three days a week.\n\n" +
            "بیکنگ سوڈا باورچی خانے کی ایک ایسی عام چیز ہے جس کے بارے میں آپ کو اندازہ نہیں ہوگا کہ آپ اس سے بلیک ہیڈز کو ختم کر سکتے ہیں۔ ڈاکٹروں کا کہنا ہے کہ بیکنگ سوڈا آپ کی جلد کے کسی بھی پی ایچ کے عدم توازن کو بے اثر کرنے میں مدد کرتا ہے، اور ساتھ ہی گندگی، تیل اور جلد کے مردہ خلیوں کو ہٹانے کے لیے ایکسفولینٹ کا کام کرتا ہے۔ اسے اپنے بلیک ہیڈز پر استعمال کرنے کے لیے دو کھانے کے چمچ بیکنگ سوڈا اور دو کھانے کے چمچ پانی کو ملا کر پیسٹ بنا لیں۔ پیسٹ کو اپنے چہرے پر مساج کریں، گرم پانی سے دھولیں، اور پھر بعد میں موئسچرائز کرنا یقینی بنائیں۔ یہ مرکب آپ کی جلد کو خشک کر سکتا ہے، اس لیے اسے ہفتے میں دو یا تین دن سے زیادہ استعمال نہ کریں۔" ,
            "Brown sugar, honey and lemon juice make up this exfoliation mixture that you can use on blackheads on your nose and chin. Mixing together one tablespoon of brown sugar, two tablespoons of lemon and one tablespoon of raw honey. When it’s mixed well, apply to your face in a circular motion, massaging it in for five minutes before rinsing it off and applying moisturizer.\n\n" +
                    "براؤن شوگر، شہد اور لیموں کا رس اس ایکسفولیئشن مکسچر کو بناتا ہے جسے آپ اپنی ناک اور ٹھوڑی پر بلیک ہیڈز پر استعمال کر سکتے ہیں۔ ایک کھانے کا چمچ براؤن شوگر، دو کھانے کے چمچ لیموں اور ایک کھانے کا چمچ شہد ملا لیں۔ جب یہ اچھی طرح مکس ہوجائے تو اپنے چہرے پر سرکلر موشن میں لگائیں، اسے دھونے اور موئسچرائزر لگانے سے پہلے پانچ منٹ تک اس پر مساج کریں۔",
            "Turmeric can be used to help remove blackheads due to its antibacterial, antifungal, and anti-inflammatory properties. It’s important to note that regular turmeric can stain skin, [but with] kasturi turmeric you avoid staining. To use, take one tablespoon of kasturi turmeric and mix with one tablespoon of water or coconut oil to form a paste, apply the paste to your face and let it sit for 10 to 15 minutes before rinsing it off.\n\n" +
                    "تیزابیت اور اس کی علامات جیسے تیزابیت، بدہضمی، متلی، ہلدی کو اینٹی بیکٹیریل، اینٹی فنگل اور اینٹی سوزش خصوصیات کی وجہ سے بلیک ہیڈز کو دور کرنے میں مدد کے لیے استعمال کیا جا سکتا ہے۔ یہ نوٹ کرنا ضروری ہے کہ باقاعدہ ہلدی جلد پر داغ ڈال سکتی ہے، لیکن کستوری ہلدی کے ساتھ آپ داغدار ہونے سے بچتے ہیں۔ استعمال کرنے کے لیے ایک کھانے کا چمچ کستوری ہلدی لیں اور ایک کھانے کا چمچ پانی یا ناریل کے تیل میں ملا کر پیسٹ بنائیں، اس پیسٹ کو اپنے چہرے پر لگائیں اور اسے دھونے سے پہلے 10 سے 15 منٹ تک لگا رہنے دیں۔","Egg whites contain nutrients that are great for your skin, and applied as a face mask, they can also tighten your pores (temporarily) and remove blackheads. This treatment will take up a little more time than most, but the nutrients the egg whites will give your skin are worth the time.\n\n"
+"1. Separate 1 to 2 eggs and whip egg whites until mixed together.\n"+"2. Rinse your face with clean water and dry.\n"+"3. Apply 1 layer egg whites to affected area or entire face and wait until dry.\n"+
            "4. Apply another layer and wait until dry – do this up to 5 times, but make sure each layer is dry before applying the next.\n"+
            "5. Wash the egg off and apply moisturizer.\n"+"6. Repeat as needed.\n\n"+"انڈے کی سفیدی میں ایسے غذائی اجزاء ہوتے ہیں جو آپ کی جلد کے لیے بہترین ہوتے ہیں، اور اسے چہرے کے ماسک کے طور پر لگایا جاتا ہے، یہ آپ کے چھیدوں کو (عارضی طور پر) سخت کر سکتے ہیں اور بلیک ہیڈز کو دور کر سکتے ہیں۔ اس علاج میں زیادہ تر کے مقابلے میں تھوڑا زیادہ وقت لگے گا، لیکن انڈے کی سفیدی آپ کی جلد کو جو غذائی اجزاء فراہم کرے گی۔"+"ایک سے دو انڈوں کو الگ کریں اور انڈے کی سفیدی کو اس وقت تک پھینٹیں جب تک کہ آپس میں نہ مل جائیں۔"+
    "اپنے چہرے کو صاف پانی سے دھو کر خشک کریں۔"+"متاثرہ جگہ یا پورے چہرے پر 1 پرت انڈے کی سفیدی لگائیں اور خشک ہونے تک انتظار کریں۔"+
    "ایک اور پرت لگائیں اور خشک ہونے تک انتظار کریں – یہ 5 بار تک کریں، لیکن اگلی پرت لگانے سے پہلے یقینی بنائیں کہ ہر پرت خشک ہے۔"+
    "انڈے کو دھو کر موئسچرائزر لگائیں۔"+"ضرورت کے مطابق دہرائیں۔"};
    int images[] = {R.drawable.remedy34,R.drawable.remedy36,R.drawable.remedy24,R.drawable.remedy37};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy11);
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
                Intent i = new Intent(Remedy11.this, LoginActivity.class);
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

