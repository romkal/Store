plugins {
    id("plugin.scoop.android.library")
    id("plugin.scoop.kotlin.multiplatform")
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose)
    id("com.apollographql.apollo3") version "3.8.2"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                api(compose.components.resources)
                api(libs.circuit.foundation)
                api(libs.apollo.runtime)
                api(libs.kotlinx.serialization.core)
                api(project(":experimental:sample:scoop:xplat:foundation:di"))
                api("io.github.pdvrieze.xmlutil:serialization:0.86.3")

            }
        }
    }
}

android {
    namespace = "monster.scoop.xplat.foundation.networking.api"
}

apollo {
    service("service") {
        packageName.set("monster.scoop.xplat.foundation.networking.api")
        schemaFiles.from(file("src/commonMain/graphql/schema.graphqls"))
    }
}