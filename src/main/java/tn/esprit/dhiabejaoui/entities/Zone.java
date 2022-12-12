package tn.esprit.dhiabejaoui.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private float dimension;

    @ManyToOne
    private Parking parking;

    @OneToMany
    private List<Personnel> personnelList;
    @OneToOne
    private Personnel personnel;
}
