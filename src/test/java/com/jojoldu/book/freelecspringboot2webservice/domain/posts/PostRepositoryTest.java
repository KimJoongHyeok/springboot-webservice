package com.jojoldu.book.freelecspringboot2webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //Junit에서 단위테스트가 끝날 때마다 수행되는 메소드를 지정 , 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사요함
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트게시글";
        String content = "테스트본문";

        postsRepository.save(Posts.builder() // postsRepository.save() :  posts 테이블에 insert/update 쿼리를 실행 ,id값이 있다면 update, 없다면 insert 쿼리가 실행됨
                .title(title)
                .content(content)
                .author("moon960427@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); //  postsRepository.findAll() : posts 테이블에 있는 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>> createDate = " + posts.getCreatedDate() + ", moifiedDate = " + posts.getModifiedDate());
    }
}
