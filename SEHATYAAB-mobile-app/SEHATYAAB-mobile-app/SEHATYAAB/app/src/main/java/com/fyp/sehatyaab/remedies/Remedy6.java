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


public class Remedy6 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. DRINK WATER","2. GET ADEQUATE SLEEP","3. DRINK TEA OR COFFEE","4. B-COMPLEX VITAMINS"};

    String mDescription[] = {"To help avoid dehydration headaches, focus on drinking enough water throughout the day and eating water-rich foods like fruits and vegetables.\n\n" +
            "پانی کی کمی سے بچنے کے لیے دن بھر کافی مقدار میں پانی پئیں اور پھل وں اور سبزیوں جیسی پانی سے بھرپور غذائیں کھائیں۔" ,
            "Sleep deprivation can be detrimental to your health in many ways and may even cause headaches in some people.For maximum benefits, aim for the “sweet spot” of 7–9 hours of sleep per night.\n\n" +
                    "نیند کی کمی بہت سے طریقوں سے آپ کی صحت کے لئے نقصان دہ ہوسکتی ہے اور یہاں تک کہ کچھ لوگوں میں سر درد کا سبب بھی بن سکتی ہے. زیادہ سے زیادہ فوائد کے لئے کم از کم 7 سے 9 گھنٹے سونا ضروری ہے۔",
            "Sipping on beverages that contain caffeine, such as tea or coffee, may provide relief when you are experiencing a headache.\n\n" +
                    "۔جب آپ سر درد کا سامنا کر رہے ہوں تو کیفین پر مشتمل مشروبات ، جیسے چائے یا کافی ، راحت فراہم کرسکتے ہیں","B vitamins are a group of water-soluble micronutrients that play many important roles in your body. For example, they contribute to neurotransmitter synthesis and help turn food into energy. Some B vitamins may also have a protective effect against headaches.\n\n" +
            "بی وٹامن آپ کے جسم میں بہت سے اہم کردار ادا کرتا ہے. مثال کے طور پر ، وہ نیورو ٹرانسمیٹر ترکیب میں حصہ لیتے ہیں اور کھانے کو توانائی میں تبدیل کرنے میں مدد کرتے ہیں۔ کچھ بی وٹامنز میں سر درد کے خلاف حفاظتی اثرات بھی ہوتے ہیں۔"};
    int images[] = {R.drawable.remedy18,R.drawable.remedy62,R.drawable.remedy19,R.drawable.remedy20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy6);
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
                Intent i = new Intent(Remedy6.this, LoginActivity.class);
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

