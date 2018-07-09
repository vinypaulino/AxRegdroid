package br.com.anestech.axreg_droid.fragments.register

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSmoothScroller
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.anestech.axcalc.AppCache
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.adapter.ListaCrmAdapter
import br.com.anestech.axreg_droid.models.CrmAnesthetist
import br.com.anestech.axreg_droid.models.State
import io.realm.internal.Util
import kotlinx.android.synthetic.main.fragment_account_create_stage_two.*
import kotlinx.android.synthetic.main.fragment_account_create_stage_two.view.*
import java.util.*

class AccountCreateStageTwoFragment : Fragment() {

    lateinit var crmAdapter: ListaCrmAdapter
    private lateinit var crms: MutableList<CrmAnesthetist>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_account_create_stage_two, container, false)


        val adapter = createAdapterForSpinner()
        view.spinner.adapter = adapter



        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnAdd.setOnClickListener{
            Toast.makeText(context, "Adicionar CRM", Toast.LENGTH_LONG).show()
        }

        val stateSP : State = State(2, "Sao Paulo", "SP")
        val stateRJ : State = State(3, "Rio de Janeiro", "RJ")

        val crmRj : CrmAnesthetist = CrmAnesthetist(uuid = UUID.randomUUID().toString(), updateAt = Calendar.getInstance().time, active = true, crm = "345656", state = stateRJ)
        val crmSp : CrmAnesthetist = CrmAnesthetist(uuid = UUID.randomUUID().toString(), updateAt = Calendar.getInstance().time, active = true, crm = "485296", state = stateSP)

        var listadeCrm : MutableList<CrmAnesthetist>? = mutableListOf(crmRj, crmSp)


        System.out.println(listadeCrm)

        crmAdapter = ListaCrmAdapter(context = context!!, list = listadeCrm!!)

        lista_cmr_recyclerview.adapter = crmAdapter

    }

    private fun createAdapterForSpinner(): ArrayAdapter<CharSequence>? {
        return ArrayAdapter.createFromResource(context,
                R.array.list_state,
                android.R.layout.simple_spinner_dropdown_item)
    }
}
