package com.example.gdsc_2324_android.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.gdsc_2324_android.R
import com.example.gdsc_2324_android.databinding.ActivityBottomBinding
import com.example.gdsc_2324_android.mapFragment
import com.example.gdsc_2324_android.scrapFragment
import com.example.gdsc_2324_android.settingFragment
import com.example.gdsc_2324_android.writeFragment


private const val TAG_WRITE = "write_fragment"
private const val TAG_MAP = "map_fragment"
private const val TAG_HOME = "home_fragment"
private const val TAG_SCARP = "scarp_fragment"
private const val TAG_SETTING = "setting_fragment"

class bottomActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBottomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setFragment(TAG_HOME, homeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.writeFragment -> setFragment(TAG_WRITE, writeFragment())
                R.id.homeFragment -> setFragment(TAG_HOME, homeFragment())
                R.id.mapFragment-> setFragment(TAG_MAP, mapFragment())
                R.id.scrapFragment-> setFragment(TAG_SCARP, scrapFragment())
                R.id.settingFragment-> setFragment(TAG_SETTING, settingFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val write = manager.findFragmentByTag(TAG_WRITE)
        val map = manager.findFragmentByTag(TAG_MAP)
        val home = manager.findFragmentByTag(TAG_HOME)
        val scrap = manager.findFragmentByTag(TAG_SCARP)
        val setting = manager.findFragmentByTag(TAG_SETTING)



        if (write != null){
            fragTransaction.hide(write)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (map != null) {
            fragTransaction.hide(map)
        }

        if (scrap != null) {
            fragTransaction.hide(scrap)
        }

        if (setting != null) {
            fragTransaction.hide(setting)
        }

        if (tag == TAG_WRITE) {
            if (write!=null){
                fragTransaction.show(write)
            }
        }
        else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        }

        else if (tag == TAG_MAP){
            if (map != null){
                fragTransaction.show(map)
            }
        }

        else if (tag == TAG_SCARP){
            if (scrap != null){
                fragTransaction.show(scrap)
            }
        }


        else if (tag == TAG_SETTING){
            if (setting != null){
                fragTransaction.show(setting)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}