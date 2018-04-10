package org.img;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Image2Text {
	public static void main(String[] args) {
		System.out.println(crackImage("test.jpg"));
	}

	public static String crackImage(String filePath) {
		File imageFile = new File(filePath);
		ITesseract instance = new Tesseract();
		instance.setDatapath("tessdata");
		instance.setLanguage("eng");
		try {
			String result = instance.doOCR(imageFile);
			return result;
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
			return "Error while reading image";
		}
	}

}
