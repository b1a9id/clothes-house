import com.moowork.gradle.node.yarn.YarnTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.6.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("com.github.node-gradle.node") version "2.2.3"
	id("com.google.cloud.tools.jib") version "2.1.0"
	kotlin("jvm") version "1.3.71"
	kotlin("plugin.spring") version "1.3.71"
}

group = "com.b1a9idps"
version = "0.0.1-SNAPSHOT"
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
//	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//	implementation("org.flywaydb:flyway-core")
	implementation("com.h2database:h2:1.4.199")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
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
	val env: String? = System.getenv("GITHUB_WORKSPACE")
	if (env != null) {
		outputs.dir(File( "$env", "frontend"))
	}
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

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
