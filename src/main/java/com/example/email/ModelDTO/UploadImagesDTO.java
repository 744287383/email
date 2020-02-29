package com.example.email.ModelDTO;

import lombok.Data;

import java.util.List;

@Data
public class UploadImagesDTO {
    private int errno;
    private List<String> data;
}
