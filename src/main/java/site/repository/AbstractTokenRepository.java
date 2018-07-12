package site.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import site.model.AbstractToken;
import site.model.User;

import java.util.List;

public interface AbstractTokenRepository<T extends AbstractToken> extends PagingAndSortingRepository <T, Long> {
	
    T findByTokenId(String tokenId);

    List<T> findAllByOwner(User owner);
}
