package br.com.anestech.axreg_droid.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.models.CrmAnesthetist
import kotlinx.android.synthetic.main.layout_item_crm.view.*

class ListaCrmAdapter(var context: Context, var list: List<CrmAnesthetist>) : RecyclerView.Adapter<ListaCrmAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.layout_item_crm, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val crmFormatado = "${list[position].crm}/ ${list[position].state?.acronym}"
        holder.tvCrm.text = crmFormatado
        holder.btnRemoveCrm.setOnClickListener {
            Toast.makeText(context, "Crm Clicado ! ${list[position].crm}", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCrm = itemView.txt_crm_state
        val btnRemoveCrm = itemView.btn_remove_crm
    }
}

