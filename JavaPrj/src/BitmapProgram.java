
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapProgram {
	public static void main(String[] args) throws IOException {

		FileInputStream fin = new FileInputStream("res/foto.bmp");
		FileOutputStream fout = new FileOutputStream("res/foto_c.bmp");

		byte[] buf = new byte[1024];

		int len = 0;
		while ((len = fin.read(buf)) != -1) {

//			len = fin.read(buf);
			fout.write(buf, 0, len);
		}

		System.out.println("e");

		// byte[] fileHeader = new byte[14];
		// byte[] bmpHeader = new byte[12];
		// fin.read(fileHeader);
		// fin.read(bmpHeader);
		// int width =
		// ((int) bmpHeader[4]) & 0x000000ff //0x-4∫Ò∆Æ
		// | (((int) bmpHeader[5]) << 8)
		// | (((int) bmpHeader[6]) << 16)
		// | (((int) bmpHeader[7]) << 24);
		// System.out.printf("width: %d\n", width);

	}

}
