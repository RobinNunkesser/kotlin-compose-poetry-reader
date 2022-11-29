plugins {
    kotlin("multiplatform")
    id("com.android.library")
    //id("dev.icerock.mobile.multiplatform-resources") version "0.20.1"
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "infra"
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "de.hshl.isd.poetryreader.infra"
    compileSdk = 32
    defaultConfig {
        minSdk = 26
        targetSdk = 32
    }
}

dependencies {
    implementation("com.beust:klaxon:5.5")
    implementation(project(":domain"))
    testImplementation("junit:junit:4.13")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
    commonMainApi("dev.icerock.moko:resources:0.20.1")
    commonTestImplementation("dev.icerock.moko:resources-test:0.20.1")
}

//multiplatformResources {
//    multiplatformResourcesPackage = "de.hshl.isd.poetryreader.infra" // required
//}