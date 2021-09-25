plugins {
    `java-library`
}

dependencies {
    implementation(project(":support"))
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}