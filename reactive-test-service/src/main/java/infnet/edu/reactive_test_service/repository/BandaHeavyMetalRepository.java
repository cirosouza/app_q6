package infnet.edu.reactive_test_service.repository;

import infnet.edu.reactive_test_service.model.BandaHeavyMetal;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BandaHeavyMetalRepository extends ReactiveCrudRepository<BandaHeavyMetal, Long> {

    // Método customizado para buscar bandas por nome
    Flux<BandaHeavyMetal> findByNome(String nome);

    // Método customizado para buscar bandas por país de origem
    Flux<BandaHeavyMetal> findByOrigem(String Origem);

    // Método customizado para buscar bandas ativas ou inativas
    Flux<BandaHeavyMetal> findByAtiva(boolean ativa);
}