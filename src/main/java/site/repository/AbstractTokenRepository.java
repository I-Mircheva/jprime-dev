package site.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AbstractTokenRepository<T,ID> extends PagingAndSortingRepository <T, ID> {

}
