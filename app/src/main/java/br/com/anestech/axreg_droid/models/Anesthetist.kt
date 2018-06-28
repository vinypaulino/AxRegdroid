package br.com.anestech.axreg_droid.models

import br.com.anestech.axcalc.AppConstants
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by vinicius on 06/06/18.
 */
open class Anesthetist(
        @PrimaryKey
        var id: Long = 0,
        var uuid: String = "",
        var serverId: Int = AppConstants.emptyServerId,
        var active: Boolean = true,
        var updateAt: Date? = null,
        var originType: String = "",
        var createUserId: Int = 0,
        var uploadUserId: Int = 0,

        var name: String = "",
        var cpf: String = "",
        var email: String = "",
        var crm_number: String = "",
        var phone: String = "",
        var crmState: State? = null,
        var state: State? = null,
        var country: Country? = null,
        var rqe: String = "",
        var userId: Int = 0,
        var signature: String = "",
        var signatureDate: Date? = null,
        var recommendLimit: Int = 5,
        var lastValidationAlert: Date? = null,
        var birthDate: Date? = null,
        var crms: RealmList<CrmAnesthetist> = RealmList()

) : RealmObject()