package com.rdp.printing.print.repo;

import com.rdp.printing.print.entity.PressPrint;
import com.rdp.printing.print.entity.UserPrint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrintRepository extends JpaRepository<UserPrint,Long>
{
}
