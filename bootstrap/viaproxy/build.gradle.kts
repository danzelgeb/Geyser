dependencies {
    api(projects.core)
}

platformRelocate("net.kyori")
platformRelocate("org.yaml")
platformRelocate("it.unimi.dsi.fastutil")
platformRelocate("org.cloudburstmc.netty")

// These dependencies are already present on the platform
provided(libs.viaproxy)

application {
    mainClass.set("org.geysermc.geyser.platform.viaproxy.GeyserViaProxyMain")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveBaseName.set("Geyser-ViaProxy")

    dependencies {
        exclude(dependency("com.google.*:.*"))
        exclude(dependency("io.netty:.*"))
        exclude(dependency("org.slf4j:.*"))
        exclude(dependency("org.ow2.asm:.*"))
    }
}
