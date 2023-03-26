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

import com.fyp.sehatyaab.therapies.Therapy1;
import com.fyp.sehatyaab.therapies.Therapy10;
import com.fyp.sehatyaab.therapies.Therapy11;
import com.fyp.sehatyaab.therapies.Therapy12;
import com.fyp.sehatyaab.therapies.Therapy13;
import com.fyp.sehatyaab.therapies.Therapy14;
import com.fyp.sehatyaab.therapies.Therapy15;
import com.fyp.sehatyaab.therapies.Therapy16;
import com.fyp.sehatyaab.therapies.Therapy17;
import com.fyp.sehatyaab.therapies.Therapy18;
import com.fyp.sehatyaab.therapies.Therapy19;
import com.fyp.sehatyaab.therapies.Therapy2;
import com.fyp.sehatyaab.therapies.Therapy20;
import com.fyp.sehatyaab.therapies.Therapy21;
import com.fyp.sehatyaab.therapies.Therapy3;
import com.fyp.sehatyaab.therapies.Therapy4;
import com.fyp.sehatyaab.therapies.Therapy5;
import com.fyp.sehatyaab.therapies.Therapy6;
import com.fyp.sehatyaab.therapies.Therapy7;
import com.fyp.sehatyaab.therapies.Therapy8;
import com.fyp.sehatyaab.therapies.Therapy9;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class therapiessymptoms extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Stomach Aches", "Anger", "Foot Pain", "Headache", "Knee Pain", "Hip Pain", "Ankle Pain", "Chest Pain", "Depression", "Elbow Pain", "Eye Fatigue", "Shoulder Pain", "Period Pain","High Blood Pressure","Face","Chronic Fatigue Syndrome","Lose Belly Fat","Lower Back Pain","Sciatica Nerve Pain","Neck Pain","Upper Back Pain"};
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
                Intent t1 = new Intent(therapiessymptoms.this, Therapy1.class);
                Intent t2 = new Intent(therapiessymptoms.this, Therapy2.class);
                Intent t3 = new Intent(therapiessymptoms.this, Therapy3.class);
                Intent t4 = new Intent(therapiessymptoms.this, Therapy4.class);
                Intent t5 = new Intent(therapiessymptoms.this, Therapy5.class);
                Intent t6 = new Intent(therapiessymptoms.this, Therapy6.class);
                Intent t7 = new Intent(therapiessymptoms.this, Therapy7.class);
                Intent t8 = new Intent(therapiessymptoms.this, Therapy8.class);
                Intent t9 = new Intent(therapiessymptoms.this, Therapy9.class);
                Intent t10 = new Intent(therapiessymptoms.this, Therapy10.class);
                Intent t11 = new Intent(therapiessymptoms.this, Therapy11.class);
                Intent t12 = new Intent(therapiessymptoms.this, Therapy12.class);
                Intent t13 = new Intent(therapiessymptoms.this, Therapy13.class);
                Intent t14 = new Intent(therapiessymptoms.this, Therapy14.class);
                Intent t15 = new Intent(therapiessymptoms.this, Therapy15.class);
                Intent t16 = new Intent(therapiessymptoms.this, Therapy16.class);
                Intent t17 = new Intent(therapiessymptoms.this, Therapy17.class);
                Intent t18 = new Intent(therapiessymptoms.this, Therapy18.class);
                Intent t19 = new Intent(therapiessymptoms.this, Therapy19.class);
                Intent t20 = new Intent(therapiessymptoms.this, Therapy20.class);
                Intent t21 = new Intent(therapiessymptoms.this, Therapy21.class);
                if(position == 0){
                    startActivity(t1);
                }
                else if(position == 1){
                    startActivity(t2);
                }
                else if(position == 2){
                    startActivity(t3);
                }
                else if(position == 3){
                    startActivity(t4);
                }
                else if(position == 4){
                    startActivity(t5);
                }
                else if(position == 5){
                    startActivity(t6);
                }
                else if(position == 6){
                    startActivity(t7);
                }
                else if(position == 7){
                    startActivity(t8);
                }
                else if(position == 8){
                    startActivity(t9);
                }
                else if(position == 9){
                    startActivity(t10);
                }
                else if(position == 10){
                    startActivity(t11);
                }
                else if(position == 11){
                    startActivity(t12);
                }
                else if(position == 12){
                    startActivity(t13);
                }
                else if(position == 13){
                    startActivity(t14);
                }
                else if(position == 14){
                    startActivity(t15);
                }
                else if(position == 15){
                    startActivity(t16);
                }
                else if(position == 16){
                    startActivity(t17);
                }
                else if(position == 17){
                    startActivity(t18);
                }
                else if(position == 18){
                    startActivity(t19);
                }
                else if(position == 19){
                    startActivity(t20);
                }
                else if(position == 20){
                    startActivity(t21);
                }

                //start activity 1
                else {
                    int index= position;
                    Toast.makeText(therapiessymptoms.this, "You selected "+ mTitle[index], Toast.LENGTH_SHORT).show();

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
                Intent i = new Intent(therapiessymptoms.this, LoginActivity.class);
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
