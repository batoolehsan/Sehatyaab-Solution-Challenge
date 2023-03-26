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


public class Medicine16 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    ListView listView;
    String mTitle[] = {"SURBEX - Z","SANGOBION","METHYCOBAL","QALSAN - D","CALTRATE","CALCITE"};

    String mDescription[] = {"This product is a combination of B vitamins used to treat or prevent vitamin deficiency due to poor diet, certain illnesses, alcoholism, or during pregnancy. Vitamins are important building blocks of the body and help keep you in good health.\n\n"+ "یہ پروڈکٹ بی وٹامنز کا ایک مجموعہ ہے جو ناقص خوراک، بعض بیماریوں، شراب نوشی، یا حمل کے دوران وٹامن کی کمی کے علاج یا روک تھام کے لیے استعمال ہوتا ہے۔ وٹامنز جسم کے اہم تعمیراتی بلاکس ہیں اور آپ کو اچھی صحت میں رکھنے میں مدد کرتے ہیں۔",
            "Sangobion capsule is an iron supplement containing vitamins and minerals that help in increasing the red blood cells and replenishing iron in the body.\n\n"+"سنگوبیون کیپسول ایک آئرن سپلیمنٹ ہے جس میں وٹامنز اور منرلز ہوتے ہیں جو خون کے سرخ خلیات کو بڑھانے اور جسم میں آئرن کو بھرنے میں مدد کرتے ہیں۔",
            "Methycobal Tablet helps replenish vitamin B12 level in your body. This further helps in regeneration of damaged nerves in the body.\n\n"+
                    "یہ آپ کے جسم میں وٹامن بی 12 کی سطح کو بھرنے میں مدد کرتا ہے۔ یہ جسم میں تباہ شدہ اعصاب کی تخلیق نو میں مزید مدد کرتا ہے۔","Qalsan-d Orange is also used to associated treatment for these conditions: Calcium Deficiency, Deficiency, Vitamin D, Osteodystrophy, Osteomalacia, Osteoporosis, Chronic Hypocalcemia, Chronic Hypocalcemia caused by anticonvulsant medications, Care of the Joint, Mineral supplementation, Nutritional supplementation.\n\n"+
            "اس کا استعمال ان حالات کے متعلقہ علاج کے لیے بھی کیا جاتا ہے: کیلشیم کی کمی، کمی، وٹامن ڈی، اوسٹیو ڈسٹروفی، اوسٹیومالیشیا، آسٹیوپوروسس، دائمی ہائپوکالسیمیا، دائمی ہائپوکالسیمیا، جوڑوں کی نگہداشت، معدنی اضافی، غذائی سپلیمنٹس۔", "This medication is used to prevent or treat low blood calcium levels in people who do not get enough calcium from their diets.\n\n"+"یہ دوا ان لوگوں میں کم خون کیلشیم کی سطح کو روکنے یا علاج کرنے کے لیے استعمال کی جاتی ہے جنہیں اپنی خوراک سے کافی کیلشیم نہیں ملتا۔",
            "This combination medication is used to prevent or treat low blood calcium levels in people who do not get enough calcium from their diets.\n\n"+
                    "یہ مرکب دوا ان لوگوں میں کم خون کیلشیم کی سطح کو روکنے یا علاج کرنے کے لیے استعمال کی جاتی ہے جنہیں اپنی خوراک سے کافی کیلشیم نہیں ملتا۔"};


    int images[] = {R.drawable.surbexz,R.drawable.sangobion,R.drawable.methycobal,R.drawable.qalsan,R.drawable.caltrate,R.drawable.calcite};

    String mDosage[] = {"It is recommended to take 1 tablet of Surbex Z every day for adults.\n\n"+"بالغوں کے لیے روزانہ ایک گولی لینا ضروری ہے۔" ,
            "In general the recommended dose is 1 to 2 capsules every day for the prescribed period.\n" +
            "\n"+"عام طور پر تجویز کردہ خوراک مقررہ مدت کے لیے روزانہ 1 سے 2 کیپسول ہے۔\n" ,
            "The usual adult dosage is 1 tablet three times daily.\n" +
            "\n" + "بالغوں کی معمول کی خوراک روزانہ تین بار 1 گولی ہے۔\n",
            "Take 1 - 2 tablets daily or as prescribed by the physician.\n" +
            "\n" + "روزانہ 1 سے 2 گولیاں لیں یا ڈاکٹر کی ہدایت کے مطابق لیں۔\n",
            "Take 2 - 3 tablets are usually recommended with meal, after meal or as directed by physician.\n" +
            "\n" + "دو سے تین گولیاں عام طور پر کھانے کے ساتھ، کھانے کے بعد یا معالج کی ہدایت کے مطابق تجویز کی جاتی ہیں۔\n",
            "Take 1 tablet, twice daily with meals.\n" +
            "\n" + "ایک گولی دن میں دو بار کھانے کے ساتھ لیں۔\n"};

    String mSideEffects[] = {"Common side effects may include constipation, change in color of stool to green, diarrhea and belly pain.\n\n"+"عام ضمنی اثرات میں قبض، پاخانہ کا رنگ سبز ہو جانا، اسہال اور پیٹ میں درد شامل ہو سکتے ہیں۔",
            "Common side effects may include vomiting, dizziness, abdominal bloating, redness, dark stool ,temporary faintness, continuing constipation, diarrhea, allergic reactions.\n" +
                    "\n" + "عام ضمنی اثرات میں الٹی، چکر آنا، پیٹ پھولنا، لالی، گہرا پاخانہ، عارضی بیہوشی، مسلسل قبض، اسہال، الرجک رد عمل شامل ہو سکتے ہیں۔\n",
            "Generally Methycobal is well tolerated. However, a few side effects like GI discomfort (including anorexia, nausea or diarrhea) & rash may be seen after administration of Methycobal.\n" +
            "\n" + "عام طور پر میتھیکوبل کو اچھی طرح سے برداشت کیا جاتا ہے۔ تاہم، چند ضمنی اثرات جیسے (بشمول کشودا، متلی یا اسہال) اور ددورا میتھیکوبل کے استعمال کے بعد دیکھے جا سکتے ہیں۔\n",
            "Its side effects include constipation and upset stomach. More serious but unlikely to occur side effects include nausea/vomiting, loss of appetite, unusual weight loss, mental & mood changes, bone & muscle pain, weakness, increased thirst/ urination. Very serious allergic reactions are rare. But if symptoms of an allergic reaction (rash, itching, swelling, severe dizziness, difficulty breathing) occurs, ask for an immediate medical help.\n" +
            "\n" + "اس کے مضر اثرات میں قبض اور خراب پیٹ شامل ہیں۔ زیادہ سنگین لیکن ممکنہ طور پر ہونے والے ضمنی اثرات میں متلی/الٹی، بھوک میں کمی، وزن میں غیر معمولی کمی، ذہنی اور موڈ میں تبدیلی، ہڈیوں اور پٹھوں میں درد، کمزوری، پیاس میں اضافہ/پیشاب شامل ہیں۔ بہت سنگین الرجک رد عمل نایاب ہیں. لیکن اگر الرجک رد عمل کی علامات (خارش، خارش، سوجن، شدید چکر آنا، سانس لینے میں دشواری) ہو تو فوری طبی مدد طلب کریں۔\n",
            "Bloating and swelling in the abdomen are common side effects of Calcium Orotate. Constipation, nausea, vomiting, headache, increased thirst/ urination, may occur infrequently.\n" +
            "\n" + "پیٹ میں اپھارہ اور سوجن کیلشیم اوروٹیٹ کے عام ضمنی اثرات ہیں۔ قبض، متلی، الٹی، سر درد، پیاس/پیشاب میں اضافہ، کبھی کبھار ہو سکتا ہے۔\n",
            "Common side effects may include upset stomach or constipation.\n" +
            "\n" +
            "عام ضمنی اثرات میں خراب پیٹ یا قبض شامل ہو سکتے ہیں۔\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine16);
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
                Intent i = new Intent(Medicine16.this, LoginActivity.class);
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

