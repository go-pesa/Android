# go-pesa for Android

Android bindings for the go-pesa client.

## Installation

- Add the go-pesa bintray repository to your project level build.gradle like so

```gradle
allprojects {
    repositories {
        jcenter()

        //go-pesa bintray repo
        maven {
            url  "https://dl.bintray.com/go-pesa/android"
        }

    }
}
```

- Then add this to your app level build.gradle's dependencies

```gradle


dependencies {

    ...

    compile 'io.github.go_pesa:gopesa:0.0.3@aar'

    ...

}
```

## Documentation

- Documentation available at [https://go-pesa.github.io](https://go-pesa.github.io)

## TO-DO

- Implement All M-pesa API functinality
- Write Tests

## Reason

- Create a very fast library with native performance on Multiple Platforms with one main source
- Delve into golang and C
