package org.mobilenativefoundation.storex.paging

data class PagingConfig(
    val pageSize: Int = DEFAULT_PAGE_SIZE,
    val prefetchDistance: Int = pageSize * DEFAULT_PREFETCH_DISTANCE_MULTIPLIER,
    val initialLoadSize: Int = pageSize * DEFAULT_INITIAL_PAGE_MULTIPLIER,
    val maxSize: Int = MAX_SIZE_UNBOUNDED,
    val jumpThreshold: Int = COUNT_UNDEFINED,
    val enablePlaceholders: Boolean = true,
    val errorHandlingStrategy: ErrorHandlingStrategy = ErrorHandlingStrategy.RetryLast(),
    val insertionStrategy: InsertionStrategy = InsertionStrategy.APPEND,
) {
    companion object {
        const val MAX_SIZE_UNBOUNDED: Int = Int.MAX_VALUE
        internal const val DEFAULT_INITIAL_PAGE_MULTIPLIER = 3
        internal const val COUNT_UNDEFINED = Int.MIN_VALUE
        const val DEFAULT_PAGE_SIZE = 10
        const val DEFAULT_PREFETCH_DISTANCE_MULTIPLIER = 2
    }
}