package in.ashokit.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entities.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Serializable> {

}
