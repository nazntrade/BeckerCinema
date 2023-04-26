package com.becker.beckerSkillCinema.presentation

import androidx.lifecycle.ViewModel
import com.becker.beckerSkillCinema.domain.local.CheckFirstRunUseCase
import com.becker.beckerSkillCinema.domain.local.FinishFirstRunUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkFirstRunUseCase: CheckFirstRunUseCase,
    private val finishFirstRunUseCase: FinishFirstRunUseCase
) : ViewModel() {

    fun checkFirstRun() = checkFirstRunUseCase.execute()

    fun finishFirstRun() = finishFirstRunUseCase.execute()
}