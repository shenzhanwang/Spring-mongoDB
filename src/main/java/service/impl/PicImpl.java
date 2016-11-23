package service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import mongodb.PictureRepository;
import po.Picture;
import service.PicService;

@Service
public class PicImpl implements PicService{
	
	private PictureRepository pictureRepository;
	@Autowired
	 public PicImpl(PictureRepository pictureRepository){
		this.pictureRepository=pictureRepository;
	}
	
	public List<Picture> getpiclist(int current,int rowCount) throws Exception {
		PageRequest pr =new PageRequest(--current, rowCount);
		Page<Picture> page=pictureRepository.findAll(pr);
		return page.getContent();
	}
	public Picture getmongobyid(String id) {
		Picture pic=pictureRepository.findById(id);
		return pic;
	}
	
	public void addmongo(Picture p) {
		pictureRepository.save(p);
	}
	public InputStream getpic(String id) {
		Picture b=pictureRepository.findById(id);
		byte[] content=b.getB();
		InputStream is=new ByteArrayInputStream(content);
	    return is;
	}
	public int getpicsize() {
		return (int) pictureRepository.count();
	}


}
