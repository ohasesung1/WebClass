package hs.kr.dgsw.webclass02.Protocol;

import hs.kr.dgsw.webclass02.Domain.Comment;
import lombok.Data;

@Data
public class CommentUsernameProtocol extends Comment{
  private String userName;
  public CommentUsernameProtocol(Comment c, String username) {
    super(c);
    this.userName = username;
  }
}