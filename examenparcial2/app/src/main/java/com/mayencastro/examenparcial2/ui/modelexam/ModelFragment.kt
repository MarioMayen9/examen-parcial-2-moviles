package com.mayencastro.examenparcial2.ui.modelexam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mayencastro.examenparcial2.R
import com.mayencastro.examenparcial2.databinding.FragmentModelBinding
import com.mayencastro.examenparcial2.ui.modelexam.viewmodel.ModelViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ModelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ModelFragment : Fragment() {
    private val viewModel: ModelViewModel by activityViewModels{
        ModelViewModel.Factory

    }

    private lateinit var binding:FragmentModelBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentModelBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
    }

}