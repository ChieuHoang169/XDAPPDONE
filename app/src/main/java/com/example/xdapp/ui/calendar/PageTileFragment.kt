package com.example.xdapp.ui.calendar

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.xdapp.R

/**
 * A simple [Fragment] subclass.
 */
class PageTileFragment : Fragment() {
    private lateinit var listener:FragmentChangeListener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page_tile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var imageButton_add = view.findViewById<ImageButton>(R.id.imageButton_add)
        imageButton_add.setOnClickListener {
           Navigation. findNavController(it).navigate(R.id.tile1)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            listener = activity as FragmentChangeListener
            listener.onHideBottomNavigation()
        } catch (e:ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement FragmentChangeListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        try {
            listener.onShowBottomNavigation()
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement FragmentChangeListener")
        }
    }

    interface FragmentChangeListener {
        fun onHideBottomNavigation()
        fun onShowBottomNavigation()
    }

}
