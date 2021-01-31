package com.coloresreactivo.business;

import com.coloresreactivo.model.api.request.CreateColorRequest;
import com.coloresreactivo.model.api.response.ColorResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ColoresService {

    Mono<ColorResponse> saveColor(CreateColorRequest createColorRequest);

    Flux<ColorResponse> findAllColor();

    Mono<ColorResponse> updateColor(CreateColorRequest createColorRequest, Integer idColor);

    Mono<Boolean> deleteColor(Integer idColor);

    Mono<ColorResponse> findByIdColor(Integer idColor);
}
