package com.fag.domain.repositories;


import com.fag.domain.entities.PixBO;

public interface IPixDataBaseRepository {

    PixBO persist(PixBO pixDTO);

}
