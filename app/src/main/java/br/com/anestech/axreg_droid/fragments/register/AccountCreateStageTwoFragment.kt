package br.com.anestech.axreg_droid.fragments.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.database.DbState
import br.com.anestech.axreg_droid.validator.DefaultValidation
import kotlinx.android.synthetic.main.fragment_account_create_stage_three.*
import kotlinx.android.synthetic.main.fragment_account_create_stage_two.*

class AccountCreateStageTwoFragment : Fragment(), AdapterView.OnItemSelectedListener {


    //lateinit var crmAdapter: ListaCrmAdapter
    private var listState = arrayOf("PA","TO", "SP")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_account_create_stage_two, container, false)




        return view
    }

    private fun configSpinner() {
        //spinner = this.spinner

        spinner!!.onItemSelectedListener = this

        //Criando ArrayAdapter com Lista
//        val arrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, listState)
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Criando ArrayAdapter com Resource
        val arrayAdapter = ArrayAdapter.createFromResource(context, R.array.list_state, android.R.layout.simple_spinner_dropdown_item)

        spinner?.adapter = arrayAdapter
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.e("ItemSelecionado", "Acronym State Selecionado $" + listState[position])
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configSpinner()
    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        btnAdd.setOnClickListener{
//
//            //testar campo null
//            if (DefaultValidation(edt_register_crm).isValid()){
//                Toast.makeText(context, "Adicionar CRM", Toast.LENGTH_LONG).show()
//
//                val stateSP : State = State(2, "Sao Paulo", "SP")
//                val stateRJ : State = State(3, "Rio de Janeiro", "RJ")
//
//                val crmRj : CrmAnesthetist = CrmAnesthetist(uuid = UUID.randomUUID().toString(), updateAt = Calendar.getInstance().time, active = true, crm = edt_register_crm.text.toString(), state = stateRJ)
//                val crmSp : CrmAnesthetist = CrmAnesthetist(uuid = UUID.randomUUID().toString(), updateAt = Calendar.getInstance().time, active = true, crm = "485296", state = stateSP)
//
//                DbHelper.save(crmRj)
//
//                Log.e("tamanho da lista", listCrms?.size.toString())
//
//
//                listCrms = DbCrmAnesthetist().getListCrm()
//                crmAdapter = ListaCrmAdapter(context = context!!, list = listCrms!!)
//
//                lista_cmr_recyclerview.adapter = crmAdapter
//
//            }
//        }
//    }

}
