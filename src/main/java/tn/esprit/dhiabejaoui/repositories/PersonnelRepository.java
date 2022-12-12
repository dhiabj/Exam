package tn.esprit.dhiabejaoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dhiabejaoui.entities.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
}
