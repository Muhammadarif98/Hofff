package com.example.hofff.view

import com.example.hofff.main.mvp.model.data.Items
import com.example.hofff.main.mvp.model.data.ItemsInfo
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hofff.R
import com.example.hofff.main.mvp.model.data.Services
import com.example.hofff.main.mvp.presenter.Ipresenter
import com.example.hofff.main.mvp.presenter.Presenter
import com.example.hofff.main.mvp.view.adapters.MyAdapter
import com.example.hofff.main.mvp.view.adapters.MyAdapterInfo
import com.example.hofff.main.mvp.view.adapters.MyAdapterService



class MainActivity :  AppCompatActivity(), View {


    private var myAdapter: MyAdapter? = MyAdapter()
    private var myAdapterInfo: MyAdapterInfo? = MyAdapterInfo()
    private var myAdapterServices: MyAdapterService = MyAdapterService()
    var mIpresenter: Ipresenter? = null
    private val mProgressBar: ProgressBar? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)




        mIpresenter = Presenter(this)

        val mRecyclerView: RecyclerView? = findViewById(R.id.recycler)
        mRecyclerView?.setHasFixedSize(true)
        mRecyclerView?.layoutManager = LinearLayoutManager(this)
        mRecyclerView?.adapter = myAdapter

        val mRecyclerViewInfo: RecyclerView? = findViewById(R.id.items_list_rv)
        mRecyclerViewInfo?.setHasFixedSize(true)
        mRecyclerViewInfo?.layoutManager = LinearLayoutManager(this)
        mRecyclerViewInfo?.adapter = myAdapterInfo

        val mRecyclerViewService: RecyclerView? = findViewById(R.id.services_recycler)
        mRecyclerViewService?.setHasFixedSize(true)
        mRecyclerViewService?.layoutManager = LinearLayoutManager(this)
        mRecyclerViewService?.adapter = myAdapterServices

        mIpresenter?.loadData()
        mIpresenter?.loadDataInfo()
        mIpresenter?.loadDataService()

    }

    override fun showData(list: List<Items>) {
        myAdapter?.addItems(list)
    }


    override fun showDataInfo(lists: List<ItemsInfo>) {
        myAdapterInfo?.addItems(lists)
    }

    override fun showDataService(list: List<Services>?) {
        myAdapterServices?.addItems(list)
    }

    override fun showError(error: String?) {

    }

    override fun showProgress(): Boolean {
        if (mProgressBar != null) {
            mProgressBar.visibility = android.view.View.VISIBLE
        }
        return true
    }

    override fun hideProgress(): Boolean {
        if (mProgressBar != null) {
            mProgressBar.visibility = android.view.View.GONE
        }
        return false
    }

}