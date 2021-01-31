package com.coloresreactivo.web;

import com.coloresreactivo.business.ColoresService;
import com.coloresreactivo.model.api.request.CreateColorRequest;
import com.coloresreactivo.model.api.response.ColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("colores")
@AllArgsConstructor
public class ColorController {

    private final ColoresService coloresService;


    @PostMapping
    public Mono<ColorResponse> saveColor(@RequestBody CreateColorRequest createColorRequest) {
        return coloresService
                .saveColor(createColorRequest);
    }

    @GetMapping
    public Flux<ColorResponse> findAllColor() {
        return coloresService.findAllColor();
    }

    @PutMapping("/{idColor}")
    public Mono<ColorResponse> updateColor(
            @RequestBody CreateColorRequest createColorRequest,
            @PathVariable Integer idColor) {
        return coloresService.updateColor(createColorRequest, idColor);
    }

    @DeleteMapping("/{idColor}")
    public Mono<Boolean> deleteColor(@PathVariable Integer idColor) {
        return coloresService.deleteColor(idColor);
    }

    @GetMapping("/{idColor}")
    public Mono<ColorResponse> findByIdColor(@PathVariable Integer idColor) {
        return coloresService.findByIdColor(idColor);
    }
}
