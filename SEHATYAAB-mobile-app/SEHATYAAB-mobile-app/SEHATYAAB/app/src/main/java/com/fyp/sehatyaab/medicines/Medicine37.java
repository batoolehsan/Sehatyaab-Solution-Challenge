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


public class Medicine37 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"CAC - 1000 PLUS","QALSAN - D","SANGOBION"};

    String mDescription[] = {"CaC 1000 plus is used to treat or prevent low levels of these minerals in the blood.\n\n"+ "اس کا استعمال خون میں ان معدنیات کی کم سطح کے علاج یا روک تھام کے لیے کیا جاتا ہے۔",
            "Qalsan-d Orange is also used to associated treatment for these conditions: Calcium Deficiency, Deficiency, Vitamin D, Osteodystrophy, Osteomalacia, Osteoporosis, Chronic Hypocalcemia, Chronic Hypocalcemia caused by anticonvulsant medications, Care of the Joint, Mineral supplementation, Nutritional supplementation.\n\n"+"اس کا استعمال ان حالات کے متعلقہ علاج کے لیے بھی کیا جاتا ہے: کیلشیم کی کمی، کمی، وٹامن ڈی، اوسٹیو ڈسٹروفی، اوسٹیومالیشیا، آسٹیوپوروسس، دائمی ہائپوکالسیمیا، دائمی ہائپوکالسیمیا، جوڑوں کی نگہداشت، معدنی اضافی، غذائی سپلیمنٹس۔",
            "Sangobion syrup is an iron supplement containing vitamins and minerals that help in increasing the red blood cells and replenishing iron in the body.\n\n"+
                    "سنگوبون سیرپ ایک آئرن سپلیمنٹ ہے جس میں وٹامنز اور منرلز ہوتے ہیں جو خون کے سرخ خلیات کو بڑھانے اور جسم میں آئرن کو بھرنے میں مدد کرتے ہیں۔"};

    int images[] = {R.drawable.cac,R.drawable.qalsan,R.drawable.sangobion2};

    String mDosage[] = {"Mix one tablet in a glass of water and drink it daily.\n\n"+"روزانہ ایک گلاس پانی میں ایک گولی ملا کر پی لیں۔" ,
            "Take 1 - 2 tablets daily or as prescribed by the physician.\n" +
            "\n"+"روزانہ 1 سے 2 گولیاں لیں یا ڈاکٹر کی ہدایت کے مطابق لیں۔\n" ,
            "Take 1 - 2 teaspoons of this medication three times a day.\n" +
            "\n" + "اس دوا کے ایک سے دو چمچ دن میں تین بار لیں۔\n"};

    String mSideEffects[] = {"Possible side effects may include gastrointestinal upset, headaches, and dizziness.\n\n"+"ممکنہ ضمنی اثرات میں معدے کی خرابی، سر درد، اور چکر آنا شامل ہو سکتے ہیں۔",
            "Its side effects include constipation and upset stomach. More serious but unlikely to occur side effects include nausea/vomiting, loss of appetite, unusual weight loss, mental & mood changes, bone & muscle pain, weakness, increased thirst/ urination. Very serious allergic reactions are rare. But if symptoms of an allergic reaction (rash, itching, swelling, severe dizziness, difficulty breathing) occurs, ask for an immediate medical help.\n" +
                    "\n" +
                    "اس کے مضر اثرات میں قبض اور خراب پیٹ شامل ہیں۔ زیادہ سنگین لیکن ممکنہ طور پر ہونے والے ضمنی اثرات میں متلی/الٹی، بھوک میں کمی، وزن میں غیر معمولی کمی، ذہنی اور موڈ میں تبدیلی، ہڈیوں اور پٹھوں میں درد، کمزوری، پیاس میں اضافہ/پیشاب شامل ہیں۔ بہت سنگین الرجک رد عمل نایاب ہیں. لیکن اگر الرجک رد عمل کی علامات (خارش، خارش، سوجن، شدید چکر آنا، سانس لینے میں دشواری) ہو تو فوری طبی مدد طلب کریں۔\n",
            "Common side effects may include vomiting, dizziness, abdominal bloating, redness, dark stool ,temporary faintness, continuing constipation, diarrhea, allergic reactions.\n" +
                    "\n" +
                    "عام ضمنی اثرات میں الٹی، چکر آنا، پیٹ پھولنا، لالی، گہرا پاخانہ، عارضی بیہوشی، مسلسل قبض، اسہال، الرجک رد عمل شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine37);
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
                Intent i = new Intent(Medicine37.this, LoginActivity.class);
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

