plugins {
    id("java")
}

group = "groupId"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.19.1")
    testImplementation("org.testng:testng:7.10.2")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.7.0")
}

tasks.test {
    useTestNG()
}