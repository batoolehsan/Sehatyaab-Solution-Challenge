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


public class Remedy16 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. GREEK YOUGURT","2. COCONUT OIL","3. VITAMIN C"};

    String mDescription[] = {"Yogurt can be considered a probiotic because it contains live bacteria, such as Lactobacillus acidophilus. These bacteria are essential to creating a healthy environment in your vagina. They can help treat an overgrowth caused by an imbalance.\n\n" +
            "دہی کو پروبائیوٹک سمجھا جا سکتا ہے کیونکہ اس میں زندہ بیکٹیریا ہوتے ہیں، جیسے کہ لیکٹو بیکیلس ایسڈوفیلس۔ یہ بیکٹیریا آپ کی اندام نہانی میں صحت مند ماحول بنانے کے لیے ضروری ہیں۔ وہ عدم توازن کی وجہ سے زیادہ بڑھنے کے علاج میں مدد کرسکتے ہیں۔" ,
            "Coconut oil is a fatty oil derived from the flesh of the coconut. The oil has many health benefits, including antifungal properties. To treat a vaginal yeast infection using coconut oil, be sure to buy pure, organic coconut oil. You can apply the oil directly to the affected area.\n\n" +
                    "ناریل کے تیل کے بہت سے فوائد ہیں جن میں اینٹی فنگل خصوصیات بھی شامل ہیں۔ ناریل کے تیل کا استعمال کرتے ہوئے اندام نہانی کے انفیکشن کا علاج کرنے کے لیے، خالص، نامیاتی ناریل کا تیل ضرور خریدیں۔ آپ تیل کو متاثرہ جگہ پر لگا سکتے ہیں۔",
            "Vitamin C is an immune system booster and also has a role in skin health. A strong immune system allows your body to bring itself back into balance. Vitamin C, also called ascorbic acid, has antimicrobial components, so some people add it to their diet to treat Candida overgrowths. Try increasing your intake of vitamin C to boost your body’s ability to beat the yeast infection. Don’t apply the acidic vitamin C to the sensitive vaginal tissue.\n\n" +
                    "وٹامن سی مدافعتی نظام کو بڑھانے والا ہے اور جلد کی صحت میں بھی اس کا کردار ہے۔ ایک مضبوط مدافعتی نظام آپ کے جسم کو خود کو توازن میں واپس لانے کی اجازت دیتا ہے۔ اپنے جسم کی انفیکشن کو شکست دینے کی صلاحیت کو بڑھانے کے لیے وٹامن سی کی مقدار بڑھانے کی کوشش کریں۔ اندام نہانی کے حساس ٹشو پر تیزابیت والے وٹامن سی کا اطلاق نہ کریں۔"
    };
    int images[] = {R.drawable.remedy15,R.drawable.remedy5,R.drawable.remedy47};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy16);
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
                Intent i = new Intent(Remedy16.this, LoginActivity.class);
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

