package com.artash.data.repository;


import com.artash.data.entity.Message;
import com.artash.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findBySenderAndReceiver(User sender, User receiver);


    @Modifying
    @Query(value = "SELECT * FROM messages WHERE sender_id=?1 and receiver_id=?2 OR sender_id=?2 AND receiver_id=?1", nativeQuery = true)
    List<Message> testFind(Long sender, Long receiver);
}
