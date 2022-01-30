import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import javax.imageio.ImageIO;

public class ImageHelper {
    public static File urlImageToFile(String url) throws IOException {
        UUID uuid = UUID.randomUUID();
        String fileName = "image" + uuid + ".jpg";

        URL urlInput = new URL(url);
        BufferedImage urlImage = ImageIO.read(urlInput);

        File file = new File(fileName);
        ImageIO.write(urlImage, "jpg", file);

        return file;
    }
}
