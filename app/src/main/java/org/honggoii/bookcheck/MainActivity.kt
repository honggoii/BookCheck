package org.honggoii.bookcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.honggoii.bookcheck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* View Binding */
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Toolbar */
        setSupportActionBar(binding.toolbar)

        /* RecyclerView */
        val datas = mutableListOf<String>()
        for (i in 1..10) {
            datas.add("Item $i")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdater(datas)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}