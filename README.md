# Kotlin_CleanArchitectureMVVM

Clean Architecture provides us:
Clean separation of concerns - making the code easier to navigate and maintain.
A common understanding of how to build features, making code reviews easier.
Testable code. Dependency injection allows us to easily mock classes, and write granular unit tests.


Data - Layer that holds APIs, Database, Cache
Domain - Layer that holds Use Cases, and Model Objects. Business logic happens here.
Application - Layer that holds presentation, Android components, Dagger components/modules, etc. MVVM exists at this layer.



