package br.com.anestech.axcalc

/**
 * Created by VinyPaulino
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

        const val emptyServerId = -1

        //Erros de Validação
        const val ERROR_FIELD_REQUIRED = "Campo obrigatório"
        const val ERROR_CPF_INVALID = "Cpf inválido"
        const val ERROR_DIGITS_CPF = "O cpf precisa ter 11 digitos"
        const val ERROR_PHONE_DIGITS = "Telefone deve ter entre 10 a 11 digitos"

        //Configurações AxReg Servidor

        //URL BASE DE Produção https://axreg-server.anestech.com.br/app

        //URL BASE De Homologação http://dev.axreg-server.anestech.com.br/app

    }
}