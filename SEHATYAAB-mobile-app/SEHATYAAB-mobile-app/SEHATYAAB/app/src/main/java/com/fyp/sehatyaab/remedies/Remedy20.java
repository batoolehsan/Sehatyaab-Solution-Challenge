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


public class Remedy20 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. OLIVE OIL & COCONUT OIL","2. BAKING SODA","3. ONION JUICE"};

    String mDescription[] = {"First, mix 2 tsp olive oil and 1 tsp coconut oil well in the bowl. Next, apply a small amount of the mixture to your scalp and hair. Then, gently massage your hair in 15 minutes. Be careful that you should not pull the hair while massaging because it may increase the amount of hair fall. After that, cover your head with the shower cap. Let the mixture stay on your hair overnight or at least 4 hours. In the next morning, rinse your hair off with shampoo and water.\n\n" +
            "سب سے پہلے پیالے میں 2 چمچ زیتون کا تیل اور 1 چمچ ناریل کا تیل اچھی طرح مکس کریں۔ اس کے بعد، مکسچر کی تھوڑی سی مقدار اپنے سر اور بالوں پر لگائیں۔ اس کے بعد، 15 منٹ میں اپنے بالوں کو آہستہ سے مساج کریں۔ ہوشیار رہیں کہ مالش کرتے وقت بال نہ کھینچیں کیونکہ اس سے بال گرنے کی مقدار بڑھ سکتی ہے۔ اس کے بعد اپنے سر کو شاور کیپ سے ڈھانپ لیں۔ اس مرکب کو اپنے بالوں پر رات بھر یا کم از کم 4 گھنٹے تک لگا رہنے دیں۔ اگلی صبح اپنے بالوں کو شیمپو اور پانی سے دھو لیں۔" ,
            "You can simply add some baking soda to your shampoo while washing hair to derive its benefits. Baking soda, along with its exfoliation and anti-fungal properties, also soothes the scalp and reduces redness and itching.\n\n" +
                    "اس کے فوائد حاصل کرنے کے لیے آپ بالوں کو دھوتے وقت اپنے شیمپو میں کچھ بیکنگ سوڈا شامل کر سکتے ہیں۔ بیکنگ سوڈا اپنی ایکسفولیئشن اور اینٹی فنگل خصوصیات کے ساتھ سر کی جلد کو بھی سکون بخشتا ہے اور سرخی اور خارش کو کم کرتا ہے۔",
            "First, chop the onion into fine pieces and then squeeze its juice out. Next, apply the juice on the affected scalp. Let it stay in 15-20 minutes. Afterward, rinse your hair off with shampoo and water. Repeat this remedy 2-3 a week till you can see the positive effects.\n\n" +
                    "سب سے پہلے پیاز کو باریک کاٹ لیں اور پھر اس کا رس نچوڑ لیں۔ اس کے بعد متاثرہ کھوپڑی پر رس لگائیں۔ اسے 15-20 منٹ تک رہنے دیں۔ اس کے بعد اپنے بالوں کو شیمپو اور پانی سے دھو لیں۔ اس علاج کو ہفتے میں 2-3 دہرائیں جب تک کہ آپ مثبت اثرات نہ دیکھ سکیں۔"
    };
    int images[] = {R.drawable.remedy31,R.drawable.remedy35,R.drawable.remedy59};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy20);
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
                Intent i = new Intent(Remedy20.this, LoginActivity.class);
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

