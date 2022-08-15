package org.honggoii.bookcheck.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import org.honggoii.bookcheck.BookCheckApplication
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.databinding.PieChartBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel
import org.honggoii.bookcheck.viewmodel.BookViewModelFactory


class ChartFragment : Fragment() {

    private lateinit var binding: PieChartBinding
    private val viewModel: BookViewModel by activityViewModels{
        BookViewModelFactory(
            (activity?.application as BookCheckApplication).database.myBookDao()
        )
    }

    private lateinit var label: List<String>
    private val entries:ArrayList<PieEntry> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PieChartBinding.inflate(inflater, container, false)

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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.myBookCodes.observe(viewLifecycleOwner) {
            for (myBookCode in it) {
                val code = myBookCode.code
                val count = myBookCode.count.toFloat()
                entries.add(PieEntry(count, label[code]))
                Log.e(TAG, "1111 ${entries.toString()}")
            }

            /* 차트 색상 */
            val colors: ArrayList<Int> = ArrayList()
            for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)
            for (c in ColorTemplate.JOYFUL_COLORS) colors.add(c)
            for (c in ColorTemplate.VORDIPLOM_COLORS) colors.add(c)
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

    companion object {
        const val TAG = "ChartFragment"
    }
}