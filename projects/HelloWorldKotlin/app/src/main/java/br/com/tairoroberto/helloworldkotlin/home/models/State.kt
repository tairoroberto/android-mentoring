package br.com.tairoroberto.helloworldkotlin.home.models

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

data class State<out T>(
    val status: Status,
    val loading: Boolean?,
    val data: T?,
    val error: Throwable?
) {
    companion object {
        fun <T> success(data: T?, loading: Boolean = false): State<T> {
            return State(Status.SUCCESS, loading = loading, data = data, error = null)
        }

        fun <T> error(error: Throwable, loading: Boolean = false): State<T> {
            return State(Status.ERROR, loading = loading, data = null, error = error)
        }

        fun <T> loading(loading: Boolean): State<T> {
            return State(Status.LOADING, loading = loading, data = null, error = null)
        }
    }
}