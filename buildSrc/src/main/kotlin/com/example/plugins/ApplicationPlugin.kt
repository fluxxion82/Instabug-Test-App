package com.example.plugins

import com.android.build.gradle.AppExtension
import com.example.plugins.base.BaseAndroidPlugin
import org.gradle.api.Project
import java.io.File

open class ApplicationPlugin : BaseAndroidPlugin() {

    override fun apply(project: Project) {
        project.plugins.apply("com.android.application")
        super.apply(project)

        project.extensions.configure(AppExtension::class.java) { extension ->
            File(project.projectDir, "proguard").list()?.forEach { fileName ->
                extension.buildTypes.all { type ->
                    type.proguardFile(fileName)
                }
            } ?: project.logger.warn("Empty `/proguard` folder, no .pro files applied")
        }
    }
}
