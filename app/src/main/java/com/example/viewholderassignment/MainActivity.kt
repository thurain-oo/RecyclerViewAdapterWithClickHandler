package com.example.viewholderassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viewholderassignment.adapter.VouncherItemAdapter
import com.example.viewholderassignment.data.Datasource
import com.example.viewholderassignment.databinding.ActivityMainBinding
import com.example.viewholderassignment.model.Vouncher

class MainActivity : AppCompatActivity(),VouncherItemAdapter.OnVouncherItemClickListener {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myVouncherSet = Datasource().loadVounchers()
        var adapter = VouncherItemAdapter(this,myVouncherSet)
        binding.recyclerView.adapter=adapter
        adapter.setOnClickListener(this)

    }

    override fun onVouncherItemClicked(vouncher: Vouncher) {
        Toast.makeText(this," ${resources.getString(vouncher.customerName)} : ${resources.getString(vouncher.serialNo)} clicked",Toast.LENGTH_SHORT).show()
    }
}