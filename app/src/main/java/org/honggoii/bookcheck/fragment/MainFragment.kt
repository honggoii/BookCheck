package org.honggoii.bookcheck.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return FragmentMainBinding.inflate(inflater, container, false).root
    }

}