package io.github.aries.java8.lambda.predicate;

import io.github.aries.java8.lambda.Project;
import io.github.aries.java8.lambda.ProjectPredicate;

/**
 * 按 star 数过滤
 *
 * @author xiaojie.haung
 * @date 2022/4/5 16:49
 */
public class ProjectStarPredicate implements ProjectPredicate {

    private Integer stars;

    public ProjectStarPredicate(Integer stars) {
        this.stars = stars;
    }

    @Override
    public boolean test(Project project) {
        return project.getStars() > stars;
    }

}
