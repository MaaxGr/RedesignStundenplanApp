package de.maaxgr.hochschule.hochschulappimprovements.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import de.maaxgr.hochschule.hochschulappimprovements.R
import de.maaxgr.hochschule.hochschulappimprovements.entity.TimetableEntry
import kotlinx.android.synthetic.main.fragment_timetable.*
import kotlinx.android.synthetic.main.fragment_timetable_element.view.*
import kotlinx.android.synthetic.main.fragment_timetable_tab.*

class TimetableFragment : Fragment() {

    companion object {
        private const val ARG_OBJECT = "object"
        private val HEADER = arrayOf("MO", "DI", "MI", "DO", "FR")

        private val TIMETABLE_ENTRIES = arrayOf(
            TimetableEntry(
                "Interface- und Interaction Design",
                "08:00 - 09:30",
                "FB010",
                "Prof. Karl-Friedrich Buhl",
                "Übung"
            ),
            TimetableEntry(
                "Tablet Computing I",
                "09:45 - 11:15",
                "FB010",
                "Prof. Dr. Sven Rill",
                "Übung"
            ),
            TimetableEntry(
                "Web Development I",
                "11:30 - 13:00",
                "FB004A",
                "Prof. Dr. Sven Rill",
                "Übung"
            )
        )

    }

    private lateinit var demoCollectionPagerAdapter: DemoCollectionPagerAdapter
    private lateinit var viewPager: ViewPager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_timetable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        demoCollectionPagerAdapter = DemoCollectionPagerAdapter(childFragmentManager)
        tab_layout.setupWithViewPager(pager)
        pager.adapter = demoCollectionPagerAdapter


        val tabsContainer: LinearLayout = tab_layout.getChildAt(0) as LinearLayout
        val item = tabsContainer.getChildAt(3) as LinearLayout

        item.setBackgroundColor(resources.getColor(R.color.grayDarker))

        /*
        Set color
        val tv = item.getChildAt(1) as TextView
        tv.setTextColor(Color.BLUE)
         */
    }

    fun setActiveDayColor() {

    }

    fun load() {
        val activity = activity as AppCompatActivity

        activity.supportActionBar!!.title = "Stundenplan"
    }

    class DemoCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getCount(): Int  = 5

        override fun getItem(i: Int): Fragment {
            val fragment = DemoObjectFragment()
            fragment.arguments = Bundle().apply {
                // Our object is just an integer :-P
                putInt(ARG_OBJECT, i + 1)
            }
            return fragment
        }

        override fun getPageTitle(position: Int): CharSequence {
            return HEADER[position]
        }
    }


    // Instances of this class are fragments representing a single
// object in our collection.
    class DemoObjectFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater,
                                  container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
            return inflater.inflate(R.layout.fragment_timetable_tab, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {

                TIMETABLE_ENTRIES.forEach {

                    val element = layoutInflater.inflate(
                        R.layout.fragment_timetable_element, null
                    )
                    val cardView = element.cardview

                    cardView.title.text = it.subjectName
                    cardView.time.text = it.time
                    cardView.lecturer.text = it.lecturer
                    cardView.description.text = it.description
                    cardView.room.text = it.room

                    entry_layout.addView(element)
                }
            }
        }
    }
}