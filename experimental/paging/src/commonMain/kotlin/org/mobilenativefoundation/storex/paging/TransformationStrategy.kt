package org.mobilenativefoundation.storex.paging

/**
 * A strategy for applying custom transformations or mappings to the paged data.
 */
fun interface TransformationStrategy<Id : Comparable<Id>, V : Identifiable<Id>> {
    operator fun invoke(data: List<StoreXPaging.Data.Item<Id, V>>): List<StoreXPaging.Data.Item<Id, V>>
}