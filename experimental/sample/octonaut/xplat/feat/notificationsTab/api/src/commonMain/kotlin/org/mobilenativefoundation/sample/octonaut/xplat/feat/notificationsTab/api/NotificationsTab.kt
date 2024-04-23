package org.mobilenativefoundation.sample.octonaut.xplat.feat.notificationsTab.api

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import org.mobilenativefoundation.sample.octonaut.xplat.domain.user.api.User
import com.slack.circuit.runtime.presenter.Presenter as CircuitPresenter
import com.slack.circuit.runtime.ui.Ui as CircuitUi

interface NotificationsTab : Screen {
    sealed interface State : CircuitUiState {
        data object Initial : State
        data class Loaded(
            val user: User,
        ) : State
    }

    sealed interface Event : CircuitUiEvent

    interface Ui : CircuitUi<State>
    interface Presenter : CircuitPresenter<State>
}