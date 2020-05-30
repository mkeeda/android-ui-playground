package io.github.mkeeda.androiduiplayground.ui.imagepreview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import io.github.mkeeda.androiduiplayground.R
import io.github.mkeeda.androiduiplayground.databinding.ImagePreviewFragmentBinding

class ImagePreviewFragment : Fragment(R.layout.image_preview_fragment) {
    private var _binding: ImagePreviewFragmentBinding? = null
    // This property is only valid between onViewCreated and onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ImagePreviewFragmentBinding.bind(view)

        binding.inButton.setOnClickListener {
            binding.imageView.zoom(scale = 2.0f)
        }

        binding.outButton.setOnClickListener {
            binding.imageView.zoom(scale = 0.5f)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
