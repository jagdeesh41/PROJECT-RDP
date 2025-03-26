package com.rdp.printing.print.repository;

import com.rdp.printing.print.entity.Print;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintRepository extends JpaRepository<Print,Long> {
}
