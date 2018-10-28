package com.compro.main.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.compro.main.R
import com.compro.main.ui.clients.ClientsFragment
import com.compro.main.ui.contactus.ContactUsFragment
import com.compro.main.ui.home.HomeFragment
import com.compro.main.ui.products.ProductsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnv_main.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.it_home -> {
                    loadFragment(savedInstanceState, HomeFragment(), getString(R.string.home))
                }
                R.id.it_products -> {
                    loadFragment(savedInstanceState, ProductsFragment(), getString(R.string.products))
                }
                R.id.it_clients -> {
                    loadFragment(savedInstanceState, ClientsFragment(), getString(R.string.clients))
                }
                R.id.it_contact_us -> {
                    loadFragment(savedInstanceState, ContactUsFragment(), getString(R.string.contact_us))
                }
            }
            true
        }
        bnv_main.selectedItemId = R.id.it_home
    }

    private fun loadFragment(savedInstanceState: Bundle?, activeFragement: Fragment, activeTitle: String?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_main, activeFragement, activeTitle)
                    .commit()
        }
    }

}
