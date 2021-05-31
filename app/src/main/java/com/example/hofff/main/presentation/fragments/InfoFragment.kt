package com.example.hofff.main.presentation.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.hofff.R
import com.example.hofff.databinding.FragmentInfoBinding
import com.example.hofff.main.presentation.HoffApp
import com.example.hofff.main.domain.model.*
import com.example.hofff.main.presentation.presenter.PresenterInfo
import com.example.hofff.main.presentation.view.ViewInfo
import com.example.hofff.main.presentation.activities.MainActivity
import com.example.hofff.main.presentation.adapters.MyAdapterInfo
import com.example.hofff.main.presentation.adapters.MyAdapterService
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class InfoFragment : MvpAppCompatFragment(), ViewInfo {
    private var bind: FragmentInfoBinding? = null
    private val binding: FragmentInfoBinding get() = bind!!
    private var myAdapterInfo: MyAdapterInfo = MyAdapterInfo()
    private var myAdapterServices: MyAdapterService = MyAdapterService()

    @Inject
    @InjectPresenter
    lateinit var presenter: PresenterInfo

    @Inject
    lateinit var router: Router

    @ProvidePresenter
    fun providePresenter() = presenter

    lateinit var items: Items
    var page = 0
    var limit = 20
    var device_id: String = "8bba9f1d60af567d"
    var isAndroid: Boolean = true
    var isGooglePayEnabled = 1
    var isSamsungPayEnabled = 0
    var isAvailableSberPay = 1
    var app_version: String = "1.8.43"
    var token: String = "6c7ca481dbe77350a488c45f0615e5fd"
    var location = 19
    var xhoff: String = "1ff0920a11e950e0e7c265f9bd35287e44558d23:8335"

    override fun onCreate(savedInstanceState: Bundle?) {
        HoffApp.INSTANCE.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(arguments?.getSerializable("items") as? Items) {
            if (this == null) {
                router.exit()
                return
            }
            items = this
        }
        (requireActivity() as MainActivity).uTitle(items.number)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).supportActionBar?.setHomeButtonEnabled(true)
        setHasOptionsMenu(true)
        presenter.loadOrderInfo(
            items.id, page, limit,
            device_id, isAndroid, isGooglePayEnabled,
            isSamsungPayEnabled, isAvailableSberPay,
            app_version, token, location, xhoff
        )
        binding.servicesRecycler.adapter = myAdapterServices
        binding.itemsRecycler.adapter = myAdapterInfo
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showDataInfo(list: List<ItemsInfo>) {
        myAdapterInfo.addItems(list)
    }

    override fun showDataService(list: List<Services>?) {
        myAdapterServices.addItems(list)
    }

    override fun showStatus() {
        with(binding) {
            when {
                items.status.id == 8 -> {
                    statusTv.setTextColor(Color.RED)
                }
                (items.status.id == 1) or (items.status.id == 2) or (items.status.id == 7) -> {
                    statusTv.setTextColor(Color.GREEN)
                }
                (items.status.id == 3) or (items.status.id == 4) or (items.status.id == 5) -> {
                    statusTv.setTextColor(Color.GRAY)
                }
            }
        }
    }

    override fun showInfoTwo() {
        with(binding) {
            orderDateTv.text = items.date.format()
            statusTv.text = items.status.name
            deliveryTv.text = items.delivery.name
        }
    }

    override fun showAddress(address: String) {
        with(binding) {
            if (items.delivery.name.contains("Самовывоз")) {
                addressTitleTv.text = "Адрес пункта выдачи"
            }
            addressTv.text = address
        }
    }

    override fun showInfo(itemsInfo: BaseInfo) {
        with(binding) {
            paymentTv.text = itemsInfo.payment.payment.orEmpty()
            bonusCardTv.text = itemsInfo.bonusCard
            shopTv.text = itemsInfo.shop.name.orEmpty()
            itemsCountTv.text = itemsCountTv.context.getString(
                R.string.total, itemsInfo.totalItemCount.toString()
            )
        }
    }

    override fun showSum(amount: Amount) {
        with(binding) {
            bonusesTv.text = bonusesTv.context.getString(R.string.ruble, amount.bonuses.toString())
            discountTv.text =
                discountTv.context.getString(R.string.ruble, amount.discount.toString())
            totalSumTv.text = totalSumTv.context.getString(R.string.ruble, amount.total.toString())
        }
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}

