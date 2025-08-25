package repository;

import com.camilo.financas.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GastoRepository extends JpaRepository<Gasto, UUID> {
}
