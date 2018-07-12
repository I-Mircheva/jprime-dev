package site.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import site.model.Tag;

import java.util.List;

@Repository(value = TagRepository.NAME)
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {

	String NAME = "tagRepository";
	
	public List<Tag> findAll();

}
