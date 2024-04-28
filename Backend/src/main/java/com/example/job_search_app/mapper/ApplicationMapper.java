package com.example.job_search_app.mapper;

import com.example.job_search_app.dto.ApplicationDTO;
import com.example.job_search_app.entities.Application;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApplicationMapper {
	Application toEntity(ApplicationDTO applicationDTO);

	ApplicationDTO toDto(Application application);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Application partialUpdate(ApplicationDTO applicationDTO, @MappingTarget Application application);
}