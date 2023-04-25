package pong

import eu.amdexfieldlab.core.backbone.BackboneMetaData
import eu.amdexfieldlab.core.backbone.IBackboneAddress
import eu.amdexfieldlab.core.executor.Executor
import eu.amdexfieldlab.core.identity.Identity
import eu.amdexfieldlab.core.nodebase.*
import eu.amdexfieldlab.core.runtime.startAmdexFieldlab
import eu.amdexfieldlab.core.util.cast

fun main() {
    // Uses auto initialization using "main.class = pong.PongExecutor" in the properties
    startAmdexFieldlab(properties = "pong.properties", autoStart = true)
}

class PongExecutor(properties: String) : Executor(properties = properties) {

    init {
        autoInit()
    }

    fun ping(metaData: BackboneMetaData, message: ExecuteMessage) : ResultMessage {
        val value : String = cast(message["value"])
        println("Received: $value")
        println("Sending: Pong $counter")
        return ResultMessage.Success("Pong ${counter++}")
    }
    companion object {
        var counter = 1
    }
}

class PongExecutorStub(address: IBackboneAddress, node: Identity) : NodeStub(address, node) {
    val ping : NodeRemoteFunction by this
}