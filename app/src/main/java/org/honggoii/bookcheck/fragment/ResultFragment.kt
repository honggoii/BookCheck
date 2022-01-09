package org.honggoii.bookcheck.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.databinding.FragmentMainBinding
import org.honggoii.bookcheck.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentResultBinding.inflate(inflater, container, false).root
    }

}