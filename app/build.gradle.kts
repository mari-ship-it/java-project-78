plugins {
    id("java")
    jacoco
    checkstyle
    id ("org.sonarqube") version "6.2.0.5505"

}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.9.2"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

sonar {
    properties {
        property("sonar.projectKey", "mari-ship-it_java-project-78")
        property("sonar.organization", "mari-ship-it")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}