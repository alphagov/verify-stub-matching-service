# verify-stub-matching-service

[![Build Status](https://travis-ci.org/alphagov/verify-stub-matching-service.svg?branch=master)](https://travis-ci.org/alphagov/verify-stub-matching-service)

This is a stub implementation of the local matching service required by RP's to integrate into GOV.UK Verify.

It is a small http server which provides 2 methods. These methods return successful responses.

The two urls are:

* http://localhost:50130/stub-matching/matching-service/POST -> returns `{"result":"match"}`
* http://localhost:50130/stub-matching/unknown-user/POST -> returns `{"result":"success"}`

Please note that the default port is 50130, however this value can be changed by setting a
port number value to an environment variable 'LMS_PORT'.

Building the project
--------------------

This project uses gradle as a build tool. To build the project you need to execute the following command
from withing the project root directory:

```
# Windows
gradlew build
```

```
# Unix based OS
./gradlew build
```

Starting the stub local matching service
-------------------------------------

Building the project will produce a verify-stub-matching-service-X.X.X-SNAPSHOT.jar file where 'X.X.X' is the
product version number.

You can also dowload a ready to use jar from the project releases. Please note that the released jar fales
are named as follow: local-matching-service-X.X.X-Y.jar where 'X.X.X' is the product version number and 'Y' is
the build number.

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

If you  would like to run the locally build jar file you can use the above commands supplementing
'local-matching-service-X.X.X-Y.jar' with 'verify-stub-matching-service-X.X.X-SNAPSHOT.jar '