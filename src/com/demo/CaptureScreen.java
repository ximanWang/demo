package com.demo;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 抓屏程序
 * 
 * @author ximan
 * 
 */
public class CaptureScreen {
	public static void captureScreen(String fileName) throws Exception {
		Dimension screanSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screanRectangle = new Rectangle(screanSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screanRectangle);
		ImageIO.write(image, "png", new File(fileName));
	}
	public static void main(String[] args) throws Exception {
		captureScreen("test");
	}
}
