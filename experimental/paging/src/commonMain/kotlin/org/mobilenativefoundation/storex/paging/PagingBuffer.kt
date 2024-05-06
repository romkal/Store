package org.mobilenativefoundation.storex.paging

/**
 * A custom data structure for efficiently storing and retrieving paging data.
 * The [PagingBuffer] is responsible for caching and providing access to the loaded pages of data.
 * It allows retrieving data by load parameters, page key, or accessing the entire buffer.
 */
interface PagingBuffer<Id : Comparable<Id>, K : Any, V : Identifiable<Id>, E : Any> {
    fun get(params: PagingSource.LoadParams<K>): StoreX.Paging.Data.Page<Id, K, V>?

    fun get(key: K): StoreX.Paging.Data.Page<Id, K, V>?

    fun get(id: Id): StoreX.Paging.Data.Item<Id, V>?
    fun getPageContaining(id: Id): StoreX.Paging.Data.Page<Id, K, V>?
    fun getNextPage(page: StoreX.Paging.Data.Page<Id, K, V>): StoreX.Paging.Data.Page<Id, K, V>?

    fun head(): StoreX.Paging.Data.Page<Id, K, V>?

    fun getAll(): List<StoreX.Paging.Data.Page<Id, K, V>>

    fun getAllItems(): List<StoreX.Paging.Data.Item<Id, V>>

    fun isEmpty(): Boolean

    fun indexOf(key: K): Int
    fun positionOf(id: Id): Int
    fun minDistanceBetween(a: Id, b: Id): Int

    fun getItemsInRange(
        anchorPosition: K,
        prefetchPosition: K?,
        pagingConfig: PagingConfig
    ): List<StoreX.Paging.Data.Item<Id, V>>
}