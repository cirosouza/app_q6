package infnet.edu.reactive_test_service.service;

import infnet.edu.reactive_test_service.model.BandaHeavyMetal;
import infnet.edu.reactive_test_service.repository.BandaHeavyMetalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BandaHeavyMetalService {

    private final BandaHeavyMetalRepository bandaHeavyMetalRepository;

    // Salvar ou atualizar uma banda
    public Mono<BandaHeavyMetal> salvarBanda(BandaHeavyMetal banda) {
        return bandaHeavyMetalRepository.save(banda);
    }

    // Buscar todas as bandas
    public Flux<BandaHeavyMetal> listarBandas() {
        return bandaHeavyMetalRepository.findAll();
    }

    // Buscar uma banda por ID
    public Mono<BandaHeavyMetal> buscarBandaPorId(Long id) {
        return bandaHeavyMetalRepository.findById(id);
    }

    // Buscar bandas por nome
    public Flux<BandaHeavyMetal> buscarBandasPorNome(String nome) {
        return bandaHeavyMetalRepository.findByNome(nome);
    }

    // Buscar bandas por país de origem
    public Flux<BandaHeavyMetal> buscarBandasPorOrigem(String Origem) {
        return bandaHeavyMetalRepository.findByOrigem(Origem);
    }

    // Buscar bandas ativas ou inativas
    public Flux<BandaHeavyMetal> buscarBandasAtivas(boolean ativa) {
        return bandaHeavyMetalRepository.findByAtiva(ativa);
    }

    // Deletar uma banda por ID
    public Mono<Void> deletarBanda(Long id) {
        return bandaHeavyMetalRepository.deleteById(id);
    }
}
