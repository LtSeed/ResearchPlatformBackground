package cqu.mve.ResearchPlatformBackground.User.Repo;

import cqu.mve.ResearchPlatformBackground.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
