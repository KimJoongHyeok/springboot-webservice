package com.jojoldu.book.freelecspringboot2webservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Entity 클래스에서는 절대 setter 메소드를 만들지 않음, 값 변경이 필요하다면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야함

@Getter //Lombok 어노테이션
@NoArgsConstructor //Lombok 어노테이션 , 기본생성자 자동 추가
@Entity //JPA 어노테이션 ,주요 어노테이션, JPA 어노테이션은 주요어노테이셔이기 때문에 클래스에 가까이 
        //가까이 두는 이유 -> 코틀리이나 새 언어 전환으로 롬복이 더 이상 필요 없을 경우 위의 Lombok 어노테이션을 쉽게 삭제할수 있게 때문

        //@Entity : 테이블과 링크될 클래스임을 나타냄 , 기본값으로 클래스의 카멜케이스 이름을 언더스코어(_)네이밍으로 테이블 이름을 매칭
                                                  // ex) SalesManager.java -> sales_manager table
public class Posts {

    @Id //해당 테이블의 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙 , 스프링부트2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야한 auto_increment됨
    private Long id;

    @Column(length = 500,nullable = false) //테이블의 컬럼,굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 됨
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

                    //@Builder  : 해당 클래스의 빌더 패턴 클래스를 형성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    @Builder        //            빌더를 사용하면 어느 필드에 어떤값을 채워야할지 명확하게 인지할 수 있음
    public Posts(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author =author;
    }
}
