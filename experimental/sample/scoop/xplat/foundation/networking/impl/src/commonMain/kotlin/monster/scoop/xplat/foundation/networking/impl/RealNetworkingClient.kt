package monster.scoop.xplat.foundation.networking.impl

import com.apollographql.apollo3.ApolloClient
import me.tatarka.inject.annotations.Inject
import monster.scoop.xplat.foundation.networking.api.FavoriteStoryMutation
import monster.scoop.xplat.foundation.networking.api.GetStoriesQuery
import monster.scoop.xplat.foundation.networking.api.GetStoryQuery
import monster.scoop.xplat.foundation.networking.api.NetworkingClient

@Inject
class RealNetworkingClient(
    private val apolloClient: ApolloClient,
) : NetworkingClient {
    override suspend fun getStories(query: GetStoriesQuery): GetStoriesQuery.Data? = try {
        apolloClient.query(query).execute().data
    } catch (error: Throwable) {
        println("Error fetching stories: ${error.printStackTrace()}")
        throw error
    }

    override suspend fun getStory(query: GetStoryQuery): GetStoryQuery.Data? {
        return apolloClient.query(query).execute().data
    }

    override suspend fun favoriteStory(mutation: FavoriteStoryMutation): FavoriteStoryMutation.Data? = try {
        apolloClient.mutation(mutation).execute().data
    } catch (error: Throwable) {
        println("Error updating story: ${error.printStackTrace()}")
        throw error
    }
}