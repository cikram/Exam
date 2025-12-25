package ma.xproce.exam.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Don {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private Double montant;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    private Action action;

    @ManyToOne
    private Donateur donateur;
}
