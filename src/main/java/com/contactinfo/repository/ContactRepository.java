package com.contactinfo.repository;

import com.contactinfo.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactInfo, Long> {
}
