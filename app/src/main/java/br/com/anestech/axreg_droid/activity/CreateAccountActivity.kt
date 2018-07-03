package br.com.anestech.axreg_droid.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.*
import br.com.anestech.axcalc.models.User
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.extensions.addFragment
import br.com.anestech.axreg_droid.extensions.toast
import br.com.anestech.axreg_droid.fragments.register.AccountCreateStageOneFragment
import br.com.anestech.axreg_droid.fragments.register.AccountCreateStageTwoFragment
import br.com.anestech.axreg_droid.models.Anesthetist
import br.com.anestech.axreg_droid.models.Country
import br.com.anestech.axreg_droid.models.State
import br.com.anestech.axreg_droid.retrofit.response.CallbackResponse
import br.com.anestech.axreg_droid.retrofit.webclient.LoginWebClient
import br.com.anestech.axreg_droid.validator.DefaultValidation
import br.com.anestech.axreg_droid.validator.ValidEmail
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.fragment_account_create_stage_one.*
import kotlinx.android.synthetic.main.fragment_create_account.view.*
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class CreateAccountActivity : BaseActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    private var nameString: String? = null
    private var valid: Boolean = true
    private var cpf: String? = null
    private var phone: String? = null
    private var email: String? = null
    private var birthDate: LocalDate? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        addFragment(R.id.frameCreateAccount, AccountCreateStageTwoFragment())

        btn_register_create_account.setOnClickListener {

            if (formIsValid()) {
                var user = loadUser()

                LoginWebClient().register(user, object : CallbackResponse<User> {
                    override fun success(response: User) {
                        insertUserRealm(response)
                        startActivity<MainActivity>()
                    }

                    override fun failure(throwable: Throwable) {
                        toast("Erro ao comunicar-se com o servidor! \n Verifique sua conexao com a Internet")
                    }

                    override fun responseFailure() {
                        toast("Erro ao Cadastrar usuário")
                        startActivity<MainActivity>()
                    }

                })

                // Fazer a requisição pelo webClient

                //no success abrir a próxima tela


            } else toast("Por favor verifique os campos do formulário")

        }
    }

    private fun loadUser(): User {
        val country = Country()
        country.id = 36
        country.name = "Brasil"

        val state = State()
        state.id = 1
        state.name = "Estado Padrao"
        state.acronym = "EP"


        var anesthetist = Anesthetist()

        anesthetist.name = this.nameString!!
        anesthetist.cpf = this.cpf!!
        anesthetist.phone = this.phone!!
        anesthetist.country = country
        anesthetist.email = this.email!!
        anesthetist.crm_number = "1234"
        val dataFormatada = configDateBirth()
        anesthetist.birthDate = dataFormatada
        anesthetist.state = state


        var user = User()
        user.password = this.password!!
        user.email = this.email!!
        user.anaesthetist = anesthetist
        return user
    }

    private fun insertUserRealm(response: User) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            realm.insertOrUpdate(response)
        }
        realm.close()
    }

    private fun formIsValid(): Boolean {
        valid = true

        if (DefaultValidation(edt_register_name).isValid()) {
            nameString = edt_register_name?.text.toString()
        } else {
            valid = false
        }

        if (DefaultValidation(edt_register_cpf).isValid() || edt_register_cpf.error.isNullOrEmpty()) {
            cpf = edt_register_cpf?.text.toString()
        } else {
            valid = false
        }

        if (DefaultValidation(edt_register_phone).isValid() || edt_register_phone.error.isNullOrEmpty()) {
            phone = edt_register_phone.text.toString()
        } else {
            valid = false
        }

        if (ValidEmail(edt_register_email).isValid()) {
            email = edt_register_email.text.toString()
        } else {
            valid = false
        }

        if (!ValidEmail(edt_register_confirm_email).isValidConfirmEmail(edt_register_email)) {
            valid = false
        }

        if (DefaultValidation(edt_register_password).isValid()) {
             password = edt_register_password.text.toString()
        } else valid = false

        if (!DefaultValidation(edt_register_confirm_password).isValid()) {
            valid = false
        }

        return valid
    }

    private fun configDateBirth(): Date? {
        val dataRecebida = edt_register_date_of_birth.text.toString()
        val formato = SimpleDateFormat("dd/MM/yyyy")
        return formato.parse(dataRecebida)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_create_account, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_create_account, container, false)
            rootView.section_label.text = getString(R.string.section_format, arguments!!.getInt(ARG_SECTION_NUMBER))
            return rootView
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
