package com.example.hofff.view

import Items
import ItemsInfo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hofff.R
import com.example.hofff.presenter.Ipresenter
import com.example.hofff.presenter.Presenter
import com.example.hofff.view.adapters.MyAdapter
import com.example.hofff.view.adapters.MyAdapterInfo

class MainActivity :  AppCompatActivity(), View {


    private var myAdapter: MyAdapter? = MyAdapter()
    private var myAdapterInfo: MyAdapterInfo? = MyAdapterInfo()
    var mIpresenter: Ipresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        mIpresenter = Presenter(this)
        val mRecyclerView: RecyclerView? = findViewById(R.id.recycler)
        val mRecyclerViewInfo: RecyclerView? = findViewById(R.id.items_list_rv)
            mRecyclerView?.setHasFixedSize(true)
        mRecyclerView?.layoutManager = LinearLayoutManager(this)

        mRecyclerView?.adapter = myAdapter
        mRecyclerViewInfo?.setHasFixedSize(true)
        mRecyclerViewInfo?.layoutManager = LinearLayoutManager(this)

        mRecyclerViewInfo?.adapter = myAdapterInfo

        mIpresenter?.loadData()
        mIpresenter?.loadDataInfo()

        var relativeLayout: RelativeLayout? = findViewById(R.id.relet)
        relativeLayout?.setOnClickListener(android.view.View.OnClickListener { v: android.view.View? -> info() })


    }
    fun info() {
        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
    }

    override fun showData(list: List<Items>?) {
        myAdapter?.addItems(list)

    }

    override fun showDataInfo(lists: List<ItemsInfo>?) {
        myAdapterInfo?.addItems(lists)
    }

    override fun showError(error: String?) {

    }



}