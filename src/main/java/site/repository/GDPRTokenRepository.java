package site.repository;

import org.springframework.stereotype.Repository;
import site.model.GDPRToken;

@Repository(value = GDPRTokenRepository.NAME)

public interface GDPRTokenRepository extends AbstractTokenRepository<GDPRToken> {
    String NAME = "GDPRTokenRepository";
}
