package Example.Example_04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * 파일 출력자
 */
public class CWriter_File implements IWriter {
	private BufferedWriter m_oWriter = null;
	
	/** 생성자 */
	public CWriter_File(String a_oPath_File) {
		try {
			File oFile = new File(a_oPath_File);
			FileWriter oWriter_File = new FileWriter(oFile);
			
			m_oWriter = new BufferedWriter(oWriter_File);
		} catch(Exception a_oException) {
			a_oException.printStackTrace();
		}
	}
	
	/** 문자열을 출력한다 */
	@Override
	public void writeStr(String a_oStr) {
		try {
			m_oWriter.write(a_oStr);
			m_oWriter.newLine();
			
			m_oWriter.flush();
		} catch(Exception a_oException) {
			a_oException.printStackTrace();
		}
	}
}
