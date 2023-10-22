# Myptv

The goal of this project is to be following the best development practices.
It's my interpretation and adaptation of the guidelines provided by Google.

Nominal functionality : As a user, I want to have access to all accessible iptv channels and be able to watch it.

## Clean architecture with 3 part
- data (for database, API and preferences code)
- domain (for business logic and models)
- presentation (for UI logic, with MVVM)

## Tests (will be nice to have)
- [Mockk](https://mockk.io/) library 
- Unit tests
- Application tests
  - example on how to work with tests
    
## Other useful features
- Dependency injection (with [Koin])
- Network calls (with [Retrofit])
- Reactive programming (with [Kotlin Flows](https://kotlinlang.org/docs/reference/coroutines/flow.html))
- Google [Material Design](https://material.io/blog/android-material-theme-color) library
- Player HLS (with [Exoplayer])
