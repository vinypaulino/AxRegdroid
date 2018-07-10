package br.com.anestech.axcalc.database

import br.com.anestech.axreg_droid.models.State
import io.realm.Realm

/**
 *
 *
 * Contains the application initial data, automatically executed on the first opening of the app, only once.
 * Used on AppCache with Realm configuration
 */
class DbInitialData : Realm.Transaction {
    override fun execute(realm: Realm) {
        dadosIniciais(realm)
    }

    private fun dadosIniciais(realm: Realm) {
        var id_state : Long = 0

        /** Criando os estados no banco de dados **/
        val state1 = realm.createObject(State::class.java, id_state++)
        state1.name = "Acre"
        state1.acronym = "AC"


        val state2 = realm.createObject(State::class.java, id_state++)
        state2.name = "Sao Paulo"
        state2.acronym = "SP"

    }


}