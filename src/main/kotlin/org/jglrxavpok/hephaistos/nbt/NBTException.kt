package org.jglrxavpok.hephaistos.nbt

import java.lang.Exception

class NBTException(message: String, cause: Throwable?): Exception(message, cause) {

    constructor(message: String): this(message, null)
}