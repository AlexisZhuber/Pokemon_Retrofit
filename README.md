#Retrofit_project

Overview

Retrofit_project is an Android application that fetches and displays detailed Pokémon information from PokeAPI using Retrofit and Gson. Unlike traditional implementations that rely on HttpURLConnection, this project leverages Retrofit for network calls and Gson for automatic JSON deserialization, making the process more efficient. The app follows the MVVM architecture and features a modern, responsive UI built with Jetpack Compose and Material3.

Features

Paginated Pokémon List – Browse Pokémon efficiently with seamless pagination.
Detailed Pokémon Data – View complete details, including ID, name, height, weight, types, and sprite images.
Exact Search – Quickly find Pokémon by name or ID.
Robust Error Handling – Gracefully handle network issues with informative error messages.
Modern UI – Designed with Jetpack Compose and Material3 for an elegant and responsive user experience.
Retrofit Integration – Uses Retrofit and Gson to streamline API calls and JSON parsing.

Architecture


The project follows MVVM principles, ensuring modularity and scalability:
RetrofitInstance & PokeApiService – Configures Retrofit to communicate with the PokeAPI.
Custom Gson Deserializer – Automatically maps JSON responses to data models.
RemoteDataSource – Handles API calls using Retrofit.
Repository – Acts as a mediator between the network layer and the ViewModel.
ViewModel – Manages UI state, pagination, search, and detailed view logic.
UI Components – Built with Composable functions for a seamless interface.

Requirements


Android Studio (Arctic Fox or newer)

Minimum SDK: 21

Internet connection required

How to Run

Clone the repository.
Open the project in Android Studio.
Build and run the app on an emulator or a physical device.

Dependencies

This project utilizes the following libraries:
Retrofit 2.9.0 – For efficient network communication.
Gson – For automatic JSON serialization and deserialization.
Kotlin Coroutines – For asynchronous programming.
Jetpack Compose & Material3 – For modern UI development.

License

[Insert License Information]

Acknowledgments
Special thanks to PokeAPI for providing Pokémon data.
