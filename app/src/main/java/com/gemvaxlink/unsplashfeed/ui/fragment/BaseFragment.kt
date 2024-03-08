package com.gemvaxlink.unsplashfeed.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.gemvaxlink.unsplashfeed.viewmodel.MainViewModel

abstract class BaseFragment<B : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> B
) : Fragment() {

    private val _viewModel: MainViewModel by activityViewModels()

    protected val viewModel get() = _viewModel

    private var _binding: B? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        initialize(binding)
        return _binding?.root
    }

    open fun initialize(binding: B) {
        // empty, can be overridden by subclasses
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Add other common methods and variables if needed
}
