package com.fyp.sehatyaab.medicines;

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
import com.fyp.sehatyaab.adultsymptoms;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Medicine33 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"PEDITRAL (O.R.S)","PEDIALYTE"};

    String mDescription[] = {"Peditral is a combination medicine used to treat or prevent dehydration (too much loss of body water). It is indicated as a source of electrolytes, water, and calories.\n\n"+ "یہ ایک مرکب دوا ہے جو پانی کی کمی (جسم میں پانی کی بہت زیادہ کمی) کے علاج یا روک تھام کے لیے استعمال ہوتی ہے۔ یہ الیکٹرولائٹس، پانی، اور کیلوری کے ذریعہ کے طور پر اشارہ کیا جاتا ہے۔",
            "Pedialyte is a flavored, ready-to-drink, Oral Rehydration Solution that provides children with the appropriate amount of electrolytes and fluids they need during mild to moderate dehydration.\n\n"+"پیڈیالائٹ ایک ذائقہ دار، پینے کے لیے تیار، اورل ری ہائیڈریشن سلوشن ہے جو بچوں کو مناسب مقدار میں الیکٹرولائٹس اور سیال فراہم کرتا ہے جس کی انہیں ہلکے سے اعتدال پسند پانی کی کمی کے دوران ضرورت ہوتی ہے۔"};

    int images[] = {R.drawable.peditral,R.drawable.pedialyte};

    String mDosage[] = {"Take this water soluble medication 1 glass in every 4 hours.\n\n"+"پانی میں حل ہونے والی اس دوا کو ہر 4 گھنٹے میں 1 گلاس لیں۔" ,
            "Take this medication 1 or 2 tablespoon every 15 - 20 minutes.\n" +
                    "\n"+"اس دوا کو ہر 15 سے 20 منٹ میں 1 یا 2 کھانے کے چمچ لیں۔\n"};

    String mSideEffects[] = {"It usually don't have any side effects but sometimes dizziness or lightheadedness, sleepiness, decrease in urination may occur.\n\n"+"اس کے عام طور پر کوئی مضر اثرات نہیں ہوتے لیکن بعض اوقات چکر آنا یا ہلکا سر ہونا، نیند آنا، پیشاب میں کمی ہو سکتی ہے۔",
            "Dizziness, fast heartbeat, high blood pressure, irritability, muscle twitching, restlessness swelling of feet or lower legs weakness.\n" +
                    "\n" +
                    "چکر آنا، تیز دل کی دھڑکن، ہائی بلڈ پریشر، چڑچڑاپن، پٹھوں کا مروڑنا، بے چینی پاؤں میں سوجن یا پیروں کے نچلے حصے کی کمزوری۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine33);
        listView = (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images, mDosage, mSideEffects);
        listView.setAdapter(adapter);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        // now set item click on list view
        // so item click is done now check list view
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
                Intent i = new Intent(Medicine33.this, LoginActivity.class);
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
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        String rDosage[];
        String rSideEffects[];

        MyAdapter(Context c, String[] title, String[] description, int[] imgs, String[] dosage, String[] sideeffects) {
            super(c, R.layout.row_medicines, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rDosage = dosage;
            this.rImgs = imgs;
            this.rSideEffects = sideeffects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_medicines, parent, false);
            ImageView images =(ImageView) row.findViewById(R.id.image);
            TextView myTitle = (TextView) row.findViewById(R.id.textView1);
            TextView myDescription = (TextView) row.findViewById(R.id.textView2);
            TextView myDosage = (TextView) row.findViewById(R.id.textView3);
            TextView mySideEffects = (TextView) row.findViewById(R.id.textView4);
            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            myDosage.setText(rDosage[position]);
            mySideEffects.setText(rSideEffects[position]);


            return row;
        }
        public boolean isEnabled(int position) {

            return false;
        }


    }
}

