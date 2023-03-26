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


public class Remedy3 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. FENNEL OR SAUNF","2. CUMIN SEEDS","3. CLOVES","4. WATERMELON JUICE","5. CARDAMON"};

    String mDescription[] = {"Having around 1 teaspoon fennel powder with a glass of warm water relieves acidity and its symptoms like heartburn, bloating and improves digestion.\n\n" +
            "ایک گلاس گرم پانی کے ساتھ تقریبا ایک چائے کا چمچ سونف کا پاؤڈر پینے سے تیزابیت اور اس کی علامات جیسے سینے کی جلن اور ہاضمہ بہتر ہوتا ہے۔" ,
            "Chew cumin seeds directly or boil 1 teaspoon of them in a glass of water and drink it to relieve acidity.\n\n" +
                    "زیرہ چبا لیں یا ان میں سے ایک چائے کا چمچ ایک گلاس پانی میں ابال کر پینے سے تیزابیت دور ہوتی ہے۔",
            "Suck a piece of clove to get rid of acidity and its symptoms like flatulence, indigestion, nausea, gastric irritability etc.\n\n" +
                    "تیزابیت اور اس کی علامات جیسے تیزابیت، بدہضمی، متلی، معدے کی چڑچڑاپن وغیرہ سے چھٹکارا پانے کے لیے لونگ کا ایک ٹکڑا چوس لیں۔","A glass of watermelon juice is effective in relieving acidity and is good for digestion as well.\n\n" +
            "تربوز کا جوس ایک گلاس تیزابیت سے نجات دلانے میں موثر ہے اور ہاضمے کے لیے بھی اچھا ہے۔","Chewing 1 cardamom pod every day helps to prevent acidity, flatulence and improves digestion.\n\n" +
            "روزانہ ایک الائچی چبانے سے تیزابیت کی روک تھام میں مدد ملتی ہے اور ہاضمہ بہتر ہوتا ہے۔"};
    int images[] = {R.drawable.remedy10,R.drawable.remedy11,R.drawable.remedy12,R.drawable.remedy13,R.drawable.remedy14};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy3);
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
                Intent i = new Intent(Remedy3.this, LoginActivity.class);
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

