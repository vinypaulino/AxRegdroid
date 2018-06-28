package br.com.anestech.axreg_droid.fragments.register

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.anestech.axreg_droid.R

class AccountCreateStageTwoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_account_create_stage_two, container, false)

        return view
    }
}
