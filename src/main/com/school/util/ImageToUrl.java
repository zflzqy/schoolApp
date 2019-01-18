package school.util;


import com.alibaba.fastjson.JSONObject;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageToUrl {
    /**
     * 解析图像
     */
    public static String testDecode(String path) {
        BufferedImage image;
        String rs ="";
        try {
            image = ImageIO.read(new File(path));
//            BufferedImage cropedImage = image.getSubimage(0, 0, 914, 400);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<>();
            // 乱码问题
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            // 优化精度
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            //复杂模式，开启PURE_BARCODE模式（带图片LOGO的解码方案）
            hints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
            System.out.println("解析的url:"+result.getText());
            rs = result.getText();

        } catch (IOException e) {
            System.out.println("异常1");
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
            System.out.println("图片解析失败异常异常");
            rs ="";
            return  rs;
        }
        return  rs;
    }
}
