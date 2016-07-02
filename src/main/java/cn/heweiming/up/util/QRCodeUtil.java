package cn.heweiming.up.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeUtil {

	public static byte[] generatorQRCode(String contents) {
		byte[] data = null;
		int width = 200;
		int height = 200;
		String format = "png";
		Map<EncodeHintType, Object> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		
		try(ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
			BitMatrix matrix = new MultiFormatWriter().encode(contents,
					BarcodeFormat.QR_CODE, width, height);
			MatrixToImageWriter.writeToStream(matrix, format, stream);
			data = stream.toByteArray();
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}
