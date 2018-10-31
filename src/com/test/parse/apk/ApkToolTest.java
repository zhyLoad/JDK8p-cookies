/**
 * 
 */
package com.test.parse.apk;

import java.io.File;
import java.io.IOException;

import brut.androlib.AndrolibException;
import brut.androlib.ApkDecoder;
import brut.directory.DirectoryException;

/**
 * @author 10007610
 *
 */
public class ApkToolTest {

	/**
	 * 
	 */
	public ApkToolTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

				try {
					File inFile = new File("D:\\ParseAPK\\pro999.apk");
					ApkDecoder decoder = new ApkDecoder();
					decoder.setOutDir(new File("D:\\ParseAPK\\apkToolOutDir"));
					decoder.setApkFile(inFile);
					decoder.decode();
				} catch (AndrolibException e) {
					e.printStackTrace();
				} catch (DirectoryException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

}
