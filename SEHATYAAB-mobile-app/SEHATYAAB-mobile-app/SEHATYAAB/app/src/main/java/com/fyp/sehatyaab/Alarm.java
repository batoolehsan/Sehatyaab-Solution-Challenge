package com.fyp.sehatyaab;

import static android.app.PendingIntent.*;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Alarm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView alarm_state;
    Context context;
    PendingIntent pending_intent;
    int sound_select;
    FirebaseDatabase firebaseDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        // Initialize alarm manager, time picker, text update
        final AlarmManager alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final TimePicker alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);
        final TextView alarm_state = (TextView) findViewById(R.id.alarm_state);

        // Create calendar instance
        final Calendar calendar = Calendar.getInstance();

        // Create intent for AlarmReceiver class, send only once
        final Intent my_intent = new Intent(Alarm.this, AlarmReceiver.class);

        // Create spinner in main UI and corresponding ArrayAdapter
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.stepbrothers_array, android.R.layout.simple_spinner_item);
        // Specify layout used for option list
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply adapter to spinner
        spinner.setAdapter(adapter);
        // Set onClickListener for spinner
        spinner.setOnItemSelectedListener(this);


        // Initialize start button and create onClickListener to start alarm
        Button alarm_on = (Button) findViewById(R.id.alarm_on);
        alarm_on.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "UnspecifiedImmutableFlag"})
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                // Set calendar based on user input
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

                // Retrieve int values of hour and minute
                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();

                // Convert ints into strings
                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                // Handles to format time data
                if(hour > 12) hour_string = String.valueOf(hour - 12);
                if(minute < 10) minute_string = "0" + String.valueOf(minute);

                alarm_state.setText("Alarm set to: " + hour_string + ":" + minute_string);

                // Put extra string into my_intent, indicates on button pressed
                my_intent.putExtra("extra", "alarm on");

                // Input extra long into my_intent
                // Requests specific value from spinner
                my_intent.putExtra("sound_choice", sound_select);


                // Pending intent to delay intent until specific calendar time
                pending_intent = PendingIntent.getBroadcast( Alarm.this ,0,my_intent, PendingIntent.FLAG_IMMUTABLE);
                // Set alarm manager
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);

            }
        });

        // Initialize stop button and create onClick listener to stop alarm
        Button alarm_off = (Button) findViewById(R.id.alarm_off);
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cancel alarm
                alarm_manager.cancel(pending_intent);

                alarm_state.setText("Alarm Off!");

                // Put extra string into my_intent, indicates off button pressed
                my_intent.putExtra("extra", "alarm off");

                // Also input extra long for alarm off to prevent null pointer exception
                my_intent.putExtra("sound_choice", sound_select);

                // Stop ringtone
                sendBroadcast(my_intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        // Output id which user selected
        //Toast.makeText(parent.getContext(), "Spinner item is " + id, Toast.LENGTH_SHORT).show();
        sound_select = (int) id;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
                Intent i = new Intent(Alarm.this, LoginActivity.class);
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
