package com.example.hofff.view

import Items
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hofff.R
import com.example.hofff.presenter.Ipresenter
import com.example.hofff.presenter.Presenter
import com.example.hofff.view.adapters.MyAdapter

class MainActivity :  AppCompatActivity(), View {


    var myAdapter: MyAdapter? = MyAdapter()
    var mIpresenter: Ipresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mIpresenter = Presenter(this)
        val mRecyclerView: RecyclerView? = findViewById(R.id.recycler)
        mRecyclerView?.setHasFixedSize(true)
        mRecyclerView?.layoutManager = LinearLayoutManager(this)

        mRecyclerView?.setAdapter(myAdapter)
        mIpresenter?.loadData()


    }

    override fun showData(list: List<Items>?) {
        myAdapter?.addItems(list)

    }

    override fun showError(error: String?) {

    }


}