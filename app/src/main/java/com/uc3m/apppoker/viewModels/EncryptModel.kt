package com.uc3m.apppoker.viewModels

import android.util.Log
import java.math.BigInteger
import java.security.KeyStore
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

class EncryptModel {
    companion object {
        fun encryptData(data: String): Pair<ByteArray, ByteArray> {
            val cipher: Cipher = Cipher.getInstance("AES/CBC/NoPadding")

            var temp: String = data
            while (temp.toByteArray().size % 16 != 0)
                temp += "\u0020"

            cipher.init(Cipher.ENCRYPT_MODE, getKey())

            val ivBytes = cipher.iv

            val encryptedBytes = cipher.doFinal(temp.toByteArray())

            return Pair(ivBytes, encryptedBytes)
        }

        fun getKey(): SecretKey {
            val keystore: KeyStore = KeyStore.getInstance("AndroidKeyStore")
            keystore.load(null)

            val secretKeyEntry = keystore.getEntry("MyKeyStore", null) as KeyStore.SecretKeyEntry
            return secretKeyEntry.secretKey
        }

        fun decryptData(ivBytes: ByteArray, data: ByteArray): String {
            val cipher = Cipher.getInstance("AES/CBC/NoPadding")
            val spec = IvParameterSpec(ivBytes)
            cipher.init(Cipher.DECRYPT_MODE, getKey(), spec)
            return cipher.doFinal(data).toString(Charsets.UTF_8).trim()
        }

        fun md5(datos: String): String{

            var md5Data : BigInteger = BigInteger("2")
            var result: String = ""
            try {

                val md5 = MessageDigest.getInstance("MD5")
                val md5HashBytes = md5.digest(datos.toByteArray()).toTypedArray()

                result = byteArrayToHexString(md5HashBytes)
            }catch (e: Exception){
                Log.e("Error al hacer el hash", "error hash")
                result = "error"
            }


            return result
        }
        private fun byteArrayToHexString( array: Array<Byte> ): String {

            var result = StringBuilder(array.size * 2)

            for ( byte in array ) {

                val toAppend =
                        String.format("%2X", byte).replace(" ", "0") // hexadecimal
                result.append(toAppend).append("-")
            }
            result.setLength(result.length - 1) // remove last '-'

            return result.toString()
        }

    }
}