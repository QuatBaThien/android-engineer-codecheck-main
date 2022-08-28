package jp.co.yumemi.android.code_check.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.utils.DialogUtils

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null

    val binding get() = _binding!!
    var mDialogLoading: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                try {
                    parentFragmentManager.popBackStackImmediate()
                } catch (e: Exception) {

                }
                super.setEnabled(false)
            }
        })

        init()
        mDialogLoading = DialogUtils.createLoading(requireActivity())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showLoading() {
        mDialogLoading?.show()
    }

    fun hideLoading() {
        mDialogLoading?.dismiss()
    }


    fun showErrorNetworkDialog() {
        DialogUtils.showErrorNetWorkSystem(
            requireActivity(), getString(R.string.error_network_title),
            getString(R.string.error_network_content),
            getString(R.string.close_app)
        )
    }
    override fun onPause() {
        super.onPause()
    }
    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    abstract fun init()
}