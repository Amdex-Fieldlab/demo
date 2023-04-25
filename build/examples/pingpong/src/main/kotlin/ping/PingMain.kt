package ping

import eu.amdexfieldlab.core.certificates.CertificateManager
import eu.amdexfieldlab.core.runtime.AmdexProperties
import eu.amdexfieldlab.core.runtime.startAmdexFieldlab
import eu.amdexfieldlab.core.util.io.getFile
import eu.amdexfieldlab.prototype.SimulatedSigning
import eu.amdexfieldlab.prototype.kafka.KafkaBackbone
import eu.amdexfieldlab.prototype.kafka.KafkaPublicCertificateStore
import pong.PongExecutorStub
import java.io.PrintStream

fun main() {
    // AMDEX FIELDLAB MANUAL INITIALIZATION

    // Since Ping does not use a node template like the PongExecutor, the initialization of Amdex is done manually.
    startAmdexFieldlab("ping.properties")

    // Start Backbone
    val backbone = KafkaBackbone(SimulatedSigning())

    // if you have a class extending NodeBase (incl Executor, Orchestrator), register its handler with the backbone here.
    // e.g.
    // val executor = PongExecutor()
    // backbone.listenForOtherNodes(executor.backboneHandler)

    backbone.start()

    // Start CertificateManager
    val publicCertificateStore = KafkaPublicCertificateStore(AmdexProperties.getProperty("certificates.store.topic"))
    CertificateManager.initialize(getFile(AmdexProperties.getProperty("certificate.file"))!!, publicCertificateStore)
    publicCertificateStore.start()

    // START OF YOUR CODE
    val pongStub = PongExecutorStub(KafkaBackbone.ADDRESS, AmdexProperties.getIdentity("member.pong"))
    for(n in 1 .. 100) {
        println("Sending: Ping $n")
        pongStub.ping("value" to "Ping $n").execute {resultMsg ->
            println("Received: ${resultMsg!!.result}")
        }
        Thread.sleep(100)
    }
}