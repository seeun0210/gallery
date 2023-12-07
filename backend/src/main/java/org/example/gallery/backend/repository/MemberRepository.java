package org.example.gallery.backend.repository;

import org.example.gallery.backend.entity.Item;
import org.example.gallery.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmailAndPassword(String email, String password);
    // additional methods can be added here if needed

}
