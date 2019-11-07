package com.example.plugins

import com.android.build.gradle.LibraryExtension
import com.example.plugins.base.BaseAndroidPlugin
import org.gradle.api.Project

open class LibraryPlugin : BaseAndroidPlugin() {

    override fun apply(project: Project) {
        project.plugins.apply("com.android.library")
        super.apply(project)
        project.extensions.getByType(LibraryExtension::class.java).apply {
            libraryVariants.all {
                it.generateBuildConfigProvider.configure { it.enabled = false }
            }
//            variantFilter {
//                it.setIgnore(it.buildType.name != "debug" || it.flavors.isNotEmpty())
//            }
        }
    }
}
