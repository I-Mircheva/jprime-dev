package site.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import site.model.Sponsor;

@Repository(value = SponsorRepository.NAME)
public interface SponsorRepository extends PagingAndSortingRepository<Sponsor, Long> {

	String NAME = "sponsorRepository";

    List<Sponsor> findAll();

    List<Sponsor> findByActive(Boolean active);
}
