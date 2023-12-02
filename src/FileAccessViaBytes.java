import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileAccessViaBytes {
	private FileInputStream in;
	final byte END_OF_FILE = -1;
	private String fileName;
	// SurveyStation survey = new SurveyStation();

	public FileAccessViaBytes(String fileName) {
		this.fileName = fileName;
		openFiles();
	}

	private void openFiles() {
		try {
			in = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Datei existiert nicht");
		}
	}

	public String readNBytes(int n) throws Exception {
		byte[] buffer = new byte[n];

		String s = "";

		try {
			int bytesRead = in.read(buffer);

			// System.out.println("Read " + bytesRead + " bytes.");
			if (bytesRead != -1) {
				s = new String(buffer, StandardCharsets.UTF_8);
				// System.out.println("Length of string: " + s.length());
			} else {
				throw new Exception("EOF");
			}
		} catch (IOException e) {
			System.out.println("Datei ist defekt");
			close();
		}

		return s;
	}

	public void close() {
		try {
			if (in != null) {
				in.close();
				System.out.println("Die Datei ist geschlossen");
			}
		} catch (IOException e) {
			System.out.println("Fehler beim Schließen der Dateien.");
		}
	}
}
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class FileAccessViaBytes {
//	private FileInputStream in;
//	final byte END_OF_FILE = -1;
//	private String fileName;
//	SurveyStation survey = new SurveyStation();
//
//	public FileAccessViaBytes(String fileName) {
//		this.fileName = fileName;
//		openFiles();
//	}
//
//	private void openFiles() {
//		try {
//			in = new FileInputStream(fileName);
//		} catch (FileNotFoundException e) {
//			System.out.println("Datei existiert nicht");
//		}
//	}
//
//	public String readNBytes(int n) {
//        byte[] buffer = new byte[n];
//        String s = null;
//        try {
//            int bytesRead = in.read(buffer);
//            if (bytesRead != END_OF_FILE) {
//                s = new String(buffer, 0, bytesRead);
//            }
//        } catch (IOException e) {
//            System.out.println("Datei ist defekt");
//            close();
//        }
//        return s;
//    }
//
//	public void close() {
//		try {
//			if (in != null) {
//				in.close();
//				System.out.println("Finish");
//			}
//		} catch (IOException e) {
//			System.out.println("Fehler beim Schließen der Dateien.");
//		}
//	}
//}
