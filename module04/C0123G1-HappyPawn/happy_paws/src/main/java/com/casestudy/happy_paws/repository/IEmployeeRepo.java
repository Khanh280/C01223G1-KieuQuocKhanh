package com.casestudy.happy_paws.repository;

import com.casestudy.happy_paws.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IEmployeeRepo extends JpaRepository<Employee,Long> {
    @Query(value = "select e from Employee e where e.isDelete = false")
    Page<Employee> getAll(Pageable pageable);
    @Query(value = "update employee set employee.is_delete=true where employee.employee_id = :id" ,nativeQuery = true)
    @Modifying
    @Transactional
    void deleteEmployee(@Param("id") Long id);
    @Query(value = "SELECT * FROM employee where employee.name like concat('%',:name,'%') AND employee.phone like concat('%',:phone,'%')",nativeQuery = true)
    Page<Employee> findEmployeeB(@Param("name") String name,@Param("phone") String phone,Pageable pageable);
}
