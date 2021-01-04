package com.example.viewholderassignment.data

import com.example.viewholderassignment.R
import com.example.viewholderassignment.model.Vouncher

class Datasource {
    fun loadVounchers(): List<Vouncher>{
        return listOf<Vouncher>(
            Vouncher(R.string.vouncher1, R.string.customer1, R.drawable.image1),
            Vouncher(R.string.vouncher2, R.string.customer2, R.drawable.image2),
            Vouncher(R.string.vouncher3, R.string.customer3, R.drawable.image3),
            Vouncher(R.string.vouncher4, R.string.customer4, R.drawable.image4),
        )
    }
}