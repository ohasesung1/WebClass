package hs.kr.dgsw.webclass02.Controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hs.kr.dgsw.webclass02.Domain.Comment;
import hs.kr.dgsw.webclass02.Domain.User;
import hs.kr.dgsw.webclass02.Protocol.AttachmentProtocol;
import hs.kr.dgsw.webclass02.Repository.CommentRepository;
import hs.kr.dgsw.webclass02.Repository.UserRepository;

@RestController
public class AttachmentController {
  @Autowired
  UserRepository userRepository;

  @Autowired
  CommentRepository commentRepository;

  @PostMapping("/attachment")
  public AttachmentProtocol upload(@RequestPart MultipartFile srcFile) {
    String destFilename = "C:/SBEX/webclass10/upload"
                          + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/mm/dd"))
                          + UUID.randomUUID().toString() + "_" + srcFile.getOriginalFilename();
    
    try {
      File destFile = new File(destFilename);
      destFile.getParentFile().mkdirs();
      srcFile.transferTo(destFile);
      return new AttachmentProtocol(destFilename, srcFile.getOriginalFilename());
    } catch (Exception e) {
      return null;
    }

  }

@GetMapping("/attachment/{type}/{id}")
  public void downLoadUser(@PathVariable String type, @PathVariable Long id, HttpServletRequest req, HttpServletResponse res) {
    String filePath = null;
    String fileName = null;

    try {
      if (type.equals("user")) {
        Optional<User> user = userRepository.findById(id);
        filePath = user.get().getStoredPath();
        fileName = user.get().getOriginalName();
      } else if (type.equals("comment")) {
        Optional<Comment> comment = commentRepository.findById(id);
        filePath = comment.get().getStoredPath();
        fileName = comment.get().getOriginalName();
      } else return;
      
      if (filePath == null || fileName == null) return;

      File file = new File(filePath);
      if (file.exists() == false) return;

      String mimeType = URLConnection.guessContentTypeFromName(file.getName());
      if (mimeType == null) mimeType = "application/octet-stream";

      res.setContentType(mimeType);
      res.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
      res.setContentLength((int) file.length());

      InputStream is = new BufferedInputStream(new FileInputStream(file));
      FileCopyUtils.copy(is, res.getOutputStream());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}