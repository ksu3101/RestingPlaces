package com.example.mvvm.model.base.redux

import com.swkang.model.base.redux.Action
import com.swkang.model.base.redux.Reducer
import com.swkang.model.base.redux.State

/**
 * @author beemo
 * @since 2020-02-24
 */
class AppReducer(
    override val initializeState: AppState
) : Reducer<AppState> {

    override fun reduce(oldState: AppState, resultAction: Action): AppState {
        return reduces<State, Reducer<State>>(oldState, resultAction)
    }

    private inline fun <reified S: State, reified R: Reducer<S>> reduces(
        oldState: AppState,
        resultAction: Action
    ): AppState {
        val states = mutableMapOf<String, S>()
        getReducers<S, R>().map {
            val reducerName = it.javaClass.simpleName
            states.put(
                reducerName,
                it.reduce(oldState.getStateBy(reducerName) ?: it.initializeState, resultAction)
            )
        }
        return AppState(states)
    }

}