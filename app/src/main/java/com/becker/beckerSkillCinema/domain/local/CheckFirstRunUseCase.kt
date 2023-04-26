package com.becker.beckerSkillCinema.domain.local

import com.becker.beckerSkillCinema.data.PreferenceManager
import javax.inject.Inject

class CheckFirstRunUseCase @Inject constructor(
    private val preferenceManager: PreferenceManager
) {

    fun execute() = preferenceManager.checkFirstRun()
}