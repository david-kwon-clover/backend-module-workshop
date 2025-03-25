package com.multiverse.Snipper.encryption;

import com.multiverse.Snipper.exception.DecryptionException;
import com.multiverse.Snipper.exception.EncryptionException;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class EncryptionService {

  private static final String ALGORITHM = "AES";
  private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
  private final SecretKey secretKey;
  private final IvParameterSpec iv;

  public EncryptionService() {
    try {
      // Generate key
      KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);

      // Try 256-bit first, fallback to 128-bit if needed
      try {
        keyGenerator.init(256);
      } catch (Exception e) {
        keyGenerator.init(128);
      }

      this.secretKey = keyGenerator.generateKey();

      // Generate IV
      byte[] ivBytes = new byte[16];
      new SecureRandom().nextBytes(ivBytes);
      this.iv = new IvParameterSpec(ivBytes);
    } catch (Exception e) {
      throw new RuntimeException("Failed to initialize encryption service", e);
    }
  }

  // Store IV with encrypted data (required for decryption)
  public String encrypt(String plainText) {
    try {
      Cipher cipher = Cipher.getInstance(TRANSFORMATION);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
      byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

      // Combine IV and encrypted content
      byte[] combined = new byte[iv.getIV().length + encryptedBytes.length];
      System.arraycopy(iv.getIV(), 0, combined, 0, iv.getIV().length);
      System.arraycopy(encryptedBytes, 0, combined, iv.getIV().length, encryptedBytes.length);

      return Base64.getEncoder().encodeToString(combined);
    } catch (Exception e) {
      throw new EncryptionException("Failed to encrypt text", e);
    }
  }

  public String decrypt(String encryptedText) {
    try {
      byte[] combined = Base64.getDecoder().decode(encryptedText);

      // Extract IV and encrypted content
      byte[] ivBytes = new byte[16];
      byte[] encryptedBytes = new byte[combined.length - 16];
      System.arraycopy(combined, 0, ivBytes, 0, ivBytes.length);
      System.arraycopy(combined, ivBytes.length, encryptedBytes, 0, encryptedBytes.length);

      IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

      Cipher cipher = Cipher.getInstance(TRANSFORMATION);
      cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
      byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
      return new String(decryptedBytes);
    } catch (IllegalArgumentException e) {
      throw new DecryptionException("Invalid Base64 encoded data", e);
    } catch (Exception e) {
      throw new DecryptionException("Failed to decrypt data", e);
    }
  }
}
