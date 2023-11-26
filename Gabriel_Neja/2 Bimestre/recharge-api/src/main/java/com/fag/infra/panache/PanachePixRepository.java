package com.fag.infra.panache;

import jakarta.enterprise.context.ApplicationScoped;
import com.fag.domain.entities.PixBO;
import com.fag.domain.repositories.IPixDatabaseRepository;
import com.fag.infra.panache.mappers.PanachePixMapper;
import com.fag.infra.panache.model.PanachePix;


@ApplicationScoped
public class PanachePixRepository implements IPixDatabaseRepository {

    @Override
    public PixBO persist(PixBO bo) {
        PanachePix entity = PanachePixMapper.toEntity(bo);

        entity.persistAndFlush();

        return PanachePixMapper.toDomain(entity);
    }

}
