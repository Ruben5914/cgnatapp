package com.uc3m.cgnnatsapp.viewModels

import android.util.Log
import java.math.BigInteger
import java.security.KeyStore
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidKeySpecException
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import kotlin.experimental.xor

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
        fun checkKey(): Boolean {
            val keystore: KeyStore = KeyStore.getInstance("AndroidKeyStore")
            keystore.load(null)


            try {
                val secretKeyEntry: KeyStore.SecretKeyEntry? = keystore?.getEntry("MyKeyStore", null) as KeyStore.SecretKeyEntry
            } catch (e: Exception){
                return false
            }
            return true


        }



        @Throws(NoSuchAlgorithmException::class, InvalidKeySpecException::class)
         fun generateStorngPasswordHash(password: String): String? {
            val iterations = 1000
            val chars = password.toCharArray()
            val salt = getSalt()
            val spec = PBEKeySpec(chars, salt, iterations, 64 * 8)
            val skf: SecretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            val hash: ByteArray = skf.generateSecret(spec).getEncoded()
            return iterations.toString() + ":" + toHex(salt) + ":" + toHex(hash)
        }

        @Throws(NoSuchAlgorithmException::class)
        private fun getSalt(): ByteArray {
            val sr: SecureRandom = SecureRandom.getInstance("SHA1PRNG")
            val salt = ByteArray(16)
            sr.nextBytes(salt)
            return salt
        }

        @Throws(NoSuchAlgorithmException::class)
        private fun toHex(array: ByteArray): String {
            val bi = BigInteger(1, array)
            val hex = bi.toString(16)
            val paddingLength = array.size * 2 - hex.length
            return if (paddingLength > 0) {
                String.format("%0" + paddingLength + "d", 0) + hex
            } else {
                hex
            }
        }
        @Throws(NoSuchAlgorithmException::class, InvalidKeySpecException::class)
         fun validatePassword(originalPassword: String, storedPassword: String): Boolean {
            val parts = storedPassword.split(":".toRegex()).toTypedArray()
            Log.d("ee", parts[0])
            val iterations = parts[0].toInt()
            val salt = fromHex(parts[1])
            val hash = fromHex(parts[2])
            val spec = PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.size * 8)
            val skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            val testHash = skf.generateSecret(spec).encoded
            var diff = hash.size xor testHash.size
            var i = 0
            while (i < hash.size && i < testHash.size) {
                diff = diff or ((hash[i] xor testHash[i]).toInt())// aqui puede haber fallo
                i++
            }
            return diff == 0
        }

        @Throws(NoSuchAlgorithmException::class)
        private fun fromHex(hex: String): ByteArray {
            val bytes = ByteArray(hex.length / 2)
            for (i in bytes.indices) {
                bytes[i] = hex.substring(2 * i, 2 * i + 2).toInt(16).toByte()
            }
            return bytes
        }

    }
}