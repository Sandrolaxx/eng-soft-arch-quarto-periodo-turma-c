package com.fag.domain.repositories;

import java.util.List;

import com.fag.domain.dto.OperatorDTO;
import com.fag.domain.dto.ProductDTO;
import com.fag.domain.dto.RechargeDTO;

public interface IRechargeVendor {

    List<OperatorDTO> listOperators(Integer stateCode, Integer category);

    List<ProductDTO> listProducts(Integer stateCode, Integer providerID);

    RechargeDTO createRecharge(RechargeDTO dto);
}
