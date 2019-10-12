package de.maaxgr.hochschule.hochschulappimprovements.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import de.maaxgr.hochschule.hochschulappimprovements.R
import de.maaxgr.hochschule.hochschulappimprovements.entity.ChangementEntry
import kotlinx.android.synthetic.main.fragment_changements.*
import kotlinx.android.synthetic.main.fragment_timetable_element.view.*

class ChangementFragment : Fragment() {

    companion object {
        val CHANGEMENT_ENTRIES = arrayOf(
            ChangementEntry(
                "Software Engineering II",
                "21.11.2019 09:45",
                "Prof. Dr. Matthias Meitner",
                "Raumänderung:",
                "FA103"
            ),
            ChangementEntry(
                "NoSQL-Datenbanken",
                "22.11.2019 08:00",
                "Prof. Dr. Walter Kern",
                "Raumänderung:",
                "FA011"
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_changements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CHANGEMENT_ENTRIES.forEach {

            val view = layoutInflater.inflate(R.layout.fragment_changements_element, null)
            val card = view.cardview

            card.title.text = it.subject


            entry_layout.addView(view)
        }

    }

    fun load() {
        val activity = activity as AppCompatActivity

        activity.supportActionBar!!.title = "Stundenplanänderungen"




    }

}