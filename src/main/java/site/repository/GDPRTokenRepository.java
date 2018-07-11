package site.repository;

import org.springframework.stereotype.Repository;
import site.model.GDPRToken;
import site.model.User;

import java.util.List;

@Repository(value = GDPRTokenRepository.NAME)

public interface GDPRTokenRepository extends AbstractTokenRepository<GDPRToken, Long> {
    String NAME = "GDPRTokenRepository";

    GDPRToken findByTokenId(String tokenId);

    List<GDPRToken> findAllByOwner(User owner);
}
