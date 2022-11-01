# Purpose of this repo is to showcase diffrent structural patterns in multi-module and modularized applications

## CurrencySort


This is a sample app written in Kotlin following clean architecture principles which displays 
a list of sorted currecies with respect to Australian Dollar

The purpose of this app to showcase:
- Implementation of Jetpack Compose, Android Architecture components with Dagger Hilt.
  Note: Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. 
- Performing network call with KTOR client and Kotlin Coroutines
- A demonstration of ProduceState with compose. 
  Note: ProduceState launches a coroutine scoped to the Composition that can push values into a returned State.

# Requirements
1. Android Studio : Android Studio Dolphin | 2021.3.1
2. Android Emulator or Physical android device

# Built With 🏗

| Tools | Link |
|     :---      |          :---: |
| 🤖   Kotlin | [Kotlin](https://kotlinlang.org/) |
| 🏛   Architecture Components | [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) |
| 💉   Dagger Hilt | [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) |
| 🌐   KTOR | [KTOR](https://ktor.io) |
| 📄   Json | [Json](https://en.wikipedia.org/wiki/JSON) |
| 🌊   Coroutines | [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) |
| 🏄🏼‍♀️   ProduceState | [ProduceState](https://developer.android.com/jetpack/compose/side-effects#producestate) |





# APK

<img width="20" alt="Screenshot 2022-10-12 at 11 43 46 PM" src="https://user-images.githubusercontent.com/9639720/195417498-f79d94e3-8c6e-483e-aebf-1192a416a46f.png"> [Download APK](https://github.com/koushikDeb/CurrencySort/blob/master/apk/CurrencySort.apk) 

## App In Action

<img width="200" height = "400" src ="https://github.com/koushikDeb/CurrencySort/blob/master/apk/normal.gif">


## Note: 
To showcase that the sort is working based on currency code while value is same. 

<img width="200" height = "400" src ="https://github.com/koushikDeb/CurrencySort/blob/master/apk/withSameValue.gif">


Developed By: [Koushik Deb](https://www.linkedin.com/in/koushik-deb-19562385/?originalSubdomain=in)

