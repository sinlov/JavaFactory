package sinlov.android.utils;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 16/11/22.
 */
public class Png9Utils {

    public static final String dir9png = "/Users/sinlov/Downloads/APKCatch/res/drawable-hdpi/";

    public static void main(String[] args) {

        String property = System.getProperty("user.home");
        System.out.println("property: " + property);
        File fdir = new File(dir9png);
        if (fdir.isDirectory()) {//遍历目录文件
            File[] files = fdir.listFiles();
            for (File f : files) {
                if (f.isFile())
                    to9Patch(f);
            }
        }
    }


    /**
     * 转换成点9
     */
    public static void to9Patch(File file) {
        try {

            String fileName = file.getName().toLowerCase();
            /**
             * 如果是点9图片或不是png图片直接返回
             */
            if (fileName.endsWith(".9.png") || !fileName.endsWith(".png")) return;
            convertTo9Patch(loadCompatibleImage(file.toURI().toURL()), file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertTo9Patch(BufferedImage image, File file) throws IOException {
        /**
         * 高度和宽度增加两个点
         */
        BufferedImage buffer = createTranslucentCompatibleImage(
                image.getWidth() + 2, image.getHeight() + 2);
        Graphics2D g2 = buffer.createGraphics();
        g2.drawImage(image, 1, 1, null);
        g2.dispose();
        image = buffer;
        String name = file.getName();
        /**
         * 重命名点9.png
         */
        name = (name.substring(0, name.lastIndexOf('.')) + ".9.png");
        ImageIO.write(image, "PNG", new File(dir9png + name));
    }

    private static BufferedImage createTranslucentCompatibleImage(int width,
                                                                  int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height,
                3);
    }

    private static GraphicsConfiguration getGraphicsConfiguration() {
        GraphicsEnvironment environment = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        return environment.getDefaultScreenDevice().getDefaultConfiguration();
    }

    private static BufferedImage loadCompatibleImage(URL resource)
            throws IOException {
        BufferedImage image = ImageIO.read(resource);
        return toCompatibleImage(image);
    }

    private static boolean isHeadless() {
        return GraphicsEnvironment.isHeadless();
    }

    private static BufferedImage toCompatibleImage(BufferedImage image) {
        if (isHeadless()) {
            return image;
        }
        if (image.getColorModel().equals(
                getGraphicsConfiguration().getColorModel())) {
            return image;
        }
        BufferedImage compatibleImage = getGraphicsConfiguration()
                .createCompatibleImage(image.getWidth(), image.getHeight(),
                        image.getTransparency());

        Graphics g = compatibleImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return compatibleImage;
    }
}
