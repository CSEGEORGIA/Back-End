package ge.cse.lms.repositories;

import ge.cse.lms.models.Webinar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebinarRepository extends JpaRepository<Webinar, Long> {
}
