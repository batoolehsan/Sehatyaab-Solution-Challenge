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


public class Remedy13 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. GRATED POTATO","2. MASSAGE","3. SOAKED TEA BAGS","4. CUCUMBER"};

    String mDescription[] = {"Raw grated potato or even cold raw potato slices have proven to have lightening effects on the skin. People have used this ingredients many a times with positive results to lighten dark circles. Try it yourself and see how it works for you.\n\n" +
            "کچے کٹے ہوئے آلو یا یہاں تک کہ کچے آلو کے ٹھنڈے ٹکڑے بھی جلد پر ہلکے اثرات مرتب کرتے ہیں۔ سیاہ حلقوں کو ہلکا کرنے کے لیے لوگوں نے کئی بار اس اجزاء کو مثبت نتائج کے ساتھ استعمال کیا ہے۔ اسے خود آزمائیں اور دیکھیں کہ یہ آپ کے لیے کیسے کام کرتا ہے۔" ,
            "Mix coconut oil and almond oil and massage gently in circular motion around the eyes. Leave on for about an hour. This should be done daily.\n\n" +
                    "ناریل کا تیل اور بادام کا تیل ملا کر آنکھوں کے گرد سرکلر موشن میں ہلکے سے مساج کریں۔ تقریباً ایک گھنٹے تک لگا رہنے دیں۔ یہ روزانہ کیا جانا چاہئے۔",
            "This is another effective home remedy for dark circles. Caffeine and other antioxidants in tea can stimulate blood circulation and reduce retention of liquid in the skin. You can soak two black or green tea bags in hot water for 5 minutes, then chill them in a refrigerator for 15 to 20 minutes. Once cold, apply them under your eyes for 15 to 20 minutes for effective results.\n\n" +
                    "سیاہ حلقوں کے لیے یہ ایک اور موثر گھریلو علاج ہے۔ چائے میں موجود کیفین اور دیگر اینٹی آکسیڈنٹس خون کی گردش کو تیز کر سکتے ہیں اور جلد میں مائع کی برقراری کو کم کر سکتے ہیں۔ آپ دو سیاہ یا سبز چائے کے تھیلوں کو گرم پانی میں 5 منٹ تک بھگو سکتے ہیں، پھر انہیں 15 سے 20 منٹ تک فریج میں ٹھنڈا کر کے رکھ سکتے ہیں۔ ٹھنڈا ہونے کے بعد، مؤثر نتائج کے لیے انہیں 15 سے 20 منٹ تک اپنی آنکھوں کے نیچے لگائیں۔","Cucumbers are naturally chilling and hydrating in nature. They can improve blood circulation in your under-eye area and reduce dark circles. Take two slices of cucumber and place them on your eye lids. Let it stay for 15 to 20 minutes. Wash with water. Repeat this every day for effective results.\n\n" +
            "کھیرے قدرتی طور پر ٹھنڈا اور نمی بخش ہوتے ہیں۔ وہ آپ کی آنکھوں کے نیچے والے حصے میں خون کی گردش کو بہتر بنا سکتے ہیں اور سیاہ حلقوں کو کم کر سکتے ہیں۔ کھیرے کے دو ٹکڑے لیں اور آنکھوں پر رکھیں۔ اسے 15 سے 20 منٹ تک لگا رہنے دیں۔ پانی سے دھو لیں۔ مؤثر نتائج کے لیے اسے ہر روز دہرائیں۔"};
    int images[] = {R.drawable.remedy41,R.drawable.remedy6,R.drawable.remedy42,R.drawable.remedy43};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy13);
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
                Intent i = new Intent(Remedy13.this, LoginActivity.class);
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

