package com.rdp.printing.press.repo;

import com.rdp.printing.press.entity.Press;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PressRepository extends JpaRepository<Press,Long> {
}
