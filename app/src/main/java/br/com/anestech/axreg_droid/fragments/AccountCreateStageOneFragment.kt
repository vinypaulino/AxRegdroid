package br.com.anestech.axreg_droid.fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
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
        var view: View = inflater.inflate(R.layout.fragment_account_create_stage_one, container, false)

        initDateRegistrer(view)

        val adapter = createAdapterForSpinner()
        view.spinner.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textInputNomeCompleto: TextInputLayout = nameWrapper
        var campoNomeCompleto = textInputNomeCompleto.editText

        addValidationDefault(campoNomeCompleto)

        edt_register_cpf.setOnFocusChangeListener { v, hasFocus ->
            var cpf = edt_register_cpf.text.toString()
            if (!hasFocus) {
                if (cpf.isEmpty()) {
                    edt_register_cpf.error = "Campo obrigatório"
                    return@setOnFocusChangeListener
                }
            }

            if (cpf.length != 11) {
                edt_register_cpf.error = "Cpf inválido"
            }

        }

        addValidationDefault(edt_register_phone)

        addValidationDefault(edt_register_date_of_birth)

        addValidationDefault(edt_register_email)

        addValidationDefault(edt_register_confirm_email)

        addValidationDefault(edt_register_password)

        addValidationDefault(edt_register_confirm_password)
    }

    private fun addValidationDefault(campo: EditText?) {
        campo?.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                var text = campo.text.toString()
                if (text.isEmpty()) {
                    campo?.error = "Campo Obrigatório"
                }
            }
        }
    }


    private fun createAdapterForSpinner(): ArrayAdapter<CharSequence>? {
        return ArrayAdapter.createFromResource(context,
                R.array.list_country,
                android.R.layout.simple_spinner_dropdown_item)
    }

    private fun initDateRegistrer(view: View) {
        hoje = Calendar.getInstance().formataParaBrasileiro()
        view.edt_register_date_of_birth.setText(hoje)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        edt_register_date_of_birth?.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                openDataPickerDialog()
            }

        }

    }

    private fun openDataPickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DATE)

        DatePickerDialog(context,
                DatePickerDialog.OnDateSetListener { _, ano, mes, dia ->
                    val dataSelecionada = Calendar.getInstance()
                    dataSelecionada.set(ano, mes, dia)
                    edt_register_date_of_birth
                            .setText(dataSelecionada.formataParaBrasileiro())
                }
                , year, month, dayOfMonth)
                .show()
    }

}// Required empty public constructor
