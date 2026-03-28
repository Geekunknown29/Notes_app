package com.Java_project_vityarthi.Notes_Manager ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository ;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>
{
    java.util.List<Note> findAllByOrderByCreatedAtDesc();
}