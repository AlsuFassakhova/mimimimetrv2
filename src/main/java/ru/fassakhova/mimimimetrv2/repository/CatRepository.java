package ru.fassakhova.mimimimetrv2.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.fassakhova.mimimimetrv2.entity.Cat;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    @Query("SELECT c FROM Cat c ORDER BY c.votes desc")
    List<Cat> findTopTenByVotesDesc(Pageable pageable);

    @Modifying
    @Query("UPDATE Cat c SET c.votes = c.votes + 1 WHERE c.catId = :id")
    void incrementVotes(@Param("id") Long id);
}
