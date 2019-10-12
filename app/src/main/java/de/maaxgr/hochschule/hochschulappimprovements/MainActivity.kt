package de.maaxgr.hochschule.hochschulappimprovements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import de.maaxgr.hochschule.hochschulappimprovements.fragment.ChangementFragment
import de.maaxgr.hochschule.hochschulappimprovements.fragment.MensaFragment
import de.maaxgr.hochschule.hochschulappimprovements.fragment.TimetableFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager

        val timetableFragment = TimetableFragment()
        val changementFragment = ChangementFragment()
        val mensaFragment = MensaFragment()

        fm.beginTransaction().add(R.id.fragment_container, changementFragment, "2")
            .hide(changementFragment).commit()
        fm.beginTransaction().add(R.id.fragment_container, mensaFragment, "3")
            .hide(mensaFragment).commit()
        fm.beginTransaction().add(R.id.fragment_container, timetableFragment, "1")
            .commit()

        var active: Fragment = timetableFragment

        navigationView.setOnNavigationItemSelectedListener {
            return@setOnNavigationItemSelectedListener when (it.itemId) {
                R.id.nav_timetable -> {
                    fm.beginTransaction().hide(active).show(timetableFragment).commit()
                    active = timetableFragment
                    timetableFragment.load()
                    true
                }
                R.id.nav_changement -> {
                    fm.beginTransaction().hide(active).show(changementFragment).commit()
                    active = changementFragment
                    changementFragment.load()
                    true
                }
                R.id.nav_diet -> {
                    fm.beginTransaction().hide(active).show(mensaFragment).commit()
                    active = mensaFragment
                    mensaFragment.load()
                    true
                }

                else -> false
            }
        }
    }

}
