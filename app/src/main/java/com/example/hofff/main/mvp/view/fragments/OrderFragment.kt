package com.example.hofff.main.mvp.view.fragments

import com.example.hofff.main.mvp.model.data.Items
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.hofff.databinding.FragmentOrderBinding
import com.example.hofff.main.HoffApp
import com.example.hofff.main.Screen
import com.example.hofff.main.mvp.presenter.PresenterOrder
import com.example.hofff.main.mvp.view.activities.MainActivity
import com.example.hofff.main.mvp.view.adapters.MyAdapter
import com.example.hofff.main.mvp.view.ViewOrder
import com.github.terrakok.cicerone.Router
import javax.inject.Inject


class OrderFragment : MvpAppCompatFragment(), ViewOrder,MyAdapter.OrderSelectListener{

    private var _binding: FragmentOrderBinding? = null
    private val binding: FragmentOrderBinding get() = _binding!!

    private val myAdapter = MyAdapter(this)


    @Inject
    @InjectPresenter
    lateinit var presenter: PresenterOrder

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var router: Router


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        HoffApp.INSTANCE.appComponent.inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).updateTitle("Мои заказы")

        binding.recycler.adapter = myAdapter

        if (myAdapter.itemCount == 0)
            presenter.loadOrders()
    }
    override fun onOrderSelected(items: Items) {
        val bundle = Bundle().apply {
            putSerializable("items",items)
        }

        router.navigateTo(Screen.infoScreen(bundle))
    }

    override fun showData(list: List<Items>) {
        myAdapter?.addItems(list)
    }




    override fun showError(error: String?) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress(): Boolean {
       // binding.loadingPbm.visibility = View.VISIBLE
        return true
    }

    override fun hideProgress(): Boolean {
       return true
    }
}