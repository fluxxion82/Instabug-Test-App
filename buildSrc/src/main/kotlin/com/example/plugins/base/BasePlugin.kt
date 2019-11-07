package com.example.plugins.base

import Libs
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.detekt
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.KotlinterExtension
import org.jmailen.gradle.kotlinter.KotlinterPlugin
import java.io.File

open class BasePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply("kotlin-kapt")

            repositories.google()
            repositories.jcenter()

            extensions.configure(KaptExtension::class.java) {
                it.correctErrorTypes = true
                it.useBuildCache = true
                it.arguments {
                    arg("dagger.formatGeneratedSource", "disabled")
                    arg("dagger.gradle.incremental")
                }
                it.javacOptions {
                    option("-Xmaxerrs", 1000)
                }
            }

            dependencies.add("implementation", Libs.kotlinStdLib)
            dependencies.add("implementation", Libs.coroutinesCore)
            dependencies.add("testImplementation", Libs.Tests.junit)
            dependencies.add("testImplementation", Libs.Tests.mockitoKotlin)
            dependencies.add("testImplementation", Libs.Tests.mockito)
            dependencies.add("testImplementation", Libs.Tests.assertJ)
            dependencies.add("testImplementation", Libs.Tests.coroutinesTest)
            dependencies.add("implementation", Libs.dagger)
            dependencies.add("kapt", Libs.Kapt.daggerCompiler)

            tasks.withType(KotlinCompile::class.java).all {
                it.kotlinOptions.freeCompilerArgs += arrayOf(
                    "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi"
                )
                it.kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
    }
}
