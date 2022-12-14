package org.mobilenativefoundation.store.store5

import org.mobilenativefoundation.store.store5.impl.RealMarket
import kotlinx.coroutines.flow.Flow

/**
 * Integrates stores and a bookkeeper.
 * @see [RealMarket]
 * @see [Store]
 * @see [Bookkeeper]
 */
interface Market<Key : Any, Input : Any, Output : Any> {
    suspend fun read(reader: ReadRequest<Key, Input, Output>): Flow<MarketResponse>
    suspend fun write(writer: WriteRequest<Key, Input, Output>): Boolean
    suspend fun delete(key: Key): Boolean
    suspend fun delete(): Boolean

    companion object {
        fun <Key : Any, Input : Any, Output : Any> of(
            stores: List<Store<Key, Input, Output>>,
            bookkeeper: Bookkeeper<Key>,
            fetcher: NetworkFetcher<Key, Input>,
            updater: NetworkUpdater<Key, Input>
        ): Market<Key, Input, Output> = RealMarket(stores, bookkeeper, fetcher, updater)
    }
}
