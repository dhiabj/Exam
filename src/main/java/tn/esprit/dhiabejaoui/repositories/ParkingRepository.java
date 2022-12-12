package tn.esprit.dhiabejaoui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dhiabejaoui.entities.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking,Integer> {
}
