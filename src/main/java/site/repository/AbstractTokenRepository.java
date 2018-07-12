package site.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import site.model.AbstractToken;
import site.model.User;

//@Repository(value = AbstractTokenRepository.NAME)
@NoRepositoryBean
public interface AbstractTokenRepository<T extends AbstractToken> extends PagingAndSortingRepository <T, Long> {
	
	String NAME = "abstractTokenRepository";
	
    T findByTokenId(String tokenId);

    List<T> findAllByOwner(User owner);
}
