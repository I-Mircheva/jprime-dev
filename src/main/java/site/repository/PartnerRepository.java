package site.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import site.model.Partner;
import site.model.PartnerPackage;

@Repository(value = PartnerRepository.NAME)
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Long> {

	String NAME = "partnerRepository";

    List<Partner> findAll();

    List<Partner> findByActiveAndPartnerPackage(Boolean active, PartnerPackage partnerPackage);
}
