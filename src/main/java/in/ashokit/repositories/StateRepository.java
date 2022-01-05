package in.ashokit.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entities.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Serializable> {

}
