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


public class Remedy17 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    ListView listView;
    String mTitle[] = {"1. EPSOM SALT","2. CHAMOMILE TEA","3. HOLY BASIL"};

    String mDescription[] = {"When it comes to home remedies for stress, Epsom salt is a great ingredient which is useful and effective in calming you down when you have stress. Take a cup of Epsom salt and several drops of your chosen aromatic essential oil (such as peppermint, sandalwood, rose, lavender, chamomile, jasmine oil) add into the warm bath water. After stirring them thoroughly, you soak yourself in this solution for 20 minutes. Enjoy this solution twice or thrice per week.\n\n" +
            "جب تناؤ کے گھریلو علاج کی بات آتی ہے تو ایپسم نمک ایک بہترین جز ہے جو آپ کو تناؤ کے وقت پرسکون کرنے میں مفید اور کارآمد ہے۔ گرم غسل کے پانی میں شامل کرنے کے لیے ایک کپ ایپسم نمک اور اپنے منتخب کردہ خوشبودار تیل (جیسے پودینہ، صندل، گلاب، لیوینڈر،روغن بابونہ، چنبیلی کا تیل ) کے کئی قطرے لیں۔ انہیں اچھی طرح ہلانے کے بعد، آپ خود کو اس محلول میں 20 منٹ تک بھگو دیں۔ ہفتے میں دو یا تین بار اس محلول سے لطف اٹھائیں۔" ,
            "Drink no more than 4 cups of chamomile tea per day to help defeat stress. The tea can be made by adding 2 teaspoons of dried chamomile into a cup of the hot water. After covering and steeping it for about 10 minutes, you strain it up and add raw honey into. Drink it and see how different chamomile tea your mood is after that.\n\n" +
                    "تناؤ کو شکست دینے میں مدد کے لیے روزانہ 4 کپ سے زیادہ کیمومائل چائے نہ پائیں۔ ایک کپ گرم پانی میں 2 چمچ خشک کیمومائل ڈال کر چائے بنائی جا سکتی ہے۔ اسے تقریباً 10 منٹ تک ڈھانپنے اور بھگانے کے بعد، آپ اسے چھان لیں اور اس میں شہد ملا دیں۔ اسے پئیں اور دیکھیں کہ کیمومائل چائے کے بعد آپ کا موڈ کتنا مختلف ہے۔",
            "Another great Ayurvedic herb which works as a good natural anti-stress agent is Holy basil. Holy basil, an adaptogenic herb can enhance the natural response of the human body to both physical and emotional stress. Moreover, it can help the human body function appropriately during stress. It is proven that holy basil can protect against chronic restraint stress-induced stress, via its effect. You just need to chew from 10 to 12 fresh holy basil leaves 2 times per day Or, drink a cup of basil tea to decrease stress. In order to make this tea, you should put 1 tablespoon of the fresh leaves of basil in a cup of boiling water. Then, cover and let it steep for 5 minutes before straining it up. Sip the tea steadily.\n\n" +
                    "ایک اور عظیم آیورویدک جڑی بوٹی جو ایک اچھے قدرتی اینٹی سٹریس ایجنٹ کے طور پر کام کرتی ہے۔ تلسی، ایک اڈاپٹوجینک جڑی بوٹی جسمانی اور جذباتی تناؤ کے لیے انسانی جسم کے قدرتی ردعمل کو بڑھا سکتی ہے۔ اس کے علاوہ، یہ انسانی جسم کو کشیدگی کے دوران مناسب طریقے سے کام کرنے میں مدد کرسکتا ہے. یہ ثابت ہوا ہے کہ تلسی اپنے اثر کے ذریعے دائمی تحمل سے پیدا ہونے والے تناؤ سے بچا سکتی ہے۔ آپ کو روزانہ 2 بار تلسی کے 10 سے 12 تازہ پتے چبانے کی ضرورت ہے یا تناؤ کو کم کرنے کے لیے ایک کپ تلسی کی چائے پی لیں۔ اس چائے کو بنانے کے لیے آپ کو ایک کپ ابلتے ہوئے پانی میں تلسی کے تازہ پتے کا 1 چمچ ڈالنا چاہیے۔ پھر، ڈھانپیں اور 5 منٹ تک رہنے دیں۔ دھیرے دھیرے چائے کی چسکی لیں۔"
    };
    int images[] = {R.drawable.remedy66,R.drawable.remedy48,R.drawable.remedy49};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy17);
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
                Intent i = new Intent(Remedy17.this, LoginActivity.class);
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

