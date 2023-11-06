package com.fag.domain.usecases;

import com.fag.domain.dto.ProductDTO;
import com.fag.domain.repositories.IRechargeVendor;
import java.util.List;

public class ListProducts {

    private IRechargeVendor repo;

    public ListProducts(IRechargeVendor repo) {
        this.repo = repo;
    }

    public List<ProductDTO> execute(Integer stateCode, Integer providerID) {
        return repo.listProducts(providerID, providerID);
    }
}
