package com.example.university.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResponse implements Serializable {
    private int code;
    private Date date;
    private Object content;

}
