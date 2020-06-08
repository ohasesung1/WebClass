package kr.hs.dgsw.blog.Protocol;

import lombok.Data;

@Data // 람북 getter, setter 설정
public class ResponseFormat {
  private int code;
  private String desc;
  private Object data;

  public ResponseFormat(ResponseType rt, Object data, Object option) { // 응답 값 포맷
    this.code = rt.code();
    this.desc = option instanceof Long || option instanceof String
                ? String.format(rt.desc(), option)
                : rt.desc();
    this.data = data;
  }

  public ResponseFormat(ResponseType rt, Object data) { // 응답 값 포맷
    this(rt, data, null);
  }
}