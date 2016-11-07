package sinlov.android.utils;

import java.io.*;

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
 * Created by sinlov on 16/11/7.
 */
public class DimenUtils {


    public static void writeFile(String file, String text) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.close();
    }

    public static void dimeGenerate(File file) {
        BufferedReader reader = null;
        StringBuilder sw480 = new StringBuilder();
        StringBuilder sw600 = new StringBuilder();
        StringBuilder sw720 = new StringBuilder();
        StringBuilder sw800 = new StringBuilder();
        StringBuilder w820 = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("</dimen>")) {
                    String start = tempString.substring(0, tempString.indexOf('>') + 1);
                    String end = tempString.substring(tempString.lastIndexOf('<') - 2);
                    int num = Integer.valueOf(tempString.substring(tempString.indexOf('>') + 1,
                            tempString.indexOf("</dimen>") - 2));
                    sw480.append(start).append((int) Math.round(num * 0.6)).append(end).append("");
                    sw600.append(start).append((int) Math.round(num * 0.75)).append(end).append("");
                    sw720.append(start).append((int) Math.round(num * 0.9)).append(end).append("");
                    sw800.append(tempString).append("");
                    w820.append(tempString).append("");
                } else {
                    sw480.append(tempString).append("");
                    sw600.append(tempString).append("");
                    sw720.append(tempString).append("");
                    sw800.append(tempString).append("");
                    w820.append(tempString).append("");
                }
                line++;
            }
            reader.close();
            String sw480file = "./app/src/main/res/values-sw480dp-land/dimens.xml";
            writeFile(sw480file, sw480.toString());
            System.out.println("Finish generate sw480 -> " + sw480file);
            String sw600file = "./app/src/main/res/values-sw600dp-land/dimens.xml";
            writeFile(sw600file, sw600.toString());
            System.out.println("Finish generate sw600 -> " + sw600file);
            String sw720file = "./app/src/main/res/values-sw720dp-land/dimens.xml";
            writeFile(sw720file, sw720.toString());
            System.out.println("Finish generate sw720 -> " + sw720file);
            String sw800file = "./app/src/main/res/values-sw800dp-land/dimens.xml";
            writeFile(sw800file, sw800.toString());
            System.out.println("Finish generate sw800 -> " + sw800file);
            String w820file = "./app/src/main/res/values-w820dp/dimens.xml";
            writeFile(w820file, w820.toString());
            System.out.println("Finish generate w820 -> " + w820file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please check input or input -h see help");
            System.exit(1);
        }
        String genPath = args[0];
        if (genPath != null && !genPath.equals("")) {
            genPath = "./app/src/main/res/values/dimens.xml";
        } else {
            genPath = ".";
        }
        File file = new File(genPath);
        if (!file.exists()) {
            System.out.println("gen path not found at " + genPath + " please check");
            System.exit(1);
        }
        dimeGenerate(file);
    }
}
