package com.example.islami.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.ui.home.fragments.adapters.SuraNameAdapter

class QuranFragment : Fragment() {
    val chaptersName = listOf<String>(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )
    val chaptersNumber = listOf<String>(
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176", "120", "165", "206", "75", "129", "109",
        "7", "286", "200", "176"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    lateinit var recyclerViewQuran: RecyclerView
    lateinit var suraNameAdapter: SuraNameAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
    }

    fun initRecyclerView() {
        recyclerViewQuran = requireView().findViewById(R.id.recycler_view_quran)
        suraNameAdapter = SuraNameAdapter(chaptersName, chaptersNumber)
        suraNameAdapter.onItemClickListener = object : SuraNameAdapter.OnItemClickedListener {
            override fun onItemClick(position: Int, name: String) {
                Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
            }

        }
        recyclerViewQuran.adapter = suraNameAdapter
    }
}