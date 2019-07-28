package com.example.movieslist.utils.extencion

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


private fun convertToHex(data: ByteArray): String {
    val buf = StringBuffer()
    for (i in data.indices) {
        var halfbyte = (data[i].toInt() shr 4) and 0x0F
        var two_halfs = 0
        do {
            if ((0 <= halfbyte) && (halfbyte <= 9)) {
                buf.append(('0' + halfbyte))
            }
            else {
                buf.append(('a' + (halfbyte - 10)))
            }
            halfbyte = data[i].toInt() and 0x0F
        } while (two_halfs++ < 1)
    }
    return buf.toString()
}


@Throws(NoSuchAlgorithmException::class, UnsupportedEncodingException::class)
fun String.SHA1(): String {
    val md = MessageDigest.getInstance("SHA-1")
    var sha1hash = ByteArray(40)
    md.update(this.toByteArray(charset("iso-8859-1")), 0, this.length)
    sha1hash = md.digest()
    return convertToHex(sha1hash)
}