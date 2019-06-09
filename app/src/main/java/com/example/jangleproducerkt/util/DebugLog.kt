package com.example.jangleproducerkt.util

import android.util.Log
import com.example.jangleproducerkt.BuildConfig

object DebugLog {


    private val MAX_INDEX = 4000
    private val MIN_INDEX = 3000
    private var isDebuggable: Boolean = false

    init {
        isDebuggable = BuildConfig.DEBUG
       // isDebuggable = true
    }


    /**
     * Writes debugging log.
     */

    fun write() {

        if (isDebuggable) {
            val sb = StringBuilder()
            val stackTrace = Exception().stackTrace[1]
            var fileName: String? = stackTrace.fileName
            if (fileName == null) {
                fileName = ""  // It is necessary if you want to use proguard obfuscation.
            }
            sb.append(stackTrace.methodName).append("(").append(fileName).append(":").append(stackTrace.lineNumber)
                .append(")")
            Log.d("***", sb.toString())
        }
    }

    fun write(message: Any) {
        if (isDebuggable) {
            val sb = StringBuilder()
            val stackTrace = Exception().stackTrace[1]
            var fileName: String? = stackTrace.fileName
            if (fileName == null) {
                fileName = ""  // It is necessary if you want to use proguard obfuscation.
            }

            sb.append(stackTrace.methodName).append("(").append(fileName).append(":").append(stackTrace.lineNumber)
                .append(")")
            val fullMessage = StringBuilder(message.toString())
            if (fullMessage.length > MAX_INDEX) {

                var theSubstring = fullMessage.substring(0, MAX_INDEX)
                var theIndex = MAX_INDEX

                // Try to find a substring break at a line end.
                // theIndex = theSubstring.lastIndexOf('\n');
                if (theIndex >= MIN_INDEX) {
                    theSubstring = theSubstring.substring(0, theIndex)
                } else {
                    theIndex = MAX_INDEX
                }
                //log the substring
                sb.append(":").append(theSubstring)
                Log.d("***", sb.toString())

                // Recursively log the remainder.
                write(fullMessage.substring(theIndex))

            } else {
                sb.append(":").append(message.toString())
                Log.d("***", sb.toString())
            }


        }

    }

    fun write(tag: String, message: Any) {
        if (isDebuggable) {
            val sb = StringBuilder()
            val stackTrace = Exception().stackTrace[1]
            var fileName: String? = stackTrace.fileName
            if (fileName == null) {
                fileName = ""  // It is necessary if you want to use proguard obfuscation.
            }
           // val info = stackTrace.methodName + " (" + fileName + ":" + stackTrace.lineNumber + ")"
            sb.append(stackTrace.methodName).append("(").append(fileName).append(":").append(stackTrace.lineNumber)
                .append(")")
                .append(" *** ").append(message.toString())

            Log.d("_$tag", sb.toString())
        }

    }
}
