package service;

import java.util.List;

import po.Picture;

public interface PictureService{
	List<Picture> getpiclist(int current,int rowCount);//获取一页记录
	int getpicturenum();//获取总数目
	Picture getPictureByid(String id);//使用主键获取记录
	void SaveorUpdatePicture(Picture p);
	void deletePicture(String id);
}
