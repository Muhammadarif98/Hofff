package com.example.hofff.view

import Amount
import BaseInfo
import DeliveryTime
import Items
import ItemsInfo
import Payment
import PickupAddress
import Services
import Shop
import Status
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hofff.InfoFragment
import com.example.hofff.OrderFragment
import com.example.hofff.R
import com.example.hofff.presenter.Ipresenter
import com.example.hofff.presenter.Presenter
import com.example.hofff.view.adapters.MyAdapter
import com.example.hofff.view.adapters.MyAdapterInfo
import com.example.hofff.view.adapters.MyAdapterService
import java.util.ArrayList

class MainActivity :  AppCompatActivity(), View {


    private var myAdapter: MyAdapter? = MyAdapter()
    private var myAdapterInfo: MyAdapterInfo? = MyAdapterInfo()
    private var myAdapterServices: MyAdapterService = MyAdapterService()
    var mIpresenter: Ipresenter? = null
    private val mProgressBar: ProgressBar? = null

    lateinit var mAdress: TextView
    lateinit var adress : String
    lateinit var payment: Payment
    lateinit var mBonusCard: TextView
    lateinit var bonusCard : String
    lateinit var mBonus: TextView
    lateinit var mDiscount: TextView
    lateinit var mTotal: TextView
    lateinit var mTotalCount: TextView
    var totalCount: Int=0
    val itemsInfo : List<ItemsInfo> = TODO()
    val services : List<Services>
    val amount : Amount
    val status : Status
    val pickupAddress : PickupAddress
    val shop : Shop
    val deliveryTime : DeliveryTime
    lateinit var mPayment: TextView


    var base: BaseInfo? = BaseInfo(adress,payment,bonusCard,totalCount,itemsInfo,services,amount,status,pickupAddress,shop,deliveryTime)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


        mPayment = findViewById(R.id.payment_tv)
        mAdress = findViewById(R.id.address_tv)
        mBonusCard = findViewById(R.id.bonus_card_tv)
        mBonus = findViewById(R.id.bonuses_tv)
        mDiscount =findViewById(R.id.discount_tv)
        mTotal = findViewById(R.id.total_sum_tv)
        mTotalCount = findViewById(R.id.items_count_tv)


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

        //val selectedFragment: Fragment = OrderFragment()
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.fragment_container, selectedFragment)
//            .commit()
        val selectedFragment: Fragment = InfoFragment()
        supportFragmentManager
            .beginTransaction()
           // .replace(R.id.fragment_container, selectedFragment)
            .commit()

        mIpresenter?.loadData()
        mIpresenter?.loadDataInfo()


        mPayment.text = base?.payment?.payment.toString()
        mAdress.text = base?.address.toString()
        mBonusCard.text = base?.bonusCard.toString()
        mBonus.text = base?.amount?.bonuses.toString()
        mDiscount.text = base?.amount?.discount.toString()
        mTotal.text = base?.amount?.total.toString()
        mTotalCount.text = mTotalCount.context.getString(R.string.total, base?.totalItemCount.toString())
    }
    fun bindInfo(base:BaseInfo){

    }


    override fun showData(list: List<Items>?) {
        myAdapter?.addItems(list)

    }

    override fun showDataInfo(lists: List<ItemsInfo>?) {
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