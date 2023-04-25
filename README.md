# Ping Pong Example
Ping Pong is a AMdEX fieldlab demo to verify if a local installation with Docker works properly.

This example will create 4 docker containers: Zookeeper, Kafka, Ping and Pong. Kafka and Zookeeper are the communications parts of the system. Ping is a simple fieldlab application which communicates with Pong which is a fieldlab Executor. Ping will send a message and Pong will respond with a message and repeats this 100 times. The messages are numbered, to check if all the messages are correctly received, processed and responded.
## Prerequisites
You need to have Docker installed and running on your system
## Build and Run
Open a shell and navigate to the build/examples/pingpong/build directory.
Run ./buildandrun.sh or buildandrun.bat script depending on your operating system.
## Result
``` 
~/Documents/GitHub/demo/build/examples/pingpong/build$ ./buildandrun.sh
[+] Building 6.8s (9/9) FINISHED                    
 => [internal] load build definition from dockerfilePong.yml       
 => => transferring dockerfile: 233B                              
 => [internal] load .dockerignore                                 
 => => transferring context: 2B                                   
 => [internal] load metadata for docker.io/library/eclipse-temurin:latest     
 => [auth] library/eclipse-temurin:pull token for registry-1.docker.io       
 => [1/3] FROM docker.io/library/eclipse-temurin:latest@sha256:56fddc837ff4447b08a600b8f6077900607639166260cb66a6ad6d8ce3acc904 
 => => resolve docker.io/library/eclipse-temurin:latest@sha256:56fddc837ff4447b08a600b8f6077900607639166260cb66a6ad6d8ce3acc904                              
 => [internal] load build context                       
 => => transferring context: 318B                    
 => CACHED [2/3] RUN mkdir /opt/app                      
 => CACHED [3/3] COPY ping_pong/* /opt/app              
 => exporting to image                                 
 => => exporting layers                                 
 => => writing image sha256:07a0b77f13d83b35e48f371021db6f805f65d0fbaa82b13e897d34c3c988956d     
 => => naming to docker.io/library/pong                                          
[+] Building 0.7s (8/8) FINISHED                                                                                                                                             
 => [internal] load build definition from dockerfilePing.yml       
 => => transferring dockerfile: 182B                             
 => [internal] load .dockerignore                              
 => => transferring context: 2B                             
 => [internal] load metadata for docker.io/library/eclipse-temurin:latest    
 => [1/3] FROM docker.io/library/eclipse-temurin:latest@sha256:56fddc837ff4447b08a600b8f6077900607639166260cb66a6ad6d8ce3acc904                     
 => => resolve docker.io/library/eclipse-temurin:latest@sha256:56fddc837ff4447b08a600b8f6077900607639166260cb66a6ad6d8ce3acc904
 => [internal] load build context         
 => => transferring context: 318B           
 => CACHED [2/3] RUN mkdir /opt/app          
 => CACHED [3/3] COPY ping_pong/* /opt/app     
 => exporting to image                        
 => => exporting layers                                
 => => writing image sha256:30a47d30d9a4929bb6a818aa1b239b189f966662d7ddb937b6392c21939723a4 
 => => naming to docker.io/library/ping                                  
[+] Running 4/0
 ✔ Container zookeeper  Created                    
 ✔ Container kafka      Created                  
 ✔ Container pong       Created                
 ✔ Container ping       Created               
Attaching to kafka, ping, pong, zookeeper
zookeeper  | ZooKeeper JMX enabled by default
zookeeper  | Using config: /opt/zookeeper-3.4.13/bin/../conf/zoo.cfg
zookeeper  | 2023-04-25 06:55:37,123 [myid:] - INFO  [main:QuorumPeerConfig@136] - Reading configuration from: /opt/zookeeper-3.4.13/bin/../conf/zoo.cfg
zookeeper  | 2023-04-25 06:55:37,126 [myid:] - INFO  [main:DatadirCleanupManager@78] - autopurge.snapRetainCount set to 3
:
:
kafka      | [Configuring] 'port' in '/opt/kafka/config/server.properties'
kafka      | [Configuring] 'advertised.host.name' in '/opt/kafka/config/server.properties'
kafka      | Excluding KAFKA_HOME from broker config
:
:
pong       | pong.properties
pong       | inner prefix: backbone.protocol.prototypekafka.
pong       | SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
pong       | SLF4J: Defaulting to no-operation (NOP) logger implementation
pong       | SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
ping       | SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
ping       | SLF4J: Defaulting to no-operation (NOP) logger implementation
ping       | SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
pong       | rSAPublicKeyFromString
pong       | -----BEGIN PUBLIC KEY-----MIIBHjANBgkqhkiG9w0BAQEFAAOCAQsAMIIBBgKB/gCGuW45BKAY8VFSa7T527aLkPOg0GssObgdZ36PiJm4+nkShYCv+CYo1fIsKMmQLaGCTOPQpVZf7xzBkJcPdmsfBXnVj1tepmjoWP9HuQrJkLVYNhP6mV10EnDc3hiHpgrnXWgzubR1RHT+Sx9msU3k62n1LeGxPF9rpPQ/U8W4XEenljCpnuapxVxaUPxBaU2GTR0ZTIYcMREoFAzI0UbILGhOPI9FEH7PrzJBSvpvrnw+ZxwiUbNnRG5BBvY3VCY9LCkxBnE8eaxZbx35gIyWYQoQcBttADgccd7sGuJMktc5VxhY2VPiNm7nioIxH9IpfCM2l1HY3uGwsxMlAgMBAAE-----END PUBLIC KEY-----
pong       | register kafka consumer
pong       | INIT
ping       | rSAPublicKeyFromString
ping       | -----BEGIN PUBLIC KEY-----MIIBHjANBgkqhkiG9w0BAQEFAAOCAQsAMIIBBgKB/gCIalJSIyhy73jM/bNS3YpdbkzjSu5n+VbWWSmeCR4Z2TtCOGgoqEAZtY+nODQkfaOheRYOXcavvTWDH3M1jDR7tCFfOWeQPmTIbQ5DMWOITOqal41m1wC7afOryfp2q9xeGx9k+82mp+UZRqzFOrWDiirSsSLo+EvLQ9/U0UP77784T+32ILrMFK0pvdPe7Po7GiFh0lCsOhH0bsB/mzyxM80Cr1vQAMyZpyZsuIOG/tC66IbCXinEJvWR0twpYFVUFwKidq0mR/sJuHiR6H1tfw6ImPFJBmAoa821WIlStVGbzgnzsw8MxMbv3RX6/pdKc5VY326KvPQr++VlAgMBAAE-----END PUBLIC KEY-----
ping       | register kafka consumer
ping       | Sending: Ping 1
:
:
ping       | Sending: Ping 2
:
:
pong       | Received: Ping 1
pong       | Sending: Pong 1
pong       | Class Name : eu.amdexfieldlab.core.certificates.PublicCertificate
ping       | Sending: Ping 3
:
:
pong       | ProcessRecord: PONG = eu.amdexfieldlab.core.certificates.PublicCertificate@66a8baa9
pong       | ProcessRecord: PING = eu.amdexfieldlab.core.certificates.PublicCertificate@17bfc9b7
pong       | Class Name : eu.amdexfieldlab.core.identity.Identity
pong       | Class Name : eu.amdexfieldlab.core.identity.Identity
pong       | Class Name : eu.amdexfieldlab.core.backbone.BackboneMetaData
pong       | Class Name : eu.amdexfieldlab.core.nodebase.ExecuteMessage
pong       | Received: Ping 2
pong       | Sending: Pong 2
pong       | Class Name : eu.amdexfieldlab.core.identity.Identity
pong       | Class Name : eu.amdexfieldlab.core.identity.Identity
pong       | Class Name : eu.amdexfieldlab.core.backbone.BackboneMetaData
pong       | Class Name : eu.amdexfieldlab.core.nodebase.ExecuteMessage
pong       | Received: Ping 3
pong       | Sending: Pong 3
ping       | Class Name : eu.amdexfieldlab.core.identity.Identity
ping       | Class Name : eu.amdexfieldlab.core.identity.Identity
ping       | Class Name : eu.amdexfieldlab.core.backbone.BackboneMetaData
ping       | Class Name : eu.amdexfieldlab.core.nodebase.ResultMessage
ping       | Class Name : eu.amdexfieldlab.core.identity.Identity
ping       | Class Name : eu.amdexfieldlab.core.identity.Identity
ping       | Class Name : eu.amdexfieldlab.core.backbone.BackboneMetaData
ping       | Class Name : eu.amdexfieldlab.core.nodebase.ResultMessage
ping       | Class Name : eu.amdexfieldlab.core.identity.Identity
ping       | Class Name : eu.amdexfieldlab.core.identity.Identity
ping       | Class Name : eu.amdexfieldlab.core.backbone.BackboneMetaData
ping       | Class Name : eu.amdexfieldlab.core.nodebase.ResultMessage
ping       | Received: Pong 1
ping       | Received: Pong 2
ping       | Received: Pong 3
:
:
ping       | Sending: Ping 100
pong       | Class Name : eu.amdexfieldlab.core.identity.Identity
pong       | Class Name : eu.amdexfieldlab.core.identity.Identity
pong       | Class Name : eu.amdexfieldlab.core.backbone.BackboneMetaData
pong       | Class Name : eu.amdexfieldlab.core.nodebase.ExecuteMessage
pong       | Received: Ping 100
pong       | Sending: Pong 100
ping       | Class Name : eu.amdexfieldlab.core.identity.Identity
ping       | Class Name : eu.amdexfieldlab.core.identity.Identity
ping       | Class Name : eu.amdexfieldlab.core.backbone.BackboneMetaData
ping       | Class Name : eu.amdexfieldlab.core.nodebase.ResultMessage
ping       | Received: Pong 100
