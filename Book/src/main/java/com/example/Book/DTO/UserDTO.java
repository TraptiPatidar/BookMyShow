package com.example.Book.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private int userId;
    private String username;
}
