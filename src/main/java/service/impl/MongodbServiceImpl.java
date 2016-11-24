package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import mongodb.PictureRepository;
import po.Picture;
import service.PictureService;

@Service
public class MongodbServiceImpl implements PictureService{
	
	private PictureRepository pictureRepository;
	@Autowired
	 public MongodbServiceImpl(PictureRepository pictureRepository){
		this.pictureRepository=pictureRepository;
	}
	
	public List<Picture> getpiclist(int current,int rowCount){
		PageRequest pr =new PageRequest(--current, rowCount);
		Page<Picture> page=pictureRepository.findAll(pr);
		return page.getContent();
	}
	public Picture getPictureByid(String id) {
		Picture pic=pictureRepository.findById(id);
		return pic;
	}
	
	public int getpicturenum() {
		return (int) pictureRepository.count();
	}

	public void deletePicture(String id) {
		pictureRepository.delete(id);
	}

	public void SaveorUpdatePicture(Picture p) {
		pictureRepository.save(p);
	}



}
