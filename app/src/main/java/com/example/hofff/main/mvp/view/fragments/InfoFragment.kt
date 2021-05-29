package com.example.hofff.main.mvp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.hofff.main.mvp.model.data.format
import com.example.hofff.databinding.FragmentInfoBinding
import com.example.hofff.main.HoffApp
import com.example.hofff.main.mvp.model.data.*
import com.example.hofff.main.mvp.presenter.PresenterInfo
import com.example.hofff.main.mvp.view.activities.MainActivity
import com.example.hofff.main.mvp.view.adapters.MyAdapterInfo
import com.example.hofff.main.mvp.view.adapters.MyAdapterService
import com.example.hofff.main.mvp.view.ViewInfo
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

    override fun onCreate(savedInstanceState: Bundle?) {
        HoffApp.INSTANCE.appComponent.inject(this)
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { bind = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.apply {
            getSerializable("items")

        }
        with(arguments?.getSerializable("items") as? Items) {
            if (this == null) {
                router.exit()
                return
            }

            items = this
        }

        (requireActivity() as MainActivity).updateTitle(items.number)

        presenter.loadOrderInfo(items.id)

        val dividerItemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)

        binding.servicesRecycler.addItemDecoration(dividerItemDecoration)
        binding.servicesRecycler.adapter = myAdapterServices

        binding.itemsListRv.addItemDecoration(dividerItemDecoration)
        binding.itemsListRv.adapter = myAdapterInfo
    }




    override fun showDataInfo(list: List<ItemsInfo>) {
        myAdapterInfo.addItems(list)
    }

    override fun showDataService(list: List<Services>?) {
        myAdapterServices.addItems(list)
    }

    override fun showContent() {
        binding.orderInfoContent.visibility = View.VISIBLE
    }

    override fun showTopOrderInfo() {
        binding.orderDateTv.text = items.date.format()
        binding.statusTv.text = items.status.name
        binding.deliveryTv.text = items.delivery.name
    }

    override fun showDeliveryTime(deliveryTime: DeliveryTime) {
        binding.deliveryDateTv.text = deliveryTime.data
        binding.deliveryTimeTv.text = deliveryTime.data
    }

    override fun showAddress(address: String) {
        if (items.delivery.name.contains("Самовывоз")) {
            binding.addressTitleTv.text = "Адрес пункта выдачи"
            binding.addressTv.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.holo_blue_dark))
        }

        binding.addressTv.text = address
    }

    override fun showOtherCenterInfo(itemsInfo: BaseInfo) {
        binding.paymentTv.text = itemsInfo.payment.payment.orEmpty()
        binding.bonusCardTv.text = itemsInfo.bonusCard
        binding.shopTv.text = itemsInfo.shop.name.orEmpty()
    }

    override fun showOrderSum(amount: Amount) {
            binding.bonusesLl.visibility = View.VISIBLE
            binding.bonusesTv.text = amount.bonuses.toString()
            binding.discountTv.text = amount.discount.toString()
            binding.totalSumTv.text = amount.total.toString()
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}