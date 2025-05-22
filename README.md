# demoapp

This project is a simple Spring Boot application exposing a REST endpoint to retrieve the current temperature for a location.

## Building

Use Gradle to build the project:

```bash
./gradlew build
```

## Running

```bash
./gradlew bootRun
```

The service exposes `/getTemperature` expecting query parameters `lat` and `lon`.
Example:

```
curl "http://localhost:8080/getTemperature?lat=52.52&lon=13.41"
```

The temperature is fetched from the public **Open-Meteo** API.

