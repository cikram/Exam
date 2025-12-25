package ma.xproce.exam.dao.entities;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String titre;
    private String description;


    private Date dateCreation;
    private Double montantobj;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "action")
    private List<Don> dons;

    @ManyToOne
    private Organisation organisation;


}
