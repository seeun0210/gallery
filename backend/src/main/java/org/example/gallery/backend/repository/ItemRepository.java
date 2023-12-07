package org.example.gallery.backend.repository;

import org.example.gallery.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // additional methods can be added here if needed
}
