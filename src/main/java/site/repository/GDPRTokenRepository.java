package site.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import site.model.GDPRToken;
import site.model.User;

import java.util.List;

@Repository(value = GDPRTokenRepository.NAME)

public interface GDPRTokenRepository extends PagingAndSortingRepository<GDPRToken, Long> , 
 AbstractTokenRepository<GDPRToken>{
    public static String NAME = "GDPRTokenRepository";

}
