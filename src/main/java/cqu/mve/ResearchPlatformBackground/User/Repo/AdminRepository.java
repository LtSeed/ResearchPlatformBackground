package cqu.mve.ResearchPlatformBackground.User.Repo;

import cqu.mve.ResearchPlatformBackground.User.Permission.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findById(Long id);
}