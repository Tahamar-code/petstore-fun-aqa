plugins {
    id("java")
}

group = "com.petstore"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Retrofit
    testImplementation("com.squareup.retrofit2:retrofit:2.11.0")
    // Serialize
    testImplementation("com.squareup.retrofit2:converter-jackson:2.11.0")

    // AssertJ
    testImplementation("org.assertj:assertj-core:3.25.3")

    // JUnit
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // kuda zhe bez my sweaty lombok
    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks.test {
    useJUnitPlatform()
}