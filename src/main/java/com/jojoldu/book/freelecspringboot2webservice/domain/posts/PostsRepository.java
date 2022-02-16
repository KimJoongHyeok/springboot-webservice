package com.jojoldu.book.freelecspringboot2webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { //JpaRepository<Entity 클래스,PK타입> 을 상속하면 기본적인 CRUD 메소드가 생성됨, @Repository를 추가할 필요도 없음
}
