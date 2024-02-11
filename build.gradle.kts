// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    // 구글 서비스에 gradle 플러그인에 대한 종속성 추가
    id("com.google.gms.google-services") version "4.4.1" apply false

}