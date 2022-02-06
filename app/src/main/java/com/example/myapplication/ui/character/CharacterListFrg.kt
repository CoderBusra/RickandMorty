package com.example.myapplication.ui.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.model.CharacterRickMorty
import com.example.myapplication.databinding.FragmentListBinding
import com.example.myapplication.ui.adapter.CharacterClickListener
import com.example.myapplication.ui.adapter.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFrg : Fragment(), CharacterClickListener {

    private lateinit var binding: FragmentListBinding
    private val viewModel: CharacterListVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        var adapter = CharacterAdapter(arrayListOf(), this)
        binding.characterList.adapter = adapter
        viewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.updateCharacterList(it)
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun itemClick(characterRick: CharacterRickMorty) {

        val action = CharacterListFrgDirections.aslan(characterRick.id)
        findNavController().navigate(action)
    }


}