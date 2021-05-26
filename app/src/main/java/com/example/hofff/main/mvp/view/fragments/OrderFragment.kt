package com.example.hofff.main.mvp.view.fragments

import com.example.hofff.main.mvp.model.data.Items
import com.example.hofff.main.mvp.model.data.ItemsInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hofff.R
import com.example.hofff.main.mvp.model.data.Services
import com.example.hofff.main.mvp.presenter.Ipresenter
import com.example.hofff.main.mvp.presenter.Presenter
import com.example.hofff.main.mvp.view.adapters.MyAdapter


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class OrderFragment : Fragment(), com.example.hofff.view.View {

    private var param1: String? = null
    private var param2: String? = null


    private var myAdapter: MyAdapter? = MyAdapter()
    var mIpresenter: Ipresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mIpresenter?.loadData()
        mIpresenter = Presenter(this)
        val mRecyclerView: RecyclerView? = view?.findViewById(R.id.recycler)
        mRecyclerView?.setHasFixedSize(true)
        mRecyclerView?.layoutManager = LinearLayoutManager(context)
        mRecyclerView?.adapter = myAdapter


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showData(list: List<Items>) {
        myAdapter?.addItems(list)
    }

    override fun showDataInfo(list: List<ItemsInfo>) {

    }

    override fun showDataService(list: List<Services>?) {
        TODO("Not yet implemented")
    }


    override fun showError(error: String?) {

    }

    override fun showProgress(): Boolean {
        TODO("Not yet implemented")
    }

    override fun hideProgress(): Boolean {
        TODO("Not yet implemented")
    }
}