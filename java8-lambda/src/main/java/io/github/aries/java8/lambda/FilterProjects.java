package io.github.aries.java8.lambda;

import io.github.aries.java8.lambda.predicate.ProjectLanguagePredicate;
import io.github.aries.java8.lambda.predicate.ProjectStarPredicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 过滤 Project
 *
 * @author xiaojie.haung
 * @date 2022/4/5 16:49
 */
public class FilterProjects {

    /**
     * 按照断言条件过滤
     *
     * @param projects
     * @param projectPredicate
     * @return
     */
    public static List<Project> filterProjects(List<Project> projects, ProjectPredicate projectPredicate) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (projectPredicate.test(project)) {
                result.add(project);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    /**
     * 初始化项目列表
     * @return 项目列表
     */
    private static List<Project> initProjectList() {
        List<Project> data = new ArrayList<>();

        data.add(Project.builder().name("Blade").language("java").author("biezhi")
                .stars(3500).description("Lightning fast and elegant mvc framework for Java8").build());

        data.add(Project.builder().name("Tale").language("java").author("biezhi")
                .stars(2600).description("Best beautiful java blog, worth a try").build());

        data.add(Project.builder().name("Vue.js").language("js").author("yyx990803")
                .stars(83000).description("A progressive, incrementally-adoptable JavaScript framework for building UI on the web.").build());

        data.add(Project.builder().name("Flask").language("python").author("pallets")
                .stars(10500).description("The Python micro framework for building web applications").build());

        data.add(Project.builder().name("Elves").language("java").author("biezhi")
                .stars(200).description("Spider").build());
        return data;
    }

    public static void main(String[] args) {
        List<Project> data = initProjectList();
        data.forEach(System.out::println);

        // 排序
        System.out.println("----------排序----------");
        data.sort(Comparator.comparing(Project::getStars));
        data.forEach(System.out::println);

        // 按language过滤
        System.out.println("----------按language过滤----------");
        List<Project> projects = filterProjects(data, new ProjectLanguagePredicate("python"));
        projects.forEach(System.out::println);

        // 按star过滤
        System.out.println("----------按star过滤----------");
        projects = filterProjects(data, new ProjectStarPredicate(1000));
        projects.forEach(System.out::println);

        System.out.println("----------按star过滤----------");
        projects = filter(data, project -> project.getStars() > 1000);
        projects.forEach(System.out::println);


    }


}
