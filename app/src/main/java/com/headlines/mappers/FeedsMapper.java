package com.headlines.mappers;

import com.headlines.data.entities.FeedsEntity;
import com.headlines.remote.response.entity.FeedsResponseEntity;
import com.headlines.utility.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

public final class FeedsMapper implements IEntityMapper<FeedsEntity, FeedsResponseEntity> {


    @Override
    public FeedsEntity convertDSEntityToData(FeedsResponseEntity dataSource) throws Exception {
        try {
            return new FeedsEntity(dataSource);
        }catch (Exception e){
            LoggerUtil.printError(FeedsMapper.class,e.getMessage());
            throw e;
        }
    }

    @Override
    public List<FeedsEntity> convertDSEntitiesListToData(FeedsResponseEntity dataSource) throws Exception {
        return new ArrayList<>();
    }
}
