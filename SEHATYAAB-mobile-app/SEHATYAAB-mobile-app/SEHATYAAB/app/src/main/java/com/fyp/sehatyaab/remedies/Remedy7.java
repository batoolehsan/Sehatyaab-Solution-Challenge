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


public class Remedy7 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. ALOEVERA GEL & ROSE WATER","2. TEA TREE OIL","3. ICE","4. ASPIRIN MASK","5. TUMERIC MASK"};

    String mDescription[] = {"Mix 1 tablespoon aloe vera gel with 1-2 teaspoons of rose water in a bowl. Apply this to the affected area for 15 minutes. Rinse with warm water. Repeat this twice a week until the acne heals. You can also add raw honey, Lemon, Turmeric, or Tea Tree Oil to the aloe vera gel.\n\n" +
            "ایک پیالے میں 1-2 چائے کے چمچ عرق گلاب کے ساتھ ایک کھانے کا چمچ ایلو ویرا جیل مکس کریں۔اسے متاثرہ جگہ پر 15 منٹ کے لئے لگائیں۔ اپنے چہرے کو نیم گرم پانی سے دھولیں۔ اسے ہفتے میں دو بار دہرائیں جب تک کہ مُہاسے ٹھیک نہ ہوجائے۔ آپ ایلوویرا جیل میں شہد ، لیموں ، ہلدی ، یا ٹی ٹری کا تیل بھی شامل کرسکتے ہیں۔" ,
            "Pour a few drops the tea tree oil or solution onto a cotton bud, cotton pad, tissue, or your fingertip. Then gently dab it directly to your pimples.\n\n" +
                    "کوٹن بڈ یا اپنی انگلی کی نوک پر ٹی ٹری کے تیل کے چند قطرے شامل کریں۔ پھر آہستہ آہستہ اسے اپنے دانوں پر لگائیں۔",
            "Because ice is often effective in decreasing swelling, itchiness, pain, and redness, some natural healers suggest rubbing an ice cube on the cystic acne spot until the cold becomes uncomfortable. Some recommend doing this three times daily.\n\n" +
                    "برف سوجن، خارش، درد اور لالی کو کم کرنے میں مؤثر ہے، کچھ ڈاکٹر مُہاسے کی جگہ پر آئس کیوب رگڑنے کا مشورہ دیتے ہیں۔","Some proponents of home remedies suggest mixing a crushed aspirin tablet with water to make a paste and applying this to a cystic pimple. The belief is that this mask may help reduce pain and inflammation."+"It’s important to note that aspirin can cause irritation when applied directly to the skin. Also, if you have a known allergy to salicylates, you might want to avoid trying this remedy.\n\n" +
            "گھریلو علاج کے کچھ حامیوں کا مشورہ ہے کہ اسپرین کی گولی کو پانی کے ساتھ ملا کر پیسٹ بنائیں اور اسے دانے پر لگائیں۔یہ درد اور سوزش کو کم کرنے میں مدد کرتا ہے۔"+"اگر آپ کو سیلیسیلیٹ سے الرجی ہے تو اسپرین جلد پر جلن کا سبب بن سکتی ہے۔ لہذا آپ اس علاج کی کوشش نہ کریں۔","Mixing small amounts of water with turmeric powder creates a thick paste. The home remedy recommendation is to apply this paste directly to the cystic acne and leave it in place for about 45 minutes, before rinsing it off with water. Proponents suggest repeating this process twice per day."+"It’s important to use caution when applying turmeric directly to the skin, as it can cause some irritation.\n\n" +
            "ہلدی پاؤڈر کے ساتھ تھوڑی مقدار میں پانی ملانے سے گاڑھا پیسٹ بن جاتا ہے۔اس پیسٹ کو مہاسوں پر لگائیں اور تقریبا 45 منٹ کے لئے چھوڑ دیں۔ اس کے بعد اسے پانی سے دھولیں۔ اس عمل کو دن میں دو بار دہرائیں۔"+"ہلدی کو جلد پر لگاتے وقت احتیاط سے کام لینا ضروری ہے کیونکہ اس سے کچھ جلن پیدا ہوسکتی ہے"};
    int images[] = {R.drawable.remedy23,R.drawable.remedy21,R.drawable.remedy63,R.drawable.remedy22,R.drawable.remedy24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy7);
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
                Intent i = new Intent(Remedy7.this, LoginActivity.class);
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

