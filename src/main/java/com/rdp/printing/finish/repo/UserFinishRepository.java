package com.rdp.printing.finish.repo;

import com.rdp.printing.finish.entity.PressFinish;
import com.rdp.printing.finish.entity.UserFinish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFinishRepository extends JpaRepository<UserFinish,Long> {
}
