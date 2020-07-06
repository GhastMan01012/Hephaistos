package org.jglrxavpok.hephaistos.nbt

import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException

/**
 * Most basic representation of a NBTag
 */
interface NBT {

    /**
     * ID of this tag type
     */
    val ID: Int

    /**
     * Reads the contents of the tag from the given source. The tag ID is supposed to be already read.
     *
     * For NBTLists, it assumes the subtag type ID as already been read
     * @throws IOException if an error occurred during reading
     * @throws NBTException if the data stream does not respect NBT specs
     */
    @Throws(IOException::class, NBTException::class)
    fun readContents(source: DataInputStream)

    /**
     * Writes the contents of the tag to the given destination. The tag ID is supposed to be already written
     * @throws IOException if an error occurred during writing
     */
    @Throws(IOException::class)
    fun writeContents(destination: DataOutputStream)

    /**
     * Produces the stringified version of this NBT (or SNBT version). Is empty for TAG_End
     */
    fun toSNBT(): String

    /**
     * Produces a human-readable version of this tag. Must be the same as `toSNBT()`, except for TAG_End which returns "<TAG_End>"
     */
    override fun toString(): String
}