// 
// 
// 

package com.esms.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import java.awt.Graphics2D;
import java.io.OutputStream;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.awt.Color;
import java.util.Random;

public final class CaptchaUtil
{
    private static final char[] CHARS;
    private static Random random;
    
    static {
        CHARS = new char[] { '2', '3', '4', '5', '6', '7', '8', '9' };
        CaptchaUtil.random = new Random();
    }
    
    private static String getRandomString() {
        final StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 4; ++i) {
            buffer.append(CaptchaUtil.CHARS[CaptchaUtil.random.nextInt(CaptchaUtil.CHARS.length)]);
        }
        return buffer.toString();
    }
    
    private static Color getRandomColor() {
        return new Color(CaptchaUtil.random.nextInt(255), CaptchaUtil.random.nextInt(255), CaptchaUtil.random.nextInt(255));
    }
    
    private static Color getReverseColor(final Color c) {
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }
    
    public static void outputCaptcha(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        final String identifyingCode = getRandomString();
        request.getSession(true).setAttribute("identifyingCode", (Object)identifyingCode);
        final int width = 100;
        final int height = 30;
        final Color color = getRandomColor();
        final Color reverse = getReverseColor(color);
        final BufferedImage bi = new BufferedImage(width, height, 1);
        final Graphics2D g = bi.createGraphics();
        g.setFont(new Font("SansSerif", 1, 16));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(identifyingCode, 18, 20);
        for (int i = 0, n = CaptchaUtil.random.nextInt(100); i < n; ++i) {
            g.drawRect(CaptchaUtil.random.nextInt(width), CaptchaUtil.random.nextInt(height), 1, 1);
        }
        final ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpeg", (OutputStream)out);
        out.flush();
    }
}
