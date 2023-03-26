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


public class Remedy21 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. PEPPERMINT OIL","2. LAVENDER OIL","3. APPLE CIDER VINEGAR"};

    String mDescription[] = {"Pour a little peppermint oil on your hand. Directly apply the oil on your legs. Now massage them for 5 to 10 minutes. Carry out this process before going to bed. Repeat every night until you feel better.\n\n" +
            "اپنے ہاتھ پر تھوڑا سا پیپرمنٹ آئل ڈالیں۔ تیل کو براہ راست اپنی ٹانگوں پر لگائیں۔ اب انہیں 5 سے 10 منٹ تک مساج کریں۔ سونے سے پہلے یہ عمل کریں۔ ہر رات دہرائیں جب تک کہ آپ بہتر محسوس نہ کریں۔" ,
            "Add a few drops of lavender oil to the tub of warm water. The soak body in and leave it on for 10 minutes before going to bed. Alternatively, you can take a few drops of lavender oil and then rub it on your feet before going to bed each night.\n\n" +
                    "گرم پانی کے ٹب میں لیوینڈر آئل کے چند قطرے ڈالیں۔ پاؤں کو اندر بھگو دیں اور سونے سے پہلے 10 منٹ تک لگا رہنے دیں۔ متبادل طور پر، آپ لیوینڈر کے تیل کے چند قطرے لے سکتے ہیں اور پھر اسے ہر رات سونے سے پہلے اپنے پیروں پر رگڑ سکتے ہیں۔",
            "Add 1 tbsp of the apple cider vinegar into a glass of the lukewarm water. Then slowly sip this solution roughly ½ hour before you go to bed. Do this way per day Or rub gently a little amount of the apple cider vinegar onto your legs before you go to bed every night until you see your symptoms are reduced.\n\n" +
                    "ایک گلاس نیم گرم پانی میں 1 چمچ ایپل سائڈر سرکہ ڈالیں۔ پھر اس محلول کو سونے سے تقریباً آدھا گھنٹہ پہلے پی لیں۔ روزانہ اس طرح کریں یا ہر رات سونے سے پہلے سیب کے سرکے کی تھوڑی سی مقدار کو اپنی ٹانگوں پر آہستہ سے رگڑیں جب تک کہ آپ اپنی علامات کو کم نہ دیکھیں۔"
    };
    int images[] = {R.drawable.remedy60,R.drawable.remedy61,R.drawable.remedy7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy21);
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
                Intent i = new Intent(Remedy21.this, LoginActivity.class);
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

