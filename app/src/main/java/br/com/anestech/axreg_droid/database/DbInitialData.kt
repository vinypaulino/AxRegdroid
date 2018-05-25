package br.com.anestech.axcalc.database

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
        //Funcao para adicionar dados iniciais ao projeto
    }


}