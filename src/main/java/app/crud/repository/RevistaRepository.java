package app.crud.repository;

import app.crud.entity.Revista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevistaRepository extends JpaRepository<Revista,Long> {
}
