package br.com.anestech.axreg_droid.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.anestech.axreg_droid.R


/**
 * A simple [Fragment] subclass.
 */
class AccountCreateStageOneFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_create_stage_one, container, false)
    }

}// Required empty public constructor
