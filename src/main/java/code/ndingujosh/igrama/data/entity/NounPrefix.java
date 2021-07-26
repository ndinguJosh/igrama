package code.ndingujosh.igrama.data.entity;

import code.ndingujosh.igrama.data.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class NounPrefix extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String prefix;

    @ManyToOne
    @JoinColumn(name = "noun_class_id")
    private NounClass nounClass;

    @OneToMany(mappedBy = "prefix")
    private List<Noun> noun;
}
