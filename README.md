# verify-stub-matching-service
This is a stub implementation of the local matching service required by RP's to integrate into GOV.UK Verify

It is a small http server which provides 2 methods. These methods return successful responses.

The two urls are:
http://localhost:50130/stub-matching/matching-service/POST -> returns {"result":"match"}
http://localhost:50130/stub-matching/unknown-user/POST -> returns {"result":"success"}


