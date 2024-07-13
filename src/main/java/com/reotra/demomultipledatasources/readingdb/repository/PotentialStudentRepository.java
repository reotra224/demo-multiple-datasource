package com.reotra.demomultipledatasources.readingdb.repository;

import com.reotra.demomultipledatasources.readingdb.domain.PotentialStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotentialStudentRepository extends JpaRepository<PotentialStudent, Long> {
}
