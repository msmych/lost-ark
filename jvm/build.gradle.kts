plugins {
    `java-library`
}

allprojects {
    repositories {
        mavenCentral()
    }
}

dependencies {

    implementation(project(":support"))
}