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


public class Remedy5 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. HEAT AND COLD THERAPY"};

    String mDescription[] = {"Use a heating pad to relieve knee pain while resting your knee and then use cold treatment to reduce inflammation.The following are some of the tips for applying heat and cold therapy:\n\n"+"1. First use heat pad for up to 15 to 20 minutes.\n\n"+"2. Check that a heat pad isn’t too hot before applying.\n\n"+"3. Heat therapy is not advisable if your joint is warm during a flare.\n\n"+
            "4. To help ease stiffness in the joint take a warm shower early in the morning.\n\n"+"5. Alternate between heat and cold.\n\n"+"6. Apply cold packs for up to 15 to 20 minutes five to six times a day for the first two days after injury.\n\n"+
            "7. During the first 24 hours after injury or joint sprain apply cold pack or gel pack more often during the entire day.\n\n"+"8. Never apply ice directly to the skin.\n\n"+
            "9. You can also apply heat and cold treatment along with ointments containing capsaicin and paraffin.\n\n"+"اپنے گھٹنے کو آرام دیتے وقت گھٹنے کے درد کو دور کرنے کے لئے ہیٹنگ پیڈ کا استعمال کریں اور پھر سوزش کو کم کرنے کے لئے سرد علاج کا استعمال کریں۔گرمی اور سرد تھراپی کو لاگو کرنے کے لئے مندرجہ ذیل تجاویز میں سے کچھ ہیں:"+
    "سب سے پہلے ہیٹ پیڈ کو 15 سے 20 منٹ تک استعمال کریں۔"+"استعمال کَرنے سے پہلے چیک کریں کہ ہیٹ پیڈ بہت گرم نہیں ہو"+"اگر آپ کا جوڑ گرم ہے تو فلیئر کے دوران ہیٹ تھراپی کا استعمال نہ کریں"+"صبح سویرے گرم پانی سے غسل کریں"+"ہیٹ اور سرد تھراپی کے درمیان متبادل۔"+"چوٹ لگنے کے بعد پہلے دو دنوں کے لئے دن میں پانچ سے چھ بار 15 سے 20 منٹ تک کولڈ پیک لگائیں"+"چوٹ یا مشترکہ موچ کے بعد پہلے 24 گھنٹوں کے دوران پورے دن کے دوران زیادہ سے زیادہ سرد پیک یا جیل پیک لگائیں"+"کبھی بھی جلد پر فوراً برف نہ لگائیں"+"آپ گرم اور سرد تھراپی کے ساتھ ساتھ کیپسیسن اور پیرافین پر مشتمل مرہم بھی لگا سکتے ہیں۔"};
    int images[] = {R.drawable.remedy17};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy5);
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
                Intent i = new Intent(Remedy5.this, LoginActivity.class);
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

