package com.example.bumil_backend.dto.chat.request;

import com.example.bumil_backend.entity.Tag;
import lombok.Getter;

@Getter
public class ChatCloseRequest {
    private Long chatRoomId;
    private Tag tag;
}
