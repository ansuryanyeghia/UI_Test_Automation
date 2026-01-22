plugins {
    id("java")
}

group = "groupId"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.seleniumhq.selenium:selenium-java:4.19.1")
    implementation("org.testng:testng:7.10.2")
    implementation("io.github.bonigarcia:webdrivermanager:5.7.0")
}

tasks.test {
    useTestNG()
}

tasks.register<Test>("suiteTest") {
    useTestNG{
        suites("src/test/resources/regressionTests.xml")
        suites("src/test/resources/smockTesting.xml")
    }
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
}