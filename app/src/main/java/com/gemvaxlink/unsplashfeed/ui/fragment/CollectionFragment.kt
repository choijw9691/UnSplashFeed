package com.gemvaxlink.unsplashfeed.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.databinding.FragmentCollectionBinding
import com.gemvaxlink.unsplashfeed.databinding.FragmentHomeBinding
import com.gemvaxlink.unsplashfeed.ui.adapter.PhotosAdapter
import com.gemvaxlink.unsplashfeed.util.Constants
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CollectionFragment : BaseFragment<FragmentCollectionBinding>(FragmentCollectionBinding::inflate) {

    override fun initialize(binding: FragmentCollectionBinding) {
        super.initialize(binding)

    }
}