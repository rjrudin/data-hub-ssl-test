Can use this project to verify that SSL both works with Data Hub and that disabling certain 
SSL protocols has the intended effect. 

You can deploy the app via `./gradlew -i mlDeploy`. This will enable SSL on the staging server on port 8010. 

You can run `./gradlew javaClientTest` to verify that an insecure `SSLContext` that defaults to 
`TLSv1.2` for the protocol will connect successfully. You can then run `./gradlew disableTLSv1_2` and
re-run `javaClientTest` to verify that the connection will fail when TLSv1.2 is disabled. You can then 
run `./gradlew disableProtocols` to disable everything except TLSv1.2 - then run `javaClientTest` again
and it will succeed.

Running `./gradlew hubTest` will exhibit the same behavior. This program uses Data Hub's support for
reading a properties file and creating a connection to the staging app server. It too defaults to TLSv1.2.

When you disable TLSv1.2 and run either test, you will get this expected error:

```
javax.net.ssl.SSLHandshakeException: The server selected protocol version TLS11 is not accepted by client preferences [TLS12]
```

