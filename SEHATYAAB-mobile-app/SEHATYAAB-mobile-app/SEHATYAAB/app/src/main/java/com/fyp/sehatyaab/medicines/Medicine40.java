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


public class Medicine40 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"MALTOFER","FERO","SANGOBION"};

    String mDescription[] = {"Maltofer Iron Syrup is used for the treatment and prevention of iron deficiency in adults and adolescents, where the use of ferrous iron supplements is not tolerated or can’t be used.\n\n"+ "اس کا استعمال بالغوں اور نوعمروں میں آئرن کی کمی کے علاج اور روک تھام کے لیے کیا جاتا ہے، جہاں فیرس آئرن سپلیمنٹس کا استعمال برداشت نہیں کیا جاتا یا استعمال نہیں کیا جا سکتا۔",
            "Nutrifactor’s Fero Syrup contains Iron with vitamin C, B12, and Folic acid which helps in the formation and proper function of red blood cells, as well as in the reduction of iron deficiency.\n\n"+"اس میں وٹامن سی، بی 12 اور فولک ایسڈ کے ساتھ آئرن ہوتا ہے جو خون کے سرخ خلیات کی تشکیل اور مناسب کام کرنے کے ساتھ ساتھ آئرن کی کمی کو دور کرنے میں بھی مدد کرتا ہے۔",
            "Sangobion syrup is an iron supplement containing vitamins and minerals that help in increasing the red blood cells and replenishing iron in the body.\n\n"+
                    "سنگوبون سیرپ ایک آئرن سپلیمنٹ ہے جس میں وٹامنز اور منرلز ہوتے ہیں جو خون کے سرخ خلیات کو بڑھانے اور جسم میں آئرن کو بھرنے میں مدد کرتے ہیں۔"};

    int images[] = {R.drawable.maltofer,R.drawable.fero,R.drawable.sangobion2};

    String mDosage[] = {"Take 10-20 mL of syrup (100-200 mg iron) daily, preferably with food.\n\n"+"روزانہ 10-20 ملی لیٹر شربت (100-200 ملی گرام آئرن) لیں، ترجیحاً کھانے کے ساتھ۔" ,
            "Take this medication 1 tablespoon twice daily.\n" +
            "\n"+"اس دوا کو 1 چمچ دن میں دو بار لیں۔\n" ,
            "Take 1 - 2 teaspoons of this medication three times a day.\n" +
            "\n" + "اس دوا کے ایک سے دو چمچ دن میں تین بار لیں۔\n"};

    String mSideEffects[] = {"Common side effects are drowsiness, dizziness, lightheadedness, stomach upset, diarrhea, nausea, vomiting, or headache may occur.\n\n"+"عام ضمنی اثرات میں غنودگی، چکر آنا، سر درد، پیٹ خراب، اسہال، متلی، الٹی، یا  سر درد ہوسکتا ہے۔",
            "No side effects have been reported yet from using Nutrifactor's Fero Syrup.\n" +
                    "\n" +
                    "اس دوا کے استعمال سے ابھی تک کوئی ضمنی اثرات کی اطلاع نہیں ملی ہے۔\n",
            "Common side effects may include vomiting, dizziness, abdominal bloating, redness, dark stool ,temporary faintness, continuing constipation, diarrhea, allergic reactions.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں الٹی، چکر آنا، پیٹ پھولنا، لالی، گہرا پاخانہ، عارضی بیہوشی، مسلسل قبض، اسہال، الرجک رد عمل شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine40);
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
                Intent i = new Intent(Medicine40.this, LoginActivity.class);
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

