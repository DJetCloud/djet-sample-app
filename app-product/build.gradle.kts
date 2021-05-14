plugins {
	id("org.springframework.boot")
	id("com.google.cloud.tools.jib")

	kotlin("jvm")
	kotlin("plugin.spring")
	kotlin("plugin.jpa")
	kotlin("kapt")
}

dependencies {
	implementation(project(":common"))

	implementation(kotlin("stdlib-jdk8"))
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("io.jsonwebtoken:jjwt:0.9.1")
	kapt( "org.hibernate:hibernate-jpamodelgen:5.4.30.Final")

	testImplementation("org.springframework.boot:spring-boot-test")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.testcontainers:junit-jupiter:1.14.3")
	testImplementation("org.testcontainers:mysql:1.14.3")
	testImplementation("com.h2database:h2:1.4.200")
	testImplementation(kotlin("test"))
}

jib {
	container {
		jvmFlags = listOf("-Dspring.profiles.active=prod")
		creationTime = "USE_CURRENT_TIMESTAMP"
	}
}
