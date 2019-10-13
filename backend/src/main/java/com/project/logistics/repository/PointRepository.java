package com.project.logistics.repository;

import com.project.logistics.entity.PointEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends CrudRepository<PointEntity, Integer> {
    PointEntity getPointEntityByName(String name);

    PointEntity getPointEntityById(Integer id);

    List<PointEntity> getPointEntitiesByIdNotIn(List<Integer> ids);
}
