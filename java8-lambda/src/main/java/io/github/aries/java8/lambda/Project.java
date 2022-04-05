package io.github.aries.java8.lambda;

import lombok.Builder;
import lombok.Data;

/**
 * 项目
 *
 * @author xiaojie.haung
 * @date 2022/4/5 16:45
 */
@Data
@Builder
public class Project {

    /**
     * 项目名称
     */
    private String  name;

    /**
     * 编程语言
     */
    private String  language;

    /**
     * star 数
     */
    private Integer stars;

    /**
     * 描述
     */
    private String  description;

    /**
     * 作者
     */
    private String  author;
}
