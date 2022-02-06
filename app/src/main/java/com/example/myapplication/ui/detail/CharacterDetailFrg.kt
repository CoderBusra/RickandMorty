package com.example.myapplication.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterDetailFrg : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var characterId = 0
    private val viewModel: CharacterDetailVM by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        arguments.let {
            characterId = CharacterDetailFrgArgs.fromBundle(it!!).characterId
        }
        viewModel.getDetail(characterId)

        observer()

    }

    private fun observer() {

        viewModel.characterData.observe(viewLifecycleOwner, Observer { character ->
            character.let {
                binding.data = character
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}