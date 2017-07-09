package wieczorek.jakub.service;

/**
 * Created by jakub on 10.07.17.
 */
public interface Converter<DTO, ENTITY>
{
    DTO convertToDto(ENTITY aEntity);
    ENTITY convertToEntity(DTO aDto);
}
