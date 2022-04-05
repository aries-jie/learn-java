package io.github.aries.java8.lambda.predicate;

import io.github.aries.java8.lambda.Project;
import io.github.aries.java8.lambda.ProjectPredicate;

/**
 * 按编程语言过滤
 *
 * @author xiaojie.haung
 * @date 2022/4/5 16:49
 */
public class ProjectLanguagePredicate implements ProjectPredicate {

    private String language;

    public ProjectLanguagePredicate(String language) {
        this.language = language;
    }

    @Override
    public boolean test(Project project) {
        return language.equals(project.getLanguage());
    }
}
