import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import javax.imageio.ImageIO;

public class ImageHelper {
    public static File urlImageToFile(String url) throws IOException {
        String extension = ".jpg";
        String fileName = getUniqueFileName(extension);

        return convertMediaToFile(url, fileName, extension);
    }

    public static File urlGifToFile(String url) throws IOException {
        String extension = ".gif";
        String fileName = getUniqueFileName(extension);

        return convertMediaToFile(url, fileName, extension);
    }

    public static File urlMediaToFile(String url, String extension) throws IOException {
        String fileName = getUniqueFileName(extension);
        return convertMediaToFile(url, fileName, extension);
    }

    private static String getUniqueFileName(String extension) {
        UUID uuid = UUID.randomUUID();
        StringBuilder builder = new StringBuilder();

        builder.append("media")
                .append(uuid)
                .append(extension);

        return builder.toString();
    }

    private static File convertMediaToFile(
            String url,
            String fileName,
            String extension) throws IOException {

        URL urlInput = new URL(url);
        BufferedImage urlImage = ImageIO.read(urlInput);

        String ext = extension.replace(".", "");
        File file = new File(fileName);
        ImageIO.write(urlImage, ext, file);

        return file;
    }
}
