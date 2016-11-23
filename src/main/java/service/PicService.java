package service;

import java.io.InputStream;
import java.util.List;
import po.Picture;

	public interface PicService{
		List<Picture> getpiclist(int current,int rowCount) throws Exception;
		int getpicsize();
		Picture getmongobyid(String pid);
		void addmongo(Picture p);
		InputStream getpic(String id);
	}
