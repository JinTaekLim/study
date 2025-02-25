package com.study.study.file.service;

import com.study.study.file.entity.Image;
import com.study.study.file.repository.ImageRepository;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {

  private final ImageRepository imageRepository;

  public void save(MultipartFile file) throws IOException {
    byte[] bytes = file.getBytes();
    Image image = new Image(bytes);
    imageRepository.save(image);
  }

  public byte[] findById(Long id) {
    return imageRepository.findById(id).get().getData();
  }

}
