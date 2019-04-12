# HeadLines

### About App
A simple android news application to demonstrate the usage for MVVM design pattern using Room database, LiveData, Databinding, Retrofit. The application supports caching of news articles.

The application uses the NY Times Most Popular Articles API and shows a list of articles, that shows details when items on the list are tapped (a typical master/detail app).

### Components Used
-   [MVVM Architecture](https://developer.android.com/jetpack/arch/) - Robust, testable, and maintainable app with classes for managing your UI component lifecycle and handling data persistence.
-    [AndroidX](https://developer.android.com/jetpack/androidx) - AndroidX is a major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index)
 -   [Data Binding](https://developer.android.com/topic/libraries/data-binding/) - Declaratively bind observable data to UI elements.
    -   [Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle) - Create a UI that automatically responds to lifecycle events.
    -   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Build data objects that notify views when the underlying database changes.
   -   [Room](https://developer.android.com/topic/libraries/architecture/room) - Access your app's SQLite database with in-app objects and compile-time checks.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
-   [Test](https://developer.android.com/training/testing/) - An Android testing framework for unit and runtime UI tests.
Third party
-   [Glide](https://bumptech.github.io/glide/) for image loading

## Highlights
- MVVM Architecture
- Room database offline caching.
- Unit test demonstration using JUnit and Mockito
- Gradle scripts for running sonarqube static code analysis, code coverage.


## Screenshots

<img src="https://raw.githubusercontent.com/faiyyazs/HeadLines/master/screenshots/device-2019-04-12-132309.png" alt="drawing" width="200"/><img src="https://raw.githubusercontent.com/faiyyazs/HeadLines/master/screenshots/device-2019-04-12-132438.png" alt="drawing" width="200"/>

## How to generate code coverage report ?

Open terminal and type the following command

`./gradlew clean jacocoTestReport`

The coverage report will be generated on the following path.

`app/build/reports`


## How to generate Sonarqube report ?

Open gradle.properties and update the below line with the sonarqube server url

`systemProp.sonar.host.url=http://localhost:9000`

Before running the sonarqube job, make sure the project version has been updated in the build.gradle. On every run, increment the version by 1.  

```
property "sonar.sources", "src/main/java"
property "sonar.projectName", "Headlines" // Name of your project
property "sonar.projectVersion", "1.0.0" // Version of your project
property "sonar.projectDescription", "News feed application"
```

For running the sonarqube job, type the below command in the terminal.  

`./gradlew sonarqube assembleDebug`

<img src="https://raw.githubusercontent.com/faiyyazs/HeadLines/master/screenshots/Screenshot%202019-04-12%20at%202.38.26%20PM.png" alt="drawing" height="250"/>

## Additional resources

Check out these web pages to learn more about following:

-   [Android Test Coverage with Sonarqube](https://overflow.buffer.com/2017/01/16/android-test-sonarqube/)




## Support

If you've found an error in this sample, please file an issue: [https://github.com/faiyyazs/HeadLines/issues](https://github.com/faiyyazs/HeadLines/issues)

Patches are encouraged, and may be submitted by forking this project and submitting a pull request through GitHub.
