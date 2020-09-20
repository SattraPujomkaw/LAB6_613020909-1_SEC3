package com.example.lab6menufragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(
                R.id.frameLayout, OneFragment()
            ).commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val manager = supportFragmentManager
    val transaction = manager.beginTransaction()
    when (item?.itemId){
        R.id.menu1 -> {
            transaction.replace(R.id.frameLayout,OneFragment())
            transaction.addToBackStack(null)
            transaction.commit()
            return true}
        R.id.menu2 -> {transaction.replace(R.id.frameLayout,TwoFragment())
        transaction.addToBackStack(null)
        transaction.commit()
        return true}
        R.id.menu3 -> {transaction.replace(R.id.frameLayout,ThreeFragment())
        transaction.addToBackStack(null)
        transaction.commit()
        return true}
        else -> {
            return super.onOptionsItemSelected(item)
        }
    }

}

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}