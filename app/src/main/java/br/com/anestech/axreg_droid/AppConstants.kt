package br.com.anestech.axcalc

/**
 * Created by felipe on 22/08/17.
 */
class AppConstants {
    companion object {

        //TODO - Vericiar o app_token para o AxReg
        const val APP_TOKEN = "484063e388273ca0614ec7af"
        private const val URL_BASE = "https://axserver.anestech.com.br/"

        const val URL_ADD_DEVICE = URL_BASE + "api/addDevice/"
        const val URL_IS_REGISTERED = URL_BASE + "api/is_registered/"
        const val URL_NEW_REGISTRATION = URL_BASE + "api/new_pre_registration/"

        const val URL_PUBLICITY = URL_BASE + "pt-BR/api/publicities/ipad"
        const val URL_TERMOS= URL_BASE + "api/terms"

    }
}