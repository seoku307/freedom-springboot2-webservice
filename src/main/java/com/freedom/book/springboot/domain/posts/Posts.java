package com.freedom.book.springboot.domain.posts;

import com.freedom.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //6. 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor //5. 기본 생성자 자동 추가 (lombok의 어노테이션 이자 필수 어노테이션이 아니기 때문에 클래스명 멀리에 위치시킴)
@Entity //1. 테이블과 링크될 Entity 클래스 (JPA의 어노테이션이자 필수 어노테이션이기 때문에 클래스명 가까이에 위치시킴)
public class Posts extends BaseTimeEntity { // Posts 클래스는 실제 DB의 테이블과 매칭될 클래스다.

    @Id //2. 해당 테이블의 PK 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //3. PK 의 생성 규칙을 나타낸다.
    private Long id;

    @Column(length = 500, nullable = false) //4. 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //7. 해당 클래스의 빌더 패턴 클래스를 생성 // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}