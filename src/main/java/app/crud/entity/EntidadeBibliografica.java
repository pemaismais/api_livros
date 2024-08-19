package app.crud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@MappedSuperclass
public class EntidadeBibliografica extends Produto {

    @ManyToOne(cascade = CascadeType.ALL)
    private Editora editora;
    private int anoPublicacao;
}
