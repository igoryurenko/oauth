package com.iyurenko.client.service.api;

/**
 * @author iyurenko
 * @since 12.05.16.
 */
public interface GenericService<DTO> {

    long save(DTO dto) throws Exception;

    DTO load(Long id);

}
