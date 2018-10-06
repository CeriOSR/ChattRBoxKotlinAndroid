package com.ceriosrey.chattrbox

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class ChattRItem : RealmModel {
    @PrimaryKey
    var itemId: String = ""
    var itemName: String = ""
    var itemCategory: String = ""
    var itemImageFileName: String = ""
    var itemAudioFileName: String = ""
}

class ChattRBoxItems(val itemId: String, val itemName: String, val itemCategory: String, val itemImageFileName: String, val itemAudioFileName: String)

