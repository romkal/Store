package org.mobilenativefoundation.sample.octonaut.xplat.feat.userProfile.api

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import me.tatarka.inject.annotations.Inject
import org.mobilenativefoundation.sample.octonaut.xplat.domain.user.api.User
import com.slack.circuit.runtime.presenter.Presenter as CircuitPresenter
import com.slack.circuit.runtime.ui.Ui as CircuitUi

@Inject
interface UserProfileScreen : Screen {

    val login: String

    sealed interface State : CircuitUiState {
        data object Initial : State
        data class Loaded(
            val user: User,
            val eventSink: (Event) -> Unit,
        ) : State

        data class Loading(
            val eventSink: (Event) -> Unit
        ) : State
    }

    sealed interface Event : CircuitUiEvent {
        data object Follow : Event
        data object Unfollow : Event
    }

    interface Ui : CircuitUi<State>
    interface Presenter : CircuitPresenter<State>
}

expect class LaunchUserProfileScreen(
    login: String
): UserProfileScreen