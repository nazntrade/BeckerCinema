package com.becker.beckerSkillCinema.data

import android.content.Context
import android.content.SharedPreferences
import com.becker.beckerSkillCinema.utils.ConstantsAndParams
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferenceManager @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(ConstantsAndParams.SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    fun checkFirstRun() =
        sharedPreferences.getBoolean(ConstantsAndParams.FIRST_RUN, true)

    fun finishFirstRun() {
        val firstRunEditor = sharedPreferences.edit()
        with(firstRunEditor) {
            putBoolean(ConstantsAndParams.FIRST_RUN, false)
            apply()
        }
    }
}