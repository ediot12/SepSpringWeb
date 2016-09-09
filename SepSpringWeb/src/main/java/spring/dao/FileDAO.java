package spring.dao;

import org.apache.ibatis.session.SqlSession;

public class FileDAO {

	private String originalfilename;
	private String filepath;
	private long filesize;
	SqlSession session;

	FileDAO() {

	}

	FileDAO(String originalfilename, String filepath, long filesize) {
		super();
		this.originalfilename = originalfilename;
		this.filepath = filepath;
		this.filesize = filesize;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public int InsertDB(String originalfilename, String filepath, long filesize) {
	
		return session.insert("filesql.insert", new FileDAO(originalfilename, filepath, filesize));
	}

	public String getoriginalfilename() {
		return originalfilename;
	}

	public void setoriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}

	public String getfilepath() {
		return filepath;
	}

	public void setfilepath(String filepath) {
		this.filepath = filepath;
	}

	public long getfilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

}
