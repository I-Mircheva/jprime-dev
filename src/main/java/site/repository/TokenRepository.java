package site.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository(value = TokenRepository.NAME)
public interface TokenRepository<T> extends PagingAndSortingRepository<T, Long>{
	public String NAME = "tokenRepository";
}
