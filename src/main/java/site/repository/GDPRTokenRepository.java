package site.repository;

import org.springframework.stereotype.Repository;
import site.model.GDPRToken;
import site.model.User;

import java.util.List;

@Repository(value = GDPRTokenRepository.NAME)

public interface GDPRTokenRepository extends AbstractTokenRepository<GDPRToken> {
    String NAME = "GDPRTokenRepository";
}
