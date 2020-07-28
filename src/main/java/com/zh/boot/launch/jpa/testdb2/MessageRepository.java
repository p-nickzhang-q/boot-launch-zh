package com.zh.boot.launch.jpa.testdb2;

import com.zh.boot.launch.jpa.common.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends BaseRepository<Message, Long> {
}
