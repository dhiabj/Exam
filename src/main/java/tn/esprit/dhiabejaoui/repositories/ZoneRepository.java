package tn.esprit.dhiabejaoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dhiabejaoui.entities.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer> {
}
