package com.arceapps.fragmentsbasicexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Use the [BasicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BasicFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var typeDocument: String? = null
    private var extDocument: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            typeDocument = it.getString(TYPE_DOCUMENT)
            extDocument = it.getString(EXT_DOCUMENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basic, container, false)
    }

    companion object {
        private const val TYPE_DOCUMENT = "type_document"
        private const val EXT_DOCUMENT = "ext_document"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BasicFragment().apply {
                arguments = Bundle().apply {
                    putString(TYPE_DOCUMENT, typeDocument)
                    putString(EXT_DOCUMENT, extDocument)
                }
            }
    }
}