Can use this project to verify that SSL both works with Data Hub and that disabling certain 
SSL protocols has the intended effect. 

By default, Data Hub will create an insecure `SSLContext` with `TLSv1.2` as the protocol when 
`mlStagingSimpleSsl=true` is in `gradle.properties` (or if any other "simple SSL" property is set to "true").

