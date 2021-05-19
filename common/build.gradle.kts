plugins {
	id("org.springframework.boot")

	kotlin("jvm")
	kotlin("plugin.spring")
	kotlin("plugin.jpa")
	kotlin("kapt")
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	kapt("org.hibernate:hibernate-jpamodelgen:5.4.30.Final")

	api("io.springfox:springfox-boot-starter:3.0.0")
	api("com.vladmihalcea:hibernate-types-52:2.9.13")
	api("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("io.springfox:springfox-swagger-ui:3.0.0")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("jakarta.persistence:jakarta.persistence-api")
	implementation("org.springframework.data:spring-data-commons")
	implementation("org.liquibase:liquibase-core")
	implementation("mysql:mysql-connector-java")
	implementation("com.github.ichanzhar:rsql-hibernate-jpa:0.7")
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
	enabled = false
}

tasks.getByName<Jar>("jar") {
	enabled = true
}
