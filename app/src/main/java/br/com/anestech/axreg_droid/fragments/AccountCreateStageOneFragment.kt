package br.com.anestech.axreg_droid.fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.anestech.axreg_droid.R
import br.com.vinipaulino.mobile.financask.extension.formataParaBrasileiro
import kotlinx.android.synthetic.main.fragment_account_create_stage_one.*
import kotlinx.android.synthetic.main.fragment_account_create_stage_one.view.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class AccountCreateStageOneFragment : BaseFragment() {

    var hoje: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_account_create_stage_one, container, false)


        hoje = Calendar.getInstance().formataParaBrasileiro()
        view.edt_register_date_of_birth.setText(hoje)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        edt_register_date_of_birth.setOnClickListener {
            val ano = 2018
            val mes = 5
            val dia = 19

            edt_register_date_of_birth.setText(hoje)
            edt_register_date_of_birth
                    .setOnClickListener {
                        DatePickerDialog(context,
                                DatePickerDialog.OnDateSetListener { view, ano, mes, dia ->
                                    val dataSelecionada = Calendar.getInstance()
                                    dataSelecionada.set(ano, mes, dia)
                                    edt_register_date_of_birth
                                            .setText(dataSelecionada.formataParaBrasileiro())
                                }
                                , ano, mes, dia)
                                .show()
                    }
        }
    }

}// Required empty public constructor
