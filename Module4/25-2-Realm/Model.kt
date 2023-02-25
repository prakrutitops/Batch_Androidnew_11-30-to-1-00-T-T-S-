package com.example.realmdb

import io.realm.RealmObject

open class Model : RealmObject()
{
    var id=0
    var name=""
    var pass=""
}