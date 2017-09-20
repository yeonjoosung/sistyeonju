import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ¼º¿¬ÁÖ¼÷Á¦ {

	public static void main(String[] args) throws IOException

	{
		
		FileInputStream fin = new FileInputStream("res/foto.bmp");
		FileOutputStream fos = new FileOutputStream("res/fotocopy.bmp");
		
		byte buf[] = new byte[1024];
		int len = 0;
		

		

		while ((len = fin.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}

		fin.close();
		fos.close();
	}

}
