package mongodb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import po.Picture;

public interface PictureRepository extends MongoRepository<Picture, String>{
	Picture findById(String  id);
	Page<Picture> findAll(Pageable pageable);
}
