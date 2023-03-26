package com.fyp.sehatyaab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fyp.sehatyaab.medicines.Medicine22;
import com.fyp.sehatyaab.remedies.Remedy1;
import com.fyp.sehatyaab.remedies.Remedy10;
import com.fyp.sehatyaab.remedies.Remedy11;
import com.fyp.sehatyaab.remedies.Remedy12;
import com.fyp.sehatyaab.remedies.Remedy13;
import com.fyp.sehatyaab.remedies.Remedy14;
import com.fyp.sehatyaab.remedies.Remedy15;
import com.fyp.sehatyaab.remedies.Remedy16;
import com.fyp.sehatyaab.remedies.Remedy17;
import com.fyp.sehatyaab.remedies.Remedy18;
import com.fyp.sehatyaab.remedies.Remedy19;
import com.fyp.sehatyaab.remedies.Remedy2;
import com.fyp.sehatyaab.remedies.Remedy20;
import com.fyp.sehatyaab.remedies.Remedy21;
import com.fyp.sehatyaab.remedies.Remedy3;
import com.fyp.sehatyaab.remedies.Remedy4;
import com.fyp.sehatyaab.remedies.Remedy5;
import com.fyp.sehatyaab.remedies.Remedy6;
import com.fyp.sehatyaab.remedies.Remedy7;
import com.fyp.sehatyaab.remedies.Remedy8;
import com.fyp.sehatyaab.remedies.Remedy9;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class remediessymptoms extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"High Blood Pressure", "Mouth Ulcer", "Acidity", "Diarrhea", "Knee Pain", "Headache", "Acne", "Cough", "Sore Throat", "Constipation", "Blackheads", "Anemia", "Dark Circles","Ear Infection","Nausea","Yeast Infection","Stress","Low Blood Sugar Level","Dandruff","Hairfall","Restless Leg Syndrome"};
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kidssymptoms);
        listView = (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle );
        listView.setAdapter(adapter);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();


        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent r1 = new Intent(remediessymptoms.this, Remedy1.class);
                Intent r2 = new Intent(remediessymptoms.this, Remedy2.class);
                Intent r3 = new Intent(remediessymptoms.this, Remedy3.class);
                Intent r4 = new Intent(remediessymptoms.this, Remedy4.class);
                Intent r5 = new Intent(remediessymptoms.this, Remedy5.class);
                Intent r6 = new Intent(remediessymptoms.this, Remedy6.class);
                Intent r7 = new Intent(remediessymptoms.this, Remedy7.class);
                Intent r8 = new Intent(remediessymptoms.this, Remedy8.class);
                Intent r9 = new Intent(remediessymptoms.this, Remedy9.class);
                Intent r10 = new Intent(remediessymptoms.this, Remedy10.class);
                Intent r11 = new Intent(remediessymptoms.this, Remedy11.class);
                Intent r12 = new Intent(remediessymptoms.this, Remedy12.class);
                Intent r13 = new Intent(remediessymptoms.this, Remedy13.class);
                Intent r14 = new Intent(remediessymptoms.this, Remedy14.class);
                Intent r15 = new Intent(remediessymptoms.this, Remedy15.class);
                Intent r16 = new Intent(remediessymptoms.this, Remedy16.class);
                Intent r17 = new Intent(remediessymptoms.this, Remedy17.class);
                Intent r18 = new Intent(remediessymptoms.this, Remedy18.class);
                Intent r19 = new Intent(remediessymptoms.this, Remedy19.class);
                Intent r20 = new Intent(remediessymptoms.this, Remedy20.class);
                Intent r21 = new Intent(remediessymptoms.this, Remedy21.class);
                if(position == 0){
                    startActivity(r1);
                }
                else if(position == 1){
                    startActivity(r2);
                }
                else if(position == 2){
                    startActivity(r3);
                }
                else if(position == 3){
                    startActivity(r4);
                }
                else if(position == 4){
                    startActivity(r5);
                }
                else if(position == 5){
                    startActivity(r6);
                }
                else if(position == 6){
                    startActivity(r7);
                }
                else if(position == 7){
                    startActivity(r8);
                }
                else if(position == 8){
                    startActivity(r9);
                }
                else if(position == 9){
                    startActivity(r10);
                }
                else if(position == 10){
                    startActivity(r11);
                }
                else if(position == 11){
                    startActivity(r12);
                }
                else if(position == 12){
                    startActivity(r13);
                }
                else if(position == 13){
                    startActivity(r14);
                }
                else if(position == 14){
                    startActivity(r15);
                }
                else if(position == 15){
                    startActivity(r16);
                }
                else if(position == 16){
                    startActivity(r17);
                }
                else if(position == 17){
                    startActivity(r18);
                }
                else if(position == 18){
                    startActivity(r19);
                }
                else if(position == 19){
                    startActivity(r20);
                }
                else if(position == 20){
                    startActivity(r21);
                }
                //start activity 1
                else {
                    int index= position;
                    Toast.makeText(remediessymptoms.this, "You selected "+ mTitle[index], Toast.LENGTH_SHORT).show();

                }
            }
        });
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
                Intent i = new Intent(remediessymptoms.this, LoginActivity.class);
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

        MyAdapter(Context c, String[] title) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = (TextView) row.findViewById(R.id.textView1);

            // now set our resources on views
            myTitle.setText(rTitle[position]);




            return row;
        }
    }
}
