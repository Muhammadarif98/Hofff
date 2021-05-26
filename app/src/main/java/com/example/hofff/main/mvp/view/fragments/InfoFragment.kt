package com.example.hofff.main.mvp.view.fragments

import com.example.hofff.main.mvp.model.data.Items
import com.example.hofff.main.mvp.model.data.ItemsInfo
import com.example.hofff.main.mvp.model.data.Services
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hofff.R
import com.example.hofff.main.mvp.presenter.Ipresenter
import com.example.hofff.main.mvp.presenter.Presenter
import com.example.hofff.main.mvp.view.adapters.MyAdapterInfo
import com.example.hofff.main.mvp.view.adapters.MyAdapterService

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoFragment : Fragment() , com.example.hofff.view.View {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var myAdapterInfo: MyAdapterInfo? = MyAdapterInfo()
    private var myAdapterServices: MyAdapterService = MyAdapterService()
    var mIpresenter: Ipresenter? = null
    private val mProgressBar: ProgressBar? = null

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
        mIpresenter?.loadDataInfo()
        mIpresenter = Presenter(this)

        val mRecyclerViewInfo: RecyclerView? = view?.findViewById(R.id.items_list_rv)
        mRecyclerViewInfo?.setHasFixedSize(true)
        mRecyclerViewInfo?.layoutManager = LinearLayoutManager(context)
        mRecyclerViewInfo?.adapter = myAdapterInfo

        val mRecyclerViewService: RecyclerView? = view?.findViewById(R.id.services_recycler)
        mRecyclerViewService?.setHasFixedSize(true)
        mRecyclerViewService?.layoutManager = LinearLayoutManager(context)
        mRecyclerViewService?.adapter = myAdapterServices

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showData(list: List<Items>) {
      //  TODO("Not yet implemented")
    }

    override fun showDataInfo(list: List<ItemsInfo>) {
        myAdapterInfo?.addItems(list)
    }

    override fun showDataService(list: List<Services>?) {
        myAdapterServices?.addItems(list)
    }

    override fun showError(error: String?) {
       // TODO("Not yet implemented")
    }

    override fun showProgress(): Boolean {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(android.view.View.VISIBLE)
        }
        return true
    }

    override fun hideProgress(): Boolean {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(android.view.View.GONE)
        }
        return true
    }
}