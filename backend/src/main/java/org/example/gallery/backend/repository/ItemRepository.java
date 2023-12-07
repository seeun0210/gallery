package org.example.gallery.backend.repository;

import org.example.gallery.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByIdIn(List<Long> id);
}
