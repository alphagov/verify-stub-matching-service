# verify-stub-matching-service

[![Build Status](https://travis-ci.org/alphagov/verify-stub-matching-service.svg?branch=master)](https://travis-ci.org/alphagov/verify-stub-matching-service)

>**GOV.UK Verify has closed**
>
>This repository is out of date and has been archived

This is a stub implementation of the local matching service required by RP's to integrate into GOV.UK Verify.

It is a small http server which provides 2 methods. These methods return successful responses.

The two urls are:

* POST http://localhost:50130/local-matching/match -> returns `{"result":"match"}`
* POST http://localhost:50130/local-matching/create-user -> returns `{"result":"success"}`

Please note that the default port is 50130, however this value can be changed by setting a
port number value to an environment variable 'LMS_PORT'.

Building the project
--------------------

This project uses gradle as a build tool. To build the project you need to execute the following command
from withing the project root directory:

```
# Windows
gradlew build fatJar
```

```
# Unix based OS
./gradlew build fatJar
```

Starting the stub local matching service
----------------------------------------

You can dowload a ready to use jar from [the releases page](https://github.com/alphagov/verify-stub-matching-service/releases).

If you've built the project yourself the `fatJar` task will place a file called local-matching-service-X.X.X-Y.jar in `build/libs`
(where 'X.X.X' is the version number).

You can run the stub local matching service with:

```
# Start the service on the default port (50130)
java -jar local-matching-service-X.X.X-Y.jar
```

If you want to start the stub local matching service on a different port you can set a `LMS_PORT`
environment variable. For example:

```
# Start the service on port (1337)
export LMS_PORT=1337
java -jar local-matching-service-X.X.X-Y.jar
```

If you  would like to run the locally built jar file you can use the above commands supplementing
'local-matching-service-X.X.X-Y.jar' with 'verify-stub-matching-service-X.X.X-SNAPSHOT.jar '
