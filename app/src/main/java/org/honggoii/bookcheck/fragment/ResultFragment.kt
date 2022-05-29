package org.honggoii.bookcheck.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import org.honggoii.bookcheck.Database.MyBookDatabase
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.databinding.PieChartBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel
import org.honggoii.bookcheck.viewmodel.BookViewModelFactory


class ResultFragment : Fragment() {

    private lateinit var binding: PieChartBinding
    private lateinit var myViewModel: BookViewModel

    private lateinit var label: List<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.pie_chart, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = MyBookDatabase.getInstance(application).myBookDao()
        val viewModelFactory = BookViewModelFactory(dataSource, application)
        myViewModel = ViewModelProvider(this, viewModelFactory).get(BookViewModel::class.java)

        label = listOf(
            getString(R.string.Code0),
            getString(R.string.Code1),
            getString(R.string.Code2),
            getString(R.string.Code3),
            getString(R.string.Code4),
            getString(R.string.Code5),
            getString(R.string.Code6),
            getString(R.string.Code7),
            getString(R.string.Code8),
            getString(R.string.Code9),
        )

        binding.lifecycleOwner = this
        binding.viewModel = myViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel?.getMyBookCode()
    }

    override fun onResume() {
        super.onResume()
        val entries:ArrayList<PieEntry> = ArrayList()

        /* 데이터베이스에서 가져오기 */
        binding.viewModel?.code?.observe(viewLifecycleOwner) {
            it.forEachIndexed { index, value ->
                if (value.toInt() != 0) { // 0%인 분류는 제외
                    entries.add(PieEntry(value, label[index]))
                }
            }
        }

        /* 차트 색상 */
        val colors: ArrayList<Int> = ArrayList()
        for (c in ColorTemplate.VORDIPLOM_COLORS) colors.add(c)
        for (c in ColorTemplate.JOYFUL_COLORS) colors.add(c)
        for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)
        for (c in ColorTemplate.LIBERTY_COLORS) colors.add(c)
        for (c in ColorTemplate.PASTEL_COLORS) colors.add(c)

        /* 차트에 데이터 + 색상 최종 입히기 */
        val dataSet = PieDataSet(entries, "")
        dataSet.colors = colors
        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        binding.chart.data = data
        binding.chart.setUsePercentValues(true)
        binding.chart.description.isEnabled = false;
        binding.chart.invalidate()
    }
}