package medical.clinic.api.repository;

import medical.clinic.api.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
}
