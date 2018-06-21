package br.com.anestech.axreg_droid.fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.validator.DefaultValidation
import br.com.anestech.axreg_droid.validator.ValidCpf
import br.com.anestech.axreg_droid.validator.ValidPhone
import br.com.caelum.stella.format.CPFFormatter
import br.com.caelum.stella.validation.CPFValidator
import br.com.caelum.stella.validation.InvalidStateException
import br.com.vinipaulino.mobile.financask.extension.formataParaBrasileiro
import kotlinx.android.synthetic.main.fragment_account_create_stage_one.*
import kotlinx.android.synthetic.main.fragment_account_create_stage_one.view.*
import java.lang.IllegalArgumentException
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

        addValidationDefault(edt_register_name)

        configFieldCpf()

        configFieldPhone()


        addValidationDefault(edt_register_date_of_birth)

        addValidationDefault(edt_register_email)

        addValidationDefault(edt_register_confirm_email)

        addValidationDefault(edt_register_password)

        addValidationDefault(edt_register_confirm_password)
    }

    private fun configFieldPhone() {
        val validator = ValidPhone(edt_register_phone)
        edt_register_phone
        edt_register_phone.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                validator.isValid()
            }
        }
    }

    private fun configFieldCpf() {
        val validator = ValidCpf(edt_register_cpf)
        val cpfFormatter = CPFFormatter()
        edt_register_cpf.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                addFormatting(cpfFormatter)
            } else {
                validator.isValid()
            }
        }
    }

    private fun addFormatting(cpfFormatter: CPFFormatter) {
        try {
            val cpfSemFormato = cpfFormatter.unformat(edt_register_cpf.text.toString())
            edt_register_cpf.setText(cpfSemFormato)
        } catch (e: IllegalArgumentException) {
            Log.e("Erro Formatação cpf", e.message)
        }
    }


    private fun addValidationDefault(campo: EditText) {
        val validator = DefaultValidation(campo)
        campo.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validator.isValid()
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
