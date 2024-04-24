plugins {
    id("plugin.octonaut.android.library")
    id("plugin.octonaut.kotlin.multiplatform")
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.plugin.parcelize)
}

kotlin {
    androidTarget {
        plugins.apply(libs.plugins.paparazzi.get().pluginId)
    }

    sourceSets {

        commonMain {
            dependencies {
                implementation(compose.material3)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinInject.runtime)

                api(project(":experimental:market:warehouse"))
                api(project(":experimental:sample:octonaut:xplat:common:market"))
                api(project(":experimental:sample:octonaut:xplat:feat:homeTab:api"))
                api(project(":experimental:sample:octonaut:xplat:foundation:di:api"))
                implementation(libs.coil.compose)
                implementation(libs.coil.network)
                implementation(libs.ktor.core)
            }
        }

        androidUnitTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

dependencies {
    add("kspAndroid", libs.kotlinInject.compiler)
    add("kspIosX64", libs.kotlinInject.compiler)
    add("kspIosArm64", libs.kotlinInject.compiler)
}

android {
    namespace = "org.mobilenativefoundation.sample.octonaut.xplat.feat.homeTab.impl"
}