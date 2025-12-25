package ma.xproce.exam.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Donateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom ;
    private String prenom;
    private String email;

    @Enumerated(EnumType.STRING)
    private Evaluation evaluation;

    @OneToMany(mappedBy="donateur")
    private List<Don> dons;

}
