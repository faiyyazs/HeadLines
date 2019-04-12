package com.headlines.mappers;

import java.util.List;

public interface IEntityMapper<T, U> {

    /**
     * Convert a Datasource entity to an Data entity.
     *
     *  */

    T convertDSEntityToData(U dataSource) throws Exception;

    /**
     * Convert a Datasource entities list to an Data entities list.
     *
     *
     * */

    List<T> convertDSEntitiesListToData(U dataSource) throws Exception;
}
