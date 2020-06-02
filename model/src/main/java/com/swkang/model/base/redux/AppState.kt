package com.example.mvvm.model.base.redux

import com.swkang.model.base.redux.State

/**
 * @author beemo
 * @since 2020-02-24
 */
class AppState(
    val states: Map<String, State>
) : State {

    inline fun <reified S : State> getCurrentState(): S? {
        for (state in states.values) {
            if (state is S) return state
        }
        return null
    }

    inline fun <reified S : State> getStateBy(key: String): S? {
        val currentState = states.get(key) ?: return null
        return currentState as S
    }

}