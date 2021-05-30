package com.example.hofff.main.mvp.view.fragments

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
import com.example.hofff.main.HoffApp
import com.example.hofff.main.mvp.model.data.*
import com.example.hofff.main.mvp.presenter.PresenterInfo
import com.example.hofff.main.mvp.view.ViewInfo
import com.example.hofff.main.mvp.view.activities.MainActivity
import com.example.hofff.main.mvp.view.adapters.MyAdapterInfo
import com.example.hofff.main.mvp.view.adapters.MyAdapterService
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

        presenter.loadOrderInfo(items.id)
        binding.servicesRecycler.adapter = myAdapterServices
        binding.itemsRecycler.adapter = myAdapterInfo


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val bundle = Bundle().apply {
                }
                activity?.onBackPressed()
                //router.navigateTo(Screen.backScreen(bundle))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onOrderSelected() {


    }

    override fun showDataInfo(list: List<ItemsInfo>) {
        myAdapterInfo.addItems(list)
    }

    override fun showDataService(list: List<Services>?) {
        myAdapterServices.addItems(list)
    }

    override fun showStatus() {
        when {
            items.status.id == 8 -> {
                binding.statusTv.setTextColor(Color.RED)
            }
            (items.status.id == 1) or (items.status.id == 2) or (items.status.id == 7) -> {
                binding.statusTv.setTextColor(Color.GREEN)
            }
            (items.status.id == 3) or (items.status.id == 4) or (items.status.id == 5) -> {
                binding.statusTv.setTextColor(Color.GRAY)
            }
        }
    }

    override fun showInfoTwo() {
        binding.orderDateTv.text = items.date.format()
        binding.statusTv.text = items.status.name
        binding.deliveryTv.text = items.delivery.name
    }

    override fun showAddress(address: String) {
        if (items.delivery.name.contains("Самовывоз")) {
            binding.addressTitleTv.text = "Адрес пункта выдачи"
        }
        binding.addressTv.text = address
    }

    override fun showInfo(itemsInfo: BaseInfo) {
        binding.paymentTv.text = itemsInfo.payment.payment.orEmpty()
        binding.bonusCardTv.text = itemsInfo.bonusCard
        binding.shopTv.text = itemsInfo.shop.name.orEmpty()
        binding.itemsCountTv.text = binding.itemsCountTv.context.getString(
            R.string.total,
            itemsInfo.totalItemCount.toString()
        )
    }

    override fun showSum(amount: Amount) {
        binding.bonusesTv.text =
            binding.bonusesTv.context.getString(R.string.ruble, amount.bonuses.toString())
        binding.discountTv.text =
            binding.discountTv.context.getString(R.string.ruble, amount.discount.toString())
        binding.totalSumTv.text =
            binding.totalSumTv.context.getString(R.string.ruble, amount.total.toString())

    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}

