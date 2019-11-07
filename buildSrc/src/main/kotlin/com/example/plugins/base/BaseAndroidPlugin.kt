package com.example.plugins.base

import Libs
import com.android.build.gradle.TestedExtension
import com.android.builder.model.LintOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import java.io.File
import java.net.URI

abstract class BaseAndroidPlugin : BasePlugin() {

    override fun apply(project: Project) {
        project.plugins.apply("kotlin-android")
        super.apply(project)

        project.repositories.maven { maven ->
            maven.url = URI.create("http://dl.bintray.com/apollographql/android")
        }

        project.extensions.getByType(TestedExtension::class.java).apply {
            compileSdkVersion(COMPILE_SDK_VERSION)
            defaultConfig.apply {
                minSdkVersion(MIN_SDK_VERSION)
                targetSdkVersion(COMPILE_SDK_VERSION)
            }

            useLibrary("android.test.runner")
            useLibrary("android.test.base")
            useLibrary("android.test.mock")

            configureSourceSets(project)
            configureAndroidLint(project)

            compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
            compileOptions.targetCompatibility = JavaVersion.VERSION_1_8
        }

        project.dependencies.apply {
            add("implementation", Libs.coroutinesAndroid)
            add("implementation", Libs.daggerAndroid)
            add("implementation", Libs.daggerAndroidSupport)
            add("kapt", Libs.Kapt.daggerAndroidCompiler)
            add("kaptAndroidTest", Libs.Kapt.daggerAndroidCompiler)
            add("testImplementation", Libs.Tests.testingCore)

            add("androidTestImplementation", Libs.Tests.assertJ)
            add("androidTestImplementation", Libs.AndroidTests.testCore)
            add("androidTestImplementation", Libs.AndroidTests.testRunner)
            add("androidTestImplementation", Libs.AndroidTests.testRules)

            add("androidTestImplementation", Libs.AndroidTests.junit)

            add("androidTestImplementation", Libs.AndroidTests.mockito)
            add("androidTestImplementation", Libs.AndroidTests.mockitoAndroid)
        }
    }

    private fun TestedExtension.configureAndroidLint(project: Project) {
        val file = File(project.projectDir, "androidlint-baseline.xml")
        if (file.exists() || project.hasProperty("refreshBaseline")) {
            // Command for refreshing baselines:
            // rm **/androidlint-*.xml ; ./gradlew :projectLint -PrefreshBaseline --continue
            lintOptions.apply {
                baselineFile = file
            }
        }
        lintOptions.apply {
            disable("InvalidPackage", "UseSparseArrays")
            severityOverrides["MissingTranslation"] = LintOptions.SEVERITY_INFORMATIONAL
        }
    }

    private fun TestedExtension.configureSourceSets(project: Project) {
        sourceSets.all { set ->
            val withKotlin = set.java.srcDirs.map { it.path.replace("java", "kotlin") }
            set.java.setSrcDirs(set.java.srcDirs + withKotlin)
        }

        File(project.projectDir, "src/main/res/layouts").list()?.forEach {
            sourceSets.getByName("main").res.srcDir("src/main/res/layouts/$it")
        }
    }

    companion object {
        private const val COMPILE_SDK_VERSION = 28
        private const val MIN_SDK_VERSION = 21
    }
}

