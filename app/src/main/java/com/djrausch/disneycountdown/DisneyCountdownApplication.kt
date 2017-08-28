package com.djrausch.disneycountdown

import android.app.Application
import net.danlew.android.joda.JodaTimeAndroid


class DisneyCountdownApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this);
    }
}