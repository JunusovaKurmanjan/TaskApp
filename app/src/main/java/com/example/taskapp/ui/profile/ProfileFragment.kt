package com.example.taskapp.ui.profile

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentProfileBinding
import com.example.taskapp.databinding.TaskItemBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    val selectImageFromGalleryResult = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            Log.e("ololo", "Photo url = : $uri", )
      //      binding.imgProfile.setImageURI(uri)

            Glide
                .with(requireContext())
                .load(uri)
                .circleCrop()
                .into(binding.imgProfile);

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        initViews()
        initListeners()

        return binding.root


    }

    private fun initListeners() {
        binding.imgProfile.setOnClickListener {
            selectImageFromGalleryResult.launch("image/*")
        }
    }

    private fun initViews() {
        TODO("Not yet implemented")
    }
}