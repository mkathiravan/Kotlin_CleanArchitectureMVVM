# Kotlin_CleanArchitectureMVVM

Clean Architecture provides us:
Clean separation of concerns - making the code easier to navigate and maintain.
A common understanding of how to build features, making code reviews easier.
Testable code. Dependency injection allows us to easily mock classes, and write granular unit tests.


Data - Layer that holds APIs, Database, Cache
Domain - Layer that holds Use Cases, and Model Objects. Business logic happens here.
Application - Layer that holds presentation, Android components, Dagger components/modules, etc. MVVM exists at this layer.

![image](https://user-images.githubusercontent.com/39657409/67218473-0cba4c00-f444-11e9-8174-f8b92e99bdd8.png)
![image](https://user-images.githubusercontent.com/39657409/67218502-18a60e00-f444-11e9-87ab-13dab0dbe284.png)
![image](https://user-images.githubusercontent.com/39657409/67218526-2360a300-f444-11e9-83b7-5e23d090a0f8.png)


