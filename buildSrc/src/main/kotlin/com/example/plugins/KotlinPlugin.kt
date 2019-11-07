package com.example.plugins

import Libs
import com.example.plugins.base.BasePlugin
import org.gradle.api.Project

open class KotlinPlugin : BasePlugin() {
    override fun apply(project: Project) {
        project.pluginManager.apply("kotlin")
        project.pluginManager.apply("com.android.lint")

        super.apply(project)

        project.dependencies.add("implementation", Libs.javaxInject)
        project.dependencies.add("implementation", Libs.androidAnnotations)
    }
}
