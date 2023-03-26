package com.fyp.sehatyaab.pharmacy;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import com.google.android.gms.location.LocationListener;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fyp.sehatyaab.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends SupportMapFragment
        implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    GoogleMap mGoogleMap;
    SupportMapFragment mapFrag;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;

    @Override
    public void onResume() {
        super.onResume();

        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {

        if (mGoogleMap == null) {
            getMapAsync(this);
        }
    }
    @Override
    public void onPause() {
        super.onPause();

        //stop location updates when Activity is no longer active
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, (com.google.android.gms.location.LocationListener) this);
        }
    }
    @Override
    public void onLocationChanged(Location location)
    {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(bitmapDescriptorFromVector(getActivity(), R.drawable.person));

        mCurrLocationMarker = mGoogleMap.addMarker(markerOptions);

        //move map camera
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

    }
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mGoogleMap=googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                buildGoogleApiClient();
                mGoogleMap.setMyLocationEnabled(true);
            } else {
                //Request Location Permission
                checkLocationPermission();
            }
        }
        else {
            buildGoogleApiClient();
            mGoogleMap.setMyLocationEnabled(true);
        }
        LatLng p1 = new LatLng(24.948317954147, 67.07527458759347);
        googleMap.addMarker(new MarkerOptions().position(p1).title("Ahmed's Pharmacy, Plot R 507, Block 18 Gulberg Town")
                .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p1));
        CameraUpdate center1 = CameraUpdateFactory.newLatLng(p1);
        CameraUpdate zoom1 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center1);
        googleMap.moveCamera(zoom1);

        LatLng p2 = new LatLng(24.948763831612403, 67.07948161039943);
        googleMap.addMarker(new MarkerOptions().position(p2).title("786 Noor-E-Syed Medical store, Al Noor Society Block 19")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p2));
        CameraUpdate center2 = CameraUpdateFactory.newLatLng(p2);
        CameraUpdate zoom2 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center2);
        googleMap.moveCamera(zoom2);

        LatLng p3 = new LatLng(24.949346323971128, 67.07479005488842);
        googleMap.addMarker(new MarkerOptions().position(p3).title("Zafa Medicos, Plot R 861, Al Noor Society Block 19")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p3));
        CameraUpdate center3 = CameraUpdateFactory.newLatLng(p3);
        CameraUpdate zoom3 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center3);
        googleMap.moveCamera(zoom3);

        LatLng p4 = new LatLng(24.94920040940104, 67.07883482621713);
        googleMap.addMarker(new MarkerOptions().position(p4).title("Sizar's Medical, Plot R 419, Al Noor Society Block 19")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p4));
        CameraUpdate center4 = CameraUpdateFactory.newLatLng(p4);
        CameraUpdate zoom4 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center4);
        googleMap.moveCamera(zoom4);

        LatLng p5 = new LatLng(24.948730969610253, 67.07525644458218);
        googleMap.addMarker(new MarkerOptions().position(p5).title("Bismillah Medical Store, Plot R 851, Block 19 Al Noor Society")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p5));
        CameraUpdate center5 = CameraUpdateFactory.newLatLng(p5);
        CameraUpdate zoom5 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center5);
        googleMap.moveCamera(zoom5);


        LatLng p11 = new LatLng(24.92858789489813, 67.06693879642516);
        googleMap.addMarker(new MarkerOptions().position(p11).title("Kashif Medical Store, Federal B Area Naseerabad Block 14 Gulberg Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p11));
        CameraUpdate center11 = CameraUpdateFactory.newLatLng(p11);
        CameraUpdate zoom11 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center11);
        googleMap.moveCamera(zoom11);

        LatLng p12 = new LatLng(24.927776066624162, 67.06763327130139);
        googleMap.addMarker(new MarkerOptions().position(p12).title("Al-Salam Pharmacy, Plot CS 35, opp. Ali Heights, Federal B Area Block 14 Naseerabad")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p12));
        CameraUpdate center12 = CameraUpdateFactory.newLatLng(p12);
        CameraUpdate zoom12 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center12);
        googleMap.moveCamera(zoom12);

        LatLng p13 = new LatLng(24.91960315407534, 67.06368505961214);
        googleMap.addMarker(new MarkerOptions().position(p13).title("Tabba Pharmacy, Federal B Area Azizabad Block 8 Gulberg Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p13));
        CameraUpdate center13 = CameraUpdateFactory.newLatLng(p13);
        CameraUpdate zoom13 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center13);
        googleMap.moveCamera(zoom13);

        LatLng p14 = new LatLng(24.917859031782147, 67.06077136260197);
        googleMap.addMarker(new MarkerOptions().position(p14).title("Tayyab's Pharmacy & Basket, Federal B Area Karimabad Block 3 Gulberg Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p14));
        CameraUpdate center14 = CameraUpdateFactory.newLatLng(p14);
        CameraUpdate zoom14 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center14);
        googleMap.moveCamera(zoom14);

        LatLng p15 = new LatLng(24.922391467205713, 67.02923077831464);
        googleMap.addMarker(new MarkerOptions().position(p15).title("HOPES Pharmacy, Block 3 Nazimabad")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p15));
        CameraUpdate center15 = CameraUpdateFactory.newLatLng(p15);
        CameraUpdate zoom15 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center15);
        googleMap.moveCamera(zoom15);

        LatLng p16 = new LatLng(24.91782296223513, 67.09711830416298);
        googleMap.addMarker(new MarkerOptions().position(p16).title("Medicine Point & General Store, Plot No C-171/1 Shop No 4, Block 10 Gulshan-e-Iqbal")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p16));
        CameraUpdate center16 = CameraUpdateFactory.newLatLng(p16);
        CameraUpdate zoom16 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center16);
        googleMap.moveCamera(zoom16);

        LatLng p17 = new LatLng(24.91974910348294, 67.09141641860533);
        googleMap.addMarker(new MarkerOptions().position(p17).title("MedicoSol, 2nd Floor, Office No.As10 Row 1, Block 10A Block 5 Gulshan-e-Iqbal")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p17));
        CameraUpdate center17 = CameraUpdateFactory.newLatLng(p17);
        CameraUpdate zoom17 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center17);
        googleMap.moveCamera(zoom17);

        LatLng p18 = new LatLng(24.921380316205084, 67.09513609282276);
        googleMap.addMarker(new MarkerOptions().position(p18).title("Mona's Pharmacy, Junaid Plaza, Shop No 01, Block 6 Gulshan-e-Iqbal")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p18));
        CameraUpdate center18 = CameraUpdateFactory.newLatLng(p18);
        CameraUpdate zoom18 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center18);
        googleMap.moveCamera(zoom18);

        LatLng p19 = new LatLng(24.92261818017038, 67.10221397834208);
        googleMap.addMarker(new MarkerOptions().position(p19).title("Ibn-e-Sina Pharmacy, Block 6 Gulshan-e-Iqbal")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p19));
        CameraUpdate center19 = CameraUpdateFactory.newLatLng(p19);
        CameraUpdate zoom19 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center19);
        googleMap.moveCamera(zoom19);

        LatLng p20 = new LatLng(24.92460832086894, 67.10195880217728);
        googleMap.addMarker(new MarkerOptions().position(p20).title("Maseeha Pharmacy, Olympian Islahuddin Rd, Block 6 Gulshan-e-Iqbal")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p20));
        CameraUpdate center20 = CameraUpdateFactory.newLatLng(p20);
        CameraUpdate zoom20 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center20);
        googleMap.moveCamera(zoom20);

        LatLng p21 = new LatLng(24.972137496898952, 67.06224037882797);
        googleMap.addMarker(new MarkerOptions().position(p21).title("Doctors Pharmacy, Sector 11C-3 North Karachi")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p21));
        CameraUpdate center21 = CameraUpdateFactory.newLatLng(p21);
        CameraUpdate zoom21 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center21);
        googleMap.moveCamera(zoom21);

        LatLng p22 = new LatLng(24.97219664726894, 67.06482769100114);
        googleMap.addMarker(new MarkerOptions().position(p22).title("Drug Mart, R-693, Sector 11C-3 North Karachi")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p22));
        CameraUpdate center22 = CameraUpdateFactory.newLatLng(p22);
        CameraUpdate zoom22 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center22);
        googleMap.moveCamera(zoom22);

        LatLng p23 = new LatLng(24.972237181207486, 67.06376020528597);
        googleMap.addMarker(new MarkerOptions().position(p23).title("Dvago Pharmacy, UP Mor Plot No.L-158, Sector 11C/1, Sir syed Town North Karachi")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p23));
        CameraUpdate center23 = CameraUpdateFactory.newLatLng(p23);
        CameraUpdate zoom23 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center23);
        googleMap.moveCamera(zoom23);

        LatLng p24 = new LatLng(24.975885532032105, 67.06494372965193);
        googleMap.addMarker(new MarkerOptions().position(p24).title("Umer Medical Store, 3 lane Shahrah-e-Usman, Sector 11-B North Karachi")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p24));
        CameraUpdate center24 = CameraUpdateFactory.newLatLng(p24);
        CameraUpdate zoom24 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center24);
        googleMap.moveCamera(zoom24);

        LatLng p25 = new LatLng(24.993303698941652, 67.06600731919961);
        googleMap.addMarker(new MarkerOptions().position(p25).title("Al Syed Pharmacy, 140/11 Service Rd, Sector 5-K New Karachi Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p25));
        CameraUpdate center25 = CameraUpdateFactory.newLatLng(p25);
        CameraUpdate zoom25 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center25);
        googleMap.moveCamera(zoom25);

        LatLng p26 = new LatLng(24.924312227977612, 67.14574979827798);
        googleMap.addMarker(new MarkerOptions().position(p26).title("New Life Pharmacy, Shop #1 Block-9 , Pia Housing Scheme, Gulistan-e-johar")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p26));
        CameraUpdate center26 = CameraUpdateFactory.newLatLng(p26);
        CameraUpdate zoom26 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center26);
        googleMap.moveCamera(zoom26);

        LatLng p27 = new LatLng(24.935284452346558, 67.13951110868992);
        googleMap.addMarker(new MarkerOptions().position(p27).title("Life Care Pharmacy, Block 5 Saadabad Society Gulistan-e-Johar")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p27));
        CameraUpdate center27 = CameraUpdateFactory.newLatLng(p27);
        CameraUpdate zoom27 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center27);
        googleMap.moveCamera(zoom27);

        LatLng p28 = new LatLng(24.920589991625107, 67.1344465488181);
        googleMap.addMarker(new MarkerOptions().position(p28).title("Al noor Medical store, Block 3 A Gulistan-e-Johar")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p28));
        CameraUpdate center28 = CameraUpdateFactory.newLatLng(p28);
        CameraUpdate zoom28 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center28);
        googleMap.moveCamera(zoom28);

        LatLng p29 = new LatLng(24.922035695755376, 67.13320065468002);
        googleMap.addMarker(new MarkerOptions().position(p29).title("All Meds Pharmacy, Shop # 2, Al Khizra Heights, Block 3-A Gulistan-e-Johar")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p29));
        CameraUpdate center29 = CameraUpdateFactory.newLatLng(p29);
        CameraUpdate zoom29 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center29);
        googleMap.moveCamera(zoom29);

        LatLng p30 = new LatLng(24.91647735802905, 67.12277412446639);
        googleMap.addMarker(new MarkerOptions().position(p30).title("Pharmacy24, Shop No 13, Haroon Royal City, Block 17 Phase 2 Gulistan-e-Johar")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p30));
        CameraUpdate center30 = CameraUpdateFactory.newLatLng(p30);
        CameraUpdate zoom30 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center30);
        googleMap.moveCamera(zoom30);

        LatLng p31 = new LatLng(24.957385866976754, 66.99406839569485);
        googleMap.addMarker(new MarkerOptions().position(p31).title("New Dew Pharmacy, near Disco More, Sector 15-D / Sector 14-E Thorani Goth, Orangi Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p31));
        CameraUpdate center31 = CameraUpdateFactory.newLatLng(p31);
        CameraUpdate zoom31 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center31);
        googleMap.moveCamera(zoom31);

        LatLng p32 = new LatLng(24.95018798519147, 66.99539065377319);
        googleMap.addMarker(new MarkerOptions().position(p32).title("Talha Medical Store, Bangla Bazaar Block G Aziz Nagar, Orangi Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p32));
        CameraUpdate center32 = CameraUpdateFactory.newLatLng(p32);
        CameraUpdate zoom32 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center32);
        googleMap.moveCamera(zoom32);

        LatLng p33 = new LatLng(24.944117834365336, 67.00174212464185);
        googleMap.addMarker(new MarkerOptions().position(p33).title("Faraz medical store, Plot no. 45, Sector 12 Orangi Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p33));
        CameraUpdate center33 = CameraUpdateFactory.newLatLng(p33);
        CameraUpdate zoom33 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center33);
        googleMap.moveCamera(zoom33);

        LatLng p34 = new LatLng(24.941491234245888, 67.00573325175142);
        googleMap.addMarker(new MarkerOptions().position(p34).title("Owais Medicos, Plot no. 530, Sector 9 Orangi Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p34));
        CameraUpdate center34 = CameraUpdateFactory.newLatLng(p34);
        CameraUpdate zoom34 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center34);
        googleMap.moveCamera(zoom34);

        LatLng p35 = new LatLng(24.952152937910217, 67.02238440529396);
        googleMap.addMarker(new MarkerOptions().position(p35).title("Karachi Medical Store, MPR Colony Road, Baloch Goth Orangi Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p35));
        CameraUpdate center35 = CameraUpdateFactory.newLatLng(p35);
        CameraUpdate zoom35 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center35);
        googleMap.moveCamera(zoom35);

        LatLng p36 = new LatLng(24.847514953597667, 67.13014575630082);
        googleMap.addMarker(new MarkerOptions().position(p36).title("DVAGO Pharmacy & Wellness Experts, Mehran Town Sector 7b Korangi")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p36));
        CameraUpdate center36 = CameraUpdateFactory.newLatLng(p36);
        CameraUpdate zoom36 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center36);
        googleMap.moveCamera(zoom36);

        LatLng p37 = new LatLng(24.852655275396415, 67.13546725916301 );
        googleMap.addMarker(new MarkerOptions().position(p37).title("Shah medical store, Plot L 779 Sector 8B Korangi Industrial Area ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p37));
        CameraUpdate center37 = CameraUpdateFactory.newLatLng(p37);
        CameraUpdate zoom37 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center37);
        googleMap.moveCamera(zoom37);

        LatLng p38 = new LatLng(24.825393556891346, 67.13495227501505  );
        googleMap.addMarker(new MarkerOptions().position(p38).title("Dawaa Pharmacy & Diagnostic Korangi, Gulzar Colony Sector 32 B Korangi ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p38));
        CameraUpdate center38 = CameraUpdateFactory.newLatLng(p38);
        CameraUpdate zoom38 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center38);
        googleMap.moveCamera(zoom38);

        LatLng p39 = new LatLng(24.82181014182281, 67.13855716405074 );
        googleMap.addMarker(new MarkerOptions().position(p39).title("Pharmacist, House# 54, y area Chakra Goth Sector 40 C Korangi ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p39));
        CameraUpdate center39 = CameraUpdateFactory.newLatLng(p39);
        CameraUpdate zoom39 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center39);
        googleMap.moveCamera(zoom39);

        LatLng p40 = new LatLng(24.83474110818278, 67.15692493199441 );
        googleMap.addMarker(new MarkerOptions().position(p40).title("Kamal Pharmacy and Super Store, Sector 35 D Korangi No 4 Karachi ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p40));
        CameraUpdate center40 = CameraUpdateFactory.newLatLng(p40);
        CameraUpdate zoom40 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center40);
        googleMap.moveCamera(zoom40);

        LatLng p41 = new LatLng(24.916129443755178, 67.05717535096714  );
        googleMap.addMarker(new MarkerOptions().position(p41).title("The Pharmacy Services, Patel Hospital, ST-18, Federal B Area Hussainabad  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p41));
        CameraUpdate center41 = CameraUpdateFactory.newLatLng(p41);
        CameraUpdate zoom41 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center41);
        googleMap.moveCamera(zoom41);

        LatLng p42 = new LatLng(24.916554021147014, 67.05701409892269  );
        googleMap.addMarker(new MarkerOptions().position(p42).title("Yasir medical Store, 809 Block 3 Hussainabad  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p42));
        CameraUpdate center42 = CameraUpdateFactory.newLatLng(p42);
        CameraUpdate zoom42 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center42);
        googleMap.moveCamera(zoom42);

        LatLng p43 = new LatLng(24.915940742222997, 67.05806483805102  );
        googleMap.addMarker(new MarkerOptions().position(p43).title("Suriya Medical Center, Federal B Area Hussainabad Block 3 ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p43));
        CameraUpdate center43 = CameraUpdateFactory.newLatLng(p43);
        CameraUpdate zoom43 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center43);
        googleMap.moveCamera(zoom43);

        LatLng p44 = new LatLng(24.916201006372884, 67.05731291020034 );
        googleMap.addMarker(new MarkerOptions().position(p44).title("Ilyas Medical Store, Federal B Area Hussainabad Block 3 ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p44));
        CameraUpdate center44 = CameraUpdateFactory.newLatLng(p44);
        CameraUpdate zoom44 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center44);
        googleMap.moveCamera(zoom44);

        LatLng p45 = new LatLng(24.956715001474596, 67.06927329890831 );
        googleMap.addMarker(new MarkerOptions().position(p45).title("Aidvia Pharmacy, Plot 878, Sector 15-A/4 Sector 15-A 04 Buffer Zone  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p45));
        CameraUpdate center45 = CameraUpdateFactory.newLatLng(p45);
        CameraUpdate zoom45 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center45);
        googleMap.moveCamera(zoom45);

        LatLng p46 = new LatLng(24.95543102416127, 67.06575424056398  );
        googleMap.addMarker(new MarkerOptions().position(p46).title("Orange Pharmacy, R1, Sector 15-A/2 Sector 15 A 2 Buffer Zone  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p46));
        CameraUpdate center46 = CameraUpdateFactory.newLatLng(p46);
        CameraUpdate zoom46 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center46);
        googleMap.moveCamera(zoom46);

        LatLng p47 = new LatLng(24.95640323014878, 67.06361810741222  );
        googleMap.addMarker(new MarkerOptions().position(p47).title("Khan Medicos, Sector 15-A/2 Sector 15 A 2 Buffer Zone  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p47));
        CameraUpdate center47 = CameraUpdateFactory.newLatLng(p47);
        CameraUpdate zoom47 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center47);
        googleMap.moveCamera(zoom47);

        LatLng p48 = new LatLng(24.956663258033274, 67.063116194002  );
        googleMap.addMarker(new MarkerOptions().position(p48).title("R.B Medicos, No 4, Road, Sector 15-A/2 Sector 15 A 2 Buffer Zone  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p48));
        CameraUpdate center48 = CameraUpdateFactory.newLatLng(p48);
        CameraUpdate zoom48 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center48);
        googleMap.moveCamera(zoom48);

        LatLng p49 = new LatLng(24.95535147740145, 67.06447175086194  );
        googleMap.addMarker(new MarkerOptions().position(p49).title("Khan Medical and Super Store, Plot R, 94, Sector 15-A/1 Sector 15 A 1 Buffer Zone  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p49));
        CameraUpdate center49 = CameraUpdateFactory.newLatLng(p49);
        CameraUpdate zoom49 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center49);
        googleMap.moveCamera(zoom49);

        LatLng p50 = new LatLng(24.96499339074597, 67.0541213281711  );
        googleMap.addMarker(new MarkerOptions().position(p50).title("Dua Medicos, Sector 14 B Shadman Town  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p50));
        CameraUpdate center50 = CameraUpdateFactory.newLatLng(p50);
        CameraUpdate zoom50 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center50);
        googleMap.moveCamera(zoom50);

        LatLng p51 = new LatLng(24.965071201889167, 67.05721123305884  );
        googleMap.addMarker(new MarkerOptions().position(p51).title("Subhani Medicos And General Store, Shop #18, Sana Height, Sector 14 B Shadman Town ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p51));
        CameraUpdate center51 = CameraUpdateFactory.newLatLng(p51);
        CameraUpdate zoom51 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center51);
        googleMap.moveCamera(zoom51);

        LatLng p52 = new LatLng(24.96242988143054, 67.05999533594049  );
        googleMap.addMarker(new MarkerOptions().position(p52).title("DVAGO Pharmacy & Wellness Experts, R-435, Sector 14 A Shadman Town   ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p52));
        CameraUpdate center52 = CameraUpdateFactory.newLatLng(p52);
        CameraUpdate zoom52 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center52);
        googleMap.moveCamera(zoom52);

        LatLng p53 = new LatLng(24.897674427709106, 67.20877904362015  );
        googleMap.addMarker(new MarkerOptions().position(p53).title("Ali Medical, V6W5+MHR, Jafar e Tayyar, Karachi ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p53));
        CameraUpdate center53 = CameraUpdateFactory.newLatLng(p53);
        CameraUpdate zoom53 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center53);
        googleMap.moveCamera(zoom53);

        LatLng p54 = new LatLng(24.8982223065744, 67.21119511066648  );
        googleMap.addMarker(new MarkerOptions().position(p54).title("Amir Medical & General Store, Khokhrapar Dak'khana, Gharibabad Malir Cantonment  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p54));
        CameraUpdate center54 = CameraUpdateFactory.newLatLng(p54);
        CameraUpdate zoom54 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center54);
        googleMap.moveCamera(zoom54);

        LatLng p55 = new LatLng(24.902182826409355, 67.21102858518431   );
        googleMap.addMarker(new MarkerOptions().position(p55).title("Faraz Medical Store, 27/10 Khokhrapar Dak'khana Rd, Khokhrapar  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p55));
        CameraUpdate center55 = CameraUpdateFactory.newLatLng(p55);
        CameraUpdate zoom55 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center55);
        googleMap.moveCamera(zoom55);

        LatLng p56 = new LatLng(24.90301787419591, 67.20249493225175    );
        googleMap.addMarker(new MarkerOptions().position(p56).title("Muniza Medical Store, Kausar Town Indus Mehran  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p56));
        CameraUpdate center56 = CameraUpdateFactory.newLatLng(p56);
        CameraUpdate zoom56 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center56);
        googleMap.moveCamera(zoom56);

        LatLng p57 = new LatLng(24.906062273104798, 67.2087561323761  );
        googleMap.addMarker(new MarkerOptions().position(p57).title("Bismillah Medicos & General Store, Shop no 3 F-1-14/1 Malir khokrapar   ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p57));
        CameraUpdate center57 = CameraUpdateFactory.newLatLng(p57);
        CameraUpdate zoom57 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center57);
        googleMap.moveCamera(zoom57);

        LatLng p58 = new LatLng(25.022613590443257, 67.13465974821865 );
        googleMap.addMarker(new MarkerOptions().position(p58).title("Makka Medical And Mart, Shop no 13, Hunain Habitat, near Ajwa Hotel, Sector Y-1 Sector Y Gulshan-e-Maymar  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p58));
        CameraUpdate center58 = CameraUpdateFactory.newLatLng(p58);
        CameraUpdate zoom58 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center58);
        googleMap.moveCamera(zoom58);

        LatLng p59 = new LatLng(25.02099136950353, 67.13266706244379 );
        googleMap.addMarker(new MarkerOptions().position(p59).title("Javed Homeopathic Store and Clinic, 786, Sector W Gulshan-e-Maymar  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p59));
        CameraUpdate center59 = CameraUpdateFactory.newLatLng(p59);
        CameraUpdate zoom59 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center59);
        googleMap.moveCamera(zoom59);

        LatLng p60 = new LatLng(25.01367519964713, 67.1249094047621 );
        googleMap.addMarker(new MarkerOptions().position(p60).title("Maymar Medicos, Sector Z Gulshan-e-Maymar ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p60));
        CameraUpdate center60 = CameraUpdateFactory.newLatLng(p60);
        CameraUpdate zoom60 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center60);
        googleMap.moveCamera(zoom60);

        LatLng p61 = new LatLng(25.016969052172136, 67.12748049468317 );
        googleMap.addMarker(new MarkerOptions().position(p61).title("Al-Shifa Pharmacy, Plot B4 Muhammad Ali Rd, Sector Z 6 Sector Z Gulshan-e-Maymar  ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p61));
        CameraUpdate center61 = CameraUpdateFactory.newLatLng(p61);
        CameraUpdate zoom61 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center61);
        googleMap.moveCamera(zoom61);

        LatLng p62 = new LatLng(25.019807926328987, 67.12739466399184  );
        googleMap.addMarker(new MarkerOptions().position(p62).title("Al Waris Medical, Shop No. 04, Plot No. B-101, Sector X-2 Gulshan-e-Maymar ")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p62));
        CameraUpdate center62 = CameraUpdateFactory.newLatLng(p62);
        CameraUpdate zoom62 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center62);
        googleMap.moveCamera(zoom62);


        LatLng p6 = new LatLng(24.925242193394077, 67.03035006633455);
        googleMap.addMarker(new MarkerOptions().position(p6).title("Faisal Homeo Pharmacy, Block 5 Nazimabad")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p6));
        CameraUpdate center6 = CameraUpdateFactory.newLatLng(p6);
        CameraUpdate zoom6 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center6);
        googleMap.moveCamera(zoom6);

        LatLng p7 = new LatLng(24.924849934243607, 67.03134030112139);
        googleMap.addMarker(new MarkerOptions().position(p7).title("Center point Pharmacy, Matric Board Office, Block 5-C Block 5 Nazimabad")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p7));
        CameraUpdate center7 = CameraUpdateFactory.newLatLng(p7);
        CameraUpdate zoom7 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center7);
        googleMap.moveCamera(zoom7);

        LatLng p8 = new LatLng(24.92529749347851, 67.02189892534277);
        googleMap.addMarker(new MarkerOptions().position(p8).title("Noorani Chemists, Block 5-A Nazimabad")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p8));
        CameraUpdate center8 = CameraUpdateFactory.newLatLng(p8);
        CameraUpdate zoom8 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center8);
        googleMap.moveCamera(zoom8);

        LatLng p9 = new LatLng(24.921507782900488, 67.02932462098599);
        googleMap.addMarker(new MarkerOptions().position(p9).title("Trauma Medical Store, Plot C 14/12B, Block 3 Nazimabad")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p9));
        CameraUpdate center9 = CameraUpdateFactory.newLatLng(p9);
        CameraUpdate zoom9 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center9);
        googleMap.moveCamera(zoom9);

        LatLng p10 = new LatLng(24.92602106623181, 67.03326833400216);
        googleMap.addMarker(new MarkerOptions().position(p10).title("Hanif’s Pharma, Hanif Hospital SF 15/A, Block B North Nazimabad Town")
                .icon(bitmapDescriptorFromVector(getActivity(),R.drawable.pharmacy)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(p10));
        CameraUpdate center10 = CameraUpdateFactory.newLatLng(p10);
        CameraUpdate zoom10 = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(center10);
        googleMap.moveCamera(zoom10);
    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId){
        Drawable vectorDrawable= ContextCompat.getDrawable(context,vectorResId);
        vectorDrawable.setBounds(0,0,vectorDrawable.getIntrinsicWidth(),vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap=Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),vectorDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationRequest mLocationRequest = new LocationRequest();
       }
    }

    @Override
    public void onConnectionSuspended(int i) {}

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {}



    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(getActivity())
                        .setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(getActivity(),
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION );
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION );
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mGoogleMap.setMyLocationEnabled(true);
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(getActivity(), "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}