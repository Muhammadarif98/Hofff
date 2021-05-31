package com.example.hofff.main.presentation.fragments

import com.example.hofff.main.domain.model.Items
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.hofff.databinding.FragmentOrderBinding
import com.example.hofff.main.presentation.HoffApp
import com.example.hofff.main.presentation.Screen
import com.example.hofff.main.presentation.presenter.PresenterOrder
import com.example.hofff.main.presentation.activities.MainActivity
import com.example.hofff.main.presentation.adapters.MyAdapter
import com.example.hofff.main.presentation.view.ViewOrder
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class OrderFragment : MvpAppCompatFragment(), ViewOrder, MyAdapter.OrderSelectListener {

    private var bind: FragmentOrderBinding? = null
    private val binding: FragmentOrderBinding get() = bind!!
    private val myAdapter = MyAdapter(this)

    @Inject
    @InjectPresenter
    lateinit var presenter: PresenterOrder

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var router: Router
    var limit = 20
    var page = 1
    var device_id: String = "43420881b672be1d"
    var isAndroid: Boolean = true
    var isGooglePayEnabled = 1
    var isSamsungPayEnabled = 0
    var isAvailableSberPay = 0
    var app_version: String = "1.8.43"
    var token: String = "350cd8c32311206b3e018165ae623737"
    var location = 19
    var xhoff: String = "6de73707b316191a529b4c4921ff1aa90b2fc819:4454"

    override fun onCreate(savedInstanceState: Bundle?) {
        HoffApp.INSTANCE.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).uTitle("Мои заказы")
        binding.recycler.adapter = myAdapter
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as MainActivity).supportActionBar?.setHomeButtonEnabled(false)
        if (myAdapter.itemCount == 0)
            presenter.loadData(
                limit, page, device_id, isAndroid, isGooglePayEnabled,
                isSamsungPayEnabled, isAvailableSberPay,
                app_version, token, location, xhoff
            )
    }

    override fun onOrderSelected(items: Items) {
        val bundle = Bundle().apply {
            putSerializable("items", items)
        }
        router.navigateTo(Screen.infoScreen(bundle))
    }

    override fun showData(list: List<Items>) {
        myAdapter.addItems(list)
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

}