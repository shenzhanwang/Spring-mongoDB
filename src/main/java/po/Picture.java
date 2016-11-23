package po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "picture")
public class Picture {
	//pid供mongodb内部使用
	@Id
	private String id;
	private String filename;
	private long size;
	private byte[] b;
	
	public Picture(){}
	
	public Picture(String filename,long size,byte[] b){
		this.filename=filename;
		this.size=size;
		this.b=b;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}

	public byte[] getB() {
		return b;
	}

	public void setB(byte[] b) {
		this.b = b;
	}
	
}
