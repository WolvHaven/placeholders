plugins {
    java
}

group = "net.wolvhaven"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("com.github.mbax:VanishNoPacket:0cb428ff27")
    compileOnly("me.clip:placeholderapi:2.10.9")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
}
