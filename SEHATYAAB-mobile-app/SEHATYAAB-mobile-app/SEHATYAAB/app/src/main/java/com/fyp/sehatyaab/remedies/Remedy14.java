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


public class Remedy14 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. SALT","2. GARLIC","3. OLIVE OIL","4. BASIL"};

    String mDescription[] = {"Salt is probably the most readily available home remedy.\n\n" +"1. Heat up one cup of salt on a pan over low heat for a few minutes. You can also heat it in a microwave or double-boiler.\n"+"2. Place the hot salt on a cloth and seal the open end with rubber band (or tie a knot).\n"+
            "3. When it is bearably hot, lay down and put the cloth on the affected ear for 5 to 10 minutes.\n"+"4. Repeat this remedy daily as many times as needed. The heat generated from the cloth will help draw out fluid from the ear and relieve swelling and pain.\n"+
            "5. As an alternative, you can use one cup of rice in the same manner described above.\n\n"+
            "نمک شاید سب سے زیادہ آسانی سے دستیاب گھریلو علاج ہے۔"+"ایک پین پر ایک کپ نمک کو ہلکی آنچ پر چند منٹ کے لیے گرم کریں۔ آپ اسے مائکروویو یا ڈبل بوائلر میں بھی گرم کر سکتے ہیں۔"+"گرم نمک کو کپڑے پر رکھیں اور کھلے سرے کو ربڑ بینڈ سے بند کریں (یا گرہ باندھ دیں)۔"+"جب یہ قابل برداشت حد تک گرم ہو جائے تو لیٹ جائیں اور متاثرہ کان پر کپڑا 5 سے 10 منٹ تک رکھیں۔"+"اس علاج کو روزانہ جتنی بار ضرورت ہو دہرائیں۔ کپڑے سے پیدا ہونے والی گرمی کان سے سیال نکالنے اور سوجن اور درد کو دور کرنے میں مدد کرے گی۔"+"متبادل کے طور پر، آپ ایک کپ چاول اسی طرح استعمال کر سکتے ہیں جو اوپر بیان کیا گیا ہے۔",
            "Garlic has antimicrobial properties and natural pain relieving qualities, making it highly effective in the treatment of ear infections. There are a few ways to use garlic as a home treatment. Make garlic oil by cooking two garlic cloves in two tablespoons of sesame oil or mustard oil until it turns blackish. Strain the solution. When it is bearably hot, use two to four drops of this oil in the infected ear as ear drops. Alternatively, you can also boil two or three fresh garlic cloves in water for five minutes, then crush them and add some salt. Put the mixture in a clean cloth and place it against the affected ear. Consuming two to three cloves of raw garlic daily also helps speed up the healing process.\n\n" +
                    "لہسن میں جراثیم کش خصوصیات اور قدرتی درد سے نجات دلانے والی خصوصیات ہوتی ہیں جو اسے کان کے انفیکشن کے علاج میں انتہائی موثر بناتی ہیں۔ لہسن کو گھریلو علاج کے طور پر استعمال کرنے کے چند طریقے ہیں۔ لہسن کے تیل میں لہسن کی دو جوے دو کھانے کے چمچ تل کے تیل یا سرسوں کے تیل میں پکائیں یہاں تک کہ وہ کالا ہو جائے۔ محلول کو چھان لیں۔ جب یہ قابل برداشت حد تک گرم ہو جائے تو اس تیل کے دو سے چار قطرے متاثرہ کان میں کان کے قطرے کے طور پر استعمال کریں۔ متبادل طور پر، آپ لہسن کے دو یا تین جوے پانچ منٹ تک پانی میں ابال سکتے ہیں، پھر انہیں کچل کر تھوڑا سا نمک ڈال سکتے ہیں۔ مکسچر کو صاف کپڑے میں ڈالیں اور متاثرہ کان کے اوپر رکھیں۔ لہسن کے دو سے تین جوے روزانہ کھانے سے شفا یابی کے عمل کو تیز کرنے میں بھی مدد ملتی ہے۔",
            "One of the main causes of an ear infection is wax in the ear catching some fungal or bacterial growth leading to a blockage in the Eustachian tubes. You can easily clear the obstruction with the help of olive oil. Warm some olive oil slightly. Put a few drops of the warm oil into the infected ear. The oil will cause the wax to soften. Remove the infected wax with cotton-tipped swabs. Be careful not to put the swab too far in the ear or you might damage the eardrum. Alternatively, you can also use mustard oil.\n\n" +
                    "کان میں انفیکشن کی ایک اہم وجہ کان میں میل کا ہونا ہے جو کچھ فنگل یا بیکٹیریا کو پکڑتا ہے۔ آپ زیتون کے تیل کی مدد سے رکاوٹ کو آسانی سے دور کر سکتے ہیں۔ زیتون کے تیل کو ہلکا سا گرم کریں۔ گرم تیل کے چند قطرے متاثرہ کان میں ڈالیں۔ تیل میل کو نرم کرنے کا سبب بنے گا۔ متاثرہ میل کو کوٹن بڈ سے ہٹا دیں۔ ہوشیار رہیں کہ کوٹن بڈ کو کان میں زیادہ دور نہ رکھیں ورنہ آپ کان کے پردے کو نقصان پہنچا سکتے ہیں۔ متبادل طور پر آپ سرسوں کا تیل بھی استعمال کر سکتے ہیں۔","Basil is an herb with many therapeutic properties. Basil is high in antioxidants and also contains potent antibacterial properties. To use basil crush five fresh holy basil leaves very gently to expel the juice. Apply the basil juice on and around the affected ear. Be careful not to get any of the juice in the ear canal. Alternatively, mix a few drops of holy basil oil with an equal amount of coconut oil and soak a cotton ball in the mixture. Wipe gently just inside the ear, around the outside of the ear and behind the ear with the mixture..\n\n" +
            "تلسی ایک جڑی بوٹی ہے جس میں بہت سے علاج کی خصوصیات ہیں۔ تلسی اینٹی آکسیڈنٹس سے بھرپور ہوتی ہے اور اس میں طاقتور اینٹی بیکٹیریل خصوصیات بھی ہوتی ہیں۔ تلسی کا استعمال کرنے کے لیے تلسی کے پانچ تازہ پتوں کو بہت آہستگی سے پیس کر رس نکال لیں۔ تلسی کا رس متاثرہ کان پر اور ارد گرد لگائیں۔ ہوشیار رہیں کہ کان کی نالی میں کوئی رس نہ ملے۔ متبادل طور پر، مقدس تلسی کے تیل کے چند قطرے ناریل کے تیل کی مساوی مقدار میں مکس کریں اور ایک روئی کی گیند کو مکسچر میں بھگو دیں۔ مکسچر سے کان کے بالکل اندر، کان کے باہر اور کان کے پیچھے آہستہ سے مسح کریں۔"};
    int images[] = {R.drawable.remedy1,R.drawable.remedy44,R.drawable.remedy30,R.drawable.remedy49};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy14);
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
                Intent i = new Intent(Remedy14.this, LoginActivity.class);
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

