import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
	id("com.github.johnrengelman.shadow") version "7.0.0"
	
	// Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
	id("org.jetbrains.kotlin.jvm") version "1.4.20"

	// Apply the application plugin to add support for building a CLI application in Java.
	application
}

repositories {
	mavenCentral()
	maven {
		name = "m2-dv8tion"
		url = uri("https://m2.dv8tion.net/releases")
	}
}

dependencies {
	// Align versions of all Kotlin components
	implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

	// Use the Kotlin JDK 8 standard library.
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// This dependency is used by the application.
	implementation("com.google.guava:guava:29.0-jre")

	// Use the Kotlin test library.
	testImplementation("org.jetbrains.kotlin:kotlin-test")

	// Use the Kotlin JUnit integration.
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

	implementation("net.dv8tion:JDA:4.2.1_253")
}

application {
	// Define the main class for the application.
	mainClass.set("bot.BotKt")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<ShadowJar> {
	archiveFileName.set("app.jar")
}

tasks.create("stage") {
	dependsOn("shadowJar")
	mustRunAfter("clean")
}
