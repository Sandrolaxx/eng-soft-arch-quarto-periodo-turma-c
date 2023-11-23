package com.fag.infra.panache.repository;

import com.fag.domain.entities.RechargeBO;
import com.fag.domain.repositories.IRechargeDataBaseRepository;
import com.fag.infra.panache.mappers.PanacheRechargeMapper;
import com.fag.infra.panache.models.PanacheRecharge;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheDataBaseRepository implements IRechargeDataBaseRepository {
    
    @Override
    public RechargeBO persist(RechargeBO bo) {
        PanacheRecharge entity = PanacheRechargeMapper.toEntity(bo);

        entity.persistAndFlush();

        return PanacheRechargeMapper.toDomain(entity);
    }
}
