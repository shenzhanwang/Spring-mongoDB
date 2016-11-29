package dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import po.Picture;

public interface PictureRepository extends MongoRepository<Picture, String>{
	Picture findById(String id);
	Page<Picture> findAll(Pageable pageable);
	
}
