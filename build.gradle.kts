import com.moowork.gradle.node.yarn.YarnTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

extra["versions"] = mapOf(
		"springBootVersion" to "2.3.0.RELEASE",
		"testContainersVersion" to "1.14.3"
)

val versions: Map<String, String> by extra

plugins {
	jacoco
	id("org.springframework.boot") version "2.3.0.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("com.github.node-gradle.node") version "2.2.4"
	id("com.google.cloud.tools.jib") version "2.3.0"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
	kotlin("plugin.allopen") version "1.3.72"
	kotlin("plugin.jpa") version "1.3.72"
}

group = "com.b1a9idps"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
//	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	runtimeOnly("org.postgresql:postgresql")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.testcontainers:testcontainers:${versions["testContainersVersion"]}")
	testImplementation("org.testcontainers:junit-jupiter:${versions["testContainersVersion"]}")
	testImplementation("org.testcontainers:postgresql:${versions["testContainersVersion"]}")
//	testImplementation("org.springframework.security:spring-security-test")
}

node {
	version = "13.9.0"
	npmVersion = "6.13.7"
	yarnVersion = "1.22.0"
	download = true
	nodeModulesDir = File(project.projectDir, "frontend")
}

val buildReact by tasks.registering(YarnTask::class) {
	args = listOf("build")
	setExecOverrides(closureOf<ExecSpec> {
		setWorkingDir("./frontend")
	})
}

tasks.named("yarn_install") {
	dependsOn("yarn_cache_clean")
}

tasks.named("buildReact") {
	dependsOn("yarn_install")
}

tasks.build {
	dependsOn(buildReact)
}

tasks.jibDockerBuild {
	dependsOn(buildReact)
}

tasks.test {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
	configure<JacocoTaskExtension> {
		excludes = listOf("**/annotation/**", "**/exception/**", "**/Application.kt")
	}
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)
	reports {
		xml.isEnabled = true
		xml.destination = file("${buildDir}/reports/jacoco/report.xml")
		csv.isEnabled = false
		html.isEnabled = false
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}

tasks.bootJar {
	archiveFileName.set("clothes-house.jar")
}
