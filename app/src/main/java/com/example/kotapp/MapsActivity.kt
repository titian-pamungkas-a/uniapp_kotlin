package com.example.kotapp

import android.Manifest
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.kotapp.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var lm : LocationManager
    private lateinit var ll : LocationListener
    private lateinit var dikirim : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private inner class lokasi :LocationListener {
        override fun onLocationChanged(p0: Location) {
//            TODO("Not yet implemented")
            val terkini = LatLng(p0.latitude, p0.longitude)
            val padang1 = LatLng(-7.28048, 112.78926)
            val padang2 = LatLng(-7.29042, 112.79573)
            val padang3 = LatLng(-7.26089, 112.79037)
            var asal = Location("asal")
            asal.latitude = terkini.latitude
            asal.longitude = terkini.longitude
            var tujuan1 = Location("tujuan1")
            tujuan1.latitude = padang1.latitude
            tujuan1.longitude = padang1.latitude
            var tujuan2 = Location("tujuan1")
            tujuan2.latitude = padang2.latitude
            tujuan2.longitude = padang2.latitude
            var tujuan3 = Location("tujuan1")
            tujuan3.latitude = padang3.latitude
            tujuan3.longitude = padang3.latitude
            mMap.addMarker(MarkerOptions().position(terkini).title("Your Location"))
            mMap.addMarker(MarkerOptions().position(padang1).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
            mMap.addMarker(MarkerOptions().position(padang2).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
            mMap.addMarker(MarkerOptions().position(padang3).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
            val namaTempat = arrayOf("Uni Ampera 1", "Uni Ampera 2", "Uni Ampera 3")
            val jarak  = arrayOf(asal.distanceTo(tujuan1), asal.distanceTo(tujuan2), asal.distanceTo(tujuan3))
            var jarakterdekat = "Uni Ampera"
            var patokan = 100000000.0f
            for (i in 0 .. 2){
                if (jarak[i] < patokan){
                    patokan=jarak[i];
                    jarakterdekat = namaTempat[i];
                }
            }
            Toast.makeText(baseContext, "Tempat terdekat adalah " + jarakterdekat, Toast.LENGTH_LONG).show()
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(terkini, 13F))
            Toast.makeText(baseContext, patokan.toString() + "  "+ jarakterdekat, Toast.LENGTH_SHORT).show()
            Toast.makeText(baseContext, jarak[0].toString() + " " + jarak[1].toString() + " " + jarak[2].toString(), Toast.LENGTH_LONG).show()
            tampilinput(jarakterdekat)
//            val sydney = LatLng(p0.latitude, p0.longitude)
//            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        }

    }

    private fun tampilinput (jarak : String){
        var li : LayoutInflater = LayoutInflater.from(this)
        var input : View = li.inflate(R.layout.konfirmasi, null)
        var dialog = AlertDialog.Builder(this)
        dialog.setView(input)
        dikirim = input.findViewById(R.id.namaTerdekat)
        dikirim.text = jarak
        dialog.setCancelable(false);
        dialog.setPositiveButton("ok", DialogInterface.OnClickListener{ dialogInterface, i ->
            Toast.makeText(baseContext, "Pesanan anda akan segera dikirim", Toast.LENGTH_LONG).show()
        })
        dialog.show();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        lm = getSystemService(LOCATION_SERVICE) as LocationManager
        ll = lokasi()
        if (ActivityCompat.checkSelfPermission(
                this,
                ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(
                this@MapsActivity,
                arrayOf(ACCESS_FINE_LOCATION),
                100
            )
            return
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 200.0f, ll)
        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}


