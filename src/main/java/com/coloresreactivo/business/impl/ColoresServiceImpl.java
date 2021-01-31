package com.coloresreactivo.business.impl;

import com.coloresreactivo.business.ColoresService;
import com.coloresreactivo.model.api.request.CreateColorRequest;
import com.coloresreactivo.model.api.response.ColorResponse;
import com.coloresreactivo.model.entity.ColoresEntity;
import com.coloresreactivo.repository.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ColoresServiceImpl implements ColoresService {

    private final ColorRepository colorRepository;

    @Override
    public Mono<ColorResponse> saveColor(CreateColorRequest createColorRequest) {

        return colorRepository.save(ColoresEntity
                .builder()
                .name(createColorRequest.getName())
                .color(createColorRequest.getColor())
                .pantone(createColorRequest.getPantone())
                .year(createColorRequest.getYear())
                .build())
                .map(this::convertToColorResponse)
                .doOnError(Throwable::printStackTrace)
                ;


    }

    @Override
    public Flux<ColorResponse> findAllColor() {
        return colorRepository
                .findAll()
                .map(this::convertToColorResponse)
                .doOnError(Throwable::printStackTrace)
                ;
    }

    private ColorResponse convertToColorResponse(ColoresEntity coloresEntity) {
        return ColorResponse
                .builder()
                .id(coloresEntity.getId())
                .name(coloresEntity.getName())
                .color(coloresEntity.getColor())
                .pantone(coloresEntity.getPantone())
                .year(coloresEntity.getYear())
                .build();
    }

    @Override
    public Mono<ColorResponse> updateColor(CreateColorRequest createColorRequest, Integer idColor) {

        return colorRepository.findById(idColor)
                .flatMap(coloresEntity -> colorRepository
                        .save(
                                ColoresEntity
                                        .builder()
                                        .id(coloresEntity.getId())
                                        .name(createColorRequest.getName())
                                        .color(createColorRequest.getColor())
                                        .pantone(createColorRequest.getPantone())
                                        .year(createColorRequest.getYear())
                                        .build()
                        )
                ).map(this::convertToColorResponse)
                .doOnError(Throwable::printStackTrace)
                ;
    }

    @Override
    public Mono<Boolean> deleteColor(Integer idColor) {

        return colorRepository.findById(idColor)
                .flatMap(coloresEntity -> colorRepository.delete(coloresEntity))
                .map(a -> Boolean.TRUE)
                ;

    }

    @Override
    public Mono<ColorResponse> findByIdColor(Integer idColor) {

        return colorRepository.findById(idColor)
                .map(this::convertToColorResponse)
                ;
    }
}
