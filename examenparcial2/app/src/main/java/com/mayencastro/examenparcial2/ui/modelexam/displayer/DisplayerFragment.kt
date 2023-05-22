package com.mayencastro.examenparcial2.ui.modelexam.displayer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mayencastro.examenparcial2.R
import com.mayencastro.examenparcial2.data.model.Model
import com.mayencastro.examenparcial2.databinding.FragmentDisplayerBinding
import com.mayencastro.examenparcial2.ui.modelexam.displayer.recyclerview.ModelRecyclerViewAdapter
import com.mayencastro.examenparcial2.ui.modelexam.viewmodel.ModelViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [DisplayerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayerFragment : Fragment() {
    private lateinit var actionNavToCreateModel: FloatingActionButton
    private val viewModel: ModelViewModel by activityViewModels{
        ModelViewModel.Factory

    }
    private lateinit var binding: FragmentDisplayerBinding
    private lateinit var adapter: ModelRecyclerViewAdapter





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDisplayerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)
        setupRecyclerView(view)

        actionNavToCreateModel.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_displayerFragment_to_newModelFragment)
        }

        // actionNavToMovie.setOnClickListener{
        //     it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        //}


    }
    private fun bind(view: View) {
        actionNavToCreateModel = view.findViewById(R.id.action_to_create_model)
        //actionNavToMovie = view.findViewById(R.id.action_billboardFragment_to_movieFragment)

    }

    private fun showSelectedItem(model: Model){
        viewModel.setSelectedModel(model)
        findNavController().navigate(R.id.action_displayerFragment_to_modelFragment)
    }



    private fun displayModel(){
        adapter.setData(viewModel.getModel())
        adapter.notifyDataSetChanged()
    }
    private fun deleteSelectedModel(deleteModel: Model) {
        viewModel.deleteModel(deleteModel) // Eliminar el modelo del ViewModel o del repositorio
        displayModel() // Actualizar la lista de modelos en el RecyclerView
    }

    private fun setupRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = ModelRecyclerViewAdapter(
            clickListener = { selectedModel -> showSelectedItem(selectedModel) },
            deleteListener = { deletedModel -> deleteSelectedModel(deletedModel) }
        )

        Log.d("TAG NameApp", viewModel.name.toString())

        binding.recyclerView.adapter = adapter
        displayModel()
    }
}