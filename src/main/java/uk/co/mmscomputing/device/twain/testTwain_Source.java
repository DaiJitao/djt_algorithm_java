package uk.co.mmscomputing.device.twain;


import uk.co.mmscomputing.device.scanner.Scanner;
import uk.co.mmscomputing.device.scanner.ScannerIOException;
import uk.co.mmscomputing.device.scanner.ScannerIOMetadata;
import uk.co.mmscomputing.device.scanner.ScannerListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author Tyler
 * @date 2019/8/16
 */
public class testTwain_Source implements ScannerListener {

    static int index=0;
    static String filename=System.getProperty("user.home")+"\\My Documents\\test";
    static String jtwain_dill = "E:\\workspace\\java\\djt_algorithm_java\\src\\main\\java\\uk\\co\\mmscomputing\\device\\twain\\win64\\jtwain.dll";



    Scanner scanner = Scanner.getDevice();
    public static void main(String[] var0) throws ScannerIOException {
        System.out.println(filename);
        new testTwain_Source(var0);
    }

    public testTwain_Source(String[] var1) throws ScannerIOException {
        TwainScanner twainScanner = new TwainScanner();
        twainScanner.addListener(this);
        jtwain.setScanner(twainScanner);
        //jtwain.getSource().setShowUI(false);
        //选择驱动，注释代表默认上次选择
        //jtwain.select();
        //防止多个驱动，默认查找EPSON驱动
        //jtwain.select("EPSON DS-410");
        jtwain.acquire(twainScanner);

        //这样也可以
        //scanner.addListener(this);
        //jtwain.getSource().setShowUI(false);
        //scanner.acquire();
    }

    public void update(ScannerIOMetadata.Type var1, ScannerIOMetadata var2) {
        if (var1.equals(ScannerIOMetadata.ACQUIRED)) {
            System.out.println("ACQUIRED");
            BufferedImage var3 = var2.getImage();
            try {
                ImageIO.write(var3, "png", new File(filename+index+".png"));
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        } else if (var1.equals(ScannerIOMetadata.NEGOTIATE)) {
            System.out.println("NEGOTIATE");
//            ScannerDevice var6 = var2.getDevice();
            BufferedImage var3 = var2.getImage();
            try {
                ImageIO.write(var3, "png", new File(filename+index+".png"));
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        } else if (var1.equals(ScannerIOMetadata.STATECHANGE)) {
            System.out.println("STATECHANGE");
            System.err.println(var2.getStateStr());
            if (var2.isFinished()) {
                System.exit(0);
            }
        } else if (var1.equals(ScannerIOMetadata.EXCEPTION)) {
            System.out.println("EXCEPTION");
            var2.getException().printStackTrace();
        }

    }


}
