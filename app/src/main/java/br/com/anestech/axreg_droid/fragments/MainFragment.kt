package br.com.anestech.axreg_droid.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.anestech.axcalc.database.DbHelper

import br.com.anestech.axreg_droid.R
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main, container, false)
        val user = DbHelper.findUser()
        view.textView.text = "${user?.token}" +
                "email ${user?.email}"
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}
