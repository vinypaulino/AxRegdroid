package br.com.anestech.axreg_droid.fragments.register

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.anestech.axcalc.database.DbHelper
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.adapter.ListaCrmAdapter
import br.com.anestech.axreg_droid.database.DbCrmAnesthetist
import br.com.anestech.axreg_droid.database.DbState
import br.com.anestech.axreg_droid.models.CrmAnesthetist
import br.com.anestech.axreg_droid.models.State
import br.com.anestech.axreg_droid.validator.DefaultValidation
import kotlinx.android.synthetic.main.fragment_account_create_stage_two.*
import kotlinx.android.synthetic.main.fragment_account_create_stage_two.view.*
import java.util.*

class AccountCreateStageTwoFragment : Fragment() {

    lateinit var crmAdapter: ListaCrmAdapter
    private  var listCrms: MutableList<CrmAnesthetist>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_account_create_stage_two, container, false)



        val listState = DbState().getAcronymState()
        Log.e("lista de estado", "Lista de estador $listState")
        val adapter =  ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, listState)


        view.spinner.adapter = adapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnAdd.setOnClickListener{

            //testar campo null
            if (DefaultValidation(edt_register_crm).isValid()){
                Toast.makeText(context, "Adicionar CRM", Toast.LENGTH_LONG).show()

                val stateSP : State = State(2, "Sao Paulo", "SP")
                val stateRJ : State = State(3, "Rio de Janeiro", "RJ")

                val crmRj : CrmAnesthetist = CrmAnesthetist(uuid = UUID.randomUUID().toString(), updateAt = Calendar.getInstance().time, active = true, crm = edt_register_crm.text.toString(), state = stateRJ)
                val crmSp : CrmAnesthetist = CrmAnesthetist(uuid = UUID.randomUUID().toString(), updateAt = Calendar.getInstance().time, active = true, crm = "485296", state = stateSP)


                DbHelper.save(crmRj)

                Log.e("tamanho da lista", listCrms?.size.toString())


                listCrms = DbCrmAnesthetist().getListCrm()
                crmAdapter = ListaCrmAdapter(context = context!!, list = listCrms!!)

                lista_cmr_recyclerview.adapter = crmAdapter

            }
        }
    }

}
