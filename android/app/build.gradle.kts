plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services") // ✅ เพิ่ม Firebase plugin
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.demo"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = "27.0.12077973"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.example.demo"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:32.7.0")) // ✅ ใช้ BOM จัดการเวอร์ชัน
    implementation("com.google.firebase:firebase-analytics") // ✅ เพิ่ม services ที่คุณใช้
    // implementation("com.google.firebase:firebase-auth") // ถ้าใช้ auth
    // implementation("com.google.firebase:firebase-firestore") // ถ้าใช้ Firestore
}

// ✅ เรียกใช้ Google Services plugin
apply(plugin = "com.google.gms.google-services")
