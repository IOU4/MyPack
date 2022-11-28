/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.5.1/samples
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    id("java")
    id("war")
}

repositories {
    mavenCentral()
}

tasks.register<Exec>("redeploy") {
    commandLine("docker", "exec", "mypack-wildfly-1", "/opt/jboss/wildfly/bin/jboss-cli.sh", "-c", "/deployment=ROOT.war:redeploy")
}

tasks.war {
    archiveFileName.set("ROOT.war")
    // exute redeploy task after war task
    // finalizedBy("redeploy")
}

dependencies {
    // jakartaee apis
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    compileOnly("jakarta.faces:jakarta.faces-api:4.0.1")
    compileOnly("jakarta.inject:jakarta.inject-api:2.0.1")
    compileOnly("jakarta.enterprise:jakarta.enterprise.cdi-api:4.0.1")
    compileOnly("jakarta.persistence:jakarta.persistence-api:3.0.0")
    runtimeOnly("org.hibernate:hibernate-orm-jbossmodules:5.4.33")

    // mariadb jdbc driver
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.1.0")
}
