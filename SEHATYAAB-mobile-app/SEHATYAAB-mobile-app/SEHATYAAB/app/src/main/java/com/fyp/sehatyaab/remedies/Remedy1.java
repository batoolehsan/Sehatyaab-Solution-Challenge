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


public class Remedy1 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. LIMIT SALT","2. BANANA","3. ONION JUICE AND HONEY"};

    String mDescription[] = {"Reducing your salt intake can be vital for lowering blood pressure.\n\n" +
            "اپنے نمک کی مقدار کو کم کرنا بلڈ پریشر کو کم کرنے کے لئے فائدہ مند ثابت ہوسکتا ہے۔" ,
            "Banana contains potassium in high amounts. It is a rich source of vitamin B6, vitamin C, and magnesium. If a banana is consumed every day, high blood pressure can be controlled. Along with banana, raisins, dried apricot, currants, orange juice, spinach, sweet potatoes (baked), and winter squash also works wonders.\n\n" +
                    "کیلے میں پوٹاشیم زیادہ مقدار میں پایا جاتا ہے۔ یہ وٹامن بی 6، وٹامن سی، اور میگنیشیم کا ایک امیر ذریعہ ہے.اگر روزانہ ایک کیلا کھایا جائے تو ہائی بلڈ پریشر کو کنٹرول کیا جاسکتا ہے۔ کیلے کے ساتھ ساتھ کشمش، خشک خوبانی، کرنٹ، سنتری کا رس، پالک، شکر قندی(بیکڈ) اور موسم سرما کا اسکواش بھی حیرت انگیز کام کرتا ہے۔",
            "Take half spoon of honey and add half a spoon of onion juice to it.Mix it and take it twice a day for 1-2 weeks. You will notice a remarkable improvement in your blood pressure. You can also eat a raw onion as a salad.\n\n" +
                    "آدھا چمچ شہد لیں اور اس میں آدھا چمچ پیاز کا رس شامل کریں۔ اسے مکس کریں اور 1-2 ہفتوں کے لئے دن میں دو بار لیں.آپ کو اپنے بلڈ پریشر میں قابل ذکر بہتری نظر آئے گی۔ آپ سلاد کے طور پر کچی پیاز بھی کھا سکتے ہیں۔"
    };
    int images[] = {R.drawable.remedy1,R.drawable.remedy2,R.drawable.remedy3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy1);
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
                Intent i = new Intent(Remedy1.this, LoginActivity.class);
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

