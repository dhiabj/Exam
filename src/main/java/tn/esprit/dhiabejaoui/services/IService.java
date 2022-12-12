package tn.esprit.dhiabejaoui.services;

import tn.esprit.dhiabejaoui.entities.Parking;
import tn.esprit.dhiabejaoui.entities.Personnel;

import java.util.List;

public interface IService {
    Personnel ajouterPersonnel(Personnel personnel);
    void ajoutParkinggetZones(Parking parking);
    void affecterPersonnelZone(int idZone, int idGarde);
    List<Personnel> getAllPersonnelByParking(Parking parking);
    Integer nombreGardeJour(String adresse);
}
