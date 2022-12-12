package tn.esprit.dhiabejaoui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dhiabejaoui.entities.Parking;
import tn.esprit.dhiabejaoui.entities.Personnel;
import tn.esprit.dhiabejaoui.services.IService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {
    @Autowired
    private IService service;

    @PostMapping("addPersonnel")
    public Personnel addPersonnel(@RequestBody Personnel personnel){
        return service.ajouterPersonnel(personnel);
    }

    @PostMapping("addParkingAndGetZones")
    public void addPersonnel(@RequestBody Parking parking){
        service.ajoutParkinggetZones(parking);
    }

    @PutMapping("/assignPersonnelZone/{idZone}/{idGarde}")
    public void assignPeronnelToZone(@PathVariable Integer idZone, @PathVariable Integer idGarde)
    {
        service.affecterPersonnelZone(idZone,idGarde);
    }

    @GetMapping("/getPersonnelByParking")
    public List<Personnel> getAllPersonnelByParking(@RequestBody Parking parking)
    {
        return service.getAllPersonnelByParking(parking);
    }

    @GetMapping("/getNbrGardeJour/{adresse}")
    public Integer nbrGardeJour(@PathVariable String adresse)
    {
        return service.nombreGardeJour(adresse);
    }
}
