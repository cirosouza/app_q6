package infnet.edu.reactive_test_service.controller;

import infnet.edu.reactive_test_service.model.BandaHeavyMetal;
import infnet.edu.reactive_test_service.service.BandaHeavyMetalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bandas")
@RequiredArgsConstructor
public class BandaHeavyMetalController {

    private final BandaHeavyMetalService bandaHeavyMetalService;

    // Criar ou atualizar uma banda
    @PostMapping
    public Mono<ResponseEntity<BandaHeavyMetal>> criarBanda(@RequestBody BandaHeavyMetal banda) {
        return bandaHeavyMetalService.salvarBanda(banda)
                .map(savedBanda -> new ResponseEntity<>(savedBanda, HttpStatus.CREATED));
    }

    // Listar todas as bandas
    @GetMapping
    public Flux<BandaHeavyMetal> listarBandas() {
        return bandaHeavyMetalService.listarBandas();
    }

    // Buscar uma banda por ID
    @GetMapping("/{id}")
    public Mono<ResponseEntity<BandaHeavyMetal>> buscarBandaPorId(@PathVariable Long id) {
        return bandaHeavyMetalService.buscarBandaPorId(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Buscar bandas por nome
    @GetMapping("/nome/{nome}")
    public Flux<BandaHeavyMetal> buscarBandasPorNome(@PathVariable String nome) {
        return bandaHeavyMetalService.buscarBandasPorNome(nome);
    }

    // Buscar bandas por país de origem
    @GetMapping("/pais/{paisOrigem}")
    public Flux<BandaHeavyMetal> buscarBandasPorOrigem(@PathVariable String Origem) {
        return bandaHeavyMetalService.buscarBandasPorOrigem(Origem);
    }

    // Buscar bandas ativas ou inativas
    @GetMapping("/ativa/{ativa}")
    public Flux<BandaHeavyMetal> buscarBandasAtivas(@PathVariable boolean ativa) {
        return bandaHeavyMetalService.buscarBandasAtivas(ativa);
    }

    // Deletar uma banda por ID
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Object>> deletarBanda(@PathVariable Long id) {
        return bandaHeavyMetalService.deletarBanda(id)
                .then(Mono.fromCallable(() -> ResponseEntity.noContent().build()))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
