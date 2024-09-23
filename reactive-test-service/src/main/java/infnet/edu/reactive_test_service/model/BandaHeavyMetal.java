package infnet.edu.reactive_test_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("bandas_metal")  // Nome da tabela no banco de dados
public class BandaHeavyMetal {

    @Id
    private Long id;

    private String nome;
    private String origem;
    private int anoFormacao;
    private String generoPrincipal;
    private boolean ativa;

    // Uma banda pode ter um site oficial
    private String siteOficial;

}
