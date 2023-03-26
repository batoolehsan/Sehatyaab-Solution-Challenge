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
import com.fyp.sehatyaab.medicines.Medicine23;
import com.fyp.sehatyaab.medicines.Medicine24;
import com.fyp.sehatyaab.medicines.Medicine25;
import com.fyp.sehatyaab.medicines.Medicine26;
import com.fyp.sehatyaab.medicines.Medicine27;
import com.fyp.sehatyaab.medicines.Medicine28;
import com.fyp.sehatyaab.medicines.Medicine29;
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
import com.fyp.sehatyaab.medicines.Medicine40;
import com.fyp.sehatyaab.medicines.Medicine41;
import com.fyp.sehatyaab.medicines.Medicine42;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class kidssymptoms extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Fever", "Cough", "Ear Infection", "Flu", "Loose Stools", "Stomach aches", "Strep Throat", "Vomiting", "Loss Of Appetite", "Nausea", "Itching", "Low Blood Pressure", "Skin Rash","Diarrhea","Conjuctivitis","Weakness","ChickenPox","Jaundice","Anemia","Muscle Aches","Asthma"};

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
                Intent m22 = new Intent(kidssymptoms.this, Medicine22.class);
                Intent m23 = new Intent(kidssymptoms.this, Medicine23.class);
                Intent m24 = new Intent(kidssymptoms.this, Medicine24.class);
                Intent m25 = new Intent(kidssymptoms.this, Medicine25.class);
                Intent m26 = new Intent(kidssymptoms.this, Medicine26.class);
                Intent m27 = new Intent(kidssymptoms.this, Medicine27.class);
                Intent m28 = new Intent(kidssymptoms.this, Medicine28.class);
                Intent m29 = new Intent(kidssymptoms.this, Medicine29.class);
                Intent m30 = new Intent(kidssymptoms.this, Medicine30.class);
                Intent m31 = new Intent(kidssymptoms.this, Medicine31.class);
                Intent m32 = new Intent(kidssymptoms.this, Medicine32.class);
                Intent m33 = new Intent(kidssymptoms.this, Medicine33.class);
                Intent m34 = new Intent(kidssymptoms.this, Medicine34.class);
                Intent m35 = new Intent(kidssymptoms.this, Medicine35.class);
                Intent m36 = new Intent(kidssymptoms.this, Medicine36.class);
                Intent m37 = new Intent(kidssymptoms.this, Medicine37.class);
                Intent m38 = new Intent(kidssymptoms.this, Medicine38.class);
                Intent m39 = new Intent(kidssymptoms.this, Medicine39.class);
                Intent m40 = new Intent(kidssymptoms.this, Medicine40.class);
                Intent m41 = new Intent(kidssymptoms.this, Medicine41.class);
                Intent m42 = new Intent(kidssymptoms.this, Medicine42.class);

                if(position == 0){
                    startActivity(m22);
                }
                else if(position == 1){
                    startActivity(m23);
                }
                else if(position == 2){
                    startActivity(m24);
                }
                else if(position == 3){
                    startActivity(m25);
                }
                else if(position == 4){
                    startActivity(m26);
                }
                else if(position == 5){
                    startActivity(m27);
                }
                else if(position == 6){
                    startActivity(m28);
                }
                else if(position == 7){
                    startActivity(m29);
                }
                else if(position == 8){
                    startActivity(m30);
                }
                else if(position == 9){
                    startActivity(m31);
                }
                else if(position == 10){
                    startActivity(m32);
                }
                else if(position == 11){
                    startActivity(m33);
                }
                else if(position == 12){
                    startActivity(m34);
                }
                else if(position == 13){
                    startActivity(m35);
                }
                else if(position == 14){
                    startActivity(m36);
                }
                else if(position == 15){
                    startActivity(m37);
                }
                else if(position == 16){
                    startActivity(m38);
                }
                else if(position == 17){
                    startActivity(m39);
                }
                else if(position == 18){
                    startActivity(m40);
                }
                else if(position == 19){
                    startActivity(m41);
                }
                else if(position == 20){
                    startActivity(m42);
                }

                //start activity 1
                else {
                    int index= position;
                    Toast.makeText(kidssymptoms.this, "You selected "+ mTitle[index], Toast.LENGTH_SHORT).show();

                }
                //start activity 2
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
                Intent i = new Intent(kidssymptoms.this, LoginActivity.class);
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
