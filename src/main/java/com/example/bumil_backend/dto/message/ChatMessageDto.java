package com.example.bumil_backend.dto.message;

import com.example.bumil_backend.entity.ChatMessage;
import com.example.bumil_backend.entity.ChatRoom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ChatMessageDto {
    private String message;
    private boolean isDeleted;
    private Long sender;
    private String senderName;
    private LocalDateTime createdAt;




    public static ChatMessageDto from(ChatMessage chatMessage) {
        return ChatMessageDto.builder()
                .message(chatMessage.getMessage())
                .isDeleted(chatMessage.isDeleted())
                .sender(chatMessage.getSender().getId())
                .senderName(chatMessage.getSender().getName())
                .createdAt(chatMessage.getCreatedAt())
                .build();
    }

    public static List<ChatMessageDto> from(List<ChatMessage> messages) {
        return messages.stream()
                .map(ChatMessageDto::from)
                .toList();
    }

    public static ChatMessageDto from(
            ChatMessage chatMessage,
            boolean isAnonymousRoom,
            Long authorId   // 작성자 아이디
    ) {
        boolean isRoomOwnerMessage =
                chatMessage.getSender().getId().equals(authorId);

        String senderName =
                (isAnonymousRoom && isRoomOwnerMessage)
                        ? "익명"
                        : chatMessage.getSender().getName();

        return ChatMessageDto.builder()
                .message(chatMessage.getMessage())
                .isDeleted(chatMessage.isDeleted())
                .sender(chatMessage.getSender().getId())
                .senderName(senderName)
                .createdAt(chatMessage.getCreatedAt())
                .build();
    }

    public static List<ChatMessageDto> from(
            List<ChatMessage> messages,
            boolean isAnonymousRoom,
            Long authorId
    ) {
        return messages.stream()
                .map(m -> ChatMessageDto.from(m, isAnonymousRoom, authorId))
                .toList();
    }

}
