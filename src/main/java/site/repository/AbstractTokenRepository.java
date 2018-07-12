package site.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import site.model.AbstractToken;
import site.model.User;

public interface AbstractTokenRepository<T extends AbstractToken> extends PagingAndSortingRepository <T, Long> {
	
    T findByTokenId(String tokenId);

    List<T> findAllByOwner(User owner);
}
