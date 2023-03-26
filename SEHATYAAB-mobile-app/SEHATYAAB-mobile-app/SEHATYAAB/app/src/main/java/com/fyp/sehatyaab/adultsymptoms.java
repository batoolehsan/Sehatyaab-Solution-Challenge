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

import com.fyp.sehatyaab.medicines.Medicine1;
import com.fyp.sehatyaab.medicines.Medicine10;
import com.fyp.sehatyaab.medicines.Medicine11;
import com.fyp.sehatyaab.medicines.Medicine12;
import com.fyp.sehatyaab.medicines.Medicine13;
import com.fyp.sehatyaab.medicines.Medicine14;
import com.fyp.sehatyaab.medicines.Medicine15;
import com.fyp.sehatyaab.medicines.Medicine16;
import com.fyp.sehatyaab.medicines.Medicine17;
import com.fyp.sehatyaab.medicines.Medicine18;
import com.fyp.sehatyaab.medicines.Medicine19;
import com.fyp.sehatyaab.medicines.Medicine2;
import com.fyp.sehatyaab.medicines.Medicine20;
import com.fyp.sehatyaab.medicines.Medicine21;
import com.fyp.sehatyaab.medicines.Medicine22;
import com.fyp.sehatyaab.medicines.Medicine23;
import com.fyp.sehatyaab.medicines.Medicine24;
import com.fyp.sehatyaab.medicines.Medicine25;
import com.fyp.sehatyaab.medicines.Medicine26;
import com.fyp.sehatyaab.medicines.Medicine27;
import com.fyp.sehatyaab.medicines.Medicine28;
import com.fyp.sehatyaab.medicines.Medicine29;
import com.fyp.sehatyaab.medicines.Medicine3;
import com.fyp.sehatyaab.medicines.Medicine30;
import com.fyp.sehatyaab.medicines.Medicine31;
import com.fyp.sehatyaab.medicines.Medicine32;
import com.fyp.sehatyaab.medicines.Medicine33;
import com.fyp.sehatyaab.medicines.Medicine34;
import com.fyp.sehatyaab.medicines.Medicine35;
import com.fyp.sehatyaab.medicines.Medicine36;
import com.fyp.sehatyaab.medicines.Medicine37;
import com.fyp.sehatyaab.medicines.Medicine38;
import com.fyp.sehatyaab.medicines.Medicine39;
import com.fyp.sehatyaab.medicines.Medicine4;
import com.fyp.sehatyaab.medicines.Medicine40;
import com.fyp.sehatyaab.medicines.Medicine41;
import com.fyp.sehatyaab.medicines.Medicine42;
import com.fyp.sehatyaab.medicines.Medicine5;
import com.fyp.sehatyaab.medicines.Medicine6;
import com.fyp.sehatyaab.medicines.Medicine7;
import com.fyp.sehatyaab.medicines.Medicine8;
import com.fyp.sehatyaab.medicines.Medicine9;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class adultsymptoms extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Fever", "Cough", "Chest Pain", "Flu", "Loose Stools", "Stomach aches", "Strep Throat", "Vomiting", "Fatigue", "Depression", "Itching", "High Blood Pressure", "Muscle Aches","Food Poisoning","Fungi","Weakness","Skin Bleeding","Stroke","Nose Bleeding","Eczema","Asthma"};
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
                Intent m1 = new Intent(adultsymptoms.this, Medicine1.class);
                Intent m2 = new Intent(adultsymptoms.this, Medicine2.class);
                Intent m3 = new Intent(adultsymptoms.this, Medicine3.class);
                Intent m4 = new Intent(adultsymptoms.this, Medicine4.class);
                Intent m5 = new Intent(adultsymptoms.this, Medicine5.class);
                Intent m6 = new Intent(adultsymptoms.this, Medicine6.class);
                Intent m7 = new Intent(adultsymptoms.this, Medicine7.class);
                Intent m8 = new Intent(adultsymptoms.this, Medicine8.class);
                Intent m9 = new Intent(adultsymptoms.this, Medicine9.class);
                Intent m10 = new Intent(adultsymptoms.this, Medicine10.class);
                Intent m11 = new Intent(adultsymptoms.this, Medicine11.class);
                Intent m12 = new Intent(adultsymptoms.this, Medicine12.class);
                Intent m13 = new Intent(adultsymptoms.this, Medicine13.class);
                Intent m14 = new Intent(adultsymptoms.this, Medicine14.class);
                Intent m15 = new Intent(adultsymptoms.this, Medicine15.class);
                Intent m16 = new Intent(adultsymptoms.this, Medicine16.class);
                Intent m17 = new Intent(adultsymptoms.this, Medicine17.class);
                Intent m18 = new Intent(adultsymptoms.this, Medicine18.class);
                Intent m19 = new Intent(adultsymptoms.this, Medicine19.class);
                Intent m20 = new Intent(adultsymptoms.this, Medicine20.class);
                Intent m21 = new Intent(adultsymptoms.this, Medicine21.class);

                if(position == 0){
                    startActivity(m1);
                }
                else if(position == 1){
                    startActivity(m2);
                }
                else if(position == 2){
                    startActivity(m3);
                }
                else if(position == 3){
                    startActivity(m4);
                }
                else if(position == 4){
                    startActivity(m5);
                }
                else if(position == 5){
                    startActivity(m6);
                }
                else if(position == 6){
                    startActivity(m7);
                }
                else if(position == 7){
                    startActivity(m8);
                }
                else if(position == 8){
                    startActivity(m9);
                }
                else if(position == 9){
                    startActivity(m10);
                }
                else if(position == 10){
                    startActivity(m11);
                }
                else if(position == 11){
                    startActivity(m12);
                }
                else if(position == 12){
                    startActivity(m13);
                }
                else if(position == 13){
                    startActivity(m14);
                }
                else if(position == 14){
                    startActivity(m15);
                }
                else if(position == 15){
                    startActivity(m16);
                }
                else if(position == 16){
                    startActivity(m17);
                }
                else if(position == 17){
                    startActivity(m18);
                }
                else if(position == 18){
                    startActivity(m19);
                }
                else if(position == 19){
                    startActivity(m20);
                }
                else if(position == 20){
                    startActivity(m21);
                }

                //start activity 1
                else {
                    int index= position;
                    Toast.makeText(adultsymptoms.this, "You selected "+ mTitle[index], Toast.LENGTH_SHORT).show();

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
                Intent i = new Intent(adultsymptoms.this, LoginActivity.class);
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
