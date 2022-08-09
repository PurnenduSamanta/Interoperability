package com.purnendu.interoperability

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.sp
import com.purnendu.interoperability.databinding.FragmentMyBinding

class MyFragment : Fragment(R.layout.fragment_my) {


    private var _binding: FragmentMyBinding? = null

    private val binding: FragmentMyBinding
        get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyBinding.inflate(inflater, container, false)

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Text(text = "This is a Compose Text", fontSize = 20.sp)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {

            startActivity(Intent(context,ComposeActivity::class.java))

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}