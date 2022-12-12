package tn.esprit.dhiabejaoui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dhiabejaoui.entities.Parking;
import tn.esprit.dhiabejaoui.entities.Personnel;
import tn.esprit.dhiabejaoui.entities.Zone;
import tn.esprit.dhiabejaoui.repositories.ParkingRepository;
import tn.esprit.dhiabejaoui.repositories.PersonnelRepository;
import tn.esprit.dhiabejaoui.repositories.ZoneRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImp implements IService{
    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Personnel ajouterPersonnel(Personnel personnel) {
        return personnelRepository.save(personnel) ;
    }

    @Override
    public void ajoutParkinggetZones(Parking parking) {
        parkingRepository.save(parking);
        List<Zone> zones = parking.getListZones();
        System.out.println(zones);
    }

    @Override
    public void affecterPersonnelZone(int idZone, int idGarde) {
        Zone zone = zoneRepository.findById(idZone).orElse(null);
        Personnel personnel = personnelRepository.findById(idGarde).orElse(null);
        if(zone != null && personnel != null){
            zone.setPersonnel(personnel);
            personnel.setZone(zone);
            zoneRepository.save(zone);
            personnelRepository.save(personnel);
        }
    }

    @Override
    public List<Personnel> getAllPersonnelByParking(Parking parking) {
        List<Personnel> listP = personnelRepository.findAll().stream().filter(p->
                p.getZone().getParking().getId() == parking.getId()).collect(Collectors.toList());
        return listP;
    }

    @Override
    public Integer nombreGardeJour(String adresse) {
        List<Personnel> personnelList =  personnelRepository.findAll().stream().filter(p->
                p.getZone().getParking().getAdresse().equals(adresse)).collect(Collectors.toList());
        int nbr = (int) personnelList.stream().filter(p->p.getPoste().toString().equals("GARDE_JOUR")).count();
        return nbr;
    }
}
