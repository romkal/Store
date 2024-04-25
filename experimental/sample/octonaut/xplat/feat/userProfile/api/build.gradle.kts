plugins {
    id("plugin.octonaut.android.library")
    id("plugin.octonaut.kotlin.multiplatform")
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                api(compose.components.resources)
                api(libs.circuit.foundation)
                api(libs.kotlinInject.runtime)
                api(project(":experimental:sample:octonaut:xplat:foundation:networking:api"))
                api(project(":experimental:sample:octonaut:xplat:foundation:di:api"))
                api(project(":store"))
                api(project(":experimental:sample:octonaut:xplat:domain:user:api"))
                api(project(":experimental:sample:octonaut:xplat:domain:feed:api"))
            }
        }
    }
}

android {
    namespace = "org.mobilenativefoundation.sample.octonaut.xplat.feat.userProfile.api"
}