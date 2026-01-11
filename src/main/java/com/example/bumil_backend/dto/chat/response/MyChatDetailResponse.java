package com.example.bumil_backend.dto.chat.response;

import com.example.bumil_backend.entity.ChatRoom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class MyChatDetailResponse {
    private Long chatRoomId;
    private String title;
    private String tag;
    private String author;
    private int studentNum;
    private LocalDateTime createdAt;

    public static MyChatDetailResponse from(ChatRoom chatRoom) {
        return MyChatDetailResponse.builder()
                .chatRoomId(chatRoom.getId())
                .title(chatRoom.getTitle())
                .tag(chatRoom.getTag().toString())
                .author(chatRoom.getAuthor().getName())
                .studentNum(chatRoom.getAuthor().getStudentNum())
                .createdAt(chatRoom.getCreatedAt())
                .build();
    }
}

