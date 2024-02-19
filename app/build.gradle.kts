import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}


android {
    namespace = "com.example.gdsc_2324_android"
    compileSdk = 34

    val properties = Properties()
    properties.load(FileInputStream(File("local.properties")))


    defaultConfig {
        applicationId = "com.example.gdsc_2324_android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // googleMapApiKey를 defaultConfig 밖으로 이동하여 변수를 재할당하지 않도록 함
        //val googleMapApiKey = properties.getProperty("google_map_api_key") ?: ""

        //buildConfigField("String", "GOOGLE_MAP_API_KEY", "\"$googleMapApiKey\"")

        // API 키 값을 local.properties에서 읽어와서 할당
        manifestPlaceholders["googleMapApiKey"] = properties.getProperty("google_maps_api_key")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        enable = true
    }



}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //viewPager
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    //google map
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.android.gms:play-services-location:21.1.0")

    // Google Play services
    implementation ("com.google.gms:google-services:4.3.15")
    implementation ("com.google.firebase:firebase-auth:22.3.1")
    implementation ("com.google.firebase:firebase-bom:32.7.1")
    implementation ("com.google.android.gms:play-services-auth:20.7.0")

    //firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    implementation("com.google.firebase:firebase-analytics")


}