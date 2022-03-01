package org.honggoii.bookcheck.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.RadarDataSet
import org.honggoii.bookcheck.Database.MyBookDatabase
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.databinding.FragmentListBinding
import org.honggoii.bookcheck.databinding.FragmentMainBinding
import org.honggoii.bookcheck.databinding.FragmentResultBinding
import org.honggoii.bookcheck.databinding.RadarChartBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel
import org.honggoii.bookcheck.viewmodel.BookViewModelFactory
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

import com.github.mikephil.charting.components.XAxis

import com.github.mikephil.charting.data.RadarData







class ResultFragment : Fragment() {

    private lateinit var binding: RadarChartBinding
    private lateinit var myViewModel: BookViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.radar_chart, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = MyBookDatabase.getInstance(application).myBookDao()
        val viewModelFactory = BookViewModelFactory(dataSource, application)
        myViewModel = ViewModelProvider(this, viewModelFactory).get(BookViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.viewModel = myViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val labels = arrayOf(
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
        val xAxis: XAxis = binding.radarChart.getXAxis()
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)

    }

    override fun onResume() {
        super.onResume()

        val dataSet = RadarDataSet(dataValue(), "DATA")
        dataSet.color = Color.BLUE

        val data = RadarData()
        data.addDataSet(dataSet)
        binding.radarChart.setData(data)
    }


    private fun dataValue(): ArrayList<RadarEntry>? {
        val dataVals: ArrayList<RadarEntry> = ArrayList()

        binding.viewModel?.getMyBookCode()

        binding.viewModel?.code?.observe(viewLifecycleOwner, {
            dataVals.clear()
            dataVals.add(RadarEntry(it.get(0)))
            dataVals.add(RadarEntry(it.get(1)))
            dataVals.add(RadarEntry(it.get(2)))
            dataVals.add(RadarEntry(it.get(3)))
            dataVals.add(RadarEntry(it.get(4)))
            dataVals.add(RadarEntry(it.get(5)))
            dataVals.add(RadarEntry(it.get(6)))
            dataVals.add(RadarEntry(it.get(7)))
            dataVals.add(RadarEntry(it.get(8)))
        })
        return dataVals
    }

}