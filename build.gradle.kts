import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}

group = "com.github.KyeongYeongDEV"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring WebFlux & Netty (리액티브 웹)
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // R2DBC (리액티브 DB 연동)
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

    // ⭐️ [수정됨]
    // 1. 'dev.miku:r2dbc-mysql' (오래된 드라이버) -> 'io.asyncer:r2dbc-mysql' (새로운 공식 드라이버)로 변경했습니다.
    // 2. Spring Boot 3.2.4를 사용 중이므로 'io.spring.dependency-management' 플러그인이
    //    'io.asyncer:r2dbc-mysql'의 버전을 자동으로 관리해 줍니다. (버전 명시 불필요)
    runtimeOnly("io.asyncer:r2dbc-mysql")

    // ⭐️ [제거됨]
    // 'com.mysql:mysql-connector-j' (JDBC 드라이버)는 R2DBC가 사용하지 않으므로 제거했습니다.
    // runtimeOnly("com.mysql:mysql-connector-j")

    // Redis (리액티브)
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")

    // Kotlin & Coroutine
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // .env 파일 로더
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    // JSON 처리를 위한 Jackson 모듈
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // 테스트
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}