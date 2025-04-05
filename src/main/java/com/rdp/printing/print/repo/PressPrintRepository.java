package com.rdp.printing.print.repo;

import com.rdp.printing.print.entity.PressPrint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PressPrintRepository extends JpaRepository<PressPrint,Long>
{
}
