plugins {
    id("com.android.application")


}

android {
    namespace = "com.example.sol5"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.sol5"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    implementation("androidx.recyclerview:recyclerview:1.3.1")
}

