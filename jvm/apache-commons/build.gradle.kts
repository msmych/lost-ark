plugins {
    java
}

val apacheCommonsVersion: String by project

dependencies {
    implementation(project(":support"))

    implementation("org.apache.commons:commons-lang3:${apacheCommonsVersion}")
}
