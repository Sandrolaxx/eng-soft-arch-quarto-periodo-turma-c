package com.fag.domain.repositories;

import com.fag.domain.entities.RechargeBO;

public interface IRechargeDataBaseRepository {

    RechargeBO persist(RechargeBO bo);

}
