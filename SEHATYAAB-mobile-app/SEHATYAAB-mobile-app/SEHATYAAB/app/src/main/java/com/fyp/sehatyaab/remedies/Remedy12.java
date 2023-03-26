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


public class Remedy12 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. YOUGURT AND TUMERIC","2. EAT MORE GREEN VEGETABLES","3. BEETROOT OR POMEGRANATE JUICE","4. RAISINS AND DATES"};

    String mDescription[] = {"Take a cup of yogurt twice a day, morning and afternoon, with a teaspoon of turmeric.\n\n" +
            "ایک کپ دہی دن میں دو بار صبح اور دوپہر ایک چائے کا چمچ ہلدی کے ساتھ لیں۔" ,
            "The high amounts of chlorophyll contained in green vegetables like spinach, celery, mustard greens and broccoli is a good source of iron. Keep in mind that it's best to have cooked spinach as raw the leaves contain oxalic acid with may prevent the absorption of iron in the body.\n\n" +
                    "ہری سبزیوں جیسے پالک، اجوائن، سرسوں کی سبزیاں اور بروکولی میں کلوروفل کی زیادہ مقدار آئرن کا ایک اچھا ذریعہ ہے۔ خیال رہے کہ پالک کو کچا پکانا ہی بہتر ہے کیونکہ اس کے پتے میں آکسالک ایسڈ ہوتا ہے جو جسم میں آئرن کے جذب کو روک سکتا ہے۔",
            "Fresh beetroot or pomegranate juice acts as great blood builders and also blood purifiers. Beetroots are rich in folic acid you can team them up with apples or carrot. Pomegranates, on the other hand, are rich in iron and also other minerals like copper and potassium. Both these juices, if had regularly, can boost your energy levels by supporting healthy blood flow and make you feel more active.\n\n" +
                    "۔تازہ چقندر یا انار کا رس خون بنانے والے اور خون صاف کرنے والے کے طور پر کام کرتا ہے۔ چقندر فولک ایسڈ سے بھرپور ہوتے ہیں آپ سیب یا گاجر شامل کر سکتے ہیں۔ دوسری طرف انار آئرن اور دیگر معدنیات جیسے کاپر اور پوٹاشیم سے بھرپور ہوتے ہیں۔ یہ دونوں جوس، اگر باقاعدگی سے پیے جائیں، تو صحت مند خون کے بہاؤ کو سپورٹ کرکے آپ کی توانائی کی سطح کو بڑھا سکتے ہیں اور آپ کو زیادہ فعال محسوس کر سکتے ہیں۔","These dried fruits offer a combination of iron and Vitamin C. This enables the body to quickly and effectively absorb the iron from them. Eat a handful of raisins and one or two dates for breakfast or as a mid-meal snack. They are also know to give you instant energy.\n\n" +
            "بی وٹامن آپ کے جسم میں بہت سے اہم کردار ادا کرتا ہے. مثال کے طور پر ، وہ نیورو ٹرانسمیٹر ترکیب میں حصہ لیتے ہیں اور کھانے کو توانائی میں تبدیل کرنے میں مدد کرتے ہیں۔ کچھ بی وٹامنز میں سر درد کے خلاف حفاظتی اثرات بھی ہوتے ہیں۔"};
    int images[] = {R.drawable.remedy24,R.drawable.remedy38,R.drawable.remedy39,R.drawable.remedy40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy12);
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
                Intent i = new Intent(Remedy12.this, LoginActivity.class);
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

