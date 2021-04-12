import io.gitlab.arturbosch.detekt.detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.4.21"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion apply false
	kotlin("plugin.jpa") version kotlinVersion apply false

	id("org.springframework.boot") version "2.4.2" apply false
	id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false
	id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion apply false
	id("org.jetbrains.kotlin.plugin.noarg") version kotlinVersion apply false

	id("io.gitlab.arturbosch.detekt") version "1.15.0"
	id("jacoco")
	id("com.google.cloud.tools.jib") version "2.7.1" apply false
}

allprojects {
	group = "com.client"
	version = "0.0.1"

	repositories {
		jcenter()
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "1.8"
		}
	}

	tasks.withType<JavaCompile> {
		sourceCompatibility = "1.8"
		targetCompatibility = "1.8"
	}
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.plugin.allopen")
	apply(plugin = "org.jetbrains.kotlin.plugin.noarg")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	apply(plugin = "jacoco")

	jacoco {
		toolVersion = "0.8.5"
	}

	tasks.jacocoTestReport {
		reports {
			xml.isEnabled = true
		}
	}

	tasks.test {
		useJUnitPlatform()
		finalizedBy(tasks.jacocoTestReport)
	}

	tasks.jacocoTestReport {
		dependsOn(tasks.test)
	}

}

detekt {
	ignoreFailures = true
}
