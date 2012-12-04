package com.hp.it.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.Provider;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class EncryptUtil
{
	byte[] encryptKey;
	DESedeKeySpec spec;
	SecretKeyFactory keyFactory;
	SecretKey theKey;
	Cipher cipher;
	IvParameterSpec IvParameters;

	public EncryptUtil()
	{
		try
		{
			try
			{
				Cipher c = Cipher.getInstance("DESede");
			} catch (Exception e)
			{
				System.err.println("Installling SunJCE provider.");
				Provider sunjce = new com.sun.crypto.provider.SunJCE();
				Security.addProvider(sunjce);
			}
			encryptKey = "This is a test DESede Key".getBytes();

			spec = new DESedeKeySpec(encryptKey);

			keyFactory = SecretKeyFactory.getInstance("DESede");

			theKey = keyFactory.generateSecret(spec);

			cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

			IvParameters = new IvParameterSpec(new byte[] { 12, 34, 56, 78, 90, 87, 65, 43 });
		} catch (Exception exc)
		{
		}
	}

	public byte[] encrypt(String password)
	{
		String encrypted_password = null;
		byte[] encrypted_pwd = null;

		try
		{
			cipher.init(Cipher.ENCRYPT_MODE, theKey, IvParameters);
			byte[] plainttext = password.getBytes();
			encrypted_pwd = cipher.doFinal(plainttext);
			encrypted_password = new String(encrypted_pwd);
		} catch (Exception ex)
		{
		}
		return encrypted_pwd;
	}

	public String decrypt(byte[] password)
	{
		String decrypted_password = null;
		try
		{
			cipher.init(Cipher.DECRYPT_MODE, theKey, IvParameters);
			byte[] decryptedPassword = password;
			byte[] decrypted_pwd = cipher.doFinal(decryptedPassword);
			decrypted_password = new String(decrypted_pwd);
		} catch (Exception ex)
		{
			System.out.println(ex);
		}
		return decrypted_password;
	}

	public static void main(String args[]) throws UnsupportedEncodingException
	{
		EncryptUtil encryptUtil = new EncryptUtil();
		byte bb[] = encryptUtil.encrypt("abcdefgh");
		System.out.println("length： " + bb.length);
		for (byte t : bb)
		{
			System.out.print(t + " ");
		}
		System.out.println();
		System.out.println(bb);
		String tmp = null;
		tmp = new String(bb, "US-ASCII");

		System.out.println(tmp.getBytes("US-ASCII"));

		String str = encryptUtil.decrypt(bb);
		String str2 = encryptUtil.decrypt(tmp.getBytes("US-ASCII"));
		System.out.println(str);
		System.out.println(str2);
	}
}
