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


public class Remedy2 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. HONEY","2. COCONUT OIL","3. APPLE CIDER VINEGAR","4. SALT WATER","5. TOOTHPASTE"};

    String mDescription[] = {"All you need to do is take some raw honey and apply it on the ulcers. You can also add some turmeric to it to speed up the healing process. Apply it every few hours for relief.\n\n" +
            "آپ کو بس اتنا کرنے کی ضرورت ہے کہ تھوڑا سا شہد لیں اور اسے السر پر لگائیں۔شفا یابی کے عمل کو تیز کرنے کے لئے آپ اس میں کچھ ہلدی بھی شامل کرسکتے ہیں۔آرام کے لئے اسے ہر چند گھنٹوں میں لگائیں۔" ,
            "All you need to do is dab a cotton ball in some virgin coconut oil and apply it on your ulcers. Repeat this after every few hours. You can also apply coconut oil to ulcers and sleep with it.\n\n" +
                    "آپ کو بس اتنا کرنے کی ضرورت ہے کہ کچھ ناریل کے تیل میں روئی کی گیند ڈال دیں اور اسے اپنے السر پر لگائیں۔ہر چند گھنٹوں کے بعد یہ عمل دہرائیں۔ آپ السر پر ناریل کا تیل بھی لگا سکتے ہیں اور اس کے ساتھ سو سکتے ہیں۔",
            "Just mix one tablespoon of apple cider vinegar with half a cup of water and swish the solution in your mouth for a few minutes. Do this every morning and night till the ulcer heals.\n\n" +
                    "بس ایک کھانے کا چمچ سیب کا سرکہ آدھا کپ پانی کے ساتھ مکس کریں اور حل کو اپنے منہ میں چند منٹ کے لئے سوئش کریں۔ایسا ہر صبح اور رات اس وقت تک کریں جب تک السر ٹھیک نہ ہوجائے۔","Gargle with salt water is that one remedy your elders would always come to you with and it is very effective too.\n\n" +
            "نمک کے پانی سے غرارے کرنا السر کو ٹھیک کرنے کا ایک مؤثر طریقہ ہے۔","Take some toothpaste on a Q-tip and apply it on the ulcer. Leave it on for some time and then rinse your mouth. Repeat this till the ulcer disappears.\n\n" +
            "انگلی کی نوک پر کچھ ٹوتھ پیسٹ لیں اور السر پر لگائیں۔اسے کچھ دیر کے لئے چھوڑ دیں اور پھر اپنے منہ کو کللا کریں۔السر غائب ہونے تک اسے دہرائیں۔"};
    int images[] = {R.drawable.remedy4,R.drawable.remedy5,R.drawable.remedy7,R.drawable.remedy8,R.drawable.remedy9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy2);
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
                Intent i = new Intent(Remedy2.this, LoginActivity.class);
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

