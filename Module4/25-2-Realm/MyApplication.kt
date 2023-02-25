package com.example.realmdb

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication :Application()
{

    override fun onCreate()
    {

        Realm.init(this)
        var realmConfiguration = RealmConfiguration.Builder()
                                .name("Tops.db")
                                .deleteRealmIfMigrationNeeded()
                                .schemaVersion(1)
                                .build()

        Realm.setDefaultConfiguration(realmConfiguration)

        super.onCreate()
    }

}