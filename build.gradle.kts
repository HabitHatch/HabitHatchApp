import org.gradle.kotlin.dsl.android
import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("com.android.application") version "8.7.3"
    id("org.jetbrains.dokka") version "2.0.0"
    id("androidx.room") version "2.6.1"
    id("org.jetbrains.kotlin.android") version "2.1.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.0"
    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
    id("com.google.dagger.hilt.android") version "2.53.1"
    id("io.gitlab.arturbosch.detekt") version ("1.23.7")
}

group = "com.habithatch"
version = "0.2.1"

room {
    schemaDirectory("$projectDir/schemas")
}

android {
    namespace = "com.habithatch.demo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.habithatch.demo"
        minSdk = 34
        targetSdk = 35
        versionCode = 2
        versionName = "0.2.1"
        group = "com.habithatch.demo"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    @Suppress("UnstableApiUsage")
    testOptions {
        managedDevices {
            localDevices {
                create("pixel2api34") {
                    device = "Pixel 2"
                    apiLevel = 34
                    systemImageSource = "aosp-atd"
                }
            }
        }
    }
}

detekt {
    config.setFrom("detekt.yml")
}

configurations.all {
    resolutionStrategy {
        force("com.squareup:javapoet:1.13.0")
    }
}
repositories {
    google()
    mavenCentral()
}
dependencies {
    implementation("com.squareup:javapoet:1.13.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    implementation("com.google.dagger:hilt-android:2.54")
    ksp("com.google.dagger:hilt-compiler:2.54")

    // Testing Dependencies
    testImplementation("com.google.dagger:hilt-android-testing:2.54")
    kspTest("com.google.dagger:hilt-compiler:2.54")

    // UI
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation(platform("androidx.compose:compose-bom:2024.12.01"))
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-text-google-fonts")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.navigation:navigation-compose:2.8.5")

    // Data
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")

    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.13.14")
    testImplementation("com.google.truth:truth:1.4.4")
    testImplementation("androidx.room:room-testing:2.6.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.1")
    testImplementation("androidx.arch.core:core-testing:2.2.0")

    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.7.6")
    androidTestImplementation("androidx.compose.ui:ui-test-manifest:1.7.6")
    androidTestImplementation("com.google.truth:truth:1.4.4")
    dokkaPlugin("org.jetbrains.dokka:android-documentation-plugin:2.0.0")
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets.configureEach {
        if (name != "main") {
            suppress.set(true)
        }
        displayName.set("app")
        moduleName.set("HabitHatch")

        sourceRoots.from("src/main/java")

        documentedVisibilities.set(setOf(DokkaConfiguration.Visibility.PUBLIC))
        skipEmptyPackages.set(true)
        skipDeprecated.set(true)
        reportUndocumented.set(false)
        suppressInheritedMembers.set(true)

        suppressedFiles.from(
            fileTree("build/generated/ksp") {
                include("**")
            },
        )
    }
}
tasks.dokkaHtml.configure {
    outputDirectory.set(file("docs/dokka"))
}
tasks.dokkaGfm.configure {
    outputDirectory.set(file("docs/dokka-md"))
}

tasks.register("codeQualityCheck") {
    description = "Runs Lint, and Detekt checks."
    group = "verification"

    dependsOn("lint", "detekt")
}

fun extractPackageName(
    file: File,
    basePackage: String,
): String {
    val splitPath = file.path.split(File.separatorChar)
    val directoryName = splitPath[splitPath.indexOf("dokka-md") + 2]
    // Remove the base package prefix from the path
    return directoryName.removePrefix("$basePackage.")
}

fun extractTrailingPackageName(
    file: File,
    basePackage: String,
): String = extractPackageName(file, basePackage).split('.').last()

fun extractTopLevelSubPackage(
    file: File,
    basePackage: String,
): String = extractPackageName(file, basePackage).substringBefore('.')

/**
 * Helper function that does interface, class, and decorator conversions
 */
fun transformKotlinMarkup(
    content: String,
    indexFile: File,
    basePackage: String,
): String =
    content
        .replace(Regex("//\\[HabitHatch].*"), "")
        .replace("### Parameters", "## Parameters")
        .replace("#### Inheritors", "## Inheritors")
        .replace(
            "# Package-level declarations",
            extractTrailingPackageName(indexFile, basePackage),
        ).replace(Regex("\\[?app[\\s\\]]"), "")
        .replace("\n#", "\n###")
        .replace("\\\n", "\n")
        .replace("| <br>", "| ")
        .replace(Regex("\\[([^\\]]+)]\\([^\\)]+\\.md\\)"), "$1")
        .replace("@Injectconstructor", "@Inject<br>constructor")
        .replace(
            Regex("(class|fun|var|val|interface)\\s+([a-zA-Z]+)"),
            "<span class=\"kotlin-kw\">$1</span> <span class=\"kotlin-name\">$2</span>",
        ).replace(Regex("(@[a-zA-Z]+)"), "<span class=\"decorator\">$1</span> ")
        .replace(Regex("\\b(class|fun|var|val|interface)\\s+"), "<span class=\"kotlin-kw $1\">$1</span> ")

tasks.register("mergeLeafIndexesMd") {
    val dokkaOutputDir = file("docs/dokka-md")
    val mergedOutputFile = file("docs/docsify/code_documentation.md")
    val basePackage = "com.habithatch.demo"

    doLast {
        println("Merging leaf index.md files...")

        val leafIndexFiles =
            dokkaOutputDir
                .walkTopDown()
                .filter { it.isFile && it.name == "index.md" }
                .filter { file ->
                    file.parentFile?.listFiles { f -> f.isDirectory }?.isEmpty() == true
                }.toList()

        // Group files by their top-level sub-package
        val groupedBySubPackage = leafIndexFiles.groupBy { extractTopLevelSubPackage(it, basePackage) }

        mergedOutputFile.bufferedWriter().use { writer ->
            writer.write("# Code Documentation\n")

            groupedBySubPackage.forEach { (subPkg, files) ->
                writer.write("\n## ${subPkg.replaceFirstChar { it.uppercase() }}\n")
                files.forEach { indexFile ->
                    writer.write(transformKotlinMarkup(indexFile.readText(), indexFile, basePackage))
                    writer.write("\n")
                }
                writer.write("\n---\n")
            }
        }
        println("Merged ${leafIndexFiles.size} leaf index.md files into ${mergedOutputFile.absolutePath}")
    }
}

tasks.dokkaGfm {
    finalizedBy("mergeLeafIndexesMd")
}
